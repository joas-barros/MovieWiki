package ufersa.omdbapi.service.front;

import org.springframework.stereotype.Service;
import ufersa.omdbapi.dados.fila.MyQueueLinkedList;
import ufersa.omdbapi.dados.lista_encadeada.DoubleList;
import ufersa.omdbapi.model.Filme;
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

    //lê arquivo binário de filme e retorna a lista dos filmes
    private List<Filme> lerFilmesDoArquivoBinario(){
        MyQueueLinkedList<Filme> filaFilmes = arquivos.lerFilmeBinario();

        List<Filme> listaFilmes = new ArrayList<Filme>();

        while(!filaFilmes.isEmpty()){
            listaFilmes.add(filaFilmes.remove());
        }

        return listaFilmes;
    };

    //Retorna filme para ser exibido
    private Filme buscarFilmeAPI(String titulo){
        return bs.buscarFilme(titulo);
    }

    public int checarListaFilmes(String nomeFilme){
        Filme filmeBuscado = bs.buscarFilme(nomeFilme);

        MyQueueLinkedList<Filme> filaFilmes = arquivos.lerFilmeBinario();

        DoubleList<Filme> listaFilmes = new DoubleList<>();

        while(!filaFilmes.isEmpty()){
            listaFilmes.addLast(filaFilmes.remove());
        }

        Filme[] vetorFilmes = new Filme[listaFilmes.getSize()];

        for(int i = 0; i < vetorFilmes.length; i++){
            vetorFilmes[i] = listaFilmes.removeFirst();
        }

        //retorna -1 se filme não estiver presente
        return search.binarySearch(vetorFilmes, filmeBuscado);
    }

    //falta salvar os filmes em arquivo binario e txt quando terminar o uso
}
