package main.java.Question8;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Question8 {

    public static void main(String args[]){
        List<Employee> ls =
                Collections.synchronizedList(new ArrayList<Employee>());
        ls.add(new Employee("a",1,1,"b"));


        ExecutorService service = Executors.newFixedThreadPool(2);
        AtomicIntegerArray arr=new AtomicIntegerArray(10);


        FutureTask<String> modifier =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {

                        while (true) {
                            Scanner in = new Scanner(System.in);
                            System.out.println("Enter 0/1:");
                            int i = in.nextInt();
                            synchronized (ls) {

                                if (i == 1) {
                                    System.out.println("adding");
                                    ls.add(new Employee("a", 1, 1, "b"));
                                }
                                if (i == 0) {
                                    Iterator iter = ls.iterator();
                                    if (iter == null) {
                                        System.exit(1);
                                    }
                                    while (iter.hasNext()) {
//                        System.out.println(iter.next());
                                        iter.next();
                                        iter.remove();
                                        System.out.println("removed");
                                    }
                                }
                            }
                        }
                    }});
        service.execute(modifier);

        FutureTask<String> reader =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {

                        while (true){
                            synchronized (ls){
                                System.out.println("printing");
                                Iterator iter = ls.iterator();
                                if(iter == null){
                                    System.exit(1);
                                }
                                while(iter.hasNext()){
                                    System.out.println(iter.next().toString());

                                }
                            }
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }});
        service.execute(reader);

        while(modifier.isDone()==false)
            work();

        while(reader.isDone()==false)
            work();
    }


    static void work(){
        try {
            Thread.sleep(1500);
            System.out.println("Working on other task here..");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
