package test.listOfIntegersImpl;

import org.junit.jupiter.api.Test;
import ru.skypro.ListOfIntegersImpl;

import static org.junit.jupiter.api.Assertions.*;
import static test.constance.ConstanceListTest.*;

public class ListOfIntegersImplTest {
    @Test
    void add() {
        ListOfIntegersImpl intList = new ListOfIntegersImpl();
        assertEquals(ZERO,intList.size());
        Integer item = intList.add(ZERO);
        assertEquals(1,intList.size());
        assertEquals(ZERO, item);

    }

    @Test
    void addAtIndex(){
        ListOfIntegersImpl intList = LS_5();
        Integer item = intList.add(ZERO, FIVE);
        assertEquals(FIVE, item);
    }

    @Test
    void addAtIndex_ShouldThrowException(){
        ListOfIntegersImpl intList = new ListOfIntegersImpl();
        assertThrows(IndexOutOfBoundsException.class, () -> intList.add(-1,ZERO));
    }

    @Test
    void set() {
        ListOfIntegersImpl list = LS_5();
        Integer item = list.set(ZERO, FIVE);
        assertEquals(ZERO, item);
    }

    @Test
    void removeAtIndex() {
        ListOfIntegersImpl intList = new ListOfIntegersImpl();
        intList.add(ZERO);
        Integer item = intList.remove(0);
        assertEquals(ZERO, item);
    }


    @Test
    void removeAtObject() {
        ListOfIntegersImpl intList = new ListOfIntegersImpl();
        intList.add(ZERO);
        Integer item = intList.remove(ZERO);
        assertEquals(ZERO, item);
    }

    @Test
    void contains() {
        ListOfIntegersImpl intList = LS_5();
        boolean contains = intList.contains(ZERO);
        assertTrue(contains);
    }

    @Test
    void indexOf() {
        ListOfIntegersImpl intList = LS_5();
        int index = intList.indexOf(ZERO);
        assertEquals(ZERO, index);
    }

    @Test
    void indexOf_ShouldReturnMinusOne() {
        ListOfIntegersImpl intList = LS_5();
        int index = intList.indexOf(FIVE);
        assertEquals(-1, index);
    }

    @Test
    void lastIndexOf() {
        ListOfIntegersImpl intList = LS_5();
        int index = intList.indexOf(ZERO);
        assertEquals(ZERO, index);
    }

    @Test
    void get() {
        ListOfIntegersImpl intList = LS_5();
        Integer item = intList.get(0);
        assertEquals(ZERO, item);
    }

    @Test
    void testEquals() {
        ListOfIntegersImpl intList = new ListOfIntegersImpl();
        intList.add(ZERO);
        intList.add(ONE);
        intList.add(TWO);
        intList.add(THREE);
        intList.add(FOUR);

       boolean equals = intList.equals(LS_5());
        assertTrue(equals);
    }

    @Test
    void size() {
        ListOfIntegersImpl intList = LS_5();
        assertEquals(5, intList.size());
    }

    @Test
    void isEmpty() {
        ListOfIntegersImpl intList = LS_5();
        assertFalse(intList.isEmpty());
        assertTrue(EMPTY_LIST.isEmpty());
    }

    @Test
    void clear() {
        ListOfIntegersImpl intList= new ListOfIntegersImpl();
        intList.add(ZERO);
        intList.clear();
        assertTrue(intList.isEmpty());
    }

    @Test
    void toArray() {

    }
}
