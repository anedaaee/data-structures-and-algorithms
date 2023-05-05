import java.util.ArrayList;

public class OrderedList {
    private int n,capacity,list[];

    OrderedList(){
        this.n = 0;
        this.capacity = 1;
        this.list = new int[this.capacity];

    }
    public int size(){
        return this.n;
    }
    public boolean isEmpty(){
        return this.n == 0;
    }
    public int getItem(int i){
        if(((i>=0) && (i<this.n))){
            return this.list[i];
        }else {
            //System.err.println("invalid index");
            return -1;
        }
    }

    public void Add(int item){
        if(this.n==this.capacity){
            resize(this.capacity * 2);
        }

        this.list[this.n] = item;
        this.n++;
        sort();
    }
    public void sort(){
        int i ,j;
        for( i = 1 ; i < this.n ; i++){
            int v = this.list[i];
            j = i-1;
            while(j >= 0 && v < this.list[j]){
                this.list[j+1] = this.list[j];
                j = j - 1;
            }
            this.list[j+1] = v;
        }
    }
    public int findIndex(int item){
        int index = -1;
        for (int i = 0 ; i < this.n ; i++){
            if(this.list[i] == item){
                index = i;
                break;
            }
        }
        return index;
    }
    public int removeIteme(int item){
        int index = findIndex(item);
        int returnValue = -1;
        if(index == -1) {
            System.err.println("no such item in list");
        }else{
            returnValue = this.list[index];
            for(int j = index ; j < this.n - 1 ;j++){
                this.list[j] = this.list[j+1];
            }
            this.n --;
        }
        return returnValue;
    }
    public ArrayList<Integer> search(int item){
        ArrayList<Integer> indexArr = new ArrayList<Integer>();
        for(int i = 0 ; i < this.n ;i++){
            if(this.list[i] == item){
                indexArr.add(i);
            }
        }
        return indexArr;
    }

    public void resize(int c){
        int [] B = new int[c];
        for(int i = 0 ; i < this.n ; i++){
            B[i] = this.list[i];
        }
        this.list = B;
        this.capacity = c;
    }

    @Override
    public String toString() {
        String returnValue = "{ ";
        for(int j = 0 ; j < this.n ; j++){
            returnValue += " "+String.valueOf(this.list[j])+" ,";
        };
        returnValue += " }";
        return returnValue;


    }
    public int pop(){
        int returnValue = -1;
        if(!this.isEmpty()){
            returnValue = this.list[this.n];
            this.n--;
        }
        return returnValue;
    }
    public int pop(int pos){
        if(pos>= 0 && pos < this.n){
            int returnValue = this.list[pos];
            for(int i = pos ; i < this.n -1  ; i++){
                this.list[i] = this.list[i+1];
            }
            this.n--;
            return returnValue;
        }else{
            System.err.println("invalid index");
            return -1;
        }
    }
}
