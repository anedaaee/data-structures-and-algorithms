import java.util.Scanner;

public class NQueen {
    private int n;
    private int [] list;
    private int num ;
    private Scanner scanner;
    NQueen(){
        this.scanner = new Scanner(System.in);
    }
    private void printSol(){
        this.num ++;
        System.out.println(this.num);
        System.out.print("[");
        for (int i = 1 ; i < this.n + 1 ; i++){
            System.out.print(","+this.list[i]);
        }
        System.out.print("]\n");
    }
    private boolean promising(int i){
        boolean switchh = true;
        int k = 1;
        while( k < i && switchh){
            if(this.list[i] == this.list[k] || Math.abs(this.list[i] - this.list[k]) == i - k){
                switchh = false;
            }
            k++;
        }
        return switchh;
    }
    private void nQueenAlgorithm(int i){
        if(this.promising(i)){
            if(i == this.n){
                this.printSol();
            }else{
                for(int j = 1 ; j <= this.n ; j++){
                    this.list[i + 1] = j;
                    this.nQueenAlgorithm(i + 1);
                }
            }
        }
    }
    private void init(){
        this.list = new int[this.n + 1];
        this.num = 0;
    }
    public void menu(){
        boolean whileBool = true;
        char choice ;
        while(whileBool){
            System.out.println("Enter number of queen: ");
            this.n = scanner.nextInt();
            scanner.nextLine();
            this.init();
            this.nQueenAlgorithm(0);
            System.out.println("do you want to exit? (y/n)");
            choice = scanner.nextLine().charAt(0);
            switch (choice){
                case 'y' :
                    whileBool = false;
                    break;
            }
        }
    }

}
