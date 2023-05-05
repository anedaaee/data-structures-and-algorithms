import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

class Node{
    int data;
    Vector<Node> child = new Vector<>();
    Node(){

    }
    Node(int data){
        this.data = data;
    }
}
public class GeneralTrees {
    Node root;

    GeneralTrees(int data){
        this.root = new Node(data);
    }
    /*public Node newNode(int key)
    {
        Node temp = new Node();
        temp.data = key;
        return temp;
    }*/
     void LevelOrderTraversal()
    {
        if (this.root == null)
            return;

        Queue<Node > q = new LinkedList<>();
        q.add(this.root);
        while (!q.isEmpty())
        {
            int n = q.size();

            while (n > 0)
            {

                Node p = q.peek();
                q.remove();
                System.out.print(p.data + " ");


                for (int i = 0; i < p.child.size(); i++)
                    q.add(p.child.get(i));
                n--;
            }

        }
    }
}
