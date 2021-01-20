public class Orientacao {
    private Professor orientador;
    private Aluno orientando;

    //construtor
    public Orientacao(Professor orientador, Aluno orientando) {
        this.orientador = orientador;
        this.orientando = orientando;
    }

//metodos
    //gets()
    public Professor getOrientador() {
        return orientador;
    }

    public Aluno getOrientando() {
        return orientando;
    }

    //sets()
    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }

    public void setOrientando(Aluno orientando) {
        this.orientando = orientando;
    }

    @Override
    public String toString() {
        return "Orientacao{" +
                "orientador=" + orientador +
                ", orientando=" + orientando +
                '}';
    }
}
