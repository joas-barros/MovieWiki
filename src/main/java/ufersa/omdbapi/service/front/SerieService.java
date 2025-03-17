package ufersa.omdbapi.service.front;

import org.springframework.stereotype.Service;
import ufersa.omdbapi.dados.fila.MyQueueLinkedList;
import ufersa.omdbapi.dados.lista_encadeada.DoubleList;
import ufersa.omdbapi.model.Episodio;
import ufersa.omdbapi.model.Serie;
import ufersa.omdbapi.search.Search;
import ufersa.omdbapi.service.Arquivos;
import ufersa.omdbapi.service.api.Buscar;
import ufersa.omdbapi.sorting.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class SerieService {
    private static final Arquivos arquivos = new Arquivos();
    private static final Buscar bs = new Buscar();
    private static final Sorting sorting = new Sorting();
    private static final Search search = new Search();

    //lê arquivo binário de filme e retorna a lista dos series
    public List<Serie> lerSeriesDoArquivoBinario(){

        MyQueueLinkedList<Serie> filaSerie = arquivos.lerSerieBinario();

        List<Serie> listaSerie = new ArrayList<>();

        while(!filaSerie.isEmpty()){
            listaSerie.add(filaSerie.remove());
        }

        return listaSerie;
    };

    //Retorna Serie para ser exibido
    public Serie buscarSerieAPI(String titulo){
        return bs.buscarSerie(titulo);
    }

    public Episodio[] listarEpisodiosSerieEOrdenar(String nomeSerie) {
        Serie s = bs.buscarEpisodiosDaSerie(nomeSerie);

        DoubleList<Episodio> episodiosSerie = s.getEpisodios();

        int tamanho = episodiosSerie.getSize();

        Episodio[] vetorEpisodios = new Episodio[tamanho];

        for(int i = 0; i < tamanho; i++){
            vetorEpisodios[i] = episodiosSerie.removeFirst();
        }

        sorting.quickSort(vetorEpisodios, Comparator.comparingDouble(Episodio::getAvaliacaoImdb));

        arquivos.imprimirEpisodiosOrdenados(vetorEpisodios);

        return vetorEpisodios;
    }

    public int buscarSerieNaLista(String nomeSerie) {

        List<Serie> series = lerSeriesDoArquivoBinario();

        Serie s = bs.buscarSerie(nomeSerie);

        return search.binarySearch(series.toArray(), s);
    }

    public void salvarSerieBinario(List<Serie> series) {
        MyQueueLinkedList<Serie> filaSerie = new MyQueueLinkedList<>();

        series.forEach(filaSerie::add);

        arquivos.escreverSerieBinario(filaSerie);
    }

    //falta salvar a série no arquivo binário e em txt quando terminar o uso
}
