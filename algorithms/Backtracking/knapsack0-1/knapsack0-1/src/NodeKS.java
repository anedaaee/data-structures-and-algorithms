public class NodeKS {
    public int p,w;
    public double pPerw;

    public NodeKS(int p, int w) {
        this.p = p;
        this.w = w;
        if(this.w != 0){
            this.pPerw = this.p / this.w;
        }else{
            this.pPerw = 0;
        }

    }

    @Override
    public String toString() {
        return "{" +
                "p=" + p +
                ", w=" + w +
                ", pPerw=" + pPerw +
                '}';
    }
}
