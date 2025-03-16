package sorting;

public class Filme implements Comparable<Filme> {
    private String nome;
    private int ano;
    private String diretor;

    public Filme(String nome, int ano, String diretor) {
        this.nome = nome;
        this.ano = ano;
        this.diretor = diretor;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public String getDiretor() {
        return diretor;
    }



    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", ano=" + ano +
                ", diretor='" + diretor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Filme o) {
        // comparar pelo ano
        return this.ano - o.ano;
    }
}
