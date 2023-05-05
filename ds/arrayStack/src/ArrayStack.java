public class ArrayStack {
    private int []data;
    private int numberOfElement,maxNumber;
    ArrayStack(int maxNumber){
        this.data = new int[maxNumber];
        this.maxNumber = maxNumber;
    }
    public int len(ArrayStack inputStack){
        return inputStack.numberOfElement;
    }
    public boolean isFull(ArrayStack inputStack){
        return  inputStack.numberOfElement == inputStack.maxNumber;
    }
    public boolean isEmpty(ArrayStack inputStack){
        return inputStack.numberOfElement == 0;
    }
    public void push(int element){
        if(isFull(this)){
            System.err.println("Stack is FULL");
        }else{
            for(int i = this.numberOfElement - 1 ; i>=0 ; i--){
                this.data[i+1] = this.data[i];
            }
            this.data[0] = element;
            this.numberOfElement++;
        }

    }
    public int pop(){
        if(this.isEmpty(this)){
            System.err.println("Stack is EMPTY");
            return -1;
        }else{
            int element = this.data[0];
            for(int i = 1 ; i < this.numberOfElement ; i++){
                this.data[i-1] = this.data[i];
            }
            this.numberOfElement--;
            return element;
        }
    }
    public int top(){
        if(this.isEmpty(this)){
            System.err.println("Stack is EMPTY");
            return -1;
        }else{
            int element = this.data[0];
            return element;
        }
    }
}
