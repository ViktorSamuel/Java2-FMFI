package explicit_locks;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SyncQueue {
    private final int capacity;
    private final ArrayList<Integer> array = new ArrayList<>();

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public SyncQueue(int capacity) {
        this.capacity = capacity;
    }

    public void push(int value) {
        lock.lock();
        try{
            while (array.size() >= capacity) {
                notFull.await();
            }
            array.add(value);
            notEmpty.signal();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }

    }
    public int pop() {
        int value = -1;
        lock.lock();
        try{
            while (array.isEmpty()) {
                notEmpty.await();
            }
            value = array.get(0);
            array.remove(0);
            notFull.signal();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
        return value;
    }
}

class Producer extends Thread {
    private final int id;
    private final SyncQueue q;

    public Producer(SyncQueue q, int id) {
        this.q = q;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            final int value = i * i;
            q.push(value);
            System.out.println("Producer #" + id + " pushed " + value);
        }
    }
}

class Consumer extends Thread {
    private final int id;
    private final SyncQueue q;
    private final int limit;

    public Consumer(SyncQueue q, int id, int limit) {
        this.id = id;
        this.q = q;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            final int value = q.pop();
            System.out.println("Consumer #" + id + " popped " + value);
        }
    }
}

public class Demo {
    public void show() {
        SyncQueue q = new SyncQueue(3);
        Thread c1 = new Consumer(q, 0, 5);
        Thread c2 = new Consumer(q, 1, 15);
        Thread p1 = new Producer(q, 2);
        Thread p2 = new Producer(q, 3);
        c1.start();
        p1.start();
        c2.start();
        p2.start();
    }
}
