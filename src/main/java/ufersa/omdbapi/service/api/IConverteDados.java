package ufersa.omdbapi.service.api;

public interface IConverteDados {
    <T> T getDados (String json, Class<T> classe);
}
