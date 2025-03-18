package ufersa.omdbapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getDados(String json, Class<T> classe) {
        try{
            return mapper.readValue(json, classe);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e + "Erro de processamento JSON");
        }
    }
}
