public class Job {
    private String jobName;
    private int time;

    public Job(String jobName, int time) {
        this.jobName = jobName;
        this.time = time;
    }

    public Job() {
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
