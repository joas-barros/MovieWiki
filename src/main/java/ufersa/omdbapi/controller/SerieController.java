package ufersa.omdbapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ufersa.omdbapi.model.Episodio;
import ufersa.omdbapi.model.Serie;
import ufersa.omdbapi.service.front.SerieService;

import java.util.List;

@RestController
public class SerieController {
   private final static SerieService ss = new SerieService();

    @GetMapping("/series")
    public List<Serie> obterListaSeries() {
        return ss.lerSeriesDoArquivoBinario();
    }

    @PostMapping("/s1")
    public Serie buscarSerieAPI(@RequestParam String titulo) {
        return ss.buscarSerieAPI(titulo);
    }

    @PostMapping("/svsd")
    public Episodio[] listarEpisodiosSerieEOrdenar(@RequestParam String titulo) {
        return ss.listarEpisodiosSerieEOrdenar(titulo);
    }
}
