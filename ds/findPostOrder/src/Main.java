public class Main {

    public static void main(String ars[])
    {
        int inorder[] = { 4, 2, 5, 1, 3, 6 };
        int preorder[] = { 1, 2, 4, 5, 3, 6 };
        int len = 6;
        FindPost tree = new FindPost();
        tree.printPost(inorder, preorder, 0, len - 1);
    }
}