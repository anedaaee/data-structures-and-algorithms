public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtTail(12);
        linkedList.insertAtTail(15);
        linkedList.insertAtHead(16);
        linkedList.printList();
        System.out.println(linkedList.indexOf(15));
        System.out.println(linkedList.indexOf(19));
        System.out.println(linkedList.removeAtTail());
        System.out.println(linkedList.removeAtHead());
        linkedList.printList();
    }
}