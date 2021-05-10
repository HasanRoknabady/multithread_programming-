package sbu.cs.multithread.priority;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner
{
    public static List<Message> messages = new ArrayList<>();
    /**
     * add your codes to this function. this function is the caller function which will be called first.
     * changing other codes in this function is allowed.
     *
     * @param blackCount    number of black threads
     * @param blueCount     number of blue threads
     * @param whiteCount    number of white threads
     */
    public void run(int blackCount, int blueCount, int whiteCount) throws InterruptedException {
        List<ColorThread> colorThreads = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        CountDownLatch BLACKTHREAD = new CountDownLatch(blackCount);
        CountDownLatch BLUETHREAD = new CountDownLatch(blueCount);
        CountDownLatch WHITETHREAD = new CountDownLatch(whiteCount);


        for (int i = 0; i < blackCount; i++) {
            BlackThread blackThread = new BlackThread(BLACKTHREAD);
            colorThreads.add(blackThread);
            blackThread.start();
        }BLACKTHREAD.await();


        for (int i = 0; i < blueCount; i++) {
            BlueThread blueThread = new BlueThread(BLUETHREAD);
            colorThreads.add(blueThread);
            blueThread.start();
        }BLUETHREAD.await();


        for (int i = 0; i < whiteCount; i++) {
            WhiteThread whiteThread = new WhiteThread(WHITETHREAD);
            colorThreads.add(whiteThread);
            whiteThread.start();
        }WHITETHREAD.await();

    }

    synchronized public static void addToList(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {}
}
