package LRUCache;

public class test {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 10);
        lruCache.put(2, 20);

        System.out.println(lruCache.get(1)); // 10
        System.out.println(lruCache.get(2)); // 20
        // now 2 is lastly touched LMU what
        lruCache.put(3, 30);
        System.out.println(lruCache.get(3)); // 30
        System.out.println(lruCache.get(1)); // -1 it is LRU so removed


        lruCache.put(4, 40);
        System.out.println(lruCache.get(3)); // -1

    }
}
