package ufersa.omdbapi.service;

import ufersa.omdbapi.dados.fila.MyQueueLinkedList;
import ufersa.omdbapi.exceptions.MyException;
import ufersa.omdbapi.model.Filme;
import ufersa.omdbapi.model.Serie;

import java.io.*;

public class Arquivos {

    private static final String pathFilmeTexto = "src\\main\\java\\ufersa\\omdbapi\\archives\\arquivoTextoFilme.txt";
    private static final String pathSerieTexto = "src\\main\\java\\ufersa\\omdbapi\\archives\\arquivoTextoSerie.txt";


    public void escreverFilmesTexto(MyQueueLinkedList<Filme> listaFilmes) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathFilmeTexto))) {

            while(!listaFilmes.isEmpty()){
                Filme filme = listaFilmes.remove();
                bw.write(filme.toString());
                bw.newLine();
            }
        } catch(Exception e){
            System.err.println("Erro ao escrever o arquivo texto" + e.getMessage());
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
            System.err.println("Erro ao escrever o arquivo texto" + e.getMessage());
        }
    }

    //public void escreverFilmeBinario(MyQueueLinkedList<Filme> listaFilmes) {
    //    System.out.println(listaFilmes);
    //    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathFilmeBinario))) {
    //        oos.writeObject(listaFilmes);
    //        System.out.println("Arquivo salvo com sucesso!");
    //    } catch (IOException e) {
    //        System.err.println("Erro ao escrever o arquivo binário" + e.getMessage());
    //    }
    //}
    //
    //public MyQueueLinkedList<Filme> lerFilmeBinario(){
    //    MyQueueLinkedList<Filme> listaFilmes = new MyQueueLinkedList<>();
    //
    //    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathFilmeBinario))){
    //        listaFilmes = (MyQueueLinkedList<Filme>) ois.readObject();
    //    } catch (IOException | ClassNotFoundException e) {
    //        System.err.print("Erro ao ler arquivo binário " + e.getMessage());
    //    }
    //
    //    return listaFilmes;
    //}
}
