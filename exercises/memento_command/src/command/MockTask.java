package command;

public class MockTask implements Command{
    private int duration;
    private int id;

    public MockTask(int duration, int id) {
        this.duration = duration;
        this.id = id;
    }

    @Override
    public void execute() {
        System.out.println("Executing task " + id + " for " + duration + " seconds");
        try {
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + id + " finished");
    }

}
