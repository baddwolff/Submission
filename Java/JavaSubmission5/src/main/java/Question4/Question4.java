package main.java.Question4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Question4 {

    public static void main(String args[]){
        BlockingQueue<Person> queue=new ArrayBlockingQueue(10);
        Set<Person> set=new HashSet<>();
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Person> arr=new ArrayList<>();
        arr.add(new Person(1,"a",5));
        arr.add(new Person(2,"b",4));
        arr.add(new Person(3,"c",3));
        arr.add(new Person(4,"d",2));
        arr.add(new Person(5,"e",1));


        FutureTask<String> writer =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {
                        int item=0;
                        while(true){
                            queue.put(arr.get(item));
                            item+=1;
                            if(item==5)item=1;
                            Thread.sleep(1000);
                        }
                    }});
        service.execute(writer);

        FutureTask<String> reader =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {
                        while(true){
                            Person temp=queue.take();
                            set.add(temp);
                            set.forEach(person -> System.out.println(person.toString()));
                            Thread.sleep(2000);
                        }
                    }});
        service.execute(reader);

        while(writer.isDone()==false)
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
