package main.java.Question7;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Question7 {

    public static void main(String args[]){
        ExecutorService service = Executors.newFixedThreadPool(2);
        AtomicInteger val =new AtomicInteger(1);
        SynchronousQueue queue=new SynchronousQueue();

        FutureTask<Integer> even =
                new FutureTask<Integer>(new Callable<Integer>() {
                    public Integer call() throws InterruptedException {
                        Thread.sleep(1000);
                        while(true){
                                
                            System.out.println("even:"+val.get());
                            val.set(val.get()+1);
                            queue.take();
                            Thread.sleep(2000);
                        }
                    }});

        service.execute(even);
        FutureTask<Integer> odd =
                new FutureTask<Integer>(new Callable<Integer>() {
                    public Integer call() throws InterruptedException {

                        while(true){
                            System.out.println("odd:"+val.get());
                            val.set(val.get()+1);
                            queue.put(1);
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
