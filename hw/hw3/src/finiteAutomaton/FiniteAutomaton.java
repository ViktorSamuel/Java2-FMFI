package finiteAutomaton;

public class FiniteAutomaton {
    private AutomatonState currentState;

    public FiniteAutomaton() {
        this.currentState = new StateA();
    }

    public boolean isAcceptingState() {
        return currentState.isAcceptingState();
    }

    public void transition(char c) {
        currentState = currentState.transition(c);
    }
}
