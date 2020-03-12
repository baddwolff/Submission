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
        arr.add(new Person(1,"a",5));
        arr.add(new Person(2,"b",4));
        arr.add(new Person(3,"c",3));
        arr.add(new Person(4,"d",2));
        arr.add(new Person(5,"e",1));



        FutureTask<String> writer =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {
                        for(int i=0;i<10;i++){
                            if(arr.get(i).getId()!=-1){
                                queue.put(arr.get(i));
                            }
                            for (int j=i+1;j<10;j++){

                                if(arr.get(i).equals(arr.get(j))){
                                    System.out.println(arr.get(j));
                                    System.out.println("same");
                                    arr.get(j).setId(-1);
//                                    arr.remove(j);
                                }

                            }

                        }

                        arr.forEach(item->System.out.println(item));

                        return "done";
                    }});
        service.execute(writer);

        FutureTask<String> reader =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {
                        while(true){
                            System.out.println("Printing:");
                            Person temp=queue.take();
                            set.add(temp);
                            set.forEach(person -> System.out.println(person.toString()));
                            Thread.sleep(2000);
                        }
                    }});
        service.execute(reader);

//        while(writer.isDone()==false)
//            work();

//        while(reader.isDone()==false)
//            work();
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
