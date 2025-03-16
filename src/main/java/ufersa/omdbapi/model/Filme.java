package ufersa.omdbapi.model;

import ufersa.omdbapi.dados.lista_encadeada.DoubleList;

import java.io.Serializable;
import java.util.*;

public class Filme implements Serializable{
    private static final long serialVersionUID = 1L;
    private String titulo;
    private Integer anoLancamento;
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
    private Integer metascore;
    private Double avaliacaoImdb;
    private Integer votosImdb;
    private String idImdb;
    private String tipo;
    private String faturamento;

    public Filme(RecordFilme filme) {
        this.titulo = filme.titulo();
        this.anoLancamento = OptionalInt.of(Integer.valueOf(filme.anoLancamento().split("–")[0])).orElse(-1);
        this.classificacaoIndicativa = filme.classificacaoIndicativa();
        this.dataLancamento = filme.lancamento().split(" ");
        if(filme.duracaoEpisodio().equalsIgnoreCase("N/A"))
            this.duracaoEpisodio = null;
        else
            this.duracaoEpisodio = OptionalInt.of(Integer.valueOf(filme.duracaoEpisodio().split(" ")[0])).orElse(-1);
        this.generos = Categoria.fromString(filme.genero());
        this.diretores = filme.diretor().split(",");
        this.roteiristas = filme.roteirista().split(",");
        this.atores = filme.atores().split(",");
        this.sinopse = filme.sinopse();
        this.idiomas = filme.idiomas().split(",");
        this.paises = filme.paises().split(",");
        this.premios = filme.premios();
        this.poster = filme.poster();
        this.metascore = filme.metascore().equals("N/A") ? null: Integer.valueOf(filme.metascore());
        this.avaliacaoImdb = OptionalDouble.of(Double.valueOf(filme.avaliacaoImdb())).orElse(-1);
        this.votosImdb = Integer.valueOf(filme.votosImdb().replaceAll(",", ""));
        this.idImdb = filme.idImdb();
        this.tipo = filme.tipo();
        this.faturamento = filme.faturamento();
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

    public Integer getMetascore() {
        return metascore;
    }

    public void setMetascore(Integer metascore) {
        this.metascore = metascore;
    }

    public String getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(String faturamento) {
        this.faturamento = faturamento;
    }

    @Override
    public String toString() {
        return  "titulo: " + titulo + "\n" +
                ", anoLancamento: " + anoLancamento + "\n" +
                ", classificacaoIndicativa: " + classificacaoIndicativa + "\n" +
                ", dataLancamento: " + Arrays.toString(dataLancamento) + "\n" +
                ", duracao: " + duracaoEpisodio + " minutos" + "\n" +
                ", generos: " + generos + "\n" +
                ", diretores: " + Arrays.toString(diretores) + "\n" +
                ", roteiristas: " + Arrays.toString(roteiristas) + "\n" +
                ", atores: " + Arrays.toString(atores) + "\n" +
                ", sinopse: " + sinopse + "\n" +
                ", idiomas: " + Arrays.toString(idiomas) + "\n" +
                ", paises: " + Arrays.toString(paises) + "\n" +
                ", premios: " + premios + "\n" +
                ", poster: " + poster + "\n" +
                ", metascore: " + metascore + "\n" +
                ", avaliacaoImdb: " + avaliacaoImdb + "\n" +
                ", votosImdb: " + votosImdb + "\n" +
                ", idImdb: " + idImdb + "\n" +
                ", tipo: " + tipo + "\n" +
                ", faturamento: " + faturamento + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(titulo, filme.titulo) && Objects.equals(anoLancamento, filme.anoLancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, anoLancamento);
    }
}
