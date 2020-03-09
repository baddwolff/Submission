package main.java.Question5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question5 {
    public static void main(String args[]){
        List<Accounts> accountsList=new ArrayList<>();
        User user1=new User(1);
        User user2=new User(2);
        User user3=new User(3);

        accountsList.add(new Accounts(1,10000));
        accountsList.add(new Accounts(1,30000));
        accountsList.add(new Accounts(2,50000));
        accountsList.add(new Accounts(2,20000));
        accountsList.add(new Accounts(3,1000000));
        accountsList.add(new Accounts(3,220000));

        accountsList.stream()
                .sorted(Comparator.comparingInt(Accounts::getId)
                .thenComparing(Comparator.comparingInt(Accounts::getBalance)))
                .forEach(System.out::println);

    }

}
