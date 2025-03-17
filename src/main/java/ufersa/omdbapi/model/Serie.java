package ufersa.omdbapi.model;

import ufersa.omdbapi.dados.lista_encadeada.DoubleList;
import ufersa.omdbapi.service.api.Buscar;

import java.io.Serializable;
import java.util.*;

public class Serie implements Serializable, Comparable<Serie> {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private Integer anoLancamento;
    private Integer anoFinal;
    private String classificacaoIndicativa;
    private String[] dataLancamento;
    private Integer duracaoEpisodio;
    private DoubleList<Categoria> generos;
    private String[] diretores;
    private String[] roteiristas;
    private String[] atores;
    private String sinopse;
    private String[] idiomas;
    private String[] paises;
    private String premios;
    private String poster;
    private Double avaliacaoImdb;
    private Integer votosImdb;
    private String idImdb;
    private String tipo;
    private Integer quantidadeTemporadas;
    private DoubleList<Episodio> episodios = new DoubleList<>();

    public Serie(RecordSerie serie) {
        this.titulo = serie.titulo();
        this.anoLancamento = OptionalInt.of(Integer.valueOf(serie.anosDuracao().split("–")[0])).orElse(-1);
        if(serie.anosDuracao().length()>5)
            this.anoFinal = OptionalInt.of(Integer.valueOf(serie.anosDuracao().split("–")[1])).orElse(-1);
        else this.anoFinal = null;
        this.classificacaoIndicativa = serie.classificacaoIndicativa();
        this.dataLancamento = serie.lancamento().split(" ");
        if(serie.duracaoEpisodio().equalsIgnoreCase("N/A"))
            this.duracaoEpisodio = null;
        else
            this.duracaoEpisodio = OptionalInt.of(Integer.valueOf(serie.duracaoEpisodio().split(" ")[0])).orElse(-0);
        this.generos = serie.genero().equals("N/A") ? null : Categoria.fromString(serie.genero());
        this.diretores = serie.diretor().equals("N/A") ? null : serie.diretor().split(",");
        this.roteiristas = serie.roteirista().split(",");
        this.atores = serie.atores().equals("N/A") ? null : serie.atores().split(",");
        this.sinopse = serie.sinopse().equals("N/A") ? null :  serie.sinopse();
        this.idiomas = serie.idiomas().equals("N/A") ? null : serie.idiomas().split(",");
        this.paises = serie.paises().equals("N/A") ? null : serie.paises().split(",");
        this.premios = serie.premios().equals("N/A") ? null : serie.premios();
        this.poster = serie.poster().equals("N/A") ? null : serie.poster();
        this.avaliacaoImdb = OptionalDouble.of(Double.valueOf(serie.avaliacaoImdb())).orElse(-0);
        this.votosImdb = Integer.valueOf(serie.votosImdb().replaceAll(",", ""));
        this.idImdb = serie.idImdb();
        this.tipo = serie.tipo();
        this.quantidadeTemporadas = Integer.valueOf(serie.quantidadeTemporadas());
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Integer getAnoFinal() {
        return anoFinal;
    }

    public void setAnoFinal(Integer anoFinal) {
        this.anoFinal = anoFinal;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String[] getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String[] dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Integer getDuracaoEpisodio() {
        return duracaoEpisodio;
    }

    public void setDuracaoEpisodio(Integer duracaoEpisodio) {
        this.duracaoEpisodio = duracaoEpisodio;
    }

    public DoubleList<Categoria> getGeneros() {
        return generos;
    }

    public void setGeneros(DoubleList<Categoria> generos) {
        this.generos = generos;
    }

    public String[] getDiretores() {
        return diretores;
    }

    public void setDiretores(String[] diretores) {
        this.diretores = diretores;
    }

    public String[] getRoteiristas() {
        return roteiristas;
    }

    public void setRoteiristas(String[] roteiristas) {
        this.roteiristas = roteiristas;
    }

    public String[] getAtores() {
        return atores;
    }

    public void setAtores(String[] atores) {
        this.atores = atores;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    public String[] getPaises() {
        return paises;
    }

    public void setPaises(String[] paises) {
        this.paises = paises;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Double getAvaliacaoImdb() {
        return avaliacaoImdb;
    }

    public void setAvaliacaoImdb(Double avaliacaoImdb) {
        this.avaliacaoImdb = avaliacaoImdb;
    }

    public Integer getVotosImdb() {
        return votosImdb;
    }

    public void setVotosImdb(Integer votosImdb) {
        this.votosImdb = votosImdb;
    }

    public String getIdImdb() {
        return idImdb;
    }

    public void setIdImdb(String idImdb) {
        this.idImdb = idImdb;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidadeTemporadas() {
        return quantidadeTemporadas;
    }

    public void setQuantidadeTemporadas(Integer quantidadeTemporadas) {
        this.quantidadeTemporadas = quantidadeTemporadas;
    }

    public DoubleList<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodiosA) {
        episodiosA.forEach(e-> episodios.addLast(e));
    }

    @Override
    public String toString() {
        return  "Título: " + titulo + "\n" +
                "Ano Lançamento: " + anoLancamento + "\n" +
                "Ano Final: " + (anoFinal== null ? "Em exibição" : anoFinal) + "\n" +
                "Classificação Indicativa: " + classificacaoIndicativa + "\n" +
                "Data Lançamento: " + Arrays.toString(dataLancamento) + "\n" +
                "Duração Episodio: " + duracaoEpisodio + " minutos" + "\n" +
                "Quantidade Temporadas: " + quantidadeTemporadas + "\n" +
                "Gêneros: " + generos + "\n" +
                "Diretores: " + Arrays.toString(diretores) + "\n" +
                "Roteiristas: " + Arrays.toString(roteiristas) + "\n" +
                "Atores: " + Arrays.toString(atores) + "\n" +
                "Sinopse: " + sinopse +  "\n" +
                "Idiomas: " + Arrays.toString(idiomas) + "\n" +
                "Países: " + Arrays.toString(paises) + "\n" +
                "Prêmios: " + premios + "\n" +
                "Poster: " + poster +  "\n" +
                "Avaliação Imdb: " + avaliacaoImdb + "\n" +
                "Votos Imdb: " + votosImdb + "\n" +
                "Id Imdb: " + idImdb +  "\n";
    }

    @Override
    public int compareTo(Serie o) {
        return this.getTitulo().compareTo(o.getTitulo());
    }
}
