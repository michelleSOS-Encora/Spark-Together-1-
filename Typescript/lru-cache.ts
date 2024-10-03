class NodeT {
    public key : number;
    public value : number;
    // Avoid assign value on constructor
    public prev!: NodeT;
    public next!: NodeT;

    constructor(key:number, value:number){
        this.key = key;
        this.value = value;
    }
}


class LRUCache {
    private capacity :number;
    // Somehow Linter marks error, but is for the target compiler, using latest target as ES modules can work
    private cache : Map<number, NodeT>;
    private head: NodeT;
    private tail: NodeT;
    constructor(capacity: number) {
        this.capacity = capacity;
        this.cache = new Map();
        this.head = new NodeT(0, 0);
        this.tail = new NodeT(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private remove(node : NodeT){
        const prevNode: NodeT = node.prev;
        const nextNode: NodeT = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    private addToFront(node: NodeT){
        const nextNode : NodeT = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    get(key: number): number {
        if(this.cache.has(key)){
            const node: NodeT = this.cache.get(key)!;
            this.remove(node);
            this.addToFront(node);
            return node.value;
        }
        return -1;
    }

    put(key: number, value: number): void {
        if(this.cache.has(key)){
            const node: NodeT = this.cache.get(key)!;
            node.value = value;
            this.remove(node);
            this.addToFront(node);
        }
        else {
            const newNode = new NodeT(key, value);
            this.cache.set(key, newNode);
            this.addToFront(newNode);
        }

        if(this.cache.size > this.capacity){
            const lruNode = this.tail.prev;
            this.remove(lruNode);
            this.cache.delete(lruNode.key);
        }
    }
}