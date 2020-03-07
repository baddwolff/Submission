package main.java.Question1;

public class Question1 {

   public static void main(String args[]){
       Thread1 ob1 = new Thread1();
       Thread2 ob2 = new Thread2();
       Thread t1= new Thread(ob1);
       Thread t2= new Thread(ob2);
       Thread t3= new Thread(ob1);
       Thread t4= new Thread(ob2);

       try{
           System.out.println("One at a time");
           t1.start();
           t1.join();
           t2.start();
           t2.join();
            System.out.println("Both at once");
           t3.start();
           t4.start();

       }
       catch(Exception e)
       {
           System.out.println("Interrupted exception " + e);
       }
   }



}
