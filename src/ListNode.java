/**
 * The list node that save the data in list
 *
 * @param <T> the data type that the node store
 */
public class ListNode<T> {
    private T data;
    private ListNode<T> next;

    /**
     * @param data data in nodes
     */
    public ListNode(T data) {
        this(data, null);
    }

    /**
     * The list node will initialize with the next node
     *
     * @param data data in nodes
     * @param next next node
     */
    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Get the data in the node
     *
     * @return data in the node
     */
    public T getData() {
        return data;
    }

    /**
     * Get the next node
     *
     * @return next node, null if no next node
     */
    public ListNode<T> getNext() {
        return next;
    }

    /**
     * Set the next node
     *
     * @param next the next node to set
     */
    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    /**
     * return the node data in the node as string
     *
     * @return The string of data in node
     */
    @Override
    public String toString() {
        return data.toString();
    }
}