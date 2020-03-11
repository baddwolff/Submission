package main.java.Question3;

import main.java.Question1.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Question3 {
    private static List<Person> persons= new ArrayList<>();
    public static void main(String args[]){
        System.out.println("Starting here..");

        List<String> jobs =new ArrayList<>();
        jobs.add("engineer");
        persons.add(new Person(1, LocalDate.now(),jobs));

        Semaphore sema = new Semaphore(1);//permits count
        int count = sema.availablePermits();
        Writer w1=new Writer(sema,1);
        Writer w2=new Writer(sema,2);
        Thread t1=new Thread(w1);
        Thread t2=new Thread(w2);
        t1.start();
        t2.start();
    }


    static class Writer implements  Runnable{

        private final int id;
        Semaphore semaphore;

        public Writer(Semaphore semaphore,int id) {
            this.semaphore=semaphore;
            this.id=id;
        }

        @Override
        public void run() {
            while (true){
                if (semaphore.tryAcquire()) {
                    try {
                        System.out.println(id+" is writing....");
                        List<String> jobs =new ArrayList<>();
                        jobs.add("engineer");
                        persons.add(new Person(1, LocalDate.now(),jobs));

                    } finally {
                        System.out.println("Releasing the locks..");
                        semaphore.release();
                        try {
                            Thread.sleep(1000+id);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}