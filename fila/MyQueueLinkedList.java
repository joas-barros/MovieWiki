package unidade2.fila;

import unidade2.exceptions.MyException;
import unidade2.lista_encadeada.DoubleList;
import unidade2.lista_encadeada.MyListInterface;
import unidade2.lista_encadeada.SinglyList;

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
}
