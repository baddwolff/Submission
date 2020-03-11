package main.java.Question5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Question5 {
    private  static List<Employee> ls=new ArrayList<>();
    public static void main(String args[]){
        ExecutorService service = Executors.newFixedThreadPool(2);
        ls.add(new Employee("a",1,1,"b"));
        Lock lock = new ReentrantLock();




        FutureTask<Integer> reader =
                new FutureTask<Integer>(new Callable<Integer>() {
                    public Integer call() throws InterruptedException {
                        while (true){
                                lock.lock();
                                System.out.println("printing");
                                Iterator iter = ls.iterator();
                                if(iter == null){
                                    System.exit(1);
                                }
                                while(iter.hasNext()){
                                    System.out.println(iter.next().toString());

                                }
                                lock.unlock();
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }});
        service.execute(reader);

        FutureTask<Integer> modifier =
                new FutureTask<Integer>(new Callable<Integer>() {
                    public Integer call() throws InterruptedException {
                        while (true){
                            Scanner in = new Scanner(System.in);
                            System.out.println("Enter 0/1:");
                            int i=in.nextInt();
                            lock.lock();
                            if(i==0){
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
                            else {
                                ls.add(new Employee("a",1,1,"b"));
                                System.out.println("added");
                            }
                            lock.unlock();
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }});
        service.execute(modifier);

       
    }


}
