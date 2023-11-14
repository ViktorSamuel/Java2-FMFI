package command;

public class RepeatCommand implements Command{
    private Command command;
    private int times;

    public RepeatCommand(Command command, int times) {
        this.command = command;
        this.times = times;
    }

    @Override
    public void execute(){
        for(int i = 0; i < times; i++){
            command.execute();
        }
    }

    @Override
    public void undo(){
        for(int i = 0; i < times; i++){
            command.undo();
        }
    }
}
