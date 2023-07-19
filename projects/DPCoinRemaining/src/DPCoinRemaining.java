import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DPCoinRemaining {
    public List<Integer> coins;
    public int [][] DP;
    public int total;
    private Scanner scanner;
    DPCoinRemaining(){
        scanner = new Scanner(System.in);
        this.getCoinst();
        this.getAmount();
    }
    private void getCoinst(){
        this.coins = new ArrayList<>();
        boolean breakWhile = true;
        while(breakWhile){
            System.out.println("Enter y if you want to exit: ");
            switch (this.scanner.nextLine()) {
                case "y":
                    breakWhile = false;
                    break;
                default:
                    System.out.println("Enter Coin price: ");
                    this.coins.add(this.scanner.nextInt());
                    this.scanner.nextLine();
                    break;
            }
        }
        Collections.sort(this.coins);
    }
    private void getAmount(){
        System.out.println("Enter total amount: ");
        this.total = this.scanner.nextInt();
        this.scanner.nextLine();
    }
    public void getDP(){
        this.DP = new int[this.coins.size()][this.total + 1];
        for(int i = 0 ; i < this.coins.size() ; i++){
            this.DP[i][0] = 0;
        }
        int coin = this.coins.get(0);
        int index = 0;
        for(int i = 1 ; i < this.total + 1; i++){
            if(i >= index * coin){
                index++;
            }
            this.DP[0][i] = index * coin;
        }
        for(int i = 1 ; i < this.coins.size(); i++){
            coin = this.coins.get(i);
            for(int j = 1 ; j < this.total + 1 ; j++){
                if(j >= coin){
                    this.DP[i][j] = Math.min(this.DP[i-1][j],1+this.DP[i][j-coin]);
                }else{
                    this.DP[i][j] = this.DP[i - 1][j];
                }
            }
        }
        int i = this.coins.size() -1;
        int j = this.total ;
        String result = "";
        while(this.DP[i][j] != 0){
            int element = this.DP[i][j];
            if(i>=0){
                if(this.DP[i-1][j] == element){
                    i--;
                    result+=" "+this.coins.get(i)+" , ";
                }else{
                    j -= this.coins.get(i);
                }
            }else{
                j -= this.coins.get(i);
            }
        }
        System.out.println("coins: "+result);
        System.out.print("amounts: ");
        for(j = 0 ; j < this.total + 1 ; j++){
            System.out.print(j+",");
        }
        System.out.println("");
        for(i = 0 ; i < this.coins.size(); i++){
            System.out.print(this.coins.get(i)+": "+"      ");
            for(j = 0 ; j < this.total + 1 ; j++){
                System.out.print(this.DP[i][j]+",");
            }
            System.out.println("");
        }
    }
}
