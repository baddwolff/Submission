package main.java.Question9;

public class User {
    String username;

    public String readUser() {
        return username;
    }

    public void updateUser(String username) {
        this.username = username;
    }

    public User(String username) {
        this.username = username;
    }
}
