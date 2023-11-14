package state;

public interface CoffeeMachineState {
    void switchPower(CoffeeMachine coffeeMachine);
    void pressEspresso(CoffeeMachine coffeeMachine);
    void pressCappuccino(CoffeeMachine coffeeMachine);
}