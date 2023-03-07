package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    /**
     * Crea una doubleLinkedList VACIA con el first y last = null y tamaño = 0     */
    public DoublyLinkedListDeque() {
        first=null;
        last=null;
        size=0;
    }

    @Override
    public void prepend(T value) {
        // TODO
        DequeNode<T> nodo= new DequeNode<T>(value,null,null);
        if(this.size==0){
            first=nodo;
            last=nodo;
            size=1;
        }else {
            first.setPrevious(nodo);
            nodo.setNext(first);
            first=nodo;
            size++;
        }
    }

    @Override
    public void append(T value) {
        // TODO
        DequeNode<T> nodo= new DequeNode<T>(value,null,null);
        if(this.size==0){
            first=nodo;
            last=nodo;
            size=1;
        }else {
            last.setNext(nodo);
            nodo.setPrevious(last);
            last=nodo;
            size++;
        }
    }

    @Override
    public void deleteFirst() {
        // TODO

    }

    @Override
    public void deleteLast() {
        // TODO
    }

    @Override
    public T first() {
        T firstElement;
        if(size==0){
            firstElement=null;
        }else{
            firstElement=first.getItem();
        }
        return firstElement;
    }

    @Override
    public T last() {
        // TODO
        T lastElement;
        if(size==0){
            lastElement=null;
        }else{
            lastElement=first.getItem();
        }
        return lastElement;
    }

    @Override
    public int size() {
        // TODO

        return size;
    }
}
