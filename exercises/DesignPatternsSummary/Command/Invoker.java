package Command;

public class Invoker {
    private Command command;

    public Invoker() {
        this.command = null;
    }
    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand() {
        command.execute();
    }
}
