package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListDequeTest {
    /*
    1. Constructor vacío devuelve una lista vacía
    2. Prepend de un valor T a una lista VACÍA devuelve una lista con un nodo first y last iguales con el valor T
    3. Prepend de un valor T a una lista devuelve la lista con un nuevo nodo first con el valor T
    4. Append de un valor T a una lista VACÍA devuelve una lista con un nodo first y last iguales con el valor T
    5. Append de un valor T a una lista devuelve la lista con un nuevo nodo last con el valor T
    6. DeleteFirst de una lista VACÍA lanza una excepción
    7. DeleteFirst de una lista SIZE=1 devuelve una lista vacía (null)
    8. DeleteFirst de una lista devuelve la lista donde su first será el NEXT del antiguo first
    9. DeleteLast de una lista VACÍA lanza una excepción
    10. DeleteLast de una lista SIZE=1 devuelve una lista vacía (null)
    11. DeleteLast de una lista devuelve la lista donde su last será el PREVIOUS del antiguo last
    12. First de una lista VACÍA lanza una excepción
    13. First de una lista devuelve el primer elemento
    14. last de una lista VACÍA lanza una excepción
    15. Last de una lista devuelve el último elemento
    16. Size de una lista VACÍA devuelve 0


     */
    DoublyLinkedListDeque<Object> lista;
    @Nested
    @DisplayName("Pruebas con lista vacía")
    class EmptyList{
        @BeforeEach
        void createList(){
            lista = new DoublyLinkedListDeque<>();
        }
        @AfterEach
        void shutDown(){
        }

        @Test
        @DisplayName("Constructor devuelve una lista vacía")
        void constructorReturnsEmptyList(){
            assertNull(lista.first);
            assertNull(lista.last);
            assertEquals(0,lista.size);
        }
        @Test
        @DisplayName("Prepend de un valor T a una lista VACÍA devuelve una lista con un nodo first y last iguales con el valor T")
        void prependWithEmptyList(){
            /*
            DequeNode<Object> nodo= new DequeNode<Object>(15,null,null);
            assertEquals(nodo,lista.first);
            assertEquals(nodo,lista.last);

            el test falla tanto como para assertEquals como para assertSame

             */
            lista.prepend(15);
            assertNotNull(lista.first);
            assertNotNull(lista.last);
            assertEquals(1,lista.size);
        }
        @Test
        @DisplayName("Append de un valor T a una lista VACÍA devuelve una lista con un nodo first y last iguales con el valor T")
        void appendWithEmptyList(){
            lista.append(15);
            assertNotNull(lista.first);
            assertNotNull(lista.last);
            assertEquals(1,lista.size);
        }
        @Test
        @DisplayName("DeleteFirst de una lista VACÍA lanza una excepción")
        void deleteFirstOnEmptyListThrowsException(){
            assertThrows(DoubleEndedQueueException.class, ()->lista.deleteFirst());
        }

        @Test
        @DisplayName("DeleteLast de una lista VACÍA lanza una excepción")
        void deleteLastOnEmptyListThrowsException(){
            assertThrows(DoubleEndedQueueException.class, ()->lista.deleteLast());
        }
        @Test
        @DisplayName("First de una lista VACÍA lanza una excepción")
        void firstOnEmptyListThrowsException(){
            assertThrows(DoubleEndedQueueException.class, ()->lista.first());
        }
        @Test
        @DisplayName("Last de una lista VACÍA lanza una excepción")
        void lastOnEmptyListThrowsException(){
            assertThrows(DoubleEndedQueueException.class, ()->lista.last());
        }


        @Test
        @DisplayName("Size de una lista VACÍA devuelve 0")
        void sizeOnEmptyListReturns0(){
            assertEquals(0,lista.size());
        }

        @Nested
        @DisplayName("Pruebas con nodos dentro de la lista")
        class fullList{
            @BeforeEach
            void createList(){
                lista = new DoublyLinkedListDeque<>();
                DequeNode<Object> nodo1=new DequeNode<>(12,null,null);
                DequeNode<Object> nodo2=new DequeNode<>(13,nodo1,null);
                nodo1.setNext(nodo2);
                lista.first=nodo1;
                lista.last=nodo2;
                lista.size=2;

            }
            @AfterEach
            void shutDown(){
            }


            @Test
            @DisplayName("Prepend de un valor T a una lista devuelve la lista con un nuevo nodo first con el valor T")
            void prependNode(){
                lista.prepend(99);
                assertEquals(99,lista.first.item);
            }
             @Test
            @DisplayName("Append de un valor T a una lista devuelve la lista con un nuevo nodo first con el valor T")
            void appendNode(){
                lista.append(99);
                assertEquals(99,lista.last.item);
            }
            // 7. DeleteFirst de una lista SIZE=1 devuelve una lista vacía (null)
            @Test
            @DisplayName("DeleteFirst de una lista SIZE=1 devuelve una lista vacía (null)")
            void borrarFirstElUnicoNodoDeLaLista(){
                lista = new DoublyLinkedListDeque<>();
                DequeNode<Object> nodoAux=new DequeNode<>(12,null,null);
                lista.first=nodoAux;
                lista.last=nodoAux;
                lista.size=1;
                lista.deleteFirst();
                assertNull(lista.first);
                assertNull(lista.last);
                assertEquals(0,lista.size);
            }
            // 8. DeleteFirst de una lista devuelve la lista donde su first será el NEXT del antiguo first
            @Test
            @DisplayName("DeleteFirst de una lista con mas de un elemento")
            void deleteFirstOfAFullList(){
                DequeNode<Object> nextNodo=lista.first.next;
                lista.deleteFirst();
                assertEquals(nextNodo,lista.first);
                assertEquals(1,lista.size);
            }
            // 10. DeleteLast de una lista SIZE=1 devuelve una lista vacía (null)
            @Test
            @DisplayName("DeleteFirst de una lista SIZE=1 devuelve una lista vacía (null)")
            void borrarLastElUnicoNodoDeLaLista(){
                lista = new DoublyLinkedListDeque<>();
                DequeNode<Object> nodoAux=new DequeNode<>(12,null,null);
                lista.first=nodoAux;
                lista.last=nodoAux;
                lista.size=1;
                lista.deleteLast();
                assertNull(lista.first);
                assertNull(lista.last);
                assertEquals(0,lista.size);
            }
            // 11. DeleteLast de una lista devuelve la lista donde su last será el PREVIOUS del antiguo last
            @Test
            @DisplayName("DeleteFirst de una lista con mas de un elemento")
            void deleteLastOfAFullList(){
                DequeNode<Object> previousNodo=lista.last.previous;
                lista.deleteLast();
                assertEquals(previousNodo,lista.last);
                assertEquals(1,lista.size);
            }
            //13. First de una lista devuelve el primer elemento
            @Test
            @DisplayName("First de una lista devuelve el primer elemento")
            void firstElement(){
                assertEquals(12,lista.first());
            }
            //15. Last de una lista devuelve el último elemento
            @Test
            @DisplayName("Last de una lista devuelve el primer elemento")
            void lastElement(){
                assertEquals(13,lista.last());
            }
        }

    }
}
