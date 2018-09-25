package Collection;

import org.junit.Assert;
import org.junit.Test;


public class ListCollectionTest {
    ListCollection<Integer> list;

    @Test
    public void addTest() {
        list = new ListCollection<Integer>();

        list.add(11);
        for (int i = 10; i > 0; i--) {
            list.add(i);
        }

        Assert.assertEquals(list.size(), 11);
    }

    @Test
    public void removeTest() {
        list = new ListCollection<Integer>();

        list.add(11);
        for (int i = 10; i > 0; i--) {
            list.add(i);
        }

        list.add(11);

        list.remove(11);

        Assert.assertEquals(1, list.get(list.size() - 1) * 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeExceptionTest() {
        list = new ListCollection<Integer>();

        list.add(11);
        for (int i = 10; i > 0; i--) {
            list.add(i);
        }

        list.remove(100);
    }

    @Test
    public void containsTest() {
        list = new ListCollection<Integer>();

        list.add(11);
        for (int i = 999; i > 0; i--) {
            list.add(i);
        }
        Assert.assertEquals(list.contains(5), true);
        Assert.assertEquals(list.contains(9999), false);
    }

    @Test
    public void isEmptyTest() {
        list = new ListCollection<Integer>();
        ListCollection<Integer> list2 = new ListCollection<Integer>();
        ListCollection<Integer> list1 = new ListCollection<Integer>(20);

        list.add(11);
        for (int i = 20; i > 0; i--) {
            list.add(i);
        }

        list2.add(1);
        list2.remove(0);

        Assert.assertEquals(list.isEmpty(), false);
        Assert.assertEquals(list1.isEmpty(), true);
        Assert.assertEquals(list2.isEmpty(), true);
    }

    @Test
    public void getTest() {
        list = new ListCollection<Integer>();

        list.add(11);
        for (int i = 10; i > 0; i--) {
            list.add(i);
        }
        Assert.assertEquals(list.get(5) * 1, 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceptionTest() {
        list = new ListCollection<Integer>();

        list.add(11);
        for (int i = 80; i > 0; i--) {
            list.add(i);
        }
        list.get(100);
    }
}
