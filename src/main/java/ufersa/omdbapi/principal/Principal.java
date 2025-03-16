package ufersa.omdbapi.principal;

import ufersa.omdbapi.dados.fila.MyQueueLinkedList;
import ufersa.omdbapi.model.Filme;
import ufersa.omdbapi.model.Serie;
import ufersa.omdbapi.service.Buscar;
import ufersa.omdbapi.service.Arquivos;

import java.util.Scanner;

public class Principal {

    public static final String ENDERECO = "https://www.omdbapi.com/?t=";
    public static final String API_KEY = "&apikey=bc5081ad";
    private final Buscar bs = new Buscar();
    Scanner scanner = new Scanner(System.in);
    private final Arquivos manipularArquivos = new Arquivos();

    public void exibeMenu(){

        MyQueueLinkedList<Filme> listaFilmes = new MyQueueLinkedList<>();

        MyQueueLinkedList<Serie> listaSeries = new MyQueueLinkedList<>();

        String menu =
                """
                1- Exibir Filme
                2- Exibir série
                6- sair
                """;

        int opcao;
        do {
            System.out.println(menu);
            System.out.print("O que deseja fazer? ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Filme f = exibirFilme(listaFilmes);
                    System.out.print("Digite 1 para adicionar o filme a fila ");
                    int fila = scanner.nextInt();
                    scanner.nextLine();
                    if (fila == 1) {
                        listaFilmes.add(f);
                    }
                    break;
                case 2:
                    Serie s = exibirSerie();
                    System.out.print("Digite 1 para adicionar a série a fila ");
                    int filaSerie = scanner.nextInt();
                    scanner.nextLine();
                    if (filaSerie == 1) {
                        listaSeries.add(s);
                    }
                    break;
                case 3:
                    listarEpisodiosSerie();
                    break;
                case 4:
                    exibirFilaExibicaoFilmes();
                    break;
                //case 5: exibirFilaExibicaoSeries(); break;
                default:
                    System.out.println("opcao invalida");
            }
        }while(opcao != 6);

        //manipularArquivos.escreverFilmeBinario(listaFilmes);

        manipularArquivos.escreverFilmesTexto(listaFilmes);
        manipularArquivos.escreverSerieTexto(listaSeries);
    }

    private Filme exibirFilme(MyQueueLinkedList listaFilmes) {
        System.out.print("Digite o nome do filme: ");
        String filme = scanner.nextLine();
        System.out.println(bs.buscarFilme(filme));

        return bs.buscarFilme(filme);
    }

    private Serie exibirSerie() {
        System.out.print("Digite o nome do serie: ");
        String serie = scanner.nextLine();
        System.out.println(bs.buscarSerie(serie));

        return bs.buscarSerie(serie);
    }

    private void listarEpisodiosSerie() {
        System.out.print("Digite o nome do serie: ");
        String serie = scanner.nextLine();
        System.out.println(bs.buscarEpisodiosDaSerie(serie).getEpisodios());
    }

    private void exibirFilaExibicaoFilmes() {

    }
}
