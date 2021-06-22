
/**
 * Double Linked List Implementation
 *
 * @author Lakindu Oshadha (lakinduoshadha98@gmail.com)
 */

public class DoublyLinkedList{
    private Node head;
    private Node tail;
    public int length;

    /**
     * Node
     */
    private class Node {
        // Implementing local variables
        private int data;
        private Node next;
        private Node previous;

        /**
         * Constructs node
         *
         * @param data Value which should be entered
         */
        public Node(int data){
            this.data = data;
        }
    }

    /**
     * Constructor of DoublyLinkedList
     *
     */
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Checks the list is emty or not
     *
     * @return True or false
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Inserts an Item at the beginning.
     *
     * @param data The value that should be inserted
     */
    public void insertFirst(int data) {
        Node newNode = new Node(data); //implementing temp Node
        // Setting the value to the first node
        if(isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;    // Pointing the head to the 1st node
        length++;   // Increasing the length of the list after insertion
    }

    /**
     * Inserts an Item at the beginning.
     *
     * @param data The value that should be inserted
     */
    public void insertLast(int data) {
        Node newNode = new Node(data); // Implementing temp Node
        // Setting the value to the last node.
        if(isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;    // Pointing the tail to the last node
        length++;   // Increasing the length of the list after insertion
    }

    /**
     * Removes the fist item.
     *
     */
    public void removeFirst() {
        // Prints error message if the list is empty
        if(isEmpty()) {
            System.out.println("ERROR! List is Empty!");
        }
        // Removing the head and pointing the head to the next node.
        if(tail == head) {
            head = null;
        } else {
            head.next.previous = null;  // Setting current head to null
            head = head.next;   // Pointing the head to the next node
            length--; // Decreasing the length of the list by 1
        }
    }

    /**
     * Removes last item
     *
     */
    public void removeLast() {
        // Prints error message if the list is empty
        if(isEmpty()) {
            System.out.println("ERROR! List is Empty!");
        }
        // Removing the tail and pointing the tail to the previous node.
        if(tail == head) {
            head = null;
        } else {
            tail.previous.next = null;  // Setting current tail to null
            tail = tail.previous;   // Pointing the tail to the previous node
            length--; // Decreasing the length of the list by 1
        }
    }

    /**
     * Inserts a value before a given node
     *
     * @param nodeIndex Index of the node
     * @param data Value that should be inserted
     */
    public void insertBefore(int nodeIndex, int data){
        // Printing an error message when nodIndex is a wrong value.
        if(0 >= nodeIndex || nodeIndex > this.length){
            System.out.println("ERROR : Entered node index is wrong !");
            return;
        }

        Node newNode = new Node(data);
        // Inserting the value before a given node
        if(nodeIndex == 1) {
            insertFirst(data);
        } else {
            Node temp1 = head;
            // Finding the node
            for(int i = 1; i != nodeIndex; i++){
                temp1 = temp1.next;
            }
            // Pointing the relevant nodes each other.
            Node temp2 = temp1.previous;
            temp2.next = newNode;
            newNode.previous = temp2;
            newNode.next = temp1;
            temp1.previous = newNode;
        }
    }

    /**
     * Inserts a value after a given node
     *
     * @param nodeIndex Index of the node
     * @param data Value that should be inserted
     */
    public void insertAfter(int nodeIndex, int data){
        // Printing an error message when nodIndex is a wrong value.
        if(0 >= nodeIndex || nodeIndex > this.length){
            System.out.println("ERROR : Entered node index is wrong !");
            return;
        }
        Node newNode = new Node(data);
        // Inserting the value before a given node
        if(nodeIndex == 1) {
            insertFirst(data);
        } else {
            Node temp1 = head;
            // Finding the node
            for(int i = 1; i != nodeIndex + 1; i++){
                temp1 = temp1.next;
            }
            // Pointing the relevant nodes each other.
            Node temp2 = temp1.previous;
            temp2.next = newNode;
            newNode.previous = temp2;
            newNode.next = temp1;
            temp1.previous = newNode;
        }
    }

    /**
     * Removes a given node
     *
     * @param nodeIndex nodeIndex which should be removed
     */
    public void removeNode(int nodeIndex){
        // Printing an error message when nodIndex is a wrong value.
        if(0 >= nodeIndex || nodeIndex > this.length){
            System.out.println("ERROR : Entered node index is wrong !");
            return;
        }
        // Removing the given index
        if(nodeIndex == 1) {
            removeFirst();
        } else {
            Node temp1 = head;
            // Finding the node
            for(int i = 1; i != nodeIndex; i++){
                temp1 = temp1.next;
            }
            // Pointing the relevant nodes each other.
            Node temp2 = temp1.next;
            Node temp3 = temp1.previous;
            temp3.next = temp2;
            temp2.previous = temp3;
        }
    }

    /**
     * Finds a given value in the list
     *
     * @param x Value which shouold be found
     */
    public void findValue(int x) {
        // Implementing temp object &local variables
        Node temp = head;
        int i = 1;
        boolean isAvailable = false;
        // Finding the index of the particular value
        while(temp != null) {
            if(temp.data == x){
                isAvailable = true;
                break;
            }
            temp = temp.next;
            i++;
        }
        // Prints the nodeIndex if the value is available
        if(isAvailable){
            System.out.println("Your value is at node : " + i );
        } else {
            System.out.println("ERROR : No such value found in the list");
        }
    }

    /**
     * Prints the list in forward
     */
    public void printForward() {
        // Exit from the method if there is no elements
        if(head == null) {
            return;
        }
        Node temp = head;
        //Printing the values
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Prints the list in reverse order
     */
    public void printRevers() {
        // Exit from the method if there is no elements
        if(tail == null) {
            return;
        }
        Node temp = tail;
        //Printing the values
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.previous;
        }
        System.out.println();
    }

    /**
     * main method
     *
     * @param args
     */
    public static void main(String [] args) {

        // DEMONSTRATING THE IMPLEMENTED METHODS

        System.out.println("\nDEMONSTRATING THE IMPLEMENTED METHODS\n");

        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertLast(10);
        myList.insertLast(12);
        myList.insertLast(35);
        myList.insertLast(41);
        myList.insertLast(15);

        System.out.print("Initial list : ");
        myList.printForward();
        System.out.println();

        System.out.print("After Inserting 56 at the beginning : ");
        myList.insertFirst(56);
        myList.printForward();

        System.out.print("After Inserting 85 at the end : ");
        myList.insertLast(85);
        myList.printForward();

        System.out.print("After removing the first item : ");
        myList.removeFirst();
        myList.printForward();

        System.out.print("After removing the last item : ");
        myList.removeLast();
        myList.printForward();

        System.out.print("After Inserting 75 before node 3 : ");
        myList.insertBefore(3,75);
        myList.printForward();

        System.out.print("After Inserting 65 after node 4 : ");
        myList.insertAfter(4,65);
        myList.printForward();

        System.out.print("After removing node 3 : ");
        myList.removeNode(3);
        myList.printForward();

        System.out.println("Searching 41 : ");
        myList.findValue(41);

        System.out.println("Printing the values in reverse order");
        myList.printRevers();
    }
}
