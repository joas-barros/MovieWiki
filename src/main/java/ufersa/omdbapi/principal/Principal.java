package ufersa.omdbapi.principal;

import ufersa.omdbapi.model.Resposta;
import ufersa.omdbapi.service.Buscar;
import ufersa.omdbapi.service.ConsumoApi;
import ufersa.omdbapi.service.ConverteDados;

import java.util.Scanner;

public class Principal {

    public static final String ENDERECO = "https://www.omdbapi.com/?t=";
    public static final String API_KEY = "&apikey=bc5081ad";
    private final Buscar bs = new Buscar();
    private final ConsumoApi consumoApi = new ConsumoApi();
    Scanner scanner = new Scanner(System.in);
    private final ConverteDados converteDados = new ConverteDados();

    public void exibeMenu(){
        System.out.print("Digite o nome do que deseja buscar: ");
        String busca = scanner.nextLine();

        String json = consumoApi.getDados(ENDERECO + busca.replaceAll(" ", "+") + API_KEY);

        if (json != null) {
            if(json.contains("series")) {
                bs.buscarSerie(busca);
            } else {
                bs.buscarFilme(busca);
            }
        }

    }
}
