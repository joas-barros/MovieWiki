package unidade2.fila;

public class PlayGround {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>(10);

        queue.add(5);
        queue.add(4);
        queue.add(3);

        queue.show();
    }
}
