package sorting;

public class Sorting <E extends Comparable<E>> {
    public void quickSort(E[] array){
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(E[] array, int inicio, int fim){
        if (inicio < fim){
            int posicaoPivo = particiona(array, inicio, fim);
            quickSort(array, inicio, posicaoPivo - 1);
            quickSort(array, posicaoPivo + 1, fim);
        }
    }

    private int particiona(E[] array, int inicio, int fim){
        E pivo = array[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f){
            if (array[i].compareTo(pivo) <= 0){
                i++;
            } else if (pivo.compareTo(array[f]) < 0){
                f--;
            } else {
                swap(array, i, f);
                i++;
                f--;
            }
        }
        array[inicio] = array[f];
        array[f] = pivo;
        return f;
    }

    private void swap(E[] array, int i, int j){
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
