package ufersa.omdbapi.model;

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

    public static List<Categoria> fromString(String texto) {
        String[] generos = texto.replace(" ", "").split(",");
        List<Categoria> retorno = new ArrayList<Categoria>();

        try {
            for (String nome : generos) {
                for (Categoria categoria : Categoria.values()) {
                    if (categoria.categoriaOMDB.equalsIgnoreCase(nome)) {
                        retorno.add(categoria);
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
