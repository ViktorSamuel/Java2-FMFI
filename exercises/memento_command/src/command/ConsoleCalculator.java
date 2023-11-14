package command;

import java.util.Scanner;

// Invoker
public class ConsoleCalculator {
    private Calculator calculator;

    public ConsoleCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void run(){
        Command currentCommand = null;

        String input, command;
        int value;
        Scanner scanner = new Scanner(System.in);

        while(true){
            input = scanner.nextLine();

            if(input.equals("EXIT")){
                break;
            }

            String[] parts = input.split(" ");
            if(parts.length != 2){
                System.out.println("Invalid command");
                continue;
            }

            command = parts[0];

            try{
                value = Integer.parseInt(parts[1]);
            }catch(NumberFormatException e){
                System.out.println("Invalid command");
                continue;
            }

            Command previous = currentCommand;
            Boolean undo = true;

            switch(command){
                case "+":
                    currentCommand = new AddCommand(calculator, value);
                    break;
                case "-":
                    currentCommand = new SubstractCommand(calculator, value);
                    break;
                case "*":
                    currentCommand = new MultiplyCommand(calculator, value);
                    break;
                case "R":
                    currentCommand = new RepeatCommand(previous, value);
                    break;
                case "U":
                    currentCommand.undo();
                    undo = false;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }

            if(currentCommand != null && undo){
                currentCommand.execute();
            }
            System.out.println("Result: " + calculator.getAcc());
        }
        scanner.close();
    }
}
