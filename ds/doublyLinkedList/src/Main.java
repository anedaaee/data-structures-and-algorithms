public class Main {
    public static void main(String[] args) {
        doublyLinkedList dll = new doublyLinkedList();
        dll.push(12);
        dll.push(13);
        dll.push(14);
        dll.push(15);
        dll.push(16);
        dll.insertbetween(4,5,17);
        dll.insertbetween(14,15,17);
        dll.deletbetween(4,6);
        dll.deletbetween(12,14);
        System.out.println(dll.len());
        dll.printList();
    }
}