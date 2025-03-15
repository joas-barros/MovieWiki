package ufersa.omdbapi.principal;

import ufersa.omdbapi.service.Buscar;

public class Principal {

    public static final String ENDERECO = "https://www.omdbapi.com/?t=";
    public static final String API_KEY = "&apikey=bc5081ad";
    private final Buscar bs = new Buscar();

    public void exibeMenu(){
        bs.exibirFilme();
        bs.exibirSerie();
        bs.exibirEpisodio();
    }
}
