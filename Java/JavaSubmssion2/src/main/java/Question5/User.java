package main.java.Question5;

import java.util.ArrayList;
import java.util.List;

public class User {
    public User(int id) {

        this.id = id;
        accounts=new ArrayList<>();
    }

    int id;
    final List<Accounts> accounts;
}
