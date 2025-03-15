package ufersa.omdbapi.service;

import ufersa.omdbapi.dados.lista_encadeada.DoubleList;
import ufersa.omdbapi.exceptions.RecordTemporadaException;
import ufersa.omdbapi.model.*;
import ufersa.omdbapi.principal.Principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Buscar {
    private static Scanner scanner = new Scanner(System.in);
    private static ConsumoApi consumoApi = new ConsumoApi();
    private static ConverteDados converteDados = new ConverteDados();
    private static StringBuilder sb = new StringBuilder();

    public void buscarSerie(String nomeSerie) {
        String json = consumoApi.getDados(Principal.ENDERECO + nomeSerie.replace(" ", "+") + Principal.API_KEY);

        RecordSerie dadosSerie = converteDados.getDados(json, RecordSerie.class);

        Serie novaSerie = new Serie(dadosSerie);

        System.out.println(novaSerie);

        System.out.println(novaSerie.getEpisodios());
    }

    public void buscarFilme(String nomeFilme) {

        String json = consumoApi.getDados(Principal.ENDERECO + nomeFilme.replace(" ", "+") + Principal.API_KEY);

        RecordFilme dadosFilme = converteDados.getDados(json, RecordFilme.class);

        Filme novoFilme = new Filme(dadosFilme);

        System.out.println(novoFilme);
    }

    public List<Episodio> buscarEpisodio(String nome, int totalTemporadas) {

        List<RecordTemporada> temporadas = new ArrayList<>();

        for(int i = 1; i <= totalTemporadas; i++) {
            String json = consumoApi.getDados("https://www.omdbapi.com/?t=" + nome.replaceAll(" ", "+") + "&season="+i+"&apikey=bc5081ad");
            RecordTemporada dadosTemporada = converteDados.getDados(json, RecordTemporada.class);
            if(dadosTemporada.resposta().equals("False")){
                continue;
            }
            temporadas.add(dadosTemporada);
        }

        List<Episodio> episodios = new ArrayList<>();

        temporadas.forEach(t-> t.episodios()
                .stream().filter(e-> e.ep() >0)
                .forEach(e->{
            String j = consumoApi.getDados("https://www.omdbapi.com/?i=" + e.id() + "&apikey=bc5081ad");
            RecordEpisodio rE = converteDados.getDados(j, RecordEpisodio.class);
            Episodio novoEp = new Episodio(rE);
            episodios.add(novoEp);
        }));

        return episodios;
    }

}
