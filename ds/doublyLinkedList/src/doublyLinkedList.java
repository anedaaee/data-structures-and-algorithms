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
public class doublyLinkedList {
    private Node header;
    private Node trailer;
    private int size;
    doublyLinkedList(){
        this.header = new Node();
        this.trailer = new Node();
        this.header.next = this.trailer;
        this.trailer.prev = this.header;
    }
    public int len(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public void push(int date){
        Node newNode = new Node(date);
        if(this.isEmpty()){
            newNode.next = this.trailer;
            this.trailer.prev = newNode;
            this.header.next = newNode;
            newNode.prev = this.header;
            this.size++;
        }else{
            newNode.next = this.header.next;
            this.header.next.prev = newNode;
            this.header.next = newNode;
            newNode.prev = this.header;
            this.size++;
        }
    }
    public void insertbetween(int index1,int index2,int data){
        if (index2-index1 == 1 && index2 <= this.size - 1 ){
            int cntr = 0;
            Node current = this.header;
            Node first,sec;
            for(int i = 1 ; i < index1 ; i++){
                current = current.next;
            }
            first = current.next;
            sec = first.next;
            Node newNode = new Node(data);
            newNode.next = sec;
            sec.prev = newNode;
            first.next = newNode;
            newNode.prev = first;
            this.size++;
        }else{
            System.err.println("there is no such node");
        }
    }
    public int deletbetween(int index1,int index2){
        if (index2-index1 == 2 && index2 <= this.size  ){
            int cntr = 0;
            int data;
            Node current = this.header;
            Node first,sec;
            for(int i = 1 ; i < index1 ; i++){
                current = current.next;
            }
            first = current.next;
            sec = first.next.next;
            Node newNode = first.next;
            data = newNode.data;
            first.next = sec;
            sec.prev = first;
            this.size--;
            return data;
        }else{
            System.err.println("there is no such node");
            return -1;
        }
    }
    public void printList(){
        if(!this.isEmpty()){
            Node current = this.header.next;
            System.out.println("[");
            while(!current.equals(this.trailer)){
                System.out.println(current.data+",");
                current = current.next;
            }
            System.out.println("]");
        }else{
            System.out.println("list is empty");
        }
    }
}
