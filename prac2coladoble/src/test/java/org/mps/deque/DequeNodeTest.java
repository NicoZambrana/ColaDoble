package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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
     * 7.isFirstNode sea true
     * 8.isfirstNode sea false
     * 9.isLastNode sea true
     * 10.isLastNode sea false
     * 11.isNotATerminalNode sea true
     * 12.isNotATerminalNode sea false porque es First
     * 13.isNotATerminalNode sea false porque es Last
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
    }

}
