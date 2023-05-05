public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtFirst(12);
        cll.insertAtFirst(13);
        cll.insertAtFirst(14);
        cll.insertAtFirst(15);
        cll.insertAtTail(16);
        cll.printList();
        cll.deletAtFirst();
        cll.deletAtTail();
        cll.printList();
    }
}