package main.java.service;

public class IdGeneratorService {

    private int currentIdValue;

    public IdGeneratorService(int currentIdValue) {
        this.currentIdValue = currentIdValue;
    }

    public int getCurrentIdValue() {
        return currentIdValue;
    }

    public void setCurrentIdValue(int currentIdValue) {
        this.currentIdValue = currentIdValue;
    }
}
