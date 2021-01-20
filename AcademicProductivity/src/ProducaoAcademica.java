import java.util.Arrays;

public class ProducaoAcademica {
    public Orientacao listaOrientacao[];
    int current_orient = -1;

    public Publicacao listaPublicacao[];
    int current_pub = -1;

    public ProducaoAcademica(int quant_orient, int quant_pub) {
        listaOrientacao = new Orientacao[quant_orient];
        listaPublicacao = new Publicacao[quant_pub];
    }

//metodos
    //gets()
    public Orientacao[] getListaOrientacao() {
        return listaOrientacao;
    }

    public Publicacao[] getListaPublicacao() {
        return listaPublicacao;
    }

    boolean addOrientacao(Orientacao orient){
        boolean result = false;
        if(current_orient+1 < listaOrientacao.length){
            current_orient++;
            listaOrientacao[current_orient] = orient;
            result = true;
        }
        return result;
    }

    boolean addPublicacao(Publicacao my_public){
        boolean result = false;
        if(current_pub+1 < listaPublicacao.length){
            current_pub++;
            listaPublicacao[current_pub] = my_public;
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "ProducaoAcademica{" +
                "listaOrientacao=" + Arrays.toString(listaOrientacao) +
                ", listaPublicacao=" + Arrays.toString(listaPublicacao) +
                '}';
    }
}
