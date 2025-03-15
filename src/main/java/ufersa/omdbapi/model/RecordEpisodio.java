package ufersa.omdbapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RecordEpisodio(@JsonAlias("Title") String titulo,
                             @JsonAlias("Year") Integer  anoLancamento,
                             @JsonAlias("Rated") String classificacaoIndicativa,
                             @JsonAlias("Season") Integer numeroTemporada,
                             @JsonAlias("Episode") Integer numeroEpisodio,
                             @JsonAlias("Runtime") String tempoExibicao,
                             @JsonAlias("Genre") String genero,
                             @JsonAlias("Director") String diretor,
                             @JsonAlias("Writer") String roteirista,
                             @JsonAlias("Actors") String ator,
                             @JsonAlias("Plot") String sinopse,
                             @JsonAlias("Language") String idioma,
                             @JsonAlias("Country") String pais,
                             @JsonAlias("Poster") String poster,
                             @JsonAlias("imdbRating") Double avaliacaoImdb,
                             @JsonAlias("imdbVotes") Integer votosImdb,
                             @JsonAlias("imdbID") String idImdb,
                             @JsonAlias("seriesID") String idSerie,
                             @JsonAlias("Type") String tipo) {
}
