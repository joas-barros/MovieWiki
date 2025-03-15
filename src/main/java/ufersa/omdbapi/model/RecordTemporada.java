package ufersa.omdbapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RecordTemporada(@JsonAlias("Season") Integer temporada,
                              @JsonAlias("Episodes")List<MiniEpisodio> episodios,
                              @JsonAlias("Response") String resposta) {
}
