package main.java.Question3;

import main.java.Question2.PrintThread;
import main.java.Question2.haveAccess;

public class SkipCounterThread implements Runnable {
    int id;
    Printer print;
    SkipCounterThread(int id, Printer print){
        this.print=print;
        this.id=id;
    }
    @Override
    public void run() {
        try {
            while (true){
                print.printHere(id);
                Thread.sleep(1000);
                id+=2;
            }
        }
        catch(Exception e)
        {
        }


    }
}
