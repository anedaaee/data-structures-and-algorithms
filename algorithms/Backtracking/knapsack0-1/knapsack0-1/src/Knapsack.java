import java.util.ArrayList;
import java.util.Scanner;

public class Knapsack {
    private int n ;
    private int numBest;
    private int maxW , maxprofit;
    private ArrayList<NodeKS> list;
    private int [] include,bestSet;
    private Scanner scanner;
    Knapsack(){
        this.numBest = 0;
        this.maxprofit = 0;
        this.n = 0;
        this.scanner = new Scanner(System.in);
        this.list = new ArrayList<>();
        this.list.add(new NodeKS(0,0));
    }
    private void sortProduct(){;
        for (int i = 2 ; i < this.list.size() ; i++){
            for(int j = 1 ; j < this.list.size() - i ; j++){
                if(this.list.get(j).pPerw > this.list.get(j+1).pPerw){
                    NodeKS Temp = this.list.get(j);
                    this.list.set(j,this.list.get(j+1));
                    this.list.set(j+1,Temp);
                }
            }
        }
    }
    private void addProduct(){
        System.out.println("Enter profit of product: ");
        int p = this.scanner.nextInt();
        this.scanner.nextLine();
        System.out.println("Enter weight of product: ");
        int w = this.scanner.nextInt();
        this.scanner.nextLine();
        this.list.add(new NodeKS(p,w));
        this.n ++;
    }
    private boolean promising(int i, int profit , int weight){
        boolean returnVal = true;
        int j , k ;
        int totalWeight;
        double bound;
        NodeKS node = this.list.get(i);
        if(weight >= this.maxW){
            return   false;
        }else{
            j = i + 1 ;
            bound = profit;
            totalWeight = weight;
            while ( j < this.n && totalWeight + this.list.get(j).w <= this.maxW){
                totalWeight += this.list.get(j).w;
                bound += this.list.get(j).p;
                j++;
            }
            k=j;
            if(k < n){
                bound += (this.maxW - totalWeight) * this.list.get(k).pPerw;
            }
            return bound > this.maxprofit;
        }
    }
    private void knapsackCalculate(int i, int profit , int weight){
        if(weight < this.maxW && profit > this.maxprofit){
            this.maxprofit = profit;
            this.numBest = i;
            this.bestSet = this.include;
        }
        if(promising(i,profit,weight)){
            this.include[i+1] = 1;
            this.knapsackCalculate(i+1,profit + this.list.get(i).p, weight + this.list.get(i).w);
            this.include[i+1] = 0;
            this.knapsackCalculate(i+1,profit + this.list.get(i).p, weight + this.list.get(i).w);
        }
    }
    private void calculate(){
        System.out.println("Enter max W : ");
        this.maxW = this.scanner.nextInt();
        this.scanner.nextLine();
        this.include = new int[this.n + 1];
        this.bestSet = new int[this.n + 1];
        for(int i = 0 ; i <= this.n ; i++){
            this.include[i] = 0;
            this.bestSet[i] = 0;
        }
        this.sortProduct();
        this.knapsackCalculate(0,0,0);
        for(int i : this.bestSet){
            System.out.println(i);
        }
    }
    public void menu(){
        boolean whileBool = true;
        String choice;
        while(whileBool){
            System.out.println("Enter what you want to do: ");
            System.out.println("1-add product.");
            System.out.println("2-calculate.");
            System.out.println("3-exit");
            choice = this.scanner.nextLine();
            switch (choice.charAt(0)){
                case '1':
                    this.addProduct();
                    break;
                case '2':
                    this.calculate();
                    break;
                case '3':
                    whileBool = false;
                    System.out.println("bye baby...");
                    break;
            }
        }
    }
}
