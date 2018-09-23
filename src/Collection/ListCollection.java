package Collection;

import java.util.*;

public class ListCollection<T> implements List<T>, RandomAccess, Cloneable, java.io.Serializable {

    private int Capacity = 10;
    private Object[] ArrayValue;
    private int Size = 0;

    public ListCollection(int initialCapacity) {

        if (initialCapacity > 0) {
            ArrayValue = CreateArray(initialCapacity);
        } else if (initialCapacity == 0) {
            ArrayValue = CreateArray(this.Capacity);
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public ListCollection() {
        ArrayValue = CreateArray(this.Capacity);
    }

    private void CheckRange(int index, boolean canExpand) {
        if (Size == Capacity && canExpand) {
            Capacity+=10;
            Object[] newArray = CreateArray(Capacity);
            System.arraycopy(ArrayValue, 0, newArray, 0, size());
            ArrayValue = newArray;
            return;
        }
        if (index > Size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Object[] CreateArray(int initialCapacity) {
        return new Object[initialCapacity];
    }

    @Override
    public int size() {
        return Size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        CheckRange(Size, true);
        ArrayValue[Size] = t;
        Size++;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        CheckRange(index, false);
        return (T) ArrayValue[index];
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
        CheckRange(index, true);
        System.arraycopy(ArrayValue, index, ArrayValue, index + 1,
                size() - index);
        ArrayValue[index] = element;
        Size++;
    }

    @Override
    public T remove(int index) {
        CheckRange(index, false);
        T oldValue = (T) ArrayValue[index];
        int numMoved = size() - index - 1;
        if (numMoved > 0)
            System.arraycopy(ArrayValue, index + 1, ArrayValue, index,
                    numMoved);
        Size--;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++)
                if (ArrayValue[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size(); i++)
                if (o.equals(ArrayValue[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
