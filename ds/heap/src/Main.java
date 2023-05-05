public class Main {

    public static void main(String[] args) {

        int a [] = {0,13,14,15,16,3,4};
        HeapTree ht = new HeapTree(a);
        int size = 6;
        //ht.heapSort(a,size);
        for (int i = 1 ; i <= size ; i++){
            System.out.print(" "+a[i]);
        }
        System.out.println(" ");
        System.out.println(ht.heapMaximum(a));
        ht.heapExtract(a,size);

        System.out.println(size);
        for (int i = 1 ; i <= size ; i++){
            System.out.print(" "+a[i]);
        }
        System.out.println(" ");
        ht.insert(a,2,size);
        System.out.println(size);
        for (int i = 1 ; i <= size ; i++){
            System.out.print(" "+a[i]);
        }

    }
}