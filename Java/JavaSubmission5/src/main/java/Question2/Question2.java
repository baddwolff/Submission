package main.java.Question2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Question2 {


    public static void main(String args[]){
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Integer> arr=new ArrayList<>();
        Semaphore semaphore=new Semaphore(1);


        FutureTask<String> writer =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {
                        int count=0;
                        while(true){
                            try{
                                if(semaphore.tryAcquire()){
                                    System.out.println("Adding!");
                                    arr.add(count);
                                    count++;

                                }
                            }
                            finally {
                                semaphore.release();
                                Thread.sleep(5000);

                            }
                        }
                    }});
        service.execute(writer);

        FutureTask<String> reader =
                new FutureTask<String>(new Callable<String>() {
                    public String call() throws InterruptedException {

                        while(true){

                            try{
                                if(semaphore.tryAcquire())
                                {
                                    System.out.println("printing!!!");
                                    for (int i=0;i<10;i++){
                                        System.out.print(arr.get(i)+" ");
                                    }

                                }
                            }
                            finally {
                                semaphore.release();

                            }
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
