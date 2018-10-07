package Hash;

import org.junit.Assert;
import org.junit.Test;

public class HashMapTest {
    @Test
    public void addTest() {
        HashMap<Integer, Integer> hashTable = new HashMap();
        hashTable.put(20, 20);

        Assert.assertEquals(true, hashTable.hasValue(20, 20));
    }

    @Test
    public void removeTest() {
        HashMap<Integer, Integer> hashTable = new HashMap();
        hashTable.put(20, 20);
        hashTable.remove(20, 20);
        Assert.assertEquals(false, hashTable.hasValue(20, 20));
    }

    @Test
    public void hasValueTest() {
        HashMap<Integer, Integer> hashTable = new HashMap();
        hashTable.put(20, 20);
        boolean result = hashTable.hasValue(20, 20);

        Assert.assertEquals(true, result);
    }

    @Test
    public void addPluralTest() {
        HashMap<String, Integer> hashTable = new HashMap();
        hashTable.put("20", 20);
        hashTable.put("20", 30);
        boolean result = hashTable.hasValue("20", 20);
        boolean result1 = hashTable.hasValue("20", 30);

        Assert.assertEquals(false, result);
        Assert.assertEquals(true, result1);

    }

    @Test
    public void getTest() {
        HashMap<String, Integer> hashTable = new HashMap();
        hashTable.put("20", 20);
        hashTable.put("20", 30);

        Assert.assertEquals(null, hashTable.get("20", 20));
        Assert.assertEquals(30, hashTable.get("20", 30)*1);

    }

    @Test
    public void containsKeyTest() {
        HashMap<String, Integer> hashTable = new HashMap();
        hashTable.put("20", 20);

        Assert.assertEquals(true, hashTable.containsKey("20"));
        Assert.assertEquals(false, hashTable.containsKey("30"));

    }

    @Test
    public void isEmpty() {
        HashMap<String, Integer> hashMap = new HashMap();
        HashMap<String, Integer> hashMap1 = new HashMap();
        hashMap.put("20", 20);

        Assert.assertEquals(false, hashMap.isEmpty());
        Assert.assertEquals(true, hashMap1.isEmpty());

    }

}
