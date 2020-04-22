import lru.LRUCache;

public class Main {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set("1","a");
        cache.set("2","b");
        cache.set("3","c");
        System.out.println(cache.toString());
        cache.set("4","d");
        System.out.println(cache.toString());
        cache.get("2");
        System.out.println(cache.toString());
    }
}
