public class FindPost {
    static int preIndex = 0;
    void printPost(int[] inorder, int[] preorder, int start, int end)
    {
        if (start > end)
            return;
        int inIndex = search(inorder, start, end, preorder[preIndex++]);
        printPost(inorder, preorder, start, inIndex - 1);
        printPost(inorder, preorder, inIndex + 1, end);
        System.out.print(inorder[inIndex] + " ");
    }

    int search(int[] inorder, int start, int end, int data)
    {
        int i = 0;
        for (i = start; i < end; i++)
            if (inorder[i] == data)
                return i;
        return i;
    }

}
