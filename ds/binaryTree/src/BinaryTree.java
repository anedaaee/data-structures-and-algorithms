import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int data;
    TreeNode leftChild;
    TreeNode rightChild;
    TreeNode (int data){
        this.data = data;
    }
}
public class BinaryTree {
    TreeNode root;
    BinaryTree(int data){
        this.root = new TreeNode(data);
    }
    public boolean isLeaf(TreeNode node){
        return (node.leftChild == null) && (node.rightChild == null);
    }
    public void heapify(){

    }
    public TreeNode copy(TreeNode original){
        TreeNode temp = new TreeNode(original.data);
        temp.leftChild = copy(original.leftChild);
        temp.rightChild = copy(original.rightChild);
        return temp;
    }
    public boolean equal(TreeNode a , TreeNode b){
        boolean returnValue = false;
        if(a != null && b != null){
            if((a!=null) && (b!=null) && (a.data == b.data) && equal(a.leftChild , b.leftChild) && equal(a.rightChild , b.rightChild)){
                returnValue =  true;
            }else{
                returnValue =  false;
            }
        }else if(a == null && b == null){
            returnValue =  true;
        }
        return returnValue;
    }
    public void levelOrder(TreeNode currentNode){
        Queue<TreeNode> q = new LinkedList<>();
        while (currentNode != null){
            System.out.print(" "+currentNode.data+" ");
            if(currentNode.leftChild != null){
                q.add(currentNode.leftChild);
            }
            if(currentNode.rightChild != null){
                q.add(currentNode.rightChild);
            }
            if(q.size()!= 0){
                currentNode = q.remove();
            }else{
                currentNode = null;
            }
        }
        System.out.println(" ");

    }
    public void preOrderShow(TreeNode currentNode){
        if(currentNode != null) {
            System.out.print(" " + currentNode.data + " ");
            preOrderShow(currentNode.leftChild);
            preOrderShow(currentNode.rightChild);
        }
    }
    public void inOrderShow(TreeNode currentNode){
        if(currentNode != null) {
            inOrderShow(currentNode.leftChild);
            System.out.print(" " + currentNode.data + " ");
            inOrderShow(currentNode.rightChild);
        }
    }
    public void postOrderShow(TreeNode currentNode){
        if(currentNode != null) {
            postOrderShow(currentNode.leftChild);
            postOrderShow(currentNode.rightChild);
            System.out.print(" " + currentNode.data + " ");
        }
    }
}
