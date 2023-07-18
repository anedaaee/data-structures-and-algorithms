public class Time {
    public int round;
    public long normalMultTime,strassen1Time,strassen2Time;

    public Time(int round, long normalMultTime, long strassen1Time, long strassen2Time) {
        this.round = round;
        this.normalMultTime = normalMultTime;
        this.strassen1Time = strassen1Time;
        this.strassen2Time = strassen2Time;
    }

    @Override
    public String toString() {
        return round +
                "," + normalMultTime +
                "," + strassen1Time +
                "," + strassen2Time+"\n";
    }
}
