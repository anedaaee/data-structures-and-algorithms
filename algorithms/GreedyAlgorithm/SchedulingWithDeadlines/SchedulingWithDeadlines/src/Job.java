public class Job {
    private String jobName;
    private int profit , deadline;

    public Job(String jobName, int profit, int deadline) {
        this.jobName = jobName;
        this.profit = profit;
        this.deadline = deadline;
    }

    public Job() {
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobName='" + jobName + '\'' +
                ", profit=" + profit +
                ", deadline=" + deadline +
                '}';
    }
}
