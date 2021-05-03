package sbu.cs.multithread.pi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

public class Compute
{

    public int numDigits;
    private Lock lock;
    private MathContext mathContext;
    volatile BigDecimal pi = new BigDecimal(0);

    public Compute(int numDigits)
    {
        this.numDigits = numDigits;
        mathContext = new MathContext(numDigits);
    }

    public BigDecimal compute() throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(numDigits);
        PiCaculate piCaculate = new PiCaculate(numDigits);

        for (int i = 0; i < numDigits; i++) {
            int final_I = i;
            Thread thread = new Thread(() -> {
                //lock thread with synchronized method that can:
                //prevent interference threads
                synchronized ("") {
                    BigDecimal pi_I = piCaculate.piFunction(final_I);
                    pi = pi.add(pi_I);
                }
                countDownLatch.countDown();
            });

            executorService.submit(thread);
        }

        executorService.shutdown();
        countDownLatch.await();

        return pi.round(mathContext);
    }


}
