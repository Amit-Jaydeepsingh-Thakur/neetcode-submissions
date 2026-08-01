class Node {
    int value;
    int key;
    Node next;
    Node prev;

    public Node (int key, int value) {
        this.key = key;
        this.value = value; 
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    int current;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        map = new HashMap<>();

        this.capacity = capacity;
        this.current = 0;

        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } 

        Node node = map.get(key);
        remove(node);
        add(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            add(node);
            return;
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(tail.prev);
            map.remove(lru.key);
        }

        Node node = new Node(key, value);
        add(node);
        map.put(key, node);
        
    }

    public void add(Node node) {
        Node next = head.next;

        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;

    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

    }
}
