package unidade2.lista2;

import unidade2.lista_encadeada.MyListInterface;
import unidade2.lista_encadeada.SinglyList;

public class Questao5 {

    public static void main(String[] args) {
        MyListInterface<Palavra> palavras = new SinglyList<>();

        String frase = "neymar neymar neymar neymar neymar";

        String[] fraseSeparada = frase.split(" ");
        Palavra p;

        for (String s: fraseSeparada){
            p = new Palavra(s);
            Palavra palavraAnalisada = palavras.search(p);
            if (palavraAnalisada == null){
                p.cont++;
                palavras.addLast(p);
            } else {
                palavraAnalisada.cont++;
            }
        }

        palavras.show();

    }
}
