package main.java.Question7;

import java.util.Iterator;
import java.util.List;

public class removeList implements Runnable {
    List<Integer> ls;



    public removeList(List<Integer> ls) {
        this.ls = ls;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ls) {
                int i = 0;
                try {
                    Iterator iter = ls.iterator();
                    if (iter == null) {
                        System.exit(1);
                    }
                    while (iter.hasNext()) {
//                        System.out.println(iter.next());
                        iter.next();
                        iter.remove();
                        System.out.println("removed");
                    }

                    Thread.sleep(1000);

                } catch (Exception e) {
                    System.out.println("Interrupted exception " + e);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
