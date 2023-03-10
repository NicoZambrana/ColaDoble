package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author("Nicolás Zambrana Smith, Jose Manuel Sánchez Navarro)
 */
public class DequeNodeTest {

    /**
     * 1.GetItem devuelve el item correcto
     * 2.SetItem cambia correctamente el item
     * 3.getPrevius sea null
     *              4.getPrevius sea un Nodo
     * 5.SetPrevius sea null
     * 6.SetPrevius sea un Nodo
     * 7.Getnext sea null
     *              8.Getnext sea Nodo
     * 9.isFirstNode sea true
     *              10.isfirstNode sea false
     * 11.isLastNode sea true
     *              12.isLastNode sea false
     *              13.isNotATerminalNode sea true
     *              14.isNotATerminalNode sea false porque es First
     *              15.isNotATerminalNode sea false porque es Last
     * 16.SetNext sea null
     * 17.SetNext sea un nodo
     */
    DequeNode<Object> nodo;
    @Nested
    @DisplayName("Pruebas con Nodo Unico")
    class UniqueNode{
        @BeforeEach
        void createNode(){
            nodo=new DequeNode<Object>(12,null,null);
        }
        @AfterEach
        void shutDown(){
        }

        @Test
        @DisplayName("GetItem devuelve el item correcto")
        void getItemCorrect(){
            assertEquals(12,nodo.getItem());
        }

        /**
         * Cambiamos la visibilidad de los atributos de la clase DequeNode a protected
         */
        @Test
        @DisplayName("SetItem cambia correctamente el item")
        void setItemCorrect(){
            nodo.setItem(20);
            assertEquals(20,nodo.item);
        }
        @Test
        @DisplayName("GetPrevius sea null")
        void getPreviusIsNull(){
            assertNull(nodo.getPrevious());
        }

        @Test
        @DisplayName("Set a previus NullNode")
        void setPreviusNull(){
            nodo.setPrevious(null);
            assertNull(nodo.previous);
        }

        @Test
        @DisplayName("Set a previus Node")
        void setPreviusNode(){
            DequeNode<Object> nodoAux=new DequeNode<>(13,null,null);
            nodo.setPrevious(nodoAux);
            assertEquals(nodoAux,nodo.previous);
        }
        @Test
        @DisplayName("isFirstNode sea true")
        void isFirstNodeTrue(){
            assertTrue(nodo.isFirstNode());
        }
        @Test
        @DisplayName("isLastNode sea true")
        void isLastNodeTrue(){
            assertTrue(nodo.isLastNode());
        }
        @Nested
        @DisplayName("Añadimos nodos anterior y posterior a nuestro Nodo Único")
        class PreviousAndNext{
            DequeNode<Object> anteriornodo;
            DequeNode<Object> posteriornodo;
            @BeforeEach
            void setNodes(){
                anteriornodo=new DequeNode<>(4,null,null);
                posteriornodo=new DequeNode<>(16,null,null);
                nodo.previous=anteriornodo;
                anteriornodo.next=nodo;
                nodo.next=posteriornodo;
                posteriornodo.previous=nodo;
            }
            @AfterEach
            void shutDown(){
            }
            @Test
            @DisplayName("getPrevious devuelve el nodo anterior")
            void getPreviousReturnsPreviousNode(){
                assertEquals(anteriornodo,nodo.getPrevious());
            }
            @Test
            @DisplayName("getNext devuelve el nodo posterior")
            void getNextReturnsNextNode(){
                assertEquals(posteriornodo,nodo.getNext());
            }
            @Test
            @DisplayName("isFirstNode devuelve falso si no es el primer nodo")
            void isFirstNodeFalse(){
                assertFalse(nodo.isFirstNode());
            }
            @Test
            @DisplayName("isLastNode devuelve falso si no es el último nodo")
            void isLastNodeFalse(){
                assertFalse(nodo.isLastNode());
            }
            @Test
            @DisplayName("isNotATerminalNode devuelve verdadero para el nodo intermedio")
            void isNotATerminalNodeTrue(){
                assertTrue(nodo.isNotATerminalNode());
            }
            @Test
            @DisplayName("isNotATerminalNode devuelve falso para el nodo primero")
            void isNotATerminalNodeFalseForFirstNode(){
                assertFalse(anteriornodo.isNotATerminalNode());
            }
            @Test
            @DisplayName("isNotATerminalNode devuelve falso para el nodo último")
            void isNotATerminalNodeFalseForLastNode(){
                assertFalse(posteriornodo.isNotATerminalNode());
            }

            @Test
            @DisplayName("Set a next NullNode")
            void setNextNull(){
                nodo.setNext(null);
                assertNull(nodo.next);
            }

            @Test
            @DisplayName("Set a next Node")
            void setNextNode(){
                DequeNode<Object> nodoAux=new DequeNode<>(13,null,null);
                nodo.setNext(nodoAux);
                assertEquals(nodoAux,nodo.next);
            }
        }
    }



}
