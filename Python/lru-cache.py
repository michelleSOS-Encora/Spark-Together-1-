class Node:
    def __init__(self, key, value):
        self.key = key #key of cache
        self.value = value #value for each key
        self.prev = None #pointer to prev in the doubly linked list
        self.next = None #pointer to next in the doubly linked list
 
class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity #capacity of cache
        self.cache = {}  #dictionary for key-> node
        self.head = Node(0, 0)  #head of the doubly linked list
        self.tail = Node(0, 0)  #tail of the dll
        self.head.next = self.tail  #head and tail point to the same value 
        self.tail.prev = self.head
 #fuction to remove a noe 
    def _remove(self, node): 
        prev_node = node.prev
        next_node = node.next
        prev_node.next = next_node
        next_node.prev = prev_node
 #fucntion to add an elemetn to the list in the front
    def _add_to_front(self, node):
        next_node = self.head.next
        self.head.next = node
        node.prev = self.head
        node.next = next_node
        next_node.prev = node
 #function to get a value associated with the key if it exists in the cache
    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            # Move the accessed node to the front (most recently used)
            self._remove(node)
            self._add_to_front(node)
            return node.value
        return -1
 #inserts and updates 
    def put(self, key: int, value: int) -> None:
      #if the key is in the cache, updates the value to the first position on the list
        if key in self.cache:
          #gets the key and stores it in node to not lose its value
            node = self.cache[key]
            node.value = value
          #removes the node from the position it used to be in
            self._remove(node)
          #adds the node to the top
            self._add_to_front(node)
          #if ithe key is not in the cache, adds it
        else:
            new_node = Node(key, value)
            self.cache[key] = new_node
            self._add_to_front(new_node)
 #if the cache exceeds capacity, removes the last node in the list
            if len(self.cache) > self.capacity:
                lru_node = self.tail.prev
                self._remove(lru_node)
                del self.cache[lru_node.key]
