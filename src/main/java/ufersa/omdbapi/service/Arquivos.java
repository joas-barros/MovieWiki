package ufersa.omdbapi.service;

import ufersa.omdbapi.dados.fila.MyQueueLinkedList;
import ufersa.omdbapi.exceptions.MyException;
import ufersa.omdbapi.model.Episodio;
import ufersa.omdbapi.model.Filme;
import ufersa.omdbapi.model.Serie;

import java.io.*;

@SuppressWarnings("ALL")
public class Arquivos {

    private static final String pathFilmeTexto = "src\\main\\java\\ufersa\\omdbapi\\archives\\arquivoTextoFilme.txt";
    private static final String pathSerieTexto = "src\\main\\java\\ufersa\\omdbapi\\archives\\arquivoTextoSerie.txt";
    private static final String pathListaEpisodios = "src\\main\\java\\ufersa\\omdbapi\\archives\\listaEpisodios.txt";
    private static final String pathFilmeBinario = "src\\main\\java\\ufersa\\omdbapi\\archives\\arquivoBinarioFilme.dat";
    private static final String pathSerieBinario = "src\\main\\java\\ufersa\\omdbapi\\archives\\arquivoBinarioSerie.dat";

    public void escreverFilmesTexto(MyQueueLinkedList<Filme> listaFilmes) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathFilmeTexto))) {

            while(!listaFilmes.isEmpty()){
                Filme filme = listaFilmes.remove();
                bw.write(filme.toString());
                bw.newLine();
            }
        } catch(Exception e){
            System.err.println("Erro ao escrever o arquivo texto" + e.getMessage() + "\n");
        }
    }

    public void escreverSerieTexto(MyQueueLinkedList<Serie> listaSerie) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathSerieTexto))) {

            while(!listaSerie.isEmpty()){
                Serie serie = listaSerie.remove();
                bw.write(serie.toString());
                bw.newLine();
            }
        } catch(Exception e){
            System.err.println("Erro ao escrever o arquivo texto" + e.getMessage() + "\n");
        }
    }

    public void escreverFilmeBinario(MyQueueLinkedList<Filme> listaFilmes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathFilmeBinario))) {
            oos.writeObject(listaFilmes);
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo filme binário" + e.getMessage() + "\n");
        }
    }

    public void escreverSerieBinario(MyQueueLinkedList<Serie> listaSerie) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathSerieBinario))) {
            oos.writeObject(listaSerie);
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo série binário " + e.getMessage() + "\n");
        }
    }

    public MyQueueLinkedList<Filme> lerFilmeBinario(){
        MyQueueLinkedList<Filme> listaFilmes = new MyQueueLinkedList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathFilmeBinario))){
            listaFilmes = (MyQueueLinkedList<Filme>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.print("Erro ao ler arquivo binário filme " + e.getMessage() + "\n");
        }
        return listaFilmes;
    }

    public MyQueueLinkedList<Serie> lerSerieBinario(){
        MyQueueLinkedList<Serie> listaSerie = new MyQueueLinkedList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathSerieBinario))){
            listaSerie = (MyQueueLinkedList<Serie>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.print("Erro ao ler arquivo binário série " + e.getMessage() + "\n");
        }

        return listaSerie;
    }

    public void imprimirEpisodiosOrdenados(Episodio[] episodios) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathListaEpisodios))) {

            for(Episodio episodio : episodios) {
                bw.write(episodio.toString());
                bw.newLine();
            }
        } catch(Exception e){
            System.err.println("Erro ao escrever o arquivo texto" + e.getMessage());
        }
    }
}
