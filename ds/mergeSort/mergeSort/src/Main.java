public class Main {

    public static void merge(int list[] , int l , int r , int m){
        int n1 = m-l+1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = list[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = list[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                list[k] = L[i];
                i++;
            }
            else {
                list[k] = R[j];
                j++;
            }
            k++;
        }
    }

    public static void mergeSort(int list[] , int l , int r){
        if(r > l){
            mergeSort(list , l , (l+r)/2);
            mergeSort(list ,( (l+r)/2 )+ 1, r);
            merge(list , l , r , (l+r)/2);
        }
    }

    public static void main(String[] args) {
        int list[] = { 12, 11, 13, 5, 6, 7 };
        mergeSort(list,0,5);

        for(int i = 0 ; i < 6 ; i++){
            System.out.println(list[i]);
        }

    }
}