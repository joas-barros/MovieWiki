package ufersa.omdbapi.dados.pilha;

public class PlayGround {
    public static void main(String[] args) {
        MYStack<Integer> myStack = new MYStack<>(8);

        myStack.push(3);
        myStack.push(2);
        myStack.push(7);
        myStack.push(13);
        myStack.show();

        System.out.println(myStack.pop());
        myStack.show();
    }
}
