package sbu.cs.multithread.semaphor;

public class Chef extends Thread {

    public Chef(String name)
    {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try
            {
                Source.getSource();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
