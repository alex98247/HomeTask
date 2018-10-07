package Hash;

public class HashMap<K, V> extends HashTable<K, V> {

    @Override
    public void put(K key, V value) {
        if (containsKey(key)) {
            remove(key, get(key));
        }
        super.put(key, value);
    }
}
