public class Node {
    public int level,value,levelValue;
    public Node leftNode,rightNode,parent;

    public Node(int level, int value, int levelValue, Node leftNode, Node rightNode, Node parent) {
        this.level = level;
        this.value = value;
        this.levelValue = levelValue;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.parent = parent;
    }

    public Node() {
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "level=" + level +
                ", value=" + value +
                ", levelValue=" + levelValue +
                '}';
    }
    public void print(){
        Node node = this;
        while(node.parent != null){
            if(node.levelValue != 0){
                System.out.print(node.levelValue + "+");
            }
            node = node.parent;
        }
        System.out.println("");
    }
}
