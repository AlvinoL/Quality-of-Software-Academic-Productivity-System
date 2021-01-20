import java.util.Arrays;

public class ListaProjetos {
    private Projeto listaProjetos[];
    int current_projeto = -1;

    public ListaProjetos(int quant_proj){
        listaProjetos = new Projeto[quant_proj];
    }

//metodos
    //gets()
    public Projeto[] getListaProjetos() {
        return listaProjetos;
    }

    //
    boolean addProjeto(Projeto my_proj){
        boolean result = false;
        if(current_projeto+1 < listaProjetos.length){
            current_projeto++;
            my_proj.setId(current_projeto);
            listaProjetos[current_projeto] = my_proj;
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "ListaProjetos{" +
                "listaProjetos=" + Arrays.toString(listaProjetos) +
                '}';
    }
}
