package Collection;

import java.util.EmptyStackException;

public class Stack<T> {

    private ListCollection<T> list;

    public Stack() {
        list = new ListCollection<T>();
    }

    public void Push(T element) {
        list.add(element);
    }

    public T Pop() {
        if(list.isEmpty()) throw  new EmptyStackException();
        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return element;
    }

    public T Peek() {
        if(list.isEmpty()) throw  new EmptyStackException();
        return list.get(list.size() - 1);
    }

    public boolean IsEmpty() {
        return list.size() == 0;
    }
}
