package main.java.Question1;

import java.util.ArrayList;
import java.util.List;

public class Thread1 implements Runnable {
    List<String> ls;
    public Thread1() {
        this.ls=new ArrayList<>();
        ls.add("*");
        ls.add("**");
        ls.add("***");
        ls.add("****");
        ls.add("*****");

    }

    @Override
    public void run() {
        try{
            for(int i=0;i<ls.size();i++){
                System.out.println(ls.get(i));
            }
        }
        catch(Exception e) {
            System.out.println("Who dared to wake me up ? ");
        }
        System.out.println("thread is exiting");

    }

}
