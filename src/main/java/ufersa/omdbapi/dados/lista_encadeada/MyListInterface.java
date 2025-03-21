package ufersa.omdbapi.dados.lista_encadeada;

public interface MyListInterface <E>{
    void addFirst(E value);
    void addLast(E value);
    boolean addAfter(E dado, E crit);

    E peekFirst();
    E peekLast();

    E search(E crit);

    E removeFirst();
    E removeLast();
    E remove(E crit);

    void show();			// opcional
    void showReverse();

    boolean isEmpty();

    E[] toArray(E[] a);
}
