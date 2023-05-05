class Node{
    public int data;
    public Node next;
    public Node prev;
    Node(){

    }
    Node(int data){
        this.data = data;
    }
}
public class CircularLinkedList {

    private Node header;

    CircularLinkedList(){
        this.header = new Node();
        this.header.data = 0;
        this.header.next = this.header;
        this.header.prev = this.header;
    }

    public boolean isEmpty(){
        return this.header.data == 0;
    }

    public void insertAtFirst(int data){
        Node newNode = new Node(data);
        if(this.isEmpty()){
            this.header.next = newNode;
            newNode.next = this.header;
            newNode.prev = this.header;
            this.header.prev = newNode;
            this.header.data++;
        }else{
            newNode.next = this.header.next;
            (this.header.next).prev = newNode;
            newNode.prev = this.header;
            this.header.next = newNode;
            this.header.data++;
        }
    }
    public void insertAtTail(int data){
        Node newNode = new Node(data);
        if(this.isEmpty()){
            this.header.next = newNode;
            newNode.next = this.header;
            newNode.prev = this.header;
            this.header.prev = newNode;
            this.header.data++;
        }else{
            newNode.prev = this.header.prev;
            (this.header.prev).next = newNode;
            newNode.next = this.header;
            this.header.prev = newNode;
            this.header.data++;
        }
    }
    public int deletAtFirst(){
        int returnValue = -1;
        if(!this.isEmpty()){
            Node deletNode = this.header.next;
            this.header.next = deletNode.next;
            (deletNode.next).prev = this.header;
            returnValue = deletNode.data;
            this.header.data--;
        }else{
            System.err.println("list is empty");
        }
        return returnValue;
    }
    public int deletAtTail(){
        int returnValue = -1;
        if(!this.isEmpty()){
            Node deletNode = this.header.prev;
            this.header.prev = deletNode.prev;
            (deletNode.prev).next = this.header;
            returnValue = deletNode.data;
            this.header.data--;
        }else{
            System.err.println("list is empty");
        }
        return returnValue;
    }
    public void printList(){
        if(!this.isEmpty()){
            Node currentNode = this.header.next;
            System.out.println("[");
            while(currentNode != this.header){
                System.out.println(currentNode.data+",");
                currentNode = currentNode.next;
            }
            System.out.println("]");
        }else{
            System.err.println("list is empty");
        }
    }
}
