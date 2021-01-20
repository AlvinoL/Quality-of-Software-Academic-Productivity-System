public class Lab {
    public ListaColaboradores allColabs;
    public ListaProjetos allProjs;
    public ProducaoAcademica allProdAcad;

    public Lab(ListaColaboradores allColabs, ListaProjetos allProjs, ProducaoAcademica allProdAcad) {
        this.allColabs = allColabs;
        this.allProjs = allProjs;
        this.allProdAcad = allProdAcad;
    }

    public ListaColaboradores getAllColabs() {
        return allColabs;
    }

    public ListaProjetos getAllProjs() {
        return allProjs;
    }

    public ProducaoAcademica getAllProdAcad() {
        return allProdAcad;
    }

    public void setAllColabs(ListaColaboradores allColabs) {
        this.allColabs = allColabs;
    }

    public void setAllProjs(ListaProjetos allProjs) {
        this.allProjs = allProjs;
    }

    public void setAllProdAcad(ProducaoAcademica allProdAcad) {
        this.allProdAcad = allProdAcad;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "\n\n allColabs=" + allColabs +
                ",\n\n allProjs=" + allProjs +
                ",\n\n allProdAcad=" + allProdAcad +
                '}';
    }

}
