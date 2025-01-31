import java.util.LinkedList;

class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap<K, V> {
    // Attributes 
    private static final int SIZE = 16; 
    private LinkedList<Pair<K, V>>[] buckets;

    // Constructor 
    public CustomHashMap() {
        this.buckets = new LinkedList[SIZE]; 
        for (int i = 0; i < 16; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Method to calculate hash 
    private int getHash(K key) {
        int hash = Math.abs(key.hashCode() % SIZE);
        return hash;
    }

    // Method to add data 
    public void put(K key, V value) {
        int hash = getHash(key);
        LinkedList<Pair<K, V>> bucket = buckets[hash];
        for (Pair<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Pair<>(key, value));
    }

    // Method to retrieve data
    public V get(K key) {
        int hash = getHash(key);
        LinkedList<Pair<K, V>> bucket = buckets[hash];
        for (Pair<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    // Method to delete data 
    public void remove(K key) {
        int hash = getHash(key);
        LinkedList<Pair<K, V>> bucket = buckets[hash];
        bucket.removeIf(entry -> entry.key.equals(key));
    } 

    // Main function for testing 
    public static void main(String[] args){
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        
        System.out.println(map.get("two")); // Output: 2
        map.remove("two");
        System.out.println(map.get("two")); // Output: null
    }
}
