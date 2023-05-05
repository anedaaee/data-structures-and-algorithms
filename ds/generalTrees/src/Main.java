public class Main {
    public static void main(String[] args) {
        GeneralTrees gt = new GeneralTrees(12);
        gt.root.child.add(new Node(14));
        gt.root.child.add(new Node(15));
        gt.root.child.add(new Node(13));
        gt.root.child.get(0).child.add(new Node(18));
        gt.root.child.get(0).child.add(new Node(19));
        gt.root.child.get(1).child.add(new Node(20));
        gt.root.child.get(2).child.add(new Node(21));
        gt.root.child.get(2).child.get(0).child.add(new Node(22));
        gt.LevelOrderTraversal();
    }
}