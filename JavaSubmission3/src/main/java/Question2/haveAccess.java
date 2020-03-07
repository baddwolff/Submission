package main.java.Question2;

public class haveAccess {
    public boolean isFlag() {
        return flag;
    }

    boolean flag;
    haveAccess(boolean flag){
        this.flag=flag;
    }
    public synchronized  void printHere(){
        try {
            if(!flag){
                wait();
            }
            flag=false;
            System.out.println("here");
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
