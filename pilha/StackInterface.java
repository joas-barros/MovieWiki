package unidade2.pilha;

import unidade2.exceptions.MyException;

public interface StackInterface <T>{
    void push(T number) throws MyException; 	// empilhar
    T pop() throws MyException;					// desempilhar
    T peek() throws MyException;				// consultar (topo)
    boolean isEmpty();
    boolean isFull();
    void show();	// opcional e auxiliar
}
