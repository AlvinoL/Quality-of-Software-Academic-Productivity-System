public class Publicacao{
    private String titulo;
    private String nomeConferencia;
    private int anoPublicacao;
    private Projeto projeto;
    // lista de colaboradores autores
    private ListaColaboradores autores;


    public Publicacao(String titulo, String nomeConferencia, int anoPublicacao, Projeto projeto, ListaColaboradores autores) {
        this.titulo = titulo;
        this.nomeConferencia = nomeConferencia;
        this.anoPublicacao = anoPublicacao;
        this.projeto = projeto;
        this.autores = autores;
    }

    //metodos
    //gets()
    public String getTitulo() {
        return titulo;
    }

    public String getNomeConferencia() {
        return nomeConferencia;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public ListaColaboradores getAutores() {
        return autores;
    }

    //sets()

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNomeConferencia(String nomeConferencia) {
        this.nomeConferencia = nomeConferencia;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public void setAutores(ListaColaboradores autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "titulo='" + titulo + '\'' +
                ", nomeConferencia='" + nomeConferencia + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", projeto=" + projeto +
                ", autores=" + autores +
                '}';
    }
}
