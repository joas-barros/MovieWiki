package ufersa.omdbapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RecordFilme(@JsonAlias("Title")String titulo,
                          @JsonAlias("Year") String anoLancamento,
                          @JsonAlias("Rated") String classificacaoIndicativa,
                          @JsonAlias("Released") String lancamento,
                          @JsonAlias("Runtime") String duracaoEpisodio,
                          @JsonAlias("Genre") String genero,
                          @JsonAlias("Director") String diretor,
                          @JsonAlias("Writer") String roteirista,
                          @JsonAlias("Actors") String atores,
                          @JsonAlias ("Plot") String sinopse,
                          @JsonAlias("Language") String idiomas,
                          @JsonAlias("Country") String paises,
                          @JsonAlias("Awards") String premios,
                          @JsonAlias("Poster") String poster,
                          @JsonAlias("Metascore") String metascore,
                          @JsonAlias("imdbRating") String avaliacaoImdb,
                          @JsonAlias("imdbVotes") String votosImdb,
                          @JsonAlias("imdbID") String idImdb,
                          @JsonAlias("Type") String tipo,
                          @JsonAlias("BoxOffice") String faturamento,
                          @JsonAlias("Response") String resposta) {
}
