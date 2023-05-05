class Node{
    public int data;
    public Node next;
    Node(){

    }
    Node(int data){
        this.data = data;
    }
}

public class LinkedList {
    private Node first;

    LinkedList(){

    }
    public boolean isEmpty(){
        return this.first == null;
    }
    public void insertAtHead(int data){
        Node newNode = new Node(data);
        if(this.first == null){
            this.first = newNode;
        }else{
            Node rest = this.first;
            this.first = newNode;
            newNode.next = rest;
        }
    }
    public void insertAtTail(int data){
        Node newNode = new Node(data);

        if(this.first == null){
            this.first = newNode;
        }else{
            Node last = this.first;
            while (last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
    }
    public int removeAtHead(){
        if(this.isEmpty()){
            System.out.println("list is empty");
            return -1;
        }else{
            Node returnNode = this.first;
            this.first = this.first.next;
            return  returnNode.data;
        }
    }
    public int indexOf(int number) {
        int cntr = 0;
        Node currentNode = null;
        if (this.isEmpty()) {
            cntr = 0;
        } else {
            currentNode = this.first;
            do {
                    if (currentNode.data != number) {
                        cntr++;
                        currentNode = currentNode.next;
                    } else {
                        cntr++;
                        break;
                    }
            } while (currentNode != null);
        }
        if (currentNode == null){
            cntr = -1;
        }
            return cntr;
    }
    public int removeAtTail(){
        if(this.isEmpty()){
            System.out.println("list is empty");
            return -1;
        }else{
            Node currentNode = this.first;
            int returnValue = -1;
            while(true) {
                if(currentNode.next.next == null){
                    returnValue = currentNode.next.data;
                    currentNode.next = null;
                    break;
                }
                currentNode = currentNode.next;
            }
            return returnValue;
        }
    }
    public void printList(){
        if(this.isEmpty()){
            System.out.println("list is empty");
        }else{
            Node currentNode = this.first;
            System.out.print("[");
            do {
                System.out.print(currentNode.data+",");
                currentNode = currentNode.next;
            }while (currentNode != null);
            System.out.println("]\n");
        }
    }
}
