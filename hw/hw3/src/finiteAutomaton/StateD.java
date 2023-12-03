package finiteAutomaton;

class StateD implements AutomatonState {
    @Override
    public boolean isAcceptingState() {
        return false;
    }

    @Override
    public AutomatonState transition(char c) {
        if (c == 'a') {
            return new StateC();
        } else if (c == 'b') {
            return this;
        } else {
            return null;
        }
    }
}

