import java.util.ArrayList;

public class gerenciador {

    private ArrayList<musica> musicas = new ArrayList<musica>();

    public void adicionar(musica novoMusica) {
        musicas.add(novoMusica);
    }

    public void remover(int posicao) {
        musicas.remove(posicao);
    }

    public void printarLista() {
        for (musica musica : musicas) {
            System.out.println(musica.getNome() + ": " + musica.getMusica());
        }
    }

    public ArrayList<musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<musica> musicas) {
        this.musicas = musicas;
    }

    public int buscar(String nomeMusica){
        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i).getMusica().equals(nomeMusica)) {
                return i;
            }
        }
        return -1;

}
}


// achar o meio
// 