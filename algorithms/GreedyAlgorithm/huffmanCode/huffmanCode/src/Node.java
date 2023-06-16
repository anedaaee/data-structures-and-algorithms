public class Node {
    public int value;
    public char character;
    public Node leftChild,rightChild,parent;
    public boolean leaf;

    Node(int value , char character , boolean leaf){
        this.value = value;
        this.character = character;
        this.leaf = leaf;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", character=" + character +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", parent=" + parent +
                ", leaf=" + leaf +
                '}';
    }
}
