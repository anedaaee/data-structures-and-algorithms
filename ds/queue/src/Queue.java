public class Queue {
    private int []queue;
    private int maxSize,front = -1,rear = -1;
     Queue(int maxSize){
         this.queue =  new int[maxSize];
         this.maxSize = maxSize;
     }

     public boolean isEmpty(){
         return this.front == this.rear;
     }
     public boolean isFull(){
         return this.rear == this.maxSize;
     }
     public void addQ(int element){
         if(!this.isFull()){
             this.queue[this.rear++] = element;
         }else{
             System.err.println("QUEUE IS FULL");
         }
     }
     public int deletQ(){
         if(this.isEmpty()){
             System.err.println("QUEUE US EMPTY");
             return  -1;
         }else{
             return this.queue[this.front++];
         }
     }
}
