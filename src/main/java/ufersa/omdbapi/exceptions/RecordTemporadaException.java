package ufersa.omdbapi.exceptions;

public class RecordTemporadaException extends RuntimeException {
    public RecordTemporadaException(String message) {
        super("Temporada não encontrada: " + message);
    }
}
