package finiteAutomaton;

class StateB implements AutomatonState {
    @Override
    public boolean isAcceptingState() {
        return false;
    }

    @Override
    public AutomatonState transition(char c) {
        if (c == 'a') {
            return new StateA();
        } else if (c == 'b') {
            return new StateC();
        } else {
            return null;
        }
    }
}

