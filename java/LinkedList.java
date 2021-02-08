package abstractdatatypes;
import java.util.Random;

public class LinkedList {
    class Node { // Node object
        Node pointer;
        int value;

        Node(int value) {
            this.value = value;
        }

        public Node getNode(int pos) {
            return (pos < 2) ? this : (this.pointer == null) ? null : this.pointer.getNode(pos - 1);
        }

        public String print() {
            if (this.pointer == null) {
                return String.format("%d -> NULL\n", this.value);
            }
            return String.format("%d -> %s", this.value, this.pointer.print());
        }
    }
    // Primary node
    private Node node;
    private int size = 0;

    // Appends node to end of the list
    public void append(int value) {
        Node newNode = new Node(value);
        if (this.node == null) {
            this.node = newNode;
        } else {
            this.node.getNode(this.size).pointer = newNode;
        }
        this.size++;
    }

    // Returns the index of the node with the specified value
    public int find(int value) {
        for (int i = 0; i < this.size - 1; i++) {
            if (this.node.getNode(i).pointer.value == value) {
                return i;
            }
        }
        return -1;
    }

    // Returns the length of the list
    public int length() {
        return this.size;
    }

    // Print nodes
    public void print() {
        if (this.node == null) {
            System.out.println("NULL");
        } else {
            System.out.println(this.node.print());
        }
    }

    // Removes the first node by reassigning the primary pointer
    public int remove(int pos) {
        if (this.node == null) {
            return -1;
        }
        if (this.node.pointer == null) {
            this.node = null;
            return -1;
        }
        else {
            this.node = this.node.pointer;
            this.size--;
            return this.node.value;
        }
    }

    // Main //
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            ll.append(rand.nextInt(10));
            System.out.printf("Length: %d\n", ll.length());
            ll.print();
        }
        for (int i = 0; i < 3; i++) {
            int value = rand.nextInt(10);
            System.out.printf("%d is at index %d\n",value ,ll.find(value));
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            ll.remove(rand.nextInt(ll.length()));
            System.out.printf("Length: %d\n", ll.length());
            ll.print();
        }
    }
}
