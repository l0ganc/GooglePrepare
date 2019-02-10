package MostFrequentlyQuestions;

import java.util.HashMap;

/**
 *
 * LRUCache cache = new LRUCache( 2 capacity  );
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LC146LRUCache {
    static class Node {
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMap<Integer, Node> map;
    public Node head;  // point to the oldest node
    public Node tail;  // point to the latest node
    public int capicity;

    public LC146LRUCache(int capicity) {
        map = new HashMap<>();
        head = null;
        tail = null;
        this.capicity = capicity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        if (node != tail) {
            if (node == head) {
                head = head.next;
            } else {
                /**
                 *    假设tail指向A，head指向C，这里的情况就是node B 在中间（null <- A <-> B <-> C）
                 *    下面的操作就是改变指向为  A <-> C
                 */
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (capicity == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capicity++;
            }
            if (head == null && tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capicity--;

        }
    }

}
