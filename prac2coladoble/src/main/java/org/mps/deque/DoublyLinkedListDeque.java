package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    protected DequeNode<T> first;
    protected DequeNode<T> last;
    protected int size;

    /**
     * Crea una doubleLinkedList VACIA con el first y last = null y tamaño = 0     */
    public DoublyLinkedListDeque() {
        first=null;
        last=null;
        size=0;
    }

    @Override
    public void prepend(T value) {
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
        if (size==0) {
          throw new DoubleEndedQueueException("Cola vacía");
        }
        if(size==1){
            first=null;
            last=null;
        }else{
            first=first.getNext();
            first.setPrevious(null);
        }
        size--;
    }

    @Override
    public void deleteLast() {
        if (size==0) {
            throw new DoubleEndedQueueException("Cola vacía");
        }
        if(size==1){
            first=null;
            last=null;
        }else{
            last=last.getPrevious();
            first.setNext(null);
        }
        size--;
    }

    @Override
    public T first() {
        T firstElement;
        if(size==0){
            throw new DoubleEndedQueueException("Cola vacía");
        }else{
            firstElement=first.getItem();
        }
        return firstElement;
    }

    @Override
    public T last() {
        T lastElement;
        if(size==0){
            throw new DoubleEndedQueueException("Cola vacía");
        }else{
            lastElement=first.getItem();
        }
        return lastElement;
    }

    @Override
    public int size() {

        return size;
    }
}
