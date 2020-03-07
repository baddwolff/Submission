package main.java.Question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedList {
    List<Integer> list;

    public SharedList(List<Integer> list) {
        this.list = list;
    }

    public synchronized  void  addList(Integer s){
        list.add(s);
        System.out.println("here");
    }

    public synchronized  void  removeList(Integer s){
        list.remove(s);
        System.out.println();
    }
}
