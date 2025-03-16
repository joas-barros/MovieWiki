package ufersa.omdbapi.service;

import ufersa.omdbapi.dados.fila.MyQueueLinkedList;
import ufersa.omdbapi.model.Filme;

import java.io.*;

public class ArquivoBinarioFilme {
    private final String path = "src\\main\\java\\ufersa\\omdbapi\\archives\\arquivoBinarioFilme.txt";
    public MyQueueLinkedList<Filme> listarFilmes(){
        MyQueueLinkedList<Filme> filmes = new MyQueueLinkedList<>();
       try{
           ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
           while(true) {
               try {
                   Object obj = ois.readObject();

                   if (obj instanceof Filme) {
                       Filme filme = (Filme) obj;
                       filmes.add(filme);
                   }
               }catch(IOException e) {
                   break;
               }catch(ClassNotFoundException e){
                   System.err.println("Classe não encontrada" + e.getMessage());
               }
           }

       } catch (FileNotFoundException e) {
           System.err.println("Arquivo não encontrado" + e.getMessage());
       }catch (IOException e) {
           System.err.println("Erro ao abrir arquivo" + e.getMessage());

       }
            return filmes;
    }

    public void escreverFilmes(MyQueueLinkedList<Filme> filmes){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(filmes);
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }
}
