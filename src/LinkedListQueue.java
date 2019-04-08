public class LinkedListQueue<E> implements Queue<E> {
    // Implements queue
    private SinglyLinkedList<E> q;

    // Init singlylinkedlist q when constructor is called
    public LinkedListQueue() {

        q = new SinglyLinkedList<>();
    }

    // Return size of queue
    public int size() {

        return q.size();
    }

    // Check if it's empty
    public boolean isEmpty() {

        return q.isEmpty();
    }

    // return getHead element
    public E first() {

        return q.getHead();
    }

    // Add to queue
    public void enqueue(E node) {

        q.addBack(node);
    }

    // Remove from queue, return element
    public E dequeue() {

        return q.removeFront();
    }
}
