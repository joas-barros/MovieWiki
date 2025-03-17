package ufersa.omdbapi.controller;

import org.springframework.web.bind.annotation.*;
import ufersa.omdbapi.model.Filme;
import ufersa.omdbapi.service.front.FilmeService;

import java.util.List;

@RestController
public class FilmeController {
    private static final FilmeService filmeService = new FilmeService();

    //usando p salvar os arquivos na pasta
    @PostMapping("/salvarFilmeArquivo")
    public void salvarFilmeArquivo(@RequestParam List<Filme> filmes) {

        filmeService.salvarFilmeArquivo(filmes);
    }

    //usado p ler a lista de filmes do arquivo
    @GetMapping("/lerListaFilmesArquivo")
    public List<Filme> addFilme() {
        return filmeService.lerFilmesDoArquivoBinario();
    }

    //usado p buscar um filme na API
    @PostMapping("/buscarFilme")
    public Filme buscarFilme(@RequestParam String titulo) {
        return filmeService.buscarFilmeAPI(titulo);
    }

    //Usado p buscar um filme na lista
    @GetMapping("/buscarFilmeNaLista")
    public int buscarFilmeNaLista(@RequestParam String titulo, List<Filme> filmes) {
        return filmeService.checarListaFilmes(titulo, filmes);
    }
}
