package ufersa.omdbapi.search;

import java.io.Serializable;
import java.util.Comparator;

public class Search <T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public int linearSearch(T[] array, T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(T[] array, T element) {
        return binarySearch(array, element, 0, array.length - 1);
    }

    private int binarySearch(T[] array, T element, int inicio, int fim) {
        if (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (array[meio].equals(element)) {
                return meio;
            } else if (((Comparable<T>) array[meio]).compareTo(element) < 0) {
                return binarySearch(array, element, meio + 1, fim);
            } else {
                return binarySearch(array, element, inicio, meio - 1);
            }
        }
        return -1;
    }

    // binary search without recursion
    public int binarySearchIterative(T[] array, T element, Comparator<T> comparator) {
        int inicio = 0;
        int fim = array.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (array[meio].equals(element)) {
                return meio;
            } else if (comparator.compare(array[meio], element) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

}