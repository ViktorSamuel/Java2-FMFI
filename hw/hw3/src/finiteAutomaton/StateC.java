package finiteAutomaton;

class StateC implements AutomatonState {
    @Override
    public boolean isAcceptingState() {
        return true;
    }

    @Override
    public AutomatonState transition(char c) {
        if (c == 'b') {
            return new StateD();
        } else {
            return this;
        }
    }
}

