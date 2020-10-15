import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LRUCacheDemo {

    public static void main(String[] args) {
        LRUCache<Integer,String> lruCache = new LRUCache<>(3);
        lruCache.put(1,"ONE");
        lruCache.put(2,"TWO");
        lruCache.put(3,"THREE");
        lruCache.display();
    }

}




class LRUCache<K,V> {
    HashMap<K,Node> store = new HashMap<>();
    Node head,tail;
    int capacity = 0, currentSize = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(K key,V value){
        Node node = null;
        if(store.containsKey(key)){
            node = store.get(key);
            node.value = value;
        } else {
            node = new Node();
            node.key = key;
            node.value = value;
        }
        if(head == null){
            head = node;
            return;
        }
        removeNode(node);
        makeHeadNode(node);
        if(tail == null){
            tail = node;
        }


    }

    private void makeHeadNode(Node node) {
        if(head == null){
            head = node;
            return;
        }
        node.after = head;
        head = node;
    }

    private void removeNode(Node node) {
        if(currentSize == capacity){
            store.remove(tail.key);
            tail.prev.after = null;
        }
        if(node.after == null){
            tail = node.prev;
            tail.after = null;
            return;
        }
        Node prev = node.prev;
        Node after = node.after;
        prev.after = after;
        after.prev = prev;
    }


    public void display() {
        Set<Map.Entry<K, Node>> entries = store.entrySet();
        for (Map.Entry<K, Node> entry : entries) {
            System.out.print("key: "+ entry.getKey());
            System.out.println(", Value: "+ entry.getValue().value);
        }
    }
}


class Node<K,V>{
    K key;
    V value;
    Node prev, after;
}
