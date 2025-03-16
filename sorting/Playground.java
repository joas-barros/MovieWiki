package sorting;

import java.util.Comparator;

public class Playground {
    public static void main(String[] args) {
        Filme[] filmes = new Filme[5];
        filmes[0] = new Filme("Filme 1", 2020, "Diretor 1");
        filmes[1] = new Filme("Filme 2", 2019, "Diretor 2");
        filmes[2] = new Filme("Filme 3", 2018, "Diretor 3");
        filmes[3] = new Filme("Filme 4", 2017, "Diretor 4");
        filmes[4] = new Filme("Filme 5", 2016, "Diretor 5");

        Sorting<Filme> sorting = new Sorting<>();
        sorting.quickSort(filmes, Comparator.comparingInt(Filme::getAno));

        for (Filme filme : filmes) {
            System.out.println(filme);
        }

        System.out.println("====================================");
        sorting.quickSort(filmes, Comparator.comparing(Filme::getDiretor));

        for (Filme filme : filmes) {
            System.out.println(filme);
        }
    }
}
