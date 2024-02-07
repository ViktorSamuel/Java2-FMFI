package threads_and_runnable;

class HelloWorldThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello, World");
    }
}

class SleepyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("I'll just go to sleep for a couple of seconds");
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            System.out.println("Someone tries to wake me :(");
        }
        System.out.println("Ok, I am back and running");

    }
}

public class Demo {
    public void show() {
        Thread t = new HelloWorldThread();
        System.out.println("priority: " + t.getPriority());
        System.out.println("state: " + t.getState());
        t.run();
        System.out.println("state: " + t.getState());
        // see, we haven't start the thread, we just called
        // the underlying show() method;
        // to start a thread, we have to call the method start()
        t.start();
        // sometimes we can catch it in the process
        System.out.println("state: " + t.getState());
        System.out.println("state: " + t.getState());

        Runnable r = new SleepyThread();
        new Thread(r).start();
    }

}
