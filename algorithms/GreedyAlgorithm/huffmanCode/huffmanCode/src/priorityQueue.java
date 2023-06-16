import java.util.ArrayList;

public class priorityQueue {
    public ArrayList<Node> queue;
    priorityQueue(){
        this.queue = new ArrayList<>();
    }
    public boolean isEmpty(){
        return this.queue.isEmpty();
    }
    public int len(){
        return this.queue.size();
    }
    public void add(Node node){
        this.queue.add(node);
    }
    public Node get(){
        int min = this.queue.get(0).value ;
        Node returnNode =this.queue.get(0);
        for(Node nd : this.queue){
            if(nd.value<min)
                returnNode = nd;
                min = nd.value;
        }
        this.queue.remove(returnNode);
        return returnNode;
    }

}
