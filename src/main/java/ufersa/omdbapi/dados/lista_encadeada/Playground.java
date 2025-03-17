package ufersa.omdbapi.dados.lista_encadeada;

public class Playground {
    public static void main(String[] args) {
        MyListInterface<Integer> list = new DoubleList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(5);
        list.addAfter(8, 2);
        list.remove(2);
        list.show();
    }
}
