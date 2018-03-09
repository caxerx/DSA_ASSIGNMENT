/**
 * A queue implement with a linked list
 *
 * @param <T> The type that queue will store
 */
public class LinkedQueue<T> {
    private LinkedList<T> queueLinkedList;

    public LinkedQueue() {
        queueLinkedList = new LinkedList<>();
    }

    /**
     * Enqueue a value
     *
     * @param data value to enqueue
     */
    public void enqueue(T data) {
        queueLinkedList.addToTail(data);
    }

    /**
     * Dequeue a value
     *
     * @return the dequeue value
     */
    public T dequeue() throws QueueEmptyException {
        try {
            return queueLinkedList.removeFromHead();
        } catch (ListEmptyException e) {
            throw new QueueEmptyException();
        }
    }

    /**
     * Check whether the queue is empty
     *
     * @return queue is empty or not
     */
    public boolean isEmpty() {
        return queueLinkedList.isEmpty();
    }

    /**
     * Get the queue size
     *
     * @return how many item in queue
     */
    public int getSize() {
        return queueLinkedList.getSize();
    }

    /**
     * return all data in the linked queue as string
     *
     * @return String of all item in queue
     */
    @Override
    public String toString() {
        return queueLinkedList.toString();
    }

}
