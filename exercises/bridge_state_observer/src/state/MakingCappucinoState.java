package state;

public class MakingCappucinoState implements CoffeeMachineState {
    public MakingCappucinoState(CoffeeMachine coffeeMachine) {
        System.out.println("Errrrrrrr!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Take your Espresso!");
        // Transition to IdleState
        coffeeMachine.setState(new IdleState());
    }

    @Override
    public void switchPower(CoffeeMachine coffeeMachine) {
        // Do nothing while making espresso
    }

    @Override
    public void pressEspresso(CoffeeMachine coffeeMachine) {
        // Do nothing while making espresso
    }

    @Override
    public void pressCappuccino(CoffeeMachine coffeeMachine) {
        // Do nothing while making espresso
    }
}
