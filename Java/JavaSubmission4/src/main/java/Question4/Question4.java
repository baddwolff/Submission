package main.java.Question4;

import main.java.Question1.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Question4 {
    private static List<Person> persons= new ArrayList<>();

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);

        FutureTask<Integer> even =
                new FutureTask<Integer>(new Callable<Integer>() {
                    public Integer call() throws InterruptedException {
                        int count =0;
                        while(true){
                            System.out.println(count);
                            count+=2;
                            Thread.sleep(2000);
                        }
                    }});
        service.execute(even);

        FutureTask<Integer> odd =
                new FutureTask<Integer>(new Callable<Integer>() {
                    public Integer call() throws InterruptedException {
                        Thread.sleep(1000);
                        int count =1;
                        while(true){

                            System.out.println(count);
                            count+=2;
                            Thread.sleep(2000);
                        }
                    }});
        service.execute(odd);
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
