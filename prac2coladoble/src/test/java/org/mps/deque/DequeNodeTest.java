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
     * 9.isFirstNode sea true
     *              10.isfirstNode sea false
     * 11.isLastNode sea true
     *              12.isLastNode sea false
     *              13.isNotATerminalNode sea true
     *              14.isNotATerminalNode sea false porque es First
     *              15.isNotATerminalNode sea false porque es Last
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

    @Test
    @DisplayName("isFirstNode sea true")
    void isFirstNodeTrue(){
        //si uso el objeto "nodo" declarado al comienzo del codigo, da un error , no entiendo por que
        DequeNode<Object> nodo1=new DequeNode<>(13,null,null);
        assertTrue(nodo1.isFirstNode());
    }
    @Test
    @DisplayName("isLastNode sea true")
    void isLastNodeTrue(){
        //si uso el objeto "nodo" declarado al comienzo del codigo, da un error , no entiendo por que
        DequeNode<Object> nodo1=new DequeNode<>(13,null,null);
        assertTrue(nodo1.isLastNode());
    }
}
