package ufersa.omdbapi.principal;

import ufersa.omdbapi.dados.fila.MyQueueLinkedList;
import ufersa.omdbapi.model.Filme;
import ufersa.omdbapi.service.ArquivoBinarioFilme;
import ufersa.omdbapi.service.Buscar;

import java.util.Scanner;

public class Principal {

    public static final String ENDERECO = "https://www.omdbapi.com/?t=";
    public static final String API_KEY = "&apikey=bc5081ad";
    private final Buscar bs = new Buscar();
    Scanner scanner = new Scanner(System.in);
    private final ArquivoBinarioFilme arquivoFilme = new ArquivoBinarioFilme();

    public void exibeMenu(){

        MyQueueLinkedList<Filme> listaFilmes = new MyQueueLinkedList<>();

        String menu =
                """
                1- Exibir Filme
                2- Exibir série
                3- Listar episódios da série
                4- Exibir fila de filmes
                5- Exibir fila de séries
                6- sair
                """;

        System.out.println(menu);
        System.out.print("O que deseja fazer? ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1: Filme f = exibirFilme(listaFilmes);
                System.out.print("Digite 1 para adicionar o filme a fila ");
                int fila = scanner.nextInt();
                scanner.nextLine();
                if(fila == 1){
                    listaFilmes.add(f);
                } break;

            case 2: exibirSerie(); break;
            case 3: listarEpisodiosSerie(); break;
            case 4: exibirFilaExibicaoFilmes(); break;
            //case 5: exibirFilaExibicaoSeries(); break;
            default:
                System.out.println("opcao invalida");
        }

        //arquivoFilme.escreverFilmes(listaFilmes);
    }

    private Filme exibirFilme(MyQueueLinkedList listaFilmes) {
        System.out.print("Digite o nome do filme: ");
        String filme = scanner.nextLine();
        System.out.println(bs.buscarFilme(filme));

        return bs.buscarFilme(filme);

    }

    private void exibirSerie() {
        System.out.print("Digite o nome do serie: ");
        String serie = scanner.nextLine();
        System.out.println(bs.buscarSerie(serie));
    }

    private void listarEpisodiosSerie() {
        System.out.print("Digite o nome do serie: ");
        String serie = scanner.nextLine();
        System.out.println(bs.buscarEpisodiosDaSerie(serie).getEpisodios());
    }

    private void exibirFilaExibicaoFilmes() {
        arquivoFilme.listarFilmes();
    }
}
