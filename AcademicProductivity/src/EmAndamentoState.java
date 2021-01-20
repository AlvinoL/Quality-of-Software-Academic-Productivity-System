import javax.swing.plaf.nimbus.State;

class EmAndamentoState implements StateProject{
    private static StateProject inst;

    private EmAndamentoState() {
    }

    public static StateProject getInst() {
        if(inst == null){
            inst = new EmAndamentoState();
        }
        return inst;
    }

    @Override
    public StateProject goNextState() {
        return ConcluidoState.getInst();
    }

    @Override
    public String toString() {
        return "Estado Em Andamento";
    }
}
