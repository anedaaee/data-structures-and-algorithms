import java.util.Scanner;

public class W {
    private int [][] w ;
    private int n;
    private Scanner scanner;
    W(){
        this.scanner = new Scanner(System.in);
    }
    public void getNumberOfCity(){
        System.out.println("Enter number of City: ");
        this.n = this.scanner.nextInt();
        this.scanner.nextLine();
        this.w = new int[this.n][this.n];
    }
    public void getCities(){
        for(int i = 0 ; i < this.n ; i++){
            for(int j = 0 ; j < this.n ; j++){
                if(i==j){
                    this.w[i][j] = 10000;
                }else{
                    System.out.println("Enter path cost of city: "+(i+1)+"->"+(j+1)+":(if there is no path enter 10000) ");
                    this.w[i][j] = this.scanner.nextInt();
                    this.scanner.nextLine();
                }
            }
        }
    }
    public int[][] getW(){
        this.getNumberOfCity();
        this.getCities();
        return this.w;
    }
    public int getN(){
        return this.n;
    }
}
