package main.java.Question5;

public class Accounts {
    int id;
    int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Accounts(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
