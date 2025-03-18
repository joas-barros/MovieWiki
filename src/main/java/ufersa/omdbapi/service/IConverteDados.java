package ufersa.omdbapi.service;

public interface IConverteDados {
    <T> T getDados (String json, Class<T> classe);
}
