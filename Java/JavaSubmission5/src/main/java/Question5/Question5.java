package main.java.Question5;

import main.java.Question4.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Question5 {


    public static void main(String args[]){
    Semaphore semaphore=new Semaphore(1);
    final Person[] shared = {null};
    Set<Person> set=new HashSet<>();
    ExecutorService service = Executors.newFixedThreadPool(2);
    List<Person> arr=new ArrayList<>();
        arr.add(new Person(1,"a",5));
        arr.add(new Person(2,"b",4));
        arr.add(new Person(3,"c",3));
        arr.add(new Person(4,"d",2));
        arr.add(new Person(5,"e",1));
        arr.add(new Person(1,"a",5));
        arr.add(new Person(2,"b",4));
        arr.add(new Person(3,"c",3));
        arr.add(new Person(4,"d",2));
        arr.add(new Person(5,"e",1));


    FutureTask<String> writer =
            new FutureTask<String>(new Callable<String>() {
                public String call() throws InterruptedException {
                        for(int i=0;i<10;i++){

                            if(semaphore.tryAcquire()){
                                System.out.println("here");
                                if(arr.get(i).getId()!=-1){
                                    shared[0]=arr.get(i);
                                }

                                for (int j=i+1;j<10;j++){
                                    if(arr.get(i).equals(arr.get(j))){
                                        System.out.println("here");
                                        System.out.println(arr.get(j));
                                        System.out.println("same");
                                        arr.get(j).setId(-1);
                                    }
                                }


                                semaphore.release();

                                Thread.sleep(1000);
                            }
                        }
//                        arr.forEach();
                        return "done";
                }});
        service.execute(writer);

    FutureTask<String> reader =
            new FutureTask<String>(new Callable<String>() {
                public String call() throws InterruptedException {
                    while(true){
                        if(semaphore.tryAcquire()){
                            System.out.println("here");
                            set.add(shared[0]);
                            set.forEach(person -> System.out.println(person.toString()));
                            semaphore.release();
                            Thread.sleep(1000);
                        }
                    }
                }});
        service.execute(reader);

//        while(writer.isDone()==false)
//    work();
//
//        while(reader.isDone()==false)
//    work();
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
