import java.util.ArrayList;
import java.util.Scanner;

public class SumOfSubset {
    private int W;
    private Node root;
    private Scanner scanner;
    private ArrayList<Integer> set;
    private ArrayList<Node> awnsers;
    SumOfSubset(){
        this.set = new ArrayList<>();
        this.scanner = new Scanner(System.in);

    }
    private void addSubSet(){
        System.out.println("enter number: ");
        this.set.add(scanner.nextInt());
        scanner.nextLine();
    }

    public int getSumAfter(int level){
        int sum = 0;
        for (int i = level  ; i < this.set.size() ; i++){
            sum += this.set.get(i);
        }
        return sum;
    }
    private void recSOS(Node node){
        if(node.level <= this.set.size()){
            int sumTillNow =node.value ;
            int sumAfter = getSumAfter(node.level);
            if(node.value == this.W){
                awnsers.add(node);
            }else if(!(sumTillNow > this.W )&& !((sumAfter+node.value) < this.W)){
                node.setLeftNode(new Node(node.level+1,node.value+this.set.get(node.level),this.set.get(node.level) ,null,null,node));
                node.setRightNode(new Node(node.level+1,node.value+0,0 ,null,null,node));
                this.recSOS(node.leftNode);
                this.recSOS(node.rightNode);
            }
        }
    }
    private void getSOS(){
        System.out.println("enter the W: ");
        this.W = scanner.nextInt();
        scanner.nextLine();
        this.root = new Node(0,0,0,null,null,null);
        this.awnsers = new ArrayList<>();
        this.recSOS(this.root);
        for(Node node : this.awnsers){
            node.print();
        }

    }
    public void menu(){
        boolean whileBool = true;
        String choice;
        while(whileBool){
            System.out.println("Enter what you want to do:");
            System.out.println("1-add sub set.");
            System.out.println("2-get ways to solution with sum of subset.");
            System.out.println("3-exit.");
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    this.addSubSet();
                    break;
                case "2":
                    this.getSOS();
                    break;
                case "3":
                    whileBool = false;
                    break;
            }
        }
    }
}
