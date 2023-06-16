import java.util.ArrayList;
import java.util.Scanner;

public class GreedyKnapsackProblem {
    public ArrayList<ObjectForks> objectForkss;
    private Scanner scanner ;
    GreedyKnapsackProblem(){
        this.objectForkss = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    private void addObject(){
        ObjectForks objectForks = new ObjectForks();
        System.out.println("enter name of object: ");
        objectForks.setName(scanner.nextLine());
        System.out.println("enter value of object: ");
        objectForks.setValue(scanner.nextInt());
        scanner.nextLine();
        System.out.println("enter wight of object: ");
        objectForks.setWeight(scanner.nextInt());
        scanner.nextLine();
        objectForks.setVWRate();
        this.objectForkss.add(objectForks);
    }
    private void sort(){;
        for (int i = 1 ; i < this.objectForkss.size() ; i++){
            for(int j = 0 ; j < this.objectForkss.size() - i ; j++){
                if(this.objectForkss.get(j).getVWRate() < this.objectForkss.get(j+1).getVWRate()){
                    ObjectForks Temp;
                    Temp = this.objectForkss.get(j);
                    this.objectForkss.set(j,this.objectForkss.get(j+1));
                    this.objectForkss.set(j+1,Temp);
                }
            }
        }
    }
    private void getBestSol(){
        System.out.println("enter limit for knapsack");
        int limit = scanner.nextInt() , totalWeight = 0;
        scanner.nextLine();
        ArrayList<ObjectForks> sol = new ArrayList<>();
        this.sort();
        ObjectForks lastOne = new ObjectForks();
        for (ObjectForks objectForks : this.objectForkss){
            if((objectForks.getWeight() + totalWeight) <= limit){
                totalWeight += objectForks.getWeight();
                sol.add(objectForks);
            }else{
                lastOne = objectForks;
                break;
            }
        }
        System.out.println("best sol: ");
        for (ObjectForks objectForks : sol){
            System.out.println(objectForks);
        }
        if(lastOne.getWeight() != 0){
            System.out.println("+ "+(limit-totalWeight)+"/"+lastOne.getWeight()+" * "+lastOne);
        }



    }
    public void menu(){
        boolean whileBool = true;
        String choice;
        while(whileBool){
            System.out.println("Tell what you want to do?");
            System.out.println("1-add new opject");
            System.out.println("2-get best solution for knapsack problem");
            System.out.println("3-exit\n");
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    this.addObject();
                    break;
                case "2":
                    this.getBestSol();
                    break;
                case "3":
                    whileBool = false;
                    break;
            }
        }

    }
}
