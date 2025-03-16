package ufersa.omdbapi.model;

import ufersa.omdbapi.dados.lista_encadeada.DoubleList;

import java.util.ArrayList;
import java.util.List;

public enum Categoria {
    Ação ("Action"),
    Rromance ("Romance"),
    Comédia ("Comedy"),
    Ssuspense ("Thriller"),
    Drama ("Drama"),
    Terror ("Horror"),
    Crime ("Crime"),
    Aventura ("Adventure"),
    Ficção ("Sci-Fi");

    private String categoriaOMDB;

    Categoria(String categoriaOMDB) {
        this.categoriaOMDB = categoriaOMDB;
    }

    public static DoubleList<Categoria> fromString(String texto) {
        String[] generos = texto.replace(" ", "").split(",");

        DoubleList<Categoria> retorno = new DoubleList<>();

        try {
            for (String nome : generos) {
                for (Categoria categoria : Categoria.values()) {
                    if (categoria.categoriaOMDB.equalsIgnoreCase(nome)) {
                        retorno.addLast(categoria);
                        break;
                    }
                }
            }
        }catch (Exception e) {
            throw new IllegalArgumentException("Nenhuma categoria encontrada: " + texto);
        }

        return retorno;
        //for (Categoria categoria : Categoria.values()) {
          //  if (categoria.categoriaOMDB.equalsIgnoreCase(texto)) {
            //    return categoria;
            //}
        //}

        //throw new IllegalArgumentException("Nenhuma categoria encontrada: " + texto);
    }
}
