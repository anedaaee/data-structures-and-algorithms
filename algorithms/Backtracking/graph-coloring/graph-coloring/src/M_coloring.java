import java.util.Scanner;

public class M_coloring {
    private int m,n;
    private int [] vcolor;
    private int [][] W;
    private Scanner scanner;
    M_coloring(){
        this.scanner = new Scanner(System.in);
    }
    private void printSol(){
        System.out.print("[");
        for (int i : this.vcolor){
            System.out.print(","+i);
        }
        System.out.print("]\n");
    }
    private boolean promising(int i){
        boolean switchh = true;
        int j = 0;
        while ( j < i && switchh){
            if(this.W[i][j] == 1 && this.vcolor[i] == this.vcolor[j]){
                switchh = false;
            }
            j++;
        }

        return switchh;
    }
    private void m_coloring(int i){
        if(this.promising(i)){
            if(i == this.n - 1 ){
                this.printSol();
            }else{
                for(int color = 1 ; color <= this.m ; color++){
                    this.vcolor[i + 1] = color;
                    this.m_coloring(i + 1);
                }
            }
        }
    }
    private void getW(){
        this.vcolor = new int[this.n];
        this.W = new int[this.n][this.n];
        for (int i = 0 ; i < this.n ; i++){
            for (int j = 0 ; j < this.n ; j++){
                System.out.println("enter w ["+(i+1)+"]["+(j+1)+"] value: (0/1)");
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
            System.out.println("Enter number of color: ");
            this.m = scanner.nextInt();
            scanner.nextLine();
            this.getW();
            this.m_coloring(-1);
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
