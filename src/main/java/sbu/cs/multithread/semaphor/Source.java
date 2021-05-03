package sbu.cs.multithread.semaphor;

import java.util.concurrent.Semaphore;

public class Source
{
    private static Semaphore semaphore = new Semaphore(2);


    public static void getSource() throws InterruptedException
    {
        // some process that is limited to 2 persons concurrently
        semaphore.acquire();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}
