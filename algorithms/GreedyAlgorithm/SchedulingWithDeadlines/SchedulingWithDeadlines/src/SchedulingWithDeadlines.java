import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SchedulingWithDeadlines {
    public ArrayList<Job> jobs;
    private Scanner scanner;
    SchedulingWithDeadlines(){
        this.jobs = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    private void addJob(){
        Job job = new Job();
        System.out.println("enter job name: ");
        job.setJobName(scanner.nextLine());
        System.out.println("enter the profit: ");
        job.setProfit(scanner.nextInt());
        scanner.nextLine();
        System.out.println("enter the deadline: ");
        job.setDeadline(scanner.nextInt());
        scanner.nextLine();
        this.jobs.add(job);
    }
    private void sort(){;
        for (int i = 1 ; i < this.jobs.size() ; i++){
            for(int j = 0 ; j < this.jobs.size() - i ; j++){
                if(this.jobs.get(j).getProfit() < this.jobs.get(j+1).getProfit()){
                    Job Temp ;
                    Temp = this.jobs.get(j);
                    this.jobs.set(j,this.jobs.get(j+1));
                    this.jobs.set(j+1,Temp);
                }
            }
        }
    }
    private int getMaxDeadline(){
        int maxDeadline = Integer.MIN_VALUE;
        for (Job job : jobs) {
            if (job.getDeadline() > maxDeadline) {
                maxDeadline = job.getDeadline();
            }
        }
        return maxDeadline;
    }
    private static int findFeasibleSlot(Job job, Job[] schedule) {
        for (int i = job.getDeadline() - 1; i >= 0; i--) {
            if (schedule[i].getJobName().equals("-")) {
                return i;
            }
        }
        return -1;
    }
    private void showBestOrder(){

        int maxDeadline = this.getMaxDeadline();
        this.sort();
        Job[] schedule = new Job[maxDeadline];
        Arrays.fill(schedule,new Job("-",0,0));
        int totalProfit = 0;
        int totalJobs = 0;
        for (Job job : this.jobs) {
            int slot = findFeasibleSlot(job, schedule);
            if (slot != -1) {
                schedule[slot] = job;
                totalProfit += job.getProfit();
                totalJobs++;
            }
        }

        System.out.println("best order:");
        int i = 1;
        for(Job job : schedule){
            System.out.println(i+": name="+job.getJobName()+" profit:"+job.getProfit()+" deadLine:"+job.getDeadline());
            i++;
        }
        System.out.println("Total Profit: " + totalProfit);
        System.out.println("Total Jobs: " + totalJobs);
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
