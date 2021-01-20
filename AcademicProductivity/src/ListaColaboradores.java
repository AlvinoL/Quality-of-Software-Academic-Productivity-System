import java.util.Arrays;

public class ListaColaboradores {
    private Colaboradores listaColaboradores[];
    int current_colab = -1;

    public ListaColaboradores(int quant_colab){
        listaColaboradores = new Colaboradores[quant_colab];
    }

//metodos
    //gets()
    public Colaboradores[] getListaColaboradores() {
        return listaColaboradores;
    }
    //

    boolean addColab(Colaboradores my_colab){
        boolean result = false;
        if(current_colab+1 < listaColaboradores.length){
            current_colab++;
            my_colab.setId(current_colab);
            listaColaboradores[current_colab] = my_colab;
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "ListaColaboradores{" +
                "listaColaboradores=" + Arrays.toString(listaColaboradores) +
                '}';
    }
}
