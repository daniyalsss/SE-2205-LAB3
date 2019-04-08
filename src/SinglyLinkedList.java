public class SinglyLinkedList<E> {

    // Declare head and tail
    private Node<E> head;
    private Node<E> tail;

    // Size of linkedList
    private int size;

    // Init empty LinkedList
    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    // Node class
    private static class Node<E> {

        // Value of node and next node
        private E element;
        private Node<E> next;

        // Create new node of value e and next node n
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        // Getter for node element
        public E getElement() {

            return element;
        }

        // Getter for next node
        public Node<E> getNext() {

            return next;
        }

        // Setter for element
        public void setElement(E e) {
            element = e;
        }

        // Setter for next node
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    // Get size
    public int size() {

        return size;
    }

    // Check if linkedList is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Getter for head (return null if empty)
    public E getHead() {
        if (isEmpty())
            return null;

        return head.getElement();
    }

    // Getter for tail (return null if empty)
    public E getTail() {
        if (isEmpty())
            return null;

        return tail.getElement();
    }

    // Add element to front of list
    public void addFront(E element) {

        head = new Node<>(element, head);
        if (isEmpty())
            tail = head;
        size++;
    }

    // Add element to back of list
    public void addBack(E element) {
        Node<E> temp = new Node<>(element, null);

        if (isEmpty())
            head = temp;
        else
            tail.setNext(temp);

        tail = temp;
        size++;
    }

    // remove element from front of list, return that element
    public E removeFront() {
        if (isEmpty())
            return null;

        E tempHead = head.getElement();
        head = head.getNext();
        size--;

        if (size == 0)
            tail = null;

        return tempHead;
    }

}