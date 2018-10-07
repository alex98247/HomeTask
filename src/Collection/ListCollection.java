package Collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class ListCollection<T> implements List<T> {

    private int capacity = 10;
    private Object[] arrayValue;
    private int size = 0;

    public ListCollection(int initialCapacity) {

        if (initialCapacity > 0) {
            arrayValue = createArray(initialCapacity);
        } else {
            throw new IllegalArgumentException("Illegal capacity: " +
                    initialCapacity);
        }
    }

    public ListCollection() {
        arrayValue = createArray(this.capacity);
    }

    private void checkRange(int index, boolean canExpand) {
        if (size == capacity && canExpand) {
            capacity += 10;
            Object[] newArray = createArray(capacity);
            System.arraycopy(arrayValue, 0, newArray, 0, size());
            arrayValue = newArray;
            return;
        }
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of range: " + index);
        }
    }

    private Object[] createArray(int initialCapacity) {
        return new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(T t) {
        checkRange(size, true);
        arrayValue[size] = t;
        size++;
        return false;
    }

    @Override
    public T get(int index) {
        checkRange(index, false);
        return (T) arrayValue[index];
    }

    @Override
    public T set(int index, T element) {
        throw new NotImplementedException();
    }

    @Override
    public void add(int index, T element) {
        checkRange(index, true);
        System.arraycopy(arrayValue, index, arrayValue, index + 1,
                size() - index);
        arrayValue[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        checkRange(index, false);
        T oldValue = (T) arrayValue[index];
        int numMoved = size() - index - 1;
        if (numMoved > 0)
            System.arraycopy(arrayValue, index + 1, arrayValue, index,
                    numMoved);
        size--;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++)
                if (arrayValue[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size(); i++)
                if (o.equals(arrayValue[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new NotImplementedException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new NotImplementedException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new NotImplementedException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new NotImplementedException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new NotImplementedException();
    }

    @Override
    public Object[] toArray() {
        throw new NotImplementedException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new NotImplementedException();
    }

    @Override
    public boolean remove(Object o) {

        throw new NotImplementedException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    @Override
    public void clear() {
        throw new NotImplementedException();
    }
}
