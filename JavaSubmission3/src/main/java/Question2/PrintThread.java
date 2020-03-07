package main.java.Question2;

public class PrintThread implements Runnable {
    int id;
    haveAccess print;
    PrintThread(int id,haveAccess print){
        this.print=print;
        this.id=id;
    }
    @Override
    public void run() {
        try {
            while (true){
               print.printHere();
            }
        }
        catch(Exception e)
        {
        }


    }
}
