import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RemainingMoney remainingMoney = RemainingMoney.build();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter money value: ");
        remainingMoney.getRemainMoney(scanner.nextInt());
        scanner.nextLine();
    }
}