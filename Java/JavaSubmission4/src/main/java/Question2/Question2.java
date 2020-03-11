package main.java.Question2;

import main.java.Question1.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;



public class Question2 {
    private static List<Person> persons= new ArrayList<>();
    public static void main(String args[]){
        System.out.println("Starting here..");

        List<String> jobs =new ArrayList<>();
        jobs.add("engineer");
        persons.add(new Person(1, LocalDate.now(),jobs));

        Semaphore sema = new Semaphore(2);//permits count
        int count = sema.availablePermits();
        Reader r=new Reader(sema);
        Writer w=new Writer(sema);
        Thread t1=new Thread(r);
        Thread t2=new Thread(w);
        t1.start();
        t2.start();
    }

    public static class Reader implements Runnable{


         Semaphore semaphore;
        public Reader(Semaphore semaphore) {
            this.semaphore=semaphore;
        }

        @Override
        public void run() {

            if (semaphore.tryAcquire()) {
                try {
                    System.out.println("reading....");
                    persons.stream().forEach(item->System.out.println(item.toString()));

                } finally {
                    System.out.println("Releasing the locks..");
                    semaphore.release();
                }
            }


        }
    }

    static class Writer implements  Runnable{

        Semaphore semaphore;

        public Writer(Semaphore semaphore) {
            this.semaphore=semaphore;
        }

        @Override
        public void run() {
            if (semaphore.tryAcquire()) {
                try {
                    System.out.println("writing....");
                    List<String> jobs =new ArrayList<>();
                    jobs.add("engineer");
                    persons.add(new Person(1, LocalDate.now(),jobs));

                } finally {
                    System.out.println("Releasing the locks..");
                    semaphore.release();
                }
            }
        }
    }
}
