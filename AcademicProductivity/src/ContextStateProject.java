public class ContextStateProject {
    private StateProject currentState;

    public ContextStateProject(){
        currentState = EmElaboracaoState.getInst();
    }

    public StateProject getCurrentState() {
        return currentState;
    }

    public void setCurrentState(StateProject currentState) {
        this.currentState = currentState;
    }

    public void goNextState(){
        currentState = currentState.goNextState();
    }
}
