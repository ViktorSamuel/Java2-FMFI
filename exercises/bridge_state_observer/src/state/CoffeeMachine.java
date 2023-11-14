package state;

public class CoffeeMachine {
    private CoffeeMachineState currentState;

    public CoffeeMachine() {
        currentState = new OffState();
    }

    public void switchPower() {
        currentState.switchPower(this);
    }

    public void pressEspresso() {
        currentState.pressEspresso(this);
    }

    public void pressCappuccino() {
        currentState.pressCappuccino(this);
    }

    public void setState(CoffeeMachineState state) {
        this.currentState = state;
    }
}