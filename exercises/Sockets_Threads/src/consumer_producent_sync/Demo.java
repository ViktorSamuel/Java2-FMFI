package consumer_producent_sync;

interface Storage {
    int pop();
    void push(int c);
}

class NaiveStorage implements Storage{
    private int content;

    public int pop() {
        return content;
    }

    public void push(int c) {
        content = c;
    }
}

class NaiveSyncStorage implements Storage {
    private int content;
    public synchronized int pop() {
        return content;
    }

    @Override
    public synchronized void push(int c) {
        content = c;
    }
}

class SyncStorage implements Storage {
    private int contents;
    private boolean isFull = false;
    @Override
    public synchronized int pop() {
        while (!isFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isFull = false;
        notify();
        return contents;

    }

    @Override
    public synchronized void push(int c) {
        while (isFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isFull = true;
        contents = c;
        notify();
    }
}

class Producer extends Thread {
    private final Storage s;
    private final int id;

    public Producer(Storage s, int id) {
        this.s = s;
        this.id = id;
    }

    public Producer(Storage s) {
        this(s, 0);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final int value = i * i;
            s.push(value);
            System.out.println("Producer "+ id + " sent value: " + value);
        }
    }
}

class Consumer extends Thread {
    private final Storage s;
    private final int id;

    public Consumer(Storage s, int id) {
        this.s = s;
        this.id = id;
    }

    public Consumer(Storage s) {
        this(s, 0);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // yield(); 4.
            int value = s.pop();
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer " + id + " got value: " + value);
            //yield(); 3.
        }
    }
}

public class Demo {
    public void show_1() {
        // 1. try without any synchronization
        Storage s = new NaiveStorage();
        // 2. try with just synchronization
        // Storage s = new NaiveSyncStorage();
        // 3. correct synchronization
        // Storage s = new SyncStorage();
        Thread p = new Producer(s);
        Thread c = new Consumer(s);
        p.start();
        c.start();
    }
    public void show_2() {
        Storage s = new SyncStorage();
        Thread p1 = new Producer(s, 1);
        Thread p2 = new Producer(s, 2);
        Thread c1 = new Consumer(s, 1);
        Thread c2 = new Consumer(s, 2);
        // 1. try without setting priorities
        // 2. try set higher priority for the first consument
        // 3. add yield() to the consument
        p1.start();
        p2.start();
        // c1.setPriority(10); // 2. 3. 4.
        c1.start();
        c2.start();
    }
}
