public class Activity {
    private int startTime,finishTime,number;
    private String name;

    public Activity(int startTime, int finishTime, String name,int number) {
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.name = name;
        this.number = number;
    }

    public Activity() {
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "{" +
                "startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
