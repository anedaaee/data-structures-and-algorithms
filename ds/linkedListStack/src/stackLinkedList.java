class Node{
    public int data;
    public Node next;
    Node(){

    }
    Node(int data){
        this.data = data;
    }
}

public class stackLinkedList {
    private Node first;

    stackLinkedList(){

    }
    public boolean isEmpty(){
        return this.first == null;
    }
    public void push(int data){
        Node newNode = new Node(data);
        if(this.first == null){
            this.first = newNode;
        }else{
            Node rest = this.first;
            this.first = newNode;
            newNode.next = rest;
        }
    }

    public int pop(){
        if(this.isEmpty()){
            System.out.println("list is empty");
            return -1;
        }else{
            Node returnNode = this.first;
            this.first = this.first.next;
            return  returnNode.data;
        }
    }
    public int top(){
        if(this.isEmpty()){
            System.out.println("list is empty");
            return -1;
        }else{
            return  this.first.data;
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
    public int len(){
        int len = 0;
        if(!this.isEmpty()){
            Node currenrNode = this.first;
            while(currenrNode != null){
                len++;
                currenrNode = currenrNode.next;
            }
        }
        return len;
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