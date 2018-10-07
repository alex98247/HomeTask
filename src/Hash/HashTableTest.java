package Hash;

import org.junit.Assert;
import org.junit.Test;

public class HashTableTest {

    @Test
    public void addTest() {
        HashTable<Integer, Integer> hashTable = new HashTable();
        hashTable.put(20, 20);

        Assert.assertEquals(true, hashTable.hasValue(20, 20));
    }

    @Test
    public void removeTest() {
        HashTable<Integer, Integer> hashTable = new HashTable();
        hashTable.put(20, 20);
        hashTable.remove(20, 20);
        Assert.assertEquals(false, hashTable.hasValue(20, 20));
    }

    @Test
    public void hasValueTest() {
        HashTable<Integer, Integer> hashTable = new HashTable();
        hashTable.put(20, 20);
        boolean result = hashTable.hasValue(20, 20);

        Assert.assertEquals(true, result);
    }
}
