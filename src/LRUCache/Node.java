package LRUCache;

public class Node {
    int key ;
    int value;
    Node prv ;
    Node nxt ;
    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
        this.prv = null;
        this.nxt = null;
    }

}
