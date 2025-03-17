package ufersa.omdbapi.service.front;

import org.springframework.stereotype.Service;
import ufersa.omdbapi.dados.fila.MyQueueLinkedList;
import ufersa.omdbapi.dados.lista_encadeada.DoubleList;
import ufersa.omdbapi.dados.lista_encadeada.MyListInterface;
import ufersa.omdbapi.model.Filme;
import ufersa.omdbapi.model.Serie;
import ufersa.omdbapi.search.Search;
import ufersa.omdbapi.service.Arquivos;
import ufersa.omdbapi.service.api.Buscar;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {
    private static final Arquivos arquivos = new Arquivos();
    private static final Buscar bs = new Buscar();
    private static final Search search = new Search();

    public void salvarFilmeArquivo(List<Filme> filmes){

        MyQueueLinkedList<Filme> filaFilme = new MyQueueLinkedList<>();

        filmes.forEach(filaFilme::add);

        arquivos.escreverFilmeBinario(filaFilme);
        arquivos.escreverFilmesTexto(filaFilme);
    }

    //lê arquivo binário de filme e retorna a lista dos filmes
    public List<Filme> lerFilmesDoArquivoBinario(){
        MyQueueLinkedList<Filme> filaFilmes = arquivos.lerFilmeBinario();

        List<Filme> listaFilmes = new ArrayList<Filme>();

        while(!filaFilmes.isEmpty()){
            listaFilmes.add(filaFilmes.remove());
        }

        return listaFilmes;
    };

    //Retorna filme para ser exibido
    public Filme buscarFilmeAPI(String titulo){
        return bs.buscarFilme(titulo);
    }

    public int checarListaFilmes(String nomeFilme, List<Filme> filmes){
        Filme filmeBuscado = bs.buscarFilme(nomeFilme);

        int tamanho = filmes.size();

        Filme[] filmeArray = filmes.toArray(new Filme[tamanho]);

        //retorna -1 se filme não estiver presente
        return search.binarySearch(filmeArray, filmeBuscado);
    }

    //falta salvar os filmes em arquivo binario e txt quando terminar o uso
}
