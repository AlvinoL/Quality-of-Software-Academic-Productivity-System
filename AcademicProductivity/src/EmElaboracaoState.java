class EmElaboracaoState implements StateProject{
    private static StateProject inst;

    private EmElaboracaoState(){

    }

    public static StateProject getInst() {
        if(inst == null){
            inst = new EmElaboracaoState();
        }
        return inst;
    }

    @Override
    public StateProject goNextState() {
        return EmAndamentoState.getInst();
    }

    @Override
    public String toString() {
        return "Estado Em Elaboracao";
    }
}
