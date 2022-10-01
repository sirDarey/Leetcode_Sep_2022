package leetcodeSep2022;

/**
 *
 * @Sir Darey
 * 
 * LeetCode Daily Challenge: September 2022, Day 25
 * Problem 622: Design Circular Queue
 */

class Day25_622_DesignCircularQueue {

    Node  front, rear;
    int k, size;
    
    private static class Node  {
        int value;
        Node next;
        
        public Node (int value) {
            this.value = value;
        }
    }
    
    public Day25_622_DesignCircularQueue(int k) {
        this.k = k;
        size = 0;        
    }
    
    public boolean enQueue(int value) {
        if (size == k) {
             return false;
        }
        
        Node newNode = new Node(value);
        if (front == null) 
            front = newNode;
        else
            rear.next = newNode;
        rear = newNode;
        newNode.next = front;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (size == 0)
            return false;
        
        size--;
        if (front == rear) {
            front = null;
            rear = null;
            return true;
        }
        
        front = front.next;        
        rear.next = front;
        return true;
    }
    
    public int Front() {
        if (front != null)
            return front.value;
        else
            return -1;
    }
    
    public int Rear() {
        if (rear != null)
            return rear.value;
        else
            return -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}
