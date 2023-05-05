public class circularQueue {
    private int []queue;
    private int front,rear,MaxNumber;

    circularQueue(int MaxNumber){
        this.MaxNumber = MaxNumber;
        this.queue = new int[MaxNumber];
        this.front = 0;
        this.rear = 0;
    }

    public int size(){
        return (this.MaxNumber - this.front + this.rear)%this.MaxNumber;
    }
    public boolean isEmpty(){
        return this.front == this.rear;
    }
    public boolean isFull(){
        return this.size() == this.MaxNumber-1;
    }
    public void enqueue(int element){
        if (this.size() == this.MaxNumber-1){
            System.err.println("QUEUE IS FULL");
        }else{
            this.queue[this.rear] = element;
            this.rear = (this.front+1) % this.MaxNumber;
        }
    }
    public int dequeue(){
        if(this.isEmpty()){
            System.err.println("QUEUE IS FULL");
            return -1;
        }else{
            int element = this.queue[this.front];
            this.front = (this.front + 1) % this.MaxNumber;
            return  element;
        }
    }


}
