package main.java.Question2;

public class Question2 {

    public static void main(String args[]){
        haveAccess print=new haveAccess(true);

        PrintThread ob1=new PrintThread(1,print);
        PrintThread ob2=new PrintThread(2,print);
        Thread t1=new Thread(ob1);
        Thread t2=new Thread(ob2);
        t1.start();
        t2.start();

    }
}
