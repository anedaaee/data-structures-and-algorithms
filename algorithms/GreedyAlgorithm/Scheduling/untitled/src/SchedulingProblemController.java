import java.util.ArrayList;
import java.util.Scanner;

public class SchedulingProblemController {
    public ArrayList<Job> jobs;
    private Scanner scanner;
    SchedulingProblemController(){
        this.jobs = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    private void addJob(){
        Job job = new Job();
        System.out.println("enter job name: ");
        job.setJobName(scanner.nextLine());
        System.out.println("enter the time: ");
        job.setTime(scanner.nextInt());
        this.jobs.add(job);
    }
    private void sort(){;
        for (int i = 1 ; i < this.jobs.size() ; i++){
            for(int j = 0 ; j < this.jobs.size() - i ; j++){
                if(this.jobs.get(j).getTime() > this.jobs.get(j+1).getTime()){
                    Job Temp = new Job();
                    Temp = this.jobs.get(j);
                    this.jobs.set(j,this.jobs.get(j+1));
                    this.jobs.set(j+1,Temp);
                }
            }
        }
    }
    private void showBestOrder(){
        this.sort();
        System.out.println("best order:");
        int i = 1;
        for(Job job : this.jobs){
            System.out.println(i+": name="+job.getJobName()+" time:"+job.getTime());
            i++;
        }
    }
    public void menu(){
        String choice;
        boolean whileBool = true;
        while(whileBool){
            System.out.println("tell what you want to do????");
            System.out.println("1-add job");
            System.out.println("2-get best order with sum of time");
            System.out.println("3-exit\n");
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    this.addJob();
                    break;
                case "2":
                    this.showBestOrder();
                    break;
                case "3":
                    whileBool=false;
                    break;
            }
        }
    }

}
