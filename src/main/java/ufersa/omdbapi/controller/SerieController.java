package ufersa.omdbapi.controller;

import org.springframework.web.bind.annotation.*;
import ufersa.omdbapi.model.Episodio;
import ufersa.omdbapi.model.Serie;
import ufersa.omdbapi.service.front.SerieService;

import java.util.List;

@RestController
public class SerieController {
   private final static SerieService ss = new SerieService();

   //Usado p salvar as séries em arquivo
   @PostMapping("salvarBinario")
   public void salvarSerie(@RequestParam List<Serie> series) {
        ss.salvarSerieBinario(series);
   }

   //usado p ler lista de séries do arquivo binário
   @GetMapping("/lerSerieArquivo")
   public List<Serie> obterListaSeries() {
       return ss.lerSeriesDoArquivoBinario();
   }

   //usado p buscar uma série com a API
   @PostMapping("/buscarSerie")
   public Serie buscarSerieAPI(@RequestParam String titulo) {
       return ss.buscarSerieAPI(titulo);
   }

   //busca lista de episodios de uma série e ordena por nota
   @PostMapping("/buscarEpisodiosEOrdenar")
   public Episodio[] listarEpisodiosSerieEOrdenar(@RequestParam String titulo) {
       return ss.listarEpisodiosSerieEOrdenar(titulo);
   }

}
