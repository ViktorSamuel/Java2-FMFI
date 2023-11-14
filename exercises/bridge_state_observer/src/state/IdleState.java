package state;

public class IdleState implements CoffeeMachineState{
    @Override
    public void switchPower(CoffeeMachine coffeeMachine) {
        System.out.println("Switching power OFF");
        coffeeMachine.setState(new OffState());
    }

    @Override
    public void pressEspresso(CoffeeMachine coffeeMachine) {
        coffeeMachine.setState(new MakingExpressoState(coffeeMachine));
    }

    @Override
    public void pressCappuccino(CoffeeMachine coffeeMachine) {
        coffeeMachine.setState(new MakingCappucinoState(coffeeMachine));
    }
}
