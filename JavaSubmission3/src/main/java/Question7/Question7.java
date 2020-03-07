package main.java.Question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question7 {
    public static void main(String args[]){

        List<Integer> list =
                Collections.synchronizedList(new ArrayList<Integer>());

        SharedList ls=new SharedList(list);
        addList o1=new addList(ls);
        removeList o2=new removeList(ls);
        Thread t1=new Thread(o1);
        Thread t2=new Thread(o2);

        t1.start();
        t2.start();

    }
}
