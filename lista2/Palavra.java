package unidade2.lista2;

import java.util.Objects;

public class Palavra {
    String palavra;
    int cont;

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.cont = 0;
    }

    @Override
    public String toString() {
        return "palavra='" + palavra +", cont=" + cont;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Palavra palavra1)) return false;
        return Objects.equals(palavra, palavra1.palavra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(palavra);
    }
}
