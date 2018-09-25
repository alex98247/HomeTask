package Collection;

import java.util.EmptyStackException;

public class Stack<T> {

    private ListCollection<T> list;

    public Stack() {
        list = new ListCollection<T>();
    }

    public void push(T element) {
        list.add(element);
    }

    public T pop() {
        if (list.isEmpty()) throw new EmptyStackException();
        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return element;
    }

    public T peek() {
        if (list.isEmpty()) throw new EmptyStackException();
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
