package Hash;

import java.util.LinkedList;

public class HashTable<K, V> {
    private int initialCapacity = 10_000;
    private LinkedList<V>[] hashTable = new LinkedList[initialCapacity];

    public void put(K key, V value) {
        if (hashTable[getIndex(key)] == null) {
            hashTable[getIndex(key)] = new LinkedList<>();
        }
        hashTable[getIndex(key)].add(value);

    }

    public void remove(K key, V value) {

        hashTable[getIndex(key)].remove(value);
    }

    public boolean hasValue(K key, V value) {
        LinkedList<V> list = hashTable[getIndex(key)];

        if (list != null && list.contains(value)) {
            return true;
        }
        return false;
    }

    public V get(K key, V value) {
        if (hashTable[getIndex(key)] == null) {
            return null;
        }
        V first = hashTable[getIndex(key)].getFirst();
        if (!first.equals(value)) {
            return null;
        }
        return first;

    }

    public V get(K key){
        if (hashTable[getIndex(key)] == null) {
            return null;
        }
        V first = hashTable[getIndex(key)].getFirst();
        return first;
    }

    public boolean containsKey(K key) {
        if (hashTable[getIndex(key)] == null) {
            return false;
        }
        if (hashTable[getIndex(key)].size() == 0) {
            return false;
        }
        return true;
    }

    public boolean isEmpty() {
        for (LinkedList<V> l : hashTable) {
            if (l != null && l.size() != 0) {
                return false;
            }
        }
        return true;
    }

    protected int getIndex(K key) {
        return Math.abs(key.hashCode()) % initialCapacity;
    }
}
