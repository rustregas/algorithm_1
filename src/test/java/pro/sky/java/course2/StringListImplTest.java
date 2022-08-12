package pro.sky.java.course2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    StringListImpl out = new StringListImpl();

    @Test
    void addTest() {
        String expected = "testAdd";
        out.add("testAdd");
        assertEquals(expected, out.add("testAdd"));
        assertEquals(expected, out.get(1));
    }

    @Test
    void addTestIndex() {
        String expected = "testAddNew";
        out.add("testAdd");
        out.add(0,"testAddNew");
        assertEquals(expected, out.get(0));
    }

    @Test
    void addShouldThrowIndexOfBoundException() {
        String expected = "testAddNew";
        out.add("testAdd");
        assertThrows( IndexOutOfBoundsException.class, () ->  out.add(2,"testAddNew"));
    }

    @Test
    void setTest() {
        String expected = "testAddNew";
        out.add("testAdd");
        out.add(0,"testAddNew");
        assertEquals(expected, out.get(0));

        assertThrows( IndexOutOfBoundsException.class, () ->  out.set(2,"testAddNew"));
    }

    @Test
    void removeIndexTest() {
        String expected = "testAdd";
        out.add("testAdd");
        assertEquals(expected, out.remove(0));
        assertNull(out.get(0));
        assertThrows( IndexOutOfBoundsException.class, () ->  out.set(2,"testAddNew"));
    }

    @Test
    void removeStringTest() {
        String expected = "testAdd";
        out.add("testAdd");
        assertEquals(expected, out.remove("testAdd"));
        assertThrows(IllegalArgumentException.class, () -> out.remove("testAdd456456"));
    }

    @Test
    void contains() {
        String expected = "testAdd";
        out.add("testAdd");
        assertTrue(out.contains("testAdd"));
        assertFalse(out.contains("testAdd2"));
    }

    @Test
    void indexOf() {
        String expected = "testAdd";
        out.add("testAdd");
        assertEquals(0, out.indexOf("testAdd"));
        assertEquals(-1, out.indexOf("testAdd2"));
    }

    @Test
    void lastIndexOf() {
        String expected = "testAdd";
        out.add("testAdd");
        out.add("testAdd");
        out.add("testAdd");
        assertEquals(2, out.lastIndexOf("testAdd"));
        assertEquals(-1, out.lastIndexOf("testAdd2"));
    }

    @Test
    void get() {
        String expected = "testAdd";
        out.add("testAdd");
        assertEquals(expected, out.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> out.get(5));
    }

    @Test
    void testEquals() {
        String[] otherList = {"testAdd"};
        out.add("testAdd");
        assertTrue(out.equals(otherList));
        out.add("testAdd");
        assertFalse(out.equals(otherList));
    }

    @Test
    void size() {
        out.add("testAdd");
        assertEquals(1, out.size());
    }

    @Test
    void isEmpty() {
        assertTrue(out.isEmpty());
        out.add("testAdd");
        assertFalse(out.isEmpty());
    }

    @Test
    void clear() {
        out.add("testAdd");
        out.add("testAdd");
        out.add("testAdd");
        out.clear();
        assertTrue(out.isEmpty());
    }

    @Test
    void toArray() {
        String[] expected = {"testAdd", "testAdd", "testAdd"};

        out.add("testAdd");
        out.add("testAdd");
        out.add("testAdd");

        assertArrayEquals(expected, out.toArray());
    }
}