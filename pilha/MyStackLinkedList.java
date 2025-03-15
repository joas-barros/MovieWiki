package unidade2.pilha;

import unidade2.exceptions.MyException;
import unidade2.lista_encadeada.DoubleList;
import unidade2.lista_encadeada.MyListInterface;
import unidade2.lista_encadeada.SinglyList;

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
