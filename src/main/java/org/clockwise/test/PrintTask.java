package org.clockwise.test;

public class PrintTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Executed");
    }

}