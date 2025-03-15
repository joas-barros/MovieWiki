package ufersa.omdbapi.service;

import ufersa.omdbapi.model.*;

import java.util.Scanner;

public class Buscar {
    private static Scanner scanner = new Scanner(System.in);
    private static ConsumoApi consumoApi = new ConsumoApi();
    private static ConverteDados converteDados = new ConverteDados();
    private static StringBuilder sb = new StringBuilder();

    public void exibirSerie(){
        String serie  = "https://www.omdbapi.com/?t=peacemaker&apikey=bc5081ad";

        String json = consumoApi.getDados(serie);

        RecordSerie dadosSerie = converteDados.getDados(json, RecordSerie.class);

        Serie novaSerie = new Serie(dadosSerie);

        System.out.println(novaSerie);
    }

    public void exibirFilme() {
        String filme = "https://www.omdbapi.com/?t=avengers&apikey=bc5081ad";

        String json = consumoApi.getDados(filme);

        RecordFilme dadosFilme = converteDados.getDados(json, RecordFilme.class);

        Filme novoFilme = new Filme(dadosFilme);

        System.out.println(novoFilme);
    }

    public void exibirEpisodio() {
        String episodio = "https://www.omdbapi.com/?t=game+of+thrones&season=1&episode=7&apikey=bc5081ad";

        String json = consumoApi.getDados(episodio);

        RecordEpisodio dadosEp = converteDados.getDados(json, RecordEpisodio.class);

        Episodio novoEp = new Episodio(dadosEp);

        System.out.println(novoEp);
    }
}
