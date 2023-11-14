package state;

public class OffState implements CoffeeMachineState{
    @Override
    public void switchPower(CoffeeMachine coffeeMachine) {
        System.out.println("Switching power ON");
        coffeeMachine.setState(new IdleState());
    }

    @Override
    public void pressEspresso(CoffeeMachine coffeeMachine) {
        System.out.println("Power is off. Pressing Espresso does nothing.");
    }

    @Override
    public void pressCappuccino(CoffeeMachine coffeeMachine) {
        System.out.println("Power is off. Pressing Cappuccino does nothing.");
    }
}
