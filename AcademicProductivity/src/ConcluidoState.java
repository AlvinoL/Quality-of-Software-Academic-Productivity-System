class ConcluidoState implements StateProject{

    private static StateProject inst;

    private ConcluidoState() {
    }

    public static StateProject getInst() {
        if(inst == null){
            inst = new ConcluidoState();
        }
        return inst;
    }

    @Override
    public StateProject goNextState() {
        System.out.println("Projeto Concluido com Sucesso");
        return inst;
    }

    @Override
    public String toString() {
        return "Estado Concluido";
    }
}
