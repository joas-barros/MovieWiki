package ufersa.omdbapi.model;

import java.util.*;

public class Serie {
    private String titulo;
    private Integer anoLancamento;
    private Integer anoFinal;
    private String classificacaoIndicativa;
    private String[] dataLancamento;
    private Integer duracaoEpisodio;
    private List<Categoria> generos;
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
    private List<Episodio> episodios;

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
            this.duracaoEpisodio = OptionalInt.of(Integer.valueOf(serie.duracaoEpisodio().split(" ")[0])).orElse(-1);
        this.generos = Categoria.fromString(serie.genero());
        this.diretores = serie.diretor().split(",");
        this.roteiristas = serie.roteirista().split(",");
        this.atores = serie.atores().split(",");
        this.sinopse = serie.sinopse();
        this.idiomas = serie.idiomas().split(",");
        this.paises = serie.paises().split(",");
        this.premios = serie.premios();
        this.poster = serie.poster();
        this.avaliacaoImdb = OptionalDouble.of(Double.valueOf(serie.avaliacaoImdb())).orElse(-1);
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

    public List<Categoria> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Categoria> generos) {
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

    @Override
    public String toString() {
        return "titulo: " + titulo + "\n" +
                ", anoLancamento: " + anoLancamento + "\n" +
                ", anoFinal: " + anoFinal + "\n" +
                ", classificacaoIndicativa: " + classificacaoIndicativa + "\n" +
                ", dataLancamento: " + Arrays.toString(dataLancamento) + "\n" +
                ", duracaoEpisodio: " + duracaoEpisodio + " minutos" + "\n" +
                ", generos: " + generos + "\n" +
                ", diretores: " + Arrays.toString(diretores) + "\n" +
                ", roteiristas: " + Arrays.toString(roteiristas) + "\n" +
                ", atores: " + Arrays.toString(atores) + "\n" +
                ", sinopse: " + sinopse +  "\n" +
                ", idiomas: " + Arrays.toString(idiomas) + "\n" +
                ", paises: " + Arrays.toString(paises) + "\n" +
                ", premios: " + premios + "\n" +
                ", poster: " + poster +  "\n" +
                ", avaliacaoImdb: " + avaliacaoImdb + "\n" +
                ", votosImdb: " + votosImdb + "\n" +
                ", idImdb: " + idImdb +  "\n" +
                ", tipo: " + tipo + "\n" +
                ", quantidadeTemporadas: " + quantidadeTemporadas + "\n";
    }
}
