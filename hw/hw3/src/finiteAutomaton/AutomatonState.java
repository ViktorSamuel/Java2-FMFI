package finiteAutomaton;

interface AutomatonState {
    boolean isAcceptingState();
    AutomatonState transition(char c);
}
