package CashMachine;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class CashTerminalTest {
    @Test
    public void exchangeSuccessTest() {
        CashTerminal cashTerminal = new CashTerminal();
        List<List<Pair<Integer, Integer>>> list = new LinkedList<>();

        List<Pair<Integer, Integer>> list1 = new LinkedList<>();
        List<Pair<Integer, Integer>> list2 = new LinkedList<>();
        List<Pair<Integer, Integer>> list3 = new LinkedList<>();
        List<Pair<Integer, Integer>> list4 = new LinkedList<>();
        list1.add(new Pair<>(1, 4));

        list2.add(new Pair<>(2, 1));
        list2.add(new Pair<>(1, 2));

        list3.add(new Pair<>(3, 1));
        list3.add(new Pair<>(2, 0));
        list3.add(new Pair<>(1, 1));

        list4.add(new Pair<>(2, 2));
        list4.add(new Pair<>(1, 0));

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        List<List<Pair<Integer, Integer>>> exchange = cashTerminal.exchange(4, 0, new int[]{1, 2, 3});

        Assert.assertArrayEquals(exchange.toArray(), list.toArray());
    }

    @Test
    public void exchangeErrorTest() {
        CashTerminal cashTerminal = new CashTerminal();

        List<List<Pair<Integer, Integer>>> exchange = cashTerminal.exchange(4, 0, new int[]{5, 3});

        Assert.assertEquals(exchange, new LinkedList<>());
    }
}
