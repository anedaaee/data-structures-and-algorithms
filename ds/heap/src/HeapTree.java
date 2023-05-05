public class HeapTree {

    public int [] heap;

    HeapTree(int [] a){
        this.heap = a;
    }
    public int heapMaximum(int [] a){
        return a[1];
    }
    public int heapExtract(int [] a,int n){
        if(n<1){
            System.out.println("heap underflow");
            return -1;
        }else{
            int max = a[1];
            a[1] = a[n];
            n--;
            heapify(a,1,n);
            return max;
        }
    }
    public void  increase (int [] a , int key ,int i){
        if (key < a [i]){
            System.err.println("key is smaller than the elemenet");
        }else{
            int temp;
            a[i] = key;
            while (i > 1 && a[(int)Math.floor(i/2)] < a[i]){
                temp = a[(int)Math.floor(i/2)];
                a[(int)Math.floor(i/2)] = a[i];
                a[i] = temp;
                i = (int)Math.floor(i/2);
            }
        }
    }
    public void resize(int a[] , int size){
        int [] b = new int[size + 2];
        for(int i = 1 ; i <= size ; i++){
            b[i] = a[i];
        }
        a = b ;
    }
    public void insert(int a[] , int n , int size){
        resize(a,size);
        size++;
        a[size] = n;
        buildingHeap(a,size);
    }
    public void heapify(int a[] , int i , int size){
        int l = i * 2 ;
        int r = i * 2 + 1;
        int largest = i;
        if(l <= size && a[l] > a[i]){
            largest = l;
        }
        if( r <= size && a[r] > a[largest]){
            largest = r;
        }
        if(largest != i){
            int temp = a[i];
            a[i] = a [largest];
            a[largest ]=temp;
            heapify(a , largest , size);
        }
    }
    public void buildingHeap(int a[],int size){
        for(int i = (int) Math.floor(size/2); i >= 1 ; i--){
            heapify(a,i,size);
        }
    }
    public int [] heapSort(int a[] , int size){
        int temp,heapSize = size;
        buildingHeap(a,size);
        int [] b = new int[size+1];

        for(int i = size ; i >= 2 ; i--){
            b[i] = a[1];
            a[1] = a [heapSize];
            heapSize--;
            heapify(a,1, heapSize );
        }
        return b;
    }
}
