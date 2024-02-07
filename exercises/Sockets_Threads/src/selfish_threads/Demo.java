package selfish_threads;

import java.util.ArrayList;

class SelfishThread extends Thread {
    public SelfishThread(int id) {
        super(String.valueOf(id));
    }

    @Override
    public void run() {
        System.out.println("thread #" +getName() + " started");
        for (long i = 0; i < 500000000; i++) {
            if (i % 10000000 == 0) {
                System.out.println("thread #" + getName() + ": tik " + i);
            }
        }
        System.out.println("thread #" +getName() + " finished");
    }
}

public class Demo {
    public void show() {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int id = 0; id < 5; id++) {
            threads.add(new SelfishThread(id));
        }
        for (Thread t: threads) {
            t.start();
        }
        // Based on the output, do your system
        // have the time-slicing feature enabled?
    }
}
