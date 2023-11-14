package command;

import com.sun.tools.jconsole.JConsoleContext;

public class Client {
    public static void main(String[] args) {
//        // Planner test
//        Planner planner = new Planner();
//
//        for(int i = 1; i <= 5; i++)
//            planner.addCommand(new MockTask(i, i*10), i*10);
//
//        planner.executeAll();
//
//        // Calculator test
//        Calculator calculator = new Calculator();
//        Command addCommand = new AddCommand(calculator, 10);
//        addCommand.execute();

        // Console Calculator test
        ConsoleCalculator consoleCalculator = new ConsoleCalculator(new Calculator());
        consoleCalculator.run();
    }
}
