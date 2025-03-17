package ufersa.omdbapi.principal;

import ufersa.omdbapi.dados.fila.MyQueueLinkedList;
import ufersa.omdbapi.dados.lista_encadeada.DoubleList;
import ufersa.omdbapi.model.Episodio;
import ufersa.omdbapi.model.Filme;
import ufersa.omdbapi.model.Serie;
import ufersa.omdbapi.search.Search;
import ufersa.omdbapi.service.Buscar;
import ufersa.omdbapi.service.Arquivos;
import ufersa.omdbapi.sorting.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {

    private final Buscar bs = new Buscar();
    Scanner scanner = new Scanner(System.in);
    private final Arquivos manipularArquivos = new Arquivos();
    private final Sorting sorting = new Sorting();
    private final Search search = new Search();

    public void exibeMenu(){

        MyQueueLinkedList<Filme> listaFilmes = manipularArquivos.lerFilmeBinario();

        MyQueueLinkedList<Serie> listaSeries = manipularArquivos.lerSerieBinario();

        String menu =
                """
                1- Exibir Filme
                2- Exibir série
                3- Listar Filmes
                4- Listar Séries
                5- Listar Episódios
                6- Remover Filme
                7- Remover Serie
                8- Buscar Filme na lista
                9- Buscar Serie na lista
                10- sair
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
                    exibirFilaExibicaoFilmes(listaFilmes);
                    break;
                case 4:
                    exibirFilaExibicaoSeries(listaSeries);
                    break;
                case 5: listarEpisodiosSerie(); break;
                case 6:
                    if(listaFilmes.isEmpty())
                        System.out.println("Lista vazia");
                    else
                        listaFilmes.remove();
                    break;
                case 7:
                    if(listaSeries.isEmpty())
                        System.out.println("Lista vazia");
                    else
                        listaSeries.remove();
                    break;
                case 8:
                    checarListaFilmes(listaFilmes);
                    break;
                default:
                    System.out.println("Saindo...");
            }
        }while(opcao != 9);

        manipularArquivos.escreverSerieBinario(listaSeries);
        manipularArquivos.escreverSerieTexto(listaSeries);
        manipularArquivos.escreverFilmeBinario(listaFilmes);
        manipularArquivos.escreverFilmesTexto(listaFilmes);
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

        Serie s = bs.buscarEpisodiosDaSerie(serie);

        DoubleList<Episodio> episodios = s.getEpisodios();

        int tam = episodios.getSize();

        Episodio[] eps = new Episodio[tam];

        for(int i = 0; i < tam; i++) {
            eps[i] = episodios.removeFirst();
        }

        sorting.quickSort(eps, Comparator.comparing(Episodio::getAvaliacaoImdb));

        System.out.println(Arrays.toString(eps));

        manipularArquivos.imprimirEpisodiosOrdenados(eps);
    }

    private void exibirFilaExibicaoFilmes(MyQueueLinkedList<Filme> listaFilmes) {
        listaFilmes.show();
    }

    private void exibirFilaExibicaoSeries(MyQueueLinkedList<Serie> listaSeries) {
        listaSeries.show();
    }

    private void checarListaFilmes(MyQueueLinkedList<Filme> listaFilmes) {

        System.out.print("Digite um filme para buscar na lista: ");
        String leitura = scanner.nextLine();

        Filme busca = bs.buscarFilme(leitura);

        MyQueueLinkedList<Filme> filmes = listaFilmes;

        DoubleList<Filme> f = new DoubleList<>();

        while (!filmes.isEmpty()) {
            f.addLast(filmes.remove());
        }

        Filme[] eps = new Filme[f.getSize()];

        for (int i = 0; i < f.getSize(); i++) {
            eps[i] = f.removeFirst();
        }

        int resposta = search.binarySearch(eps, busca);

        if (resposta == -1) {
            System.out.println("Filme não está na lista.");
        } else {
            System.out.println("Filme já adicionado.");
        }

    }
}
