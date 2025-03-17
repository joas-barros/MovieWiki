package ufersa.omdbapi.service.front;

import org.springframework.stereotype.Service;
import ufersa.omdbapi.dados.fila.MyQueueLinkedList;
import ufersa.omdbapi.dados.lista_encadeada.DoubleList;
import ufersa.omdbapi.model.Episodio;
import ufersa.omdbapi.model.Serie;
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

    //lê arquivo binário de filme e retorna a lista dos series
    public List<Serie> lerSeriesDoArquivoBinario(){
        MyQueueLinkedList<Serie> filaSerie = arquivos.lerSerieBinario();

        List<Serie> listaSerie = new ArrayList<>();

        while(!listaSerie.isEmpty()){
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

    //falta salvar a série no arquivo binário e em txt quando terminar o uso
}
