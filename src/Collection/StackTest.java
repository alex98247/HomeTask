package Collection;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void PushTest(){
        Stack<Integer> stack = new Stack<>();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        Integer element = stack.Peek();
        Assert.assertEquals(3, element*1);
    }

    @Test
    public void PopTest(){
        Stack<Integer> stack = new Stack<>();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        Integer element1 = stack.Pop();
        Integer element2 = stack.Pop();
        Assert.assertEquals(3, element1*1);
        Assert.assertEquals(2, element2*1);
    }

    @Test
    public void PeekTest(){
        Stack<Integer> stack = new Stack<>();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        Integer element1 = stack.Peek();
        Integer element2 = stack.Peek();
        Assert.assertEquals(3, element1*1);
        Assert.assertEquals(3, element2*1);
    }

    @Test
    public void isEmptyTest(){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        stack.Push(1);
        Assert.assertEquals(stack.IsEmpty(), false);
        Assert.assertEquals(stack1.IsEmpty(), true);
    }
}
