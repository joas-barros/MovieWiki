package ufersa.omdbapi.dados.lista_encadeada;


import ufersa.omdbapi.exceptions.MyException;

import java.lang.reflect.Array;

public class SinglyList <T> implements MyListInterface<T>{

    class Node {
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    // Atributos de MyLinkedListSingly
    private Node head;
    private Node tail;
    private int size;

    public SinglyList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(T value) {
        Node node = new Node(value);
        if (size == 0){
            head = node;
            tail = node;
        } else if (size == 1){
            head = node;
            head.next = tail;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(T value) {
        Node node = new Node(value);
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public boolean addAfter(T dado, T crit) {
        Node antecessor = searchNode(crit);
        if (antecessor == null){
            System.out.println("O elemento " + crit + " não existe na lista");
            return false;
        }

        Node novo = new Node(dado);
        if (antecessor == tail){
            tail.next = novo;
            tail = novo;
        } else {
            novo.next = antecessor.next;
            antecessor.next = novo;
        }
        size++;
        return true;
    }

    private Node searchNode(T crit) {
        Node p = head;		// ponteiro temporario

        while( p != null )
        {
            if( p.data.equals(crit) ) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    @Override
    public T peekFirst() {
        if( head == null ) {
            System.out.println("Lista Vazia!!! \n");
            return null;
        }
        return head.data;
    }

    @Override
    public T peekLast() {
        if (tail == null) {
            System.out.println("Lista Vazia!!! \n");
            return null;
        }
        return tail.data;
    }

    @Override
    public T search(T crit) {
        if (head == null){
            return null;
        }
        Node p = head;
        while (p != null){
            if(p.data.equals(crit)){
                return p.data;
            }
            p = p.next;
        }
        return null;
    }

    @Override
    public T removeFirst() {
        if (head == null){
            throw new MyException("A lista está vazia");
        }

        T dado = null;
        Node p = head;

        if ( head == tail){
            System.out.println("Removendo elemento único");
            dado = head.data;
            head = null;
            tail = null;
        } else {
            System.out.println("Removendo item mas ainda tem outros");
            dado = head.data;
            head = head.next;
            p.next = null;
        }
        size--;
        return dado;
    }

    @Override
    public T removeLast() {
        if (tail == null){
            throw new MyException("A lista está vazia");
        }

        T dado = null;
        if (head == tail){
            System.out.println("Removendo elemento único da lista");
            dado = tail.data;
            head = null;
            tail = null;
        } else {
            System.out.println("Removendo elemento, porém existem outros");
            Node p = head;
            while (p.next != tail){
                p = p.next;
            }
            dado = tail.data;
            p.next = null;
            tail = p;
        }
        size--;
        return dado;
    }

    @Override
    public T remove(T crit) {
        if (head == null){
            throw new MyException("A lista está vazia");
        }
        Node node = searchNode(crit);
        T dado = null;
        if (node == null){
            throw new MyException("O elemento não existe na fila");
        }

        if (head == tail){
            System.out.println("Removendo elemento único da lista");
            dado = node.data;
            head = null;
            tail = null;
        } else if (node == head){
            dado = removeFirst();
        } else if (node == tail) {
            dado = removeLast();
        } else {
            Node p = head;
            while (p.next != node){
                p = p.next;
            }
            dado = node.data;
            p.next = node.next;
            node.next = null;
        }
        size--;
        return dado;
    }

    @Override
    public void show() {
        if (head == null){
            System.out.println("[]");
            return;
        }

        System.out.print("[ ");
        Node p = head;
        while (p != null){
            System.out.print(p.data + ", ");
            p = p.next;
        }
        System.out.println("]");
    }

    @Override
    public boolean isEmpty(){
        return head == null && tail == null;
    }

    @Override
    public T[] toArray(T[] a) {
        if (a.length < size) {
            // Creates a new array of the correct type
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        }

        Node p = head;
        int i = 0;
        while (p != null) {
            a[i] = p.data;
            p = p.next;
            i++;
        }
        return a;
    }


    @Override
    public void showReverse() {
        System.out.println("Da não");
    }
}
