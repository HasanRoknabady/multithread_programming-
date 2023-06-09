package sbu.cs.multithread.priority;

import java.util.concurrent.CountDownLatch;

public class BlackThread extends ColorThread {

    private CountDownLatch countDownLatch;
    public BlackThread(CountDownLatch countDownLatch)
    {
        this.countDownLatch = countDownLatch;
    }

    private static final String MESSAGE = "hi blues, hi whites";

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
