package Collection;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void pushTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Integer element = stack.peek();
        Assert.assertEquals(3, element * 1);
    }

    @Test
    public void popTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Integer element1 = stack.pop();
        Integer element2 = stack.pop();
        Assert.assertEquals(3, element1 * 1);
        Assert.assertEquals(2, element2 * 1);
    }

    @Test
    public void peekTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Integer element1 = stack.peek();
        Integer element2 = stack.peek();
        Assert.assertEquals(3, element1 * 1);
        Assert.assertEquals(3, element2 * 1);
    }

    @Test
    public void isEmptyTest() {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        stack.push(1);
        Assert.assertEquals(stack.isEmpty(), false);
        Assert.assertEquals(stack1.isEmpty(), true);
    }
}
