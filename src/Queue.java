
public interface Queue<E> {
    // Size of queue
    int size();

    // Determine if queue is empty
    boolean isEmpty();

    // First element in queue
    E first();

    // Add to queue
    void enqueue(E node);

    // Remove from queue, return element that was removed
    E dequeue();
}

