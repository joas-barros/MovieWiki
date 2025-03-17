package ufersa.omdbapi.service.api;

import ufersa.omdbapi.exceptions.RecordTemporadaException;
import ufersa.omdbapi.model.Resposta;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    private final ConverteDados conversor = new ConverteDados();
     public String getDados(String url) {
         HttpClient client = HttpClient.newHttpClient();

         HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create(url)).build();

         HttpResponse<String> response = null;

         try{
             response = client.send(request, HttpResponse.BodyHandlers.ofString());
             String json = response.body();

             Resposta testeResposta = conversor.getDados(json, Resposta.class);

             if(testeResposta.resposta().equals("False")) {
                 System.out.println("Erro ao buscar");
                 return null;
             }
            if (response.body() == null) {
                throw new RecordTemporadaException("");
            }
         }catch (IOException e){
             System.out.println("Erro de I/O ao fazer a requisição: " + e.getMessage());
         }catch (InterruptedException e){
             System.out.println("A requisição foi interrompida: " + e.getMessage());
         } catch (Exception e){
             System.out.println("Erro desconhecido: " + e.getMessage());
         }

         assert response != null;
         return response.body();
     }
}
