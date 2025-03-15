package unidade2.fila;

import unidade2.exceptions.MyException;

public class MyQueue<T> implements QueueInterface<T>{

    private int maxSize;
    private Object[] array;
    private int first;
    private int last;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        this.first = -1;
        this.last = -1;
        array = new Object[maxSize];
    }

    //ADICAO: Muda a fim
    //REMOCAO: Muda o inicio
    @Override
    public void add(T number) throws MyException {

        // Nesse cenario não há mais espaço na fila circular
        if (isFull()){
            throw new MyException("A fila está cheia");
        }

        last = (last + 1) % maxSize;;
        array[last] = number;

        if(isEmpty()){
            first = 0;
        }

        // Somento caso a fila esteja vazia, devemos alterar o first na inserção
        if (isEmpty()){
            first = 0;
        }
    }

    @Override
    public T remove() throws MyException {
        if (isEmpty()){
            throw new MyException("A fila está vazia");
        }

        T retorno = (T) array[last];

        // Caso só exista um elemento na fila
        if (first == last){
            first = -1;
            last = -1;
        } else {
            first = (first + 1) % maxSize;
        }
        return retorno;
    }

    @Override
    public T peek() throws MyException {
        T retorno;

        if (isEmpty()){
            throw new MyException("A fila está vazia");
        }

        retorno = (T) array[first];
        return retorno;
    }

    @Override
    public boolean isEmpty() {
        return first == -1;
    }

    @Override
    public boolean isFull() {
        int lastTemp = (last + 1) % maxSize;
        return lastTemp == first;
    }

    @Override
    public void show() {
        int i = first;

        if(isEmpty()){
            throw new MyException("A pilha está vazia");
        }

        while (i != last) {
            System.out.print(array[i] + " ");
            i = (i + 1) % maxSize;
        }
        System.out.println(array[i] + "\n");
        System.out.println("inicio = " + first + "  fim = " + last + "\n");
    }
}
