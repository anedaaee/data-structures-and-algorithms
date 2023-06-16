import java.util.ArrayList;
import java.util.Scanner;

public class ChooseAnActivity {
    public ArrayList<Activity> activities;
    private ArrayList<Activity> solution;
    private Scanner scanner ;
    private int numberOfActivityes;
    ChooseAnActivity(){
        this.activities = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.numberOfActivityes = 1;
        Activity activity = new Activity(0,0,"0",this.numberOfActivityes);
        this.activities.add(activity);
    }

    private void addActivity(){
        Activity activity = new Activity();
        System.out.println("enter activity name: ");
        activity.setName(this.scanner.nextLine());
        System.out.println("enter activity start time: ");
        activity.setStartTime(this.scanner.nextInt());
        this.scanner.nextLine();
        System.out.println("enter activity finish time: ");
        activity.setFinishTime(this.scanner.nextInt());
        this.scanner.nextLine();
        this.numberOfActivityes++;
        activity.setNumber(this.numberOfActivityes);
        this.activities.add(activity);
    }
    private void sortFinishTime(){;
        for (int i = 1 ; i < this.activities.size() ; i++){
            for(int j = 0 ; j < this.activities.size() - i ; j++){
                if(this.activities.get(j).getFinishTime() > this.activities.get(j+1).getFinishTime()){
                    Activity Temp ;
                    Temp = this.activities.get(j);
                    this.activities.set(j,this.activities.get(j+1));
                    this.activities.set(j+1,Temp);
                }
            }
        }
    }
    private void recActivitySelector(int i){
        int m = i+1;
        if(m < this.numberOfActivityes){
            Activity iActivity = this.activities.get(i);
            Activity mActivity = this.activities.get(m);
            if (mActivity != null && iActivity != null) {
                while (m < this.numberOfActivityes && mActivity.getStartTime() < iActivity.getFinishTime()) {
                    m++;
                    mActivity = this.activities.get(m);
                }
                if (m < this.numberOfActivityes) {
                    this.solution.add(mActivity);
                    this.recActivitySelector(m);
                }
            }
        }
    }
    private void getBestActivityOrder(){
        this.sortFinishTime();
        this.solution = new ArrayList<>();
        this.recActivitySelector(0);
        for ( Activity activity : this.solution ){
            System.out.println(activity);
        }
    }
    public void menu(){
        boolean whileBool = true;
        String choice ;
        while(whileBool){
            System.out.println("Enter what you want to do: ");
            System.out.println("1-add activity");
            System.out.println("2-get best activity order");
            System.out.println("3-exit\n");
            choice = this.scanner.nextLine();
            switch (choice){
                case "1":
                    this.addActivity();
                    break;
                case "2":
                    this.getBestActivityOrder();
                    break;
                case "3":
                    whileBool=false;
                    break;

            }
        }
    }

}
