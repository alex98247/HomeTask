package Hash;

import org.junit.Assert;
import org.junit.Test;

public class HashTableTest {

    @Test
    public void addTest(){
        HashTable<Integer> hashTable = new HashTable();
        hashTable.add(20);
    }

    @Test
    public void removeTest(){
        HashTable<Integer> hashTable = new HashTable();
        hashTable.add(20);
        hashTable.remove(20);
        Assert.assertEquals(false, hashTable.hasValue(20));
    }
}
