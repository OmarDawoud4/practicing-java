package LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Node head ;
    private Node tail ;
    private Map<Integer , Node > hashCash ;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new  Node(0,0);
        head.nxt = tail;
        tail.prv = head;
        this.hashCash = new HashMap<Integer, Node >();

    }
    private void setMRU (Node node ){
        node.prv=head ;
        node.nxt = head.nxt ;
        head.nxt.prv = node ;
        head.nxt =  node ;
    }
    private void removeNode (Node node ){
        //regular one
        node.prv.nxt = node.nxt ;
        node.nxt.prv = node.prv ;

    }
    private void moveToHead (Node node ){
        //first after head
        removeNode (node);
        setMRU(node);
    }
    private Node removeLRU (){
        //first before tail
        Node lru = tail.prv ;
        removeNode(lru);
        return lru ;
    }

    // Core Operations
    public int get (int key){
        Node node = hashCash.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }
    public void put (int key , int value){

        if (hashCash.containsKey(key)) {
            Node node = hashCash.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            if (hashCash.size() >= capacity) {
                Node lru = removeLRU();
                // the key still exist int the hashCash though !

                hashCash.remove(lru.key);
            }
            hashCash.put(key, newNode);
            setMRU(newNode);

        }

    }
}
