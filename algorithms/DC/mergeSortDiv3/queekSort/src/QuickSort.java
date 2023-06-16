import java.util.Scanner;

public class QuickSort {
    private int [] list;
    private int len;
    public QuickSort(){
        this.createList();
        this.printList();
        this.sort(0 , this.len - 1);
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
    private void sort(int low , int high){
        int pivotPoint;

        if(high > low) {
            pivotPoint = this.patition(low,high);
            this.sort(low , pivotPoint - 1);
            this.sort(pivotPoint + 1 , high);
        }
    }

    private int patition(int low , int high){
        int i,j,pivotItem = this.list[low] , temp ;
        j = low;
        for(i = low + 1 ; i <= high ; i++){
            if(this.list[i] < pivotItem){
                j++;
                temp = this.list[i];
                this.list[i] = this.list[j];
                this.list[j] = temp;
            }
        }
        temp = this.list[low];
        this.list[low] = this.list[j];
        this.list[j] = temp;
        return j;
    }

}
