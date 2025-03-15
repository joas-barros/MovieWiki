package unidade2.fila;

import unidade2.exceptions.MyException;

public interface QueueInterface <T>{
    void add(T number) throws MyException;
    T remove() throws MyException;

    T peek() throws MyException;	// consulta o início (primeiro elemento)

    boolean isEmpty();
    boolean isFull();

    void show(); // opcional e auxiliar
}
