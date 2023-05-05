import java.util.Arrays;

public class DynamicArray {
    private int n;
    private int capacity;
    private int [] A;

    DynamicArray(){
        this.n = 0;
        this.capacity = 1;
        this.A = new int[this.capacity];
    }

    public int len(){
        return this.n;
    }

    public int getItem(int i){
        if(((i>=0) && (i<this.n))){
            return this.A[i];
        }else {
            //System.err.println("invalid index");
            return -1;
        }
    }

    public void append(int item){
        if(this.n==this.capacity){
            resize(this.capacity * 2);
        }

        this.A[this.n] = item;
        this.n++;
    }

    public void resize(int c){
        int [] B = new int[c];
        for(int i = 0 ; i < this.n ; i++){
            B[i] = this.A[i];
        }
        this.A = B;
        this.capacity = c;
    }

    @Override
    public String toString() {
        String returnValue = "{ ";
        for(int j = 0 ; j < this.n ; j++){
            returnValue += " "+String.valueOf(this.A[j])+" ,";
        };
        returnValue += " }";
        return returnValue;


    }
}
