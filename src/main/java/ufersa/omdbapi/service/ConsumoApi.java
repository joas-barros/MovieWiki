package ufersa.omdbapi.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
     public String getDados(String url) {
         HttpClient client = HttpClient.newHttpClient();

         HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create(url)).build();

         HttpResponse<String> response = null;

         try{
             response = client.send(request, HttpResponse.BodyHandlers.ofString());
         }catch (IOException | InterruptedException e){
             e.printStackTrace();
         }

         assert response != null;
         return response.body();
     }
}
