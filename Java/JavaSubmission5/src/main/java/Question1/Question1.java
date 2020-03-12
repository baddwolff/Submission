package main.java.Question1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Question1 {

    public static void main(String args[]){

        ExecutorService service = Executors.newFixedThreadPool(2);
        AtomicIntegerArray arr=new AtomicIntegerArray(10);


        FutureTask<String> writer =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {
                        int count=0;
                        while(true){
                            for (int i=0;i<10;i++){
                                arr.set(i,count);
                            }
                            count++;
                            Thread.sleep(1000);
                        }
                    }});
        service.execute(writer);

        FutureTask<String> reader =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {

                        while(true){
                            System.out.println("printing!!!");
                            for (int i=0;i<10;i++){
                                System.out.print(arr.get(i)+" ");
                            }
                            Thread.sleep(3000);
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
