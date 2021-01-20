public class Colaboradores {
    protected String nome;
    protected String email;
    protected int id = -1;
//    protected ProducaoAcademica colabProdAcad;
    protected Projeto colabProject;

    //construtor
    public Colaboradores(String nome, String email, Projeto colabProject) {
        this.nome = nome;
        this.email = email;
//        this.colabProdAcad = colabProdAcad;
        this.colabProject = colabProject;
    }

    //metodos

    //gets()
    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public int getId() {
        return id;
    }

//    public ProducaoAcademica getColabProdAcad() {
//        return colabProdAcad;
//    }

    public Projeto getColabProject() {
        return colabProject;
    }

    //sets()
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public void setColabProdAcad(ProducaoAcademica colabProdAcad) {
//        this.colabProdAcad = colabProdAcad;
//    }

    public void setColabProject(Projeto colabProject) {
        this.colabProject = colabProject;
    }
}
