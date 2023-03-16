package org.mps.deque;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author("Nicolás Zambrana Smith, Jose Manuel Sánchez Navarro)
 */

public class DoublyLinkedListDequeTest {
    /**
    1. Constructor vacío devuelve una lista vacía
    2. Prepend de un valor 15 a una lista VACÍA devuelve una lista con un nodo first y last iguales que no son null y una lista del tamaño 1
    3. Prepend de un valor 15 a una lista devuelve la lista con un nuevo nodo first con el valor T
    4. Append de un valor 15 a una lista VACÍA devuelve una lista con un nodo first y last iguales que no son null y una lista del tamaño 1
    5. Append de un valor 15 a una lista devuelve la lista con un nuevo nodo last con el valor T
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
    17. Get de una lista VACÍA lanza una excepción
    18. Get de una lista con índice 0 le devuelve el primero
    19. Get de una lista con índice size-1 le devuelve el último
    20. Get de una lista con índice 2 le devuelve el tercero
    21. Get de una lista con índice -1 lanza una excepción
    22. Get de una lista con índice size+1 lanza una excepción
    23. Contains de una lista VACÍA lanza una excepción
    24. Contains de una lista con elemento incluido el primero
    25. Contains de una lista con elemento incluido el segundo
    26. Contains de una lista con elemento no incluido
    27. Remove de una lista vacía lanza una excepción
    28. Remove de una lista SIZE=1 devuelve una lista vacía (null)
    29. Remove de una lista SIZE=1 un elemento que no está en la lista no hace nada
    30. Remove el primer elemento de una lista devuelve la lista donde su first será el NEXT del antiguo first
    31. Remove el último elemento de una lista devuelve la lista donde su last será el PREVIOUS del antiguo last
    32. Remove un elemento intermedio de la lista devuelve la lista con size-1 y sin ese elemento
    33. Remove un elemento que no está en la lista no hace nada
    34. Sort de una lista vacía lanza una excepción
    35. Sort de una lista de integers devuelve la lista en orden ascendente
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
        @DisplayName("Prepend de un valor 15 a una lista VACÍA devuelve una lista con un nodo first y last iguales que no son null y una lista del tamaño 1")
        void prependValue15WithEmptyList(){
            lista.prepend(15);
            assertNotNull(lista.first);
            assertNotNull(lista.last);
            assertEquals(1,lista.size);
        }
        @Test
        @DisplayName("Append de un valor 15 a una lista VACÍA devuelve una lista con un nodo first y last iguales que no son null y una lista del tamaño 1")
        void appendValue15WithEmptyList(){
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
        @Test
        @DisplayName("Get de una lista VACÍA lanza una excepción")
        void getOnEmptyListThrowsException(){
            assertThrows(DoubleEndedQueueException.class,  ()->lista.get(0));
        }
        @Test
        @DisplayName("Contains de una lista VACÍA lanza una excepción")
        void containsOnEmptyListThrowsException(){
            assertThrows(DoubleEndedQueueException.class,()->lista.contains(0));
        }
        @Test
        @DisplayName("Remove de una lista vacía lanza una excepción")
        void removeOnEmptyListThrowsException(){
            assertThrows(DoubleEndedQueueException.class, ()->lista.remove(0));
        }

        @Test
        @DisplayName("Sort de una lista vacía lanza una excepción")
        void sortOnEmptyListThrowsException(){
            DoublyLinkedListDeque<Integer> listaint = new DoublyLinkedListDeque<>();
            assertThrows(DoubleEndedQueueException.class, ()->listaint.sort(Comparator.naturalOrder()));
        }



        @Nested
        @DisplayName("Añadimos un solo nodo a la lista")
        class listSize1{
            @BeforeEach
            void createList(){
                DequeNode<Object> nodo1=new DequeNode<>(12,null,null);
                lista.first=nodo1;
                lista.last=nodo1;
                lista.size=1;

            }
            @AfterEach
            void shutDown(){
            }
            @Test
            @DisplayName("Prepend de un valor 99 a una lista devuelve la lista con un nuevo nodo first con el valor 99")
            void prependNode(){
                lista.prepend(99);
                assertEquals(99,lista.first.item);
            }
            @Test
            @DisplayName("Append de un valor 99 a una lista devuelve la lista con un nuevo nodo last con el valor 99")
            void appendNode(){
                lista.append(99);
                assertEquals(99,lista.last.item);
            }
            @Test
            @DisplayName("DeleteFirst de una lista SIZE=1 devuelve una lista vacía (null)")
            void deleteFirstFromAListWithSize1ReturnsEmptyList(){
                lista.deleteFirst();
                assertNull(lista.first);
                assertNull(lista.last);
                assertEquals(0,lista.size);
            }
            @Test
            @DisplayName("DeleteFirst de una lista SIZE=1 devuelve una lista vacía (null)")
            void deleteLastFromAListWithSize1ReturnsEmptyList(){
                lista.deleteLast();
                assertNull(lista.first);
                assertNull(lista.last);
                assertEquals(0,lista.size);
            }
            @Test
            @DisplayName("Remove de una lista SIZE=1 devuelve una lista vacía (null)")
            void removeAnElementFromAListWithSize1ReturnsEmptyList(){
                lista.remove(12);
                assertNull(lista.first);
                assertNull(lista.last);
                assertEquals(0,lista.size);
            }
            @Test
            @DisplayName("Remove de una lista SIZE=1 un elemento que no está en la lista no hace nada")
            void removeFromAListSize1AnElementThatItIsNotOnTheListDoesNothing(){
                lista.remove(20);
                assertNotNull(lista.first);
                assertNotNull(lista.last);
                assertEquals(1,lista.size);
            }
            @Nested
            @DisplayName("Añadimos 3 nodos más")
            class listSize4{
                @BeforeEach
                void add3Nodes(){
                    DequeNode<Object> nodo2=new DequeNode<>(13,lista.first,null);
                    lista.first.setNext(nodo2);
                    DequeNode<Object> nodo3=new DequeNode<>(14,nodo2,null);
                    nodo2.setNext(nodo3);
                    DequeNode<Object> nodo4=new DequeNode<>(15,nodo3,null);
                    nodo3.setNext(nodo4);
                    lista.last=nodo4;
                    lista.size=4;

                }
                @AfterEach
                void shutDown(){
                }
                @Test
                @DisplayName("DeleteFirst de una lista devuelve la lista donde su first será el NEXT del antiguo first")
                void deleteFirstOfAFullList(){
                    DequeNode<Object> nextNodo=lista.first.next;
                    lista.deleteFirst();
                    assertEquals(nextNodo,lista.first);
                    assertEquals(3,lista.size);
                }
                @Test
                @DisplayName("DeleteLast de una lista devuelve la lista donde su last será el PREVIOUS del antiguo last")
                void deleteLastOfAFullList(){
                    DequeNode<Object> previousNodo=lista.last.previous;
                    lista.deleteLast();
                    assertEquals(previousNodo,lista.last);
                    assertEquals(3,lista.size);
                }
                @Test
                @DisplayName("First de una lista devuelve el primer elemento")
                void firstElement(){
                    assertEquals(12,lista.first());
                }
                @Test
                @DisplayName("Last de una lista devuelve el último elemento")
                void lastElement(){
                    assertEquals(15,lista.last());
                }
                @Test
                @DisplayName("Get de una lista con índice 0 le devuelve el primero")
                void getWithIndex0ReturnsFirstNode(){
                    assertEquals(lista.first.item,lista.get(0));
                }
                @Test
                @DisplayName("Get de una lista con índice size-1 le devuelve el último")
                void getWithIndexSizeMinus1ReturnsLastNode(){
                    assertEquals(lista.last.item,lista.get(lista.size-1));
                }
                @Test
                @DisplayName("Get de una lista con índice 2 le devuelve el tercero")
                void getWithIndex2ReturnsTheThirdNode(){
                    assertEquals(lista.last.previous.item,lista.get(2));
                }
                @Test
                @DisplayName("Get de una lista con índice -1 lanza una excepción")
                void getWithIndexMinus1ThrowsException(){
                    assertThrows(IndexOutOfBoundsException.class, ()->lista.get(-1));
                }
                @Test
                @DisplayName("Get de una lista con índice size lanza una excepción")
                void getWithIndexSizeThrowsException(){
                    assertThrows(IndexOutOfBoundsException.class,()->lista.get(lista.size));
                }
                @Test
                @DisplayName("Contains de una lista con elemento incluido el primero")
                void containsAnElementAtTheBeginningOfTheList(){
                    assertTrue(lista.contains(12));
                }
                @Test
                @DisplayName("Contains de una lista con elemento incluido el segundo")
                void containsAnElementSomewhereElseInTheList(){
                    assertTrue(lista.contains(13));
                }
                @Test
                @DisplayName("Contains de una lista con elemento no incluido")
                void containsAnElementThatIsNotInTheList(){
                    assertFalse(lista.contains(20));
                }
                @Test
                @DisplayName("Remove el primer elemento de una lista devuelve la lista donde su first será el NEXT del antiguo first")
                void removeFirstFromAListReturnsListWhereFirstWillBeNextFromThePreviousFirst(){
                    DequeNode<Object> nextNodo=lista.first.next;
                    lista.remove(12);
                    assertEquals(nextNodo,lista.first);
                    assertEquals(3,lista.size);

                }
                @Test
                @DisplayName("Remove el último elemento de una lista devuelve la lista donde su last será el PREVIOUS del antiguo last")
                void removeLastFromAListReturnsListWhereLastWillBePreviousFromThePreviousLast(){
                    DequeNode<Object> previousNodo=lista.last.previous;
                    lista.remove(15);
                    assertEquals(previousNodo,lista.last);
                    assertEquals(3,lista.size);
                }
                @Test
                @DisplayName("Remove un elemento intermedio de la lista devuelve la lista con size-1 y sin ese elemento")
                void removeMiddleElementFromListReturnsListWithSizeMinus1AndWithoutThatElement(){
                    int size = lista.size;
                    lista.remove(13);
                    assertEquals(size-1,lista.size);
                    assertFalse(lista.contains(13));
                }
                @Test
                @DisplayName("Remove un elemento que no está en la lista no hace nada")
                void removeAnElementThatsIsNotOnTheListDoesNothing(){
                    int size = lista.size;
                    lista.remove(20);
                    assertEquals(size,lista.size);
                }
                @Test
                @DisplayName("Sort de una lista de integers devuelve la lista en orden ascendente")
                void sortOfAIntegerListReturnsTheListInAscendingOrder(){
                    DoublyLinkedListDeque<Integer> listaTest = new DoublyLinkedListDeque<>();
                    listaTest.append(2);
                    listaTest.append(4);
                    listaTest.append(3);
                    listaTest.append(1);

                    listaTest.sort(Comparator.naturalOrder());

                    assertEquals(1,listaTest.get(0));
                    assertEquals(2,listaTest.get(1));
                    assertEquals(3,listaTest.get(2));
                    assertEquals(4,listaTest.get(3));
                }

            }

        }

    }
}
