package ufersa.omdbapi.exceptions;

public class RecordTemporadaException extends RuntimeException {
    public RecordTemporadaException(String s) {
        super("Temporada não encontrada: " + s);
    }
}
