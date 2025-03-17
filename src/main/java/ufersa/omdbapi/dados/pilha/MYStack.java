package ufersa.omdbapi.dados.pilha;

import ufersa.omdbapi.exceptions.MyException;

public class MYStack<T> implements StackInterface<T> {

    private int maxSize;
    private Object[] array;
    private int top;

    public MYStack(int maxSize) {
        this.maxSize = maxSize;
        array = new Object[maxSize];
        top = -1;
    }

    @Override
    public void push(T element) throws MyException {
        if (isFull()){
            throw new MyException("Pilha ta cheia colega");
        }
        top++;
        array[top] = element;
    }

    @Override
    public T pop() throws MyException {
        if (isEmpty()){
            throw new MyException("A pilha está vaiza");
        }

        T element = (T) array[top];
        top--;
        return element;
    }

    @Override
    public T peek() throws MyException {
        if(isEmpty()){
            throw new MyException("Não há elementos na pilha");
        }
        return (T) array[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public void show() {
        if (isEmpty()){
            System.out.println("Não há elementos na pilha para mostrar");
            return;
        }

        for (int i = top; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}