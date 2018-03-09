/**
 * The implementation of linked list
 *
 * @param <T> the data type that linked list will store
 */
public class LinkedList<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    /**
     * Check whether the linked list is empty
     *
     * @return whether the linked list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Check the size of the linked list
     *
     * @return the size of the linked list
     */
    public int getSize() {
        return size;
    }

    /**
     * Add an item to head of the linked list
     *
     * @param data the data to add
     */
    public void addToHead(T data) {
        if (isEmpty()) {
            head = tail = new ListNode<>(data);
        } else {
            head = new ListNode<>(data, head);
        }
        size++;
    }

    /**
     * Add an item to tail of the linked list
     *
     * @param data the data to add
     */
    public void addToTail(T data) {
        if (isEmpty()) {
            head = tail = new ListNode<>(data);
        } else {
            tail.setNext(new ListNode<>(data));
            tail = tail.getNext();
        }
        size++;
    }


    /**
     * Remove the item from head of linked list
     *
     * @return the removed item
     * @throws ListEmptyException throw if the list is empty
     */
    public T removeFromHead() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        size--;
        T data;
        data = head.getData();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
        }
        return data;
    }


    /**
     * Remove the item from tail of linked list
     *
     * @return the removed item
     * @throws ListEmptyException throw if the list is empty
     */
    public T removeFromTail() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        size--;
        T data = tail.getData();

        if (head == tail) {
            head = tail = null;
            return data;
        }

        ListNode<T> current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        current.setNext(null);
        tail = current;
        return data;
    }

    /**
     * return all data in the linked list as string
     *
     * @return String of all item in linked list
     */
    @Override
    public String toString() {
        ListNode<T> current = head;
        StringBuilder stringBuilder = new StringBuilder("[ ");
        while (current != null) {
            stringBuilder.append(current).append(" ");
            current = current.getNext();
        }
        return stringBuilder.append("]").toString();
    }
}
