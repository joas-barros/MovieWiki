package ufersa.omdbapi.dados.fila;

import ufersa.omdbapi.dados.lista_encadeada.DoubleList;
import ufersa.omdbapi.dados.lista_encadeada.MyListInterface;
import ufersa.omdbapi.exceptions.MyException;

public class MyQueueLinkedList <T> implements QueueInterface<T>{

    private MyListInterface<T> fila = new DoubleList<>();
    @Override
    public void add(T number) throws MyException {
        fila.addLast(number);
    }

    @Override
    public T remove() throws MyException {
        return fila.removeFirst();
    }

    @Override
    public T peek() throws MyException {
        return fila.peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void show() {
        fila.show();
    }

    @Override
    public String toString() {
        return "[" + fila + ']';
    }
}
