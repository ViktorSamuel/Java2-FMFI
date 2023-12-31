package finiteAutomaton;

class StateA implements AutomatonState {
    @Override
    public boolean isAcceptingState() {
        return false;
    }

    @Override
    public AutomatonState transition(char c) {
        if (c == 'a') {
            return new StateB();
        } else if (c == 'b') {
            return this;
        }
        return null;
    }
}
