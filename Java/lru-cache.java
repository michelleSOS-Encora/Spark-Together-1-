import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0); // Nodo cabeza (dummy)
        this.tail = new Node(0, 0); // Nodo cola (dummy)
        head.next = tail; // Inicializa la lista doblemente enlazada
        tail.prev = head;
    }

    private void remove(Node node) {
        // Remueve un nodo de la lista doblemente enlazada
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addToFront(Node node) {
        // Añade un nodo al frente de la lista, justo después de la cabeza
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // Mueve el nodo accedido al frente de la lista
            remove(node);
            addToFront(node);
            return node.value;
        }
        return -1; // Si no está presente, retorna -1
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Si la clave existe, actualiza el valor y lo mueve al frente
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addToFront(node);
        } else {
            // Si la clave no existe, crea un nuevo nodo
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToFront(newNode);

            if (cache.size() > capacity) {
                // Si excede la capacidad, elimina el nodo menos usado (último en la lista)
                Node lruNode = tail.prev;
                remove(lruNode);
                cache.remove(lruNode.key);
            }
        }
    }
}
