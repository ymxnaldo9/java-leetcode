package other._0146;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private doublelist cache;
    private int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new doublelist();
    }
    private void makerecently(int x){
        Node node = map.get(x);
        cache.remove(node);
        cache.addlast(node);
    }
    private void addrecently(int key, int val){
        Node x = new Node(key, val);
        cache.addlast(x);
        map.put(key, x);
    }
    private void deletekey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(x);
    }
    private void removelessrecently(){
        Node deletednode = cache.removefirst();
        int deletedkey = deletednode.key;
        map.remove(deletedkey);
    }
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        makerecently(key);
        return map.get(key).val;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)){
            deletekey(key);
            addrecently(key, value);
            return;
        }
        if (cap == cache.size())
            removelessrecently();
        addrecently(key, value);
    }
}
class doublelist{
    private Node head;
    private Node tail;
    private int size;
    public doublelist(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    public void addlast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }
    public Node removefirst(){
        if (head.next == null)
            return null;
        Node first = head.next;
        remove(first);
        return first;
    }
    public int size(){
        return size;
    }
}
class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
