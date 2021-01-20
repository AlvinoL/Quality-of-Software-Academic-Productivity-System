public class Professor extends Colaboradores{
//    private int idProfessor = -1;
    //private <vetor-Orientacoes> listaOrientacoes;
    //private <vetor-Publicacoes> listaPublicacoes;

    Professor(String nome, String email, Projeto colabProject) {
        super(nome, email, colabProject);
//        setIdProfessor(idProfessor++);
    }

    //metodos
    //gets()
//    public int getIdProfessor() {
//        return idProfessor;
//    }

    //sets()
//    public void setIdProfessor(int idProfessor) {
//        this.idProfessor = idProfessor;
//    }

    @Override
    public String toString() {
        return "Professor{" +
//                "idProfessor=" + idProfessor +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
//                ", colabProdAcad=" + colabProdAcad +
                ", colabProject=" + colabProject +
                '}';
    }
}
