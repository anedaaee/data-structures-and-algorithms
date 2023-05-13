import java.util.Scanner;

public class MergeSort {
    private int [] list;
    private int len;
    private int [] sortList;
    public MergeSort(){
        this.createList();
        this.printList();
        this.sortList = this.mergeSort(0,this.len - 1);
        this.printSortList();
    }
    private void createList(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter len of list: ");
        this.len = scanner.nextInt();
        scanner.nextLine();

        this.list = new int[this.len];

        for (int i = 0 ; i < this.len ; i++){
            System.out.println("Enter element "+(i+1)+"'th of the list: ");
            this.list[i] = scanner.nextInt();
            scanner.nextLine();
        }
    }

    private void printList(){
        System.out.println("[");
        for(int i = 0 ; i < this.len ; i++){
            System.out.println(" "+this.list[i]+" , ");
        }
        System.out.println("]");
    }
    private void printSortList(){
        System.out.println("[");
        for(int i = 0 ; i < this.len ; i++){
            System.out.println(" "+this.sortList[i]+" , ");
        }
        System.out.println("]");
    }
    private int[] mergeSort(int low , int high){
        int mid1,mid2;
        if(low < high){
            mid1 = (low+high)/3;
            mid2 = ((low+high)/3)*2;
            this.mergeSort(low,mid1);
            this.mergeSort(mid1+1 , mid2);
            this.mergeSort(mid2+1 , high);
            return this.merge(low,mid1,mid2,high);
        }else{
            int [] x = {this.list[low]};
            return x;
        }

    }

    private int[] merge(int low , int mid1, int mid2 , int high) throws ArrayIndexOutOfBoundsException{

        int[] merged = new int[this.len];

        int i = low, j = mid1, k = mid2, l = low;

        // choose smaller of the smallest in the three ranges
        while ((i < mid1) && (j < mid2) && (k < high))
        {
            if (this.list[i]<this.list[j])
            {
                if (this.list[i] < this.list[j])
                    merged[l++] = this.list[i++];

                else
                     merged[l++] = this.list[k++];
            }
            else
            {
                if (this.list[j] < this.list[k])
                    merged[l++] = this.list[j++];
                else
                    merged[l++] = this.list[k++];
            }
        }

        while ((i < mid1) && (j < mid2))
        {
            if (this.list[i] < this.list[j])
                merged[l++] = this.list[i++];
            else
                merged[l++] = this.list[j++];
        }

        while ((j < mid2) && (k < high))
        {
            if ( this.list[i] < this.list[k])
                merged[l++] = this.list[j++];

            else
                merged[l++] = this.list[k++];
        }

        while ((i < mid1) && (k < high))
        {
            if (this.list[i] < this.list[k])
                merged[l++] = this.list[i++];
            else
                merged[l++] = this.list[k++];
        }

        while (i < mid1)
            merged[l++] = this.list[i++];

        while (j < mid2)
            merged[l++] = this.list[j++];

        while (k < high)
            merged[l++] = this.list[k++];

        return merged;
    }

}
