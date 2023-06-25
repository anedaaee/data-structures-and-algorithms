import java.util.Scanner;

public class HamiltonianCircuits {
    private int n;
    private int [] vinder;
    private int [][] W;
    private Scanner scanner;
    HamiltonianCircuits(){
        this.scanner = new Scanner(System.in);
    }
    private void printSol(){
        System.out.print("[");
        for (int i = 1 ; i < this.n + 1 ; i++){
            System.out.print(","+this.vinder[i]);
        }
        System.out.print("]\n");
    }
    private boolean promising(int i){
        boolean switchh = true;
        int j = 1;
        if( i == this.n && this.W[this.vinder[this.n]][this.vinder[1]] == 0){
            switchh = false;
        }else if( i > 1 && this.W[this.vinder[i - 1]][this.vinder[i]] == 0){
            switchh = false;
        }else{
            while ( j < i && switchh){
                if(this.vinder[i] == this.vinder[j]){
                    switchh = false;
                }
                j++;
            }
        }
        return switchh;
    }
    private void hamiltonianCircuitsFind(int i){
        if(this.promising(i)){
            if(i == this.n){
                this.printSol();
            }else{
                for(int j = 1 ; j <= this.n ; j++){
                    this.vinder[i + 1] = j;
                    this.hamiltonianCircuitsFind(i + 1);
                }
            }
        }
    }
    private void getW(){
        this.vinder = new int[this.n + 1];
        this.W = new int[this.n + 1][this.n + 1];
        for (int i = 1 ; i < this.n + 1 ; i++){
            for (int j = 1 ; j < this.n + 1; j++){
                System.out.println("enter w ["+i+"]["+j+"] value: (0/1)");
                this.W[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }
    }
    public void menu(){
        boolean whileBool = true;
        char choice ;
        while(whileBool){
            System.out.println("Enter number of nodes: ");
            this.n = scanner.nextInt();
            scanner.nextLine();
            this.getW();
            this.hamiltonianCircuitsFind(0);
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
