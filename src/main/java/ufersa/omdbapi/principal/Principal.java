package ufersa.omdbapi.principal;

import ufersa.omdbapi.dados.fila.MyQueueLinkedList;
import ufersa.omdbapi.dados.lista_encadeada.DoubleList;
import ufersa.omdbapi.model.Episodio;
import ufersa.omdbapi.model.Filme;
import ufersa.omdbapi.model.Serie;
import ufersa.omdbapi.search.Search;
import ufersa.omdbapi.service.api.Buscar;
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

        manipularArquivos.escreverSerieBinario(listaSeries);
        manipularArquivos.escreverSerieTexto(listaSeries);
        manipularArquivos.escreverFilmeBinario(listaFilmes);
        manipularArquivos.escreverFilmesTexto(listaFilmes);
    }

}
