import java.util.*;

public class RemainingMoney {
    public  int n;
    public  List<Integer> coinValues;
    RemainingMoney(int n , List<Integer> coinValues){
        this.n = n;
        this.coinValues = coinValues;
    }
    public static RemainingMoney build() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of coin: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Integer> coinValues = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            System.out.println("Enter "+(i+1)+"'th coin value: ");
            coinValues.add(scanner.nextInt());
            scanner.nextLine();
        }
        return new RemainingMoney(n,coinValues);
    }
    private void sort(){
        Collections.sort(this.coinValues);
    }
    public void getRemainMoney(int money){
        this.sort();
        int sum = 0;
        int index,totalIndex = 0;
        String result = "";
        for(int i = this.coinValues.size() - 1 ; i >= 0 ; i--){
            int coin = this.coinValues.get(i);
            index = 0;
            while(sum + coin <= money){
                index++;
                totalIndex++;
                sum +=coin;
            }
            result += index+"*"+coin+"\n";
        }
        System.out.println(result);
        System.out.println("Remaining money: "+(money-sum)+" And total coin: "+totalIndex);
    }
}
