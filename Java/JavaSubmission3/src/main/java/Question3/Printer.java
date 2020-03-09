package main.java.Question3;

public class Printer {

    public boolean isFlag() {
        return flag;
    }

    boolean flag;
    Printer(boolean flag){
        this.flag=flag;
    }
    public synchronized  void printHere(int id){
        try {
            if(!flag){
                wait();
            }
            flag=false;
            System.out.println(id);
            Thread.sleep(1000);
            flag=true;
            notify();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted exception " + e);
        }



    }
}
