package main.java.Question1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;



public class Question1 {
    private static List<Person> persons= new ArrayList<>();



    public static void main(String args[]) throws ExecutionException, InterruptedException {
        Lock lock = new ReentrantLock();
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<String> jobs =new ArrayList<>();
        jobs.add("engineer");
        persons.add(new Person(1, LocalDate.now(),jobs));

        FutureTask<List<Person>> futurer =
                new FutureTask<List<Person>>(new Callable<List<Person>>() {
                    public List<Person> call() {
                        lock.lock();
                        System.out.println("reading");
                        lock.unlock();
                        return persons;
                    }});
        service.execute(futurer);

        FutureTask<String> futurew =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {
                        lock.lock();
                        persons.add(new Person(1, LocalDate.now(),jobs));
                        Thread.sleep(1000);
                        lock.unlock();
                        System.out.println("writing");
                        return "writing";
                    }});
        service.execute(futurew);

        while(futurer.isDone()==false)
            work();

        while(futurew.isDone()==false)
            work();


        String result =futurew.get();
        List<Person> res= futurer.get();
        System.out.println(result);
        res.stream().forEach(item->System.out.println(item.toString()));




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
