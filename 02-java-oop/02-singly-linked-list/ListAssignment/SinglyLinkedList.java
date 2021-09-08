public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void remove() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        else{
            if(head != tail){
                Node current = head;
                while(current.next != tail){
                    current = current.next;
                }
                tail = current;
                tail.next = null;
            }
            else{
                head = tail = null;
            }
        }
    }
    public void printValues(){
        Node thisnode = head;
        while(thisnode != null){
            System.out.print(thisnode.value + " ");
            thisnode = thisnode.next;
        }
        System.out.println();
    }
}
