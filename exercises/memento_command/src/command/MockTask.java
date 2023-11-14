package command;

public class MockTask implements Command{
    private int id;
    private int duration;

    public MockTask(int id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public void execute(){
        try{
            Thread.sleep(duration);
            System.out.println("Task " + id + " finished");
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void undo(){

    }

}
