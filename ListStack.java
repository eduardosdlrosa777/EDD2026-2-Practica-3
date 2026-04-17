import java.util.EmptyStackException;

public class ListStack<T> implements TDAStack<T> {

    private class Node<T> {

        public T dato;
        public Node siguiente;

        public Node(T dato, Node siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    private Node puntero;
    public int magnitud;

    public ListStack() {
        this.puntero = null;
        this.magnitud = 0;
    }

    public int size() {
        return this.magnitud;
    }

    @SuppressWarnings("unchecked")
    public void push(T e) {
        Node nuevoDato = new Node(e, this.puntero);
        this.puntero = nuevoDato;
        magnitud++;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T valorDeRetorno = (T) this.puntero.dato;
        this.puntero = this.puntero.siguiente;
        magnitud--;
        return valorDeRetorno;
    }

    @SuppressWarnings("unchecked")
    public T top(){
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) this.puntero.dato;
    }

    @SuppressWarnings("unchecked")
    public boolean isEmpty() {
        return this.puntero == null;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        this.puntero = null;
        magnitud = 0;
    }

    @SuppressWarnings("unchecked")
    public void show() {
    Node temp = this.puntero;
    while(temp != null) {
        System.out.print(temp.dato + " -> ");
        temp = temp.siguiente;
        }
    System.out.println();
    }

}
