package main.java.Question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question7 {
    public static void main(String args[]){

        List<Integer> list =
                Collections.synchronizedList(new ArrayList<Integer>());
        list.add(1);

        addList o1=new addList(list);
        removeList o2=new removeList(list);
        Thread t1=new Thread(o1);
        Thread t2=new Thread(o2);

        t1.start();
        t2.start();


    }
}
