package ufersa.omdbapi.dados.pilha;

import ufersa.omdbapi.dados.lista_encadeada.DoubleList;
import ufersa.omdbapi.dados.lista_encadeada.MyListInterface;
import ufersa.omdbapi.exceptions.MyException;

public class MyStackLinkedList <T> implements StackInterface<T>{

    MyListInterface<T> pilha = new DoubleList<>();

    @Override
    public void push(T number) throws MyException {
        pilha.addFirst(number);
    }

    @Override
    public T pop() throws MyException {
        return pilha.removeFirst();
    }

    @Override
    public T peek() throws MyException {
        return pilha.peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void show() {
        pilha.show();
    }
}
