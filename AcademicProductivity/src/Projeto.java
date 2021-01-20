public class Projeto {
    private String titulo;
    private String inicioData;
    private String terminoData;
    private String agFinanciadora;
    private double valorFinanciado;
    private String objetivo;
    private String descricao;
    private Professor professorResponsavel;
    private ContextStateProject status;
//    private int status = 0;     //"Em Elaboração": 0;     "Em Andamento": 1;    "Concluído": 2;
    protected int id = -1;
    private ListaColaboradores participantes;
    public ProducaoAcademica projProdAcad;

//Construtor
    public Projeto(String titulo, String inicioData, String terminoData, String agFinanciadora, double valorFinanciado, String objetivo, String descricao, Professor professorResponsavel, ListaColaboradores participantes, ProducaoAcademica projProdAcad) {
        this.titulo = titulo;
        this.inicioData = inicioData;
        this.terminoData = terminoData;
        this.agFinanciadora = agFinanciadora;
        this.valorFinanciado = valorFinanciado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.professorResponsavel = professorResponsavel;
        this.status = new ContextStateProject();
        this.participantes = participantes;
        this.projProdAcad = projProdAcad;
    }

    //metodos
    //gets()
    public String getTitulo() {
        return titulo;
    }

    public String getInicioData() {
        return inicioData;
    }

    public String getTerminoData() {
        return terminoData;
    }

    public String getAgFinanciadora() {
        return agFinanciadora;
    }

    public double getValorFinanciado() {
        return valorFinanciado;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public ContextStateProject getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public ListaColaboradores getParticipantes() {
        return participantes;
    }

    public ProducaoAcademica getProjProdAcad() {
        return projProdAcad;
    }

    //sets()

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setInicioData(String inicioData) {
        this.inicioData = inicioData;
    }

    public void setTerminoData(String terminoData) {
        this.terminoData = terminoData;
    }

    public void setAgFinanciadora(String agFinanciadora) {
        this.agFinanciadora = agFinanciadora;
    }

    public void setValorFinanciado(double valorFinanciado) {
        this.valorFinanciado = valorFinanciado;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public void nextStatus() {
        this.status.goNextState();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParticipantes(ListaColaboradores participantes) {
        this.participantes = participantes;
    }

    public void setProjProdAcad(ProducaoAcademica projProdAcad) {
        this.projProdAcad = projProdAcad;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "titulo='" + titulo + '\'' +
                ", inicioData='" + inicioData + '\'' +
                ", terminoData='" + terminoData + '\'' +
                ", agFinanciadora='" + agFinanciadora + '\'' +
                ", valorFinanciado=" + valorFinanciado +
                ", objetivo='" + objetivo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", professorResponsavel=" + professorResponsavel +
                ", status=" + status +
                ", id=" + id +
                ", participantes=" + participantes +
                ", projProdAcad=" + projProdAcad +
                '}';
    }
}
