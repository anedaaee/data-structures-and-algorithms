public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.leftChild = new TreeNode(2);
        bt.root.rightChild = new TreeNode(3);
        bt.root.leftChild.leftChild = new TreeNode(4);
        bt.root.rightChild.leftChild = new TreeNode(5);
        bt.root.rightChild.rightChild = new TreeNode(6);
        bt.root.rightChild.rightChild.leftChild = new TreeNode(7);
        bt.root.rightChild.rightChild.rightChild = new TreeNode(8);
        bt.root.rightChild.rightChild.rightChild.rightChild = new TreeNode(9);
        bt.preOrderShow(bt.root);
        System.out.println("");
        bt.inOrderShow(bt.root);
        System.out.println("");
        bt.postOrderShow(bt.root);
        System.out.println("");
        bt.levelOrder(bt.root);
    }
}