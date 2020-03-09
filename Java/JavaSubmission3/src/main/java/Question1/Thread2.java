package main.java.Question1;

import java.util.ArrayList;
import java.util.List;

public class Thread2 implements Runnable{
    List<String> ls;
    public Thread2() {
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
            for(int i=ls.size()-1;i>=0;i--){
                System.out.println(ls.get(i));
            }
        }
        catch(Exception e) {
            System.out.println("Who dared to wake me up ? ");
        }
        System.out.println("thread is exiting");

    }
}
