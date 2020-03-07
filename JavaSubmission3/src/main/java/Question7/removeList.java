package main.java.Question7;

public class removeList implements Runnable {
    SharedList ls;

    public removeList(SharedList ls) {
        this.ls = ls;
    }

    @Override
    public void run() {
        int i=0;
        try {
            while (true){
                ls.removeList(i);
                System.out.println("removed");
                Thread.sleep(1000);
            }
        }
        catch(Exception e)
        {
            System.out.println("Interrupted exception " + e);
        }

    }
}
