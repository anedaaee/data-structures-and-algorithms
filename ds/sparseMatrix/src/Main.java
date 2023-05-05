import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row,col,matrix[][];
        System.out.println("Enter number of row ");
        row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter number of column ");
        col = scanner.nextInt();
        scanner.nextLine();
        matrix = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                System.out.println("enter element "+(i+1)+" "+(j+1)+" of matrix ");
                matrix[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }
        SparseMatrix sparseMatrix = new SparseMatrix(matrix,col,row);
        System.out.println(sparseMatrix.toString());
        System.out.println(sparseMatrix.transpose());
        sparseMatrix.print();
        sparseMatrix.transpose().print();
    }
}