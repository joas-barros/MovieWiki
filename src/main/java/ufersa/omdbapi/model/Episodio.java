package ufersa.omdbapi.model;

import ufersa.omdbapi.dados.lista_encadeada.DoubleList;

import java.util.*;

public class Episodio {
    private String titulo;
    private Integer anoLancamento;
    private String classificacaoIndicativa;
    private Integer numeroTemporada;
    private Integer numeroEpisodio;
    private Integer duracao;
    private DoubleList<Categoria> generos;
    private List<String> diretores;
    private String[] roteiristas;
    private String[] atores;
    private String sinopse;
    private List<String> idiomas;
    private List<String> paises;
    private String poster;
    private Double avaliacaoImdb;
    private Integer votosImdb;
    private String imdbId;
    private String idSerie;
    private String tipo;

    public Episodio(RecordEpisodio episodio) {
        this.titulo = episodio.titulo();
        this.anoLancamento = episodio.anoLancamento();
        this.classificacaoIndicativa = episodio.classificacaoIndicativa();
        this.numeroTemporada = episodio.numeroTemporada();
        this.numeroEpisodio = episodio.numeroEpisodio();
        this.duracao = OptionalInt.of(Integer.valueOf(episodio.tempoExibicao().split(" ")[0])).orElse(-1);
        this.generos = Categoria.fromString(episodio.genero());
        this.diretores = new ArrayList<>(List.of(episodio.diretor().replaceAll(" ","").split(",")));
        this.roteiristas = episodio.roteirista().replaceAll(" ","").split(",");
        this.atores = episodio.ator().replaceAll(" ","").split(",");
        this.sinopse = episodio.sinopse();
        this.idiomas = new ArrayList<>(Arrays.asList(episodio.idioma()));
        this.paises = new ArrayList<>(Arrays.asList(episodio.pais()));
        this.poster = episodio.poster();
        this.avaliacaoImdb = episodio.avaliacaoImdb();
        this.votosImdb = episodio.votosImdb();
        this.imdbId = episodio.idImdb();
        this.idSerie = episodio.idSerie();
        this.tipo = episodio.tipo();
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

    public Integer getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(Integer numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public DoubleList<Categoria> getGeneros() {
        return generos;
    }

    public void setGeneros(DoubleList<Categoria> generos) {
        this.generos = generos;
    }

    public List<String> getDiretores() {
        return diretores;
    }

    public void setDiretores(List<String> diretores) {
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

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public List<String> getPaises() {
        return paises;
    }

    public void setPaises(List<String> paises) {
        this.paises = paises;
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

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(String idSerie) {
        this.idSerie = idSerie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  "titulo: " + titulo + "\n" +
                ", anoLancamento: " + anoLancamento + "\n" +
                ", classificacaoIndicativa: " + classificacaoIndicativa + "\n" +
                ", numeroTemporada: " + numeroTemporada + "\n" +
                ", numeroEpisodio: " + numeroEpisodio + "\n" +
                ", duracao: " + duracao + " minutos" + "\n" +
                ", generos: " + generos + "\n" +
                ", diretores: " + diretores + "\n" +
                ", roteiristas: " + Arrays.toString(roteiristas) + "\n" +
                ", atores: " + Arrays.toString(atores) + "\n" +
                ", sinopse: " + sinopse + "\n" +
                ", idiomas: " + idiomas + "\n" +
                ", paises: " + paises + "\n" +
                ", poster: " + poster + "\n" +
                ", avaliacaoImdb: " + avaliacaoImdb + "\n" +
                ", votosImdb: " + votosImdb + "\n" +
                ", imdbId: " + imdbId + "\n" +
                ", idSerie: " + idSerie + "\n" +
                ", tipo: " + tipo + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Episodio episodio = (Episodio) o;
        return Objects.equals(imdbId, episodio.imdbId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(imdbId);
    }
}
