package org.mps.deque;

import java.util.Comparator;

/**
 * @author("Nicolás Zambrana Smith, Jose Manuel Sánchez Navarro)
 */
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
            lastElement=last.getItem();
        }
        return lastElement;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public T get(int index) {
        T res= null;
        if(this.size==0){
            throw new DoubleEndedQueueException("Cola vacía");
        }
        if(index<0 || index>=this.size){
            throw new IndexOutOfBoundsException("Index fuera de la lista");
        }
        if(index==0){
            res = this.first.item;
        }
        if(index==this.size-1){
            res=this.last.item;
        }
        DequeNode<T> curr = this.first;
        int cont=1;

        while(cont<=index && curr!=null){
            if(cont==index){
                res= curr.item;
            }else{
                cont++;
                curr=curr.next;
            }
        }
        return res;

    }


    @Override
    public boolean contains(T value) {
        if(this.size==0){
            throw new DoubleEndedQueueException("Cola vacía");
        }
        //DequeNode<T> prev = null;
        DequeNode<T> curr = this.first;
        boolean found=false;
        while(!found && curr!=null){
            if(curr.item.equals(value)){
                found=true;

            }else{
                //prev=curr;
                curr=curr.next;
            }
        }
        return found;

    }

    @Override
    public void remove(T value) {
        if(this.size==0) {
            //No hace nada
        } else if (size==1) {
            if(first.getItem()==value){
                first=null;
                last=null;
                size=0;
            }
        }else{
            int cont=size;
            boolean encontrado=false;
            DequeNode<T> firstAux=first;
            DequeNode<T> lastAux=last;
            while(cont>0 && !encontrado){
                if(firstAux.getItem().equals(value)){
                    encontrado=true;
                    DequeNode<T> next = firstAux.getNext();
                    firstAux.setNext(null);
                    first=next;
                }else if(lastAux.getItem().equals(value)){
                    encontrado=true;
                    DequeNode<T> previous = lastAux.getPrevious();
                    lastAux.setPrevious(null);
                    last=previous;
                }else {
                    //si el siguiente es
                    DequeNode<T> next = firstAux.getNext();
                    if(next.getItem().equals(value)){
                        firstAux.setNext(next.getNext());
                        next.getNext().setPrevious(firstAux);
                        next.setPrevious(null);
                        next.setNext(null);
                        encontrado=true;
                    }else{//si el siguiente no es

                        firstAux=firstAux.getNext();
                        cont--;
                    }

                }
            }
            if(encontrado){
                size--;
            }
        }


    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        //TODO
        if(size==0 || size==1){
            //no hace nada
        }else{

            DequeNode<T> firstAux=first;
            DequeNode<T> next=first.getNext();
            int cont1=size;
            while(cont1>0){
                int cont2=size;
                if(cont2>0){
                    if(comparator.compare(firstAux.getItem(),next.getItem())>0){
                        firstAux.setNext(next.getNext());
                        next.setNext(firstAux);
                        next.setPrevious(firstAux.getPrevious());
                        firstAux.setPrevious(next);
                    }
                    else{
                        firstAux=next;
                        next=next.getNext();
                    }
                    cont2--;
                }else{
                    firstAux=first;
                    next=firstAux.getNext();
                }
                cont1--;
            }

        }

    }
}
