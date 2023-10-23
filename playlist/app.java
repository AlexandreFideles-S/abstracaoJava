import java.util.ArrayList;
import java.util.Scanner;

public class app {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        gerenciador g1 = new gerenciador();

        while (true) {
            System.out.println("Bem vindo a Playlist");
            System.out.println("O que deseja fazer?");
            System.out.println("1. Adicionar musica");
            System.out.println("2. Remover musica");
            System.out.println("3. Exibir lista");
            System.out.println("4. Você quer buscar uma música?");
            System.out.println("0. sair");

            System.out.println("");

            int resposta = ler.nextInt();

            if (resposta == 0) {
                System.exit(0);
            } else if (resposta == 1) {
                musica m1 = new musica();

                System.out.println("Digite o nome da musica");
                ler.nextLine();
                m1.setMusica(ler.nextLine());
                System.out.println("Digite o nome do artista");
                m1.setNome(ler.nextLine());
                g1.adicionar(m1);
            }

            else if (resposta == 2) {
                System.out.println("Digite o numero da musica para remover: ");
                g1.remover(ler.nextInt());

            } else if (resposta == 3) {
                g1.printarLista();
            }

            else if (resposta == 4) {
                System.out.println("Digite o nome da música");
                String nomeMusica = ler.next();
           
                int posicao = g1.buscar(nomeMusica);
                if (posicao == -1) {
                    System.out.println("Música não encontrada");
                    System.out.println("");
                } else {
                    System.out.println("Música encontrada na posição: " + posicao);
                    System.out.println("");
                }

            }

        }

    }
}
