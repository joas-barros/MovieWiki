package ufersa.omdbapi.sorting;

import java.util.Comparator;

public class Sorting<E> {
    public void quickSort(E[] array, Comparator<E> comparator) {
        quickSort(array, 0, array.length - 1, comparator);
    }

    private void quickSort(E[] array, int inicio, int fim, Comparator<E> comparator) {
        if (inicio < fim) {
            int posicaoPivo = particiona(array, inicio, fim, comparator);
            quickSort(array, inicio, posicaoPivo - 1, comparator);
            quickSort(array, posicaoPivo + 1, fim, comparator);
        }
    }

    private int particiona(E[] array, int inicio, int fim, Comparator<E> comparator) {
        E pivo = array[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (comparator.compare(array[i], pivo) <= 0) {
                i++;
            } else if (comparator.compare(pivo, array[f]) < 0) {
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

    private void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

