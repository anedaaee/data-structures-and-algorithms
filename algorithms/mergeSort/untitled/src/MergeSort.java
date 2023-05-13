import java.util.Scanner;

public class MergeSort {
    private int [] list;
    private int len;
    private int [] sortList;
    public MergeSort(){
        this.createList();
        this.printList();
        this.mergeSort(0,this.len - 1);
        this.printList();
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
    private void mergeSort(int low , int high){
        int mid;
        if(low < high){
            mid = (low+high)/2;
            this.mergeSort(low,mid);
            this.mergeSort(mid+1 , high);
            this.merge(low,mid,high);
        }
    }

    private void merge(int low , int mid , int high) throws ArrayIndexOutOfBoundsException{

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = this.list[low + i];
        for (int j = 0; j < n2; ++j)
            R[j] = this.list[mid + 1 + j];

        int i = 0, j = 0;

        int k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                this.list[k] = L[i];
                i++;
            }
            else {
                this.list[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            this.list[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            this.list[k] = R[j];
            j++;
            k++;
        }

    }
}
