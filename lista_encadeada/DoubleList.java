package unidade2.lista_encadeada;

import unidade2.exceptions.MyException;

public class DoubleList<T> implements MyListInterface<T>{

    class Node {
        T data;
        Node next;
        Node previous;

        public Node(T data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoubleList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(T value) {
        Node novo = new Node(value);
        if (head == null){
            head = novo;
            tail = novo;
        } else {
            novo.next = head;
            head.previous = novo;
            head = novo;
        }
        size++;
    }

    @Override
    public void addLast(T value) {
        Node novo = new Node(value);
        if (tail == null){
            head = novo;
        } else {
            novo.previous = tail;
            tail.next = novo;
        }
        tail = novo;
        size++;
    }

    private Node searchNode(T crit){
        Node p = head;

        while (p != null){
            if (p.data == crit){
                return p;
            }
            p = p.next;
        }
        return p;
    }

    @Override
    public boolean addAfter(T dado, T crit) {
        Node antecessor = searchNode(crit);
        if (antecessor == null){
            System.out.println("Elemento não existe dentro da lista");
            return false;
        }
        Node novo = new Node(dado);

        if (antecessor == tail){
            tail.next = novo;
            novo.previous = tail;
            tail = novo;
        } else {
            Node sucessor = antecessor.next;

            novo.next = sucessor;
            novo.previous = antecessor;

            sucessor.previous = novo;
            antecessor.next = novo;
        }
        size++;
        return true;
    }

    @Override
    public T peekFirst() {
        if (head == null){
            throw new MyException("A lista está vazia");
        }
        return head.data;
    }

    @Override
    public T peekLast() {
        if (tail == null){
            throw new MyException("A lista está vazia");
        }
        return tail.data;
    }

    @Override
    public T search(T crit) {
        Node node = searchNode(crit);
        if (node == null){
            return null;
        }
        return node.data;
    }

    @Override
    public T removeFirst() {
        if (head == null){
            throw new MyException("Lista vazia");
        }
        Node p = head;
        T elemento = null;
        if(head == tail){
            System.out.println("Removendo unico elemento da lista");
            elemento = head.data;
            head = null;
            tail = null;

        } else {
            elemento = head.data;
            head = head.next;
            head.previous = null;
        }
        p.next = null;
        size--;
        return elemento;
    }

    @Override
    public T removeLast() {
        if (tail == null){
            throw new MyException("Lista vazia");
        }
        Node p = tail;
        T elemento = null;
        if(head == tail){
            System.out.println("Removendo unico elemento da lista");
            elemento = tail.data;
            head = null;
            tail = null;

        }else {
            elemento = tail.data;
            tail = tail.previous;
            tail.next = null;
        }
        p.previous = null;
        size--;
        return elemento;
    }

    @Override
    public T remove(T crit) {
        if (head == null){
            throw new MyException("Lista vazia");
        }
        Node node = searchNode(crit);
        if (node == null){
            throw new MyException("Criteiro não atendido");
        }
        T elemento = null;
        if(head == tail){
            System.out.println("Removendo unico elemento");
            elemento = head.data;
        } else if (node == head){
            elemento = removeFirst();
        } else if (node == tail){
            elemento = removeLast();
        } else {
            elemento = node.data;
            Node anterior = node.previous;
            Node sucessor = node.next;
            anterior.next = sucessor;
            sucessor.previous = anterior;
            node.next = null;
            node.previous = null;
        }
        size--;
        return elemento;
    }

    @Override
    public void show() {
        if (head == null){
            throw new MyException("Não tem elementos para mostrar");
        }

        Node p = head;
        System.out.print("[");
        while (p != null){
            System.out.print(p.data + ",");
            p = p.next;
        }
        System.out.println(']');
    }

    @Override
    public void showReverse() {
        if (tail == null){
            throw new MyException("Não tem elementos para mostrar");
        }

        Node p = tail;
        System.out.print("[");
        while (p != null){
            System.out.print(p.data + ",");
            p = p.previous;
        }
        System.out.println(']');
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }
}
