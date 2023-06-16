public class ObjectForks {
    private String name;
    private int value,weight;
    private double VWRate;

    public ObjectForks(String name, int value, int weight, double VWRate) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.VWRate = this.value/this.weight;
    }

    public ObjectForks() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getVWRate() {
        return VWRate;
    }

    public void setVWRate() {
        this.VWRate = this.value/this.weight;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", weight=" + weight +
                ", VWRate=" + VWRate +
                '}';
    }
}
