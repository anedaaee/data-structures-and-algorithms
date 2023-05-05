class Node{
    int data;
    Node leftChild;
    Node rightChild;

    Node(int data){
        this.data = data;
    }
}
public class BST {
    Node root;

    BST(int data){
        this.root = new Node(data);
    }
    void deleteKey(int key) { root = deleteRec(root, key); }

    /* A recursive function to
      delete an existing key in BST
     */
    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.leftChild = deleteRec(root.leftChild, key);
        else if (key > root.data)
            root.rightChild = deleteRec(root.rightChild, key);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.leftChild == null)
                return root.rightChild;
            else if (root.rightChild == null)
                return root.leftChild;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.data = minValue(root.rightChild);

            // Delete the inorder successor
            root.rightChild = deleteRec(root.rightChild, root.data);
        }

        return root;
    }

    int minValue(Node root)
    {
        int minv = root.data;
        while (root.leftChild != null) {
            minv = root.leftChild.data;
            root = root.leftChild;
        }
        return minv;
    }
    public void inorderWalk(Node current){
        if(current != null){
            inorderWalk(current.leftChild);
            System.out.print(current.data);
            inorderWalk(current.rightChild);
        }
    }
    public void preorderWalk(Node current){
        if(current != null){
            System.out.print(current.data);
            inorderWalk(current.leftChild);
            inorderWalk(current.rightChild);
        }
    }
    public void postorderWalk(Node current){
        if(current != null){
            inorderWalk(current.leftChild);
            inorderWalk(current.rightChild);
            System.out.print(current.data);
        }
    }
    public Node search(Node current , int key){
        if(current != null) {
            if (key == current.data) {
                return current;
            } else if (key < current.data) {
                return search(current.leftChild, key);
            } else {
                return search(current.rightChild, key);
            }
        }else {
            return null;
        }
    }
    public boolean insert(BST tree , int data){
        Node x = tree.root;
        Node y;
        while (x != null){
            y = x;
            if(data == y.data){
                return false;
            }else if(data < y.data){
                x = x.leftChild;
            }else if (data > y.data) {
                x = x.rightChild;
            }
            x = new Node(data);
            if(tree.root == null){
                tree.root = x;
            }else {
                if(data < y.data){
                    y.leftChild = x;
                }else if(data > y.data){
                    y.rightChild = x;
                }
            }
        }
        return true;
    }
}
