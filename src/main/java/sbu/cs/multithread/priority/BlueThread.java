package sbu.cs.multithread.priority;

import java.util.concurrent.CountDownLatch;

public class BlueThread extends ColorThread {

    private final CountDownLatch countDownLatch;

    public BlueThread(CountDownLatch countDownLatch)
    {
        this.countDownLatch = countDownLatch;
    }

    private static final String MESSAGE = "hi back blacks, hi whites";

    void printMessage() {
        super.printMessage(new Message(this.getClass().getName(), getMessage()));
    }

    @Override
    String getMessage() {
        return MESSAGE;
    }

    @Override
    public void run()
    {
        printMessage();
        countDownLatch.countDown();
    }
}
