public class Pesquisador extends Colaboradores{
//    private int idPesquisador = 456;
    private String instituicaoExterna = "PixForce";
    //private <vetor-Publicacoes> listaPublicacoes;

    Pesquisador(String nome, String email, Projeto colabProject) {
        super(nome, email, colabProject);
    }

//metodos
    //gets
//    public int getIdPesquisador() {
//        return idPesquisador;
//    }

    public String getInstituicaoExterna(){
        return instituicaoExterna;
    }

    //sets
//    public void setIdPesquisador(int idPesquisador) {
//        this.idPesquisador = idPesquisador;
//    }

    public void setInstituicaoExterna(String instituicaoExterna) {
        this.instituicaoExterna = instituicaoExterna;
    }

    @Override
    public String toString() {
        return "Pesquisador{" +
//                "idPesquisador=" + idPesquisador +
                ", instituicaoExterna='" + instituicaoExterna + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
//                ", colabProdAcad=" + colabProdAcad +
                ", colabProject=" + colabProject +
                '}';
    }
}
