import java.util.Random;
import java.util.Scanner;

public class StrassenAlgorithm2 {
    private int [][] matrixA;
    private int [][] matrixB;
    private int [][] matrixC;
    private int size;
    private int power2Size;
    StrassenAlgorithm2(){
        this.getSize();
        this.getPower2Size();
        this.generateMatrix();
        this.printMatrix();
        this.matrixC = this.multiply_matrix(this.matrixA , this.matrixB);
        this.printMatrix();
    }
    private void getSize(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the size of matrixs: ");
        this.size = scanner.nextInt();
        scanner.nextLine();
    }
    private void getPower2Size(){
        this.power2Size = 1;
        while(this.power2Size < this.size){
            this.power2Size *= 2;
        }
    }
    private void generateMatrix(){
        Random random = new Random();
        int i,j;
        this.matrixA = new int[this.power2Size][this.power2Size];
        this.matrixB = new int[this.power2Size][this.power2Size];
        this.matrixC = new int[this.power2Size][this.power2Size];

        for( i = 0 ; i < this.size ; i++){
            for( j = 0 ; j < this.size ; j++){
                matrixA[i][j] = random.nextInt(9 - 1 + 1) + 1;
                matrixB[i][j] = random.nextInt(9 - 1 + 1) + 1;
                matrixC[i][j] = 0;
            }
        }
        for( i = this.size ; i < this.power2Size ; i++){
            for ( j = this.size ; j < this.power2Size ; j++){
                matrixA[i][j] = 0;
                matrixB[i][j] = 0;
                matrixC[i][j] = 0;
            }
        }
    }
    private void printMatrix(){
        int i , j ;
        System.out.println("A:");
        for(i = 0 ; i < this.size ;i++){
            System.out.print("|");
            for (j = 0 ; j < this.size ; j++){
                System.out.print(" "+matrixA[i][j]+",");
            }
            System.out.print("|\n");
        }
        System.out.println("B:");
        for(i = 0 ; i < this.size ;i++){
            System.out.print("|");
            for (j = 0 ; j < this.size ; j++){
                System.out.print(" "+matrixB[i][j]+",");
            }
            System.out.print("|\n");
        }
        System.out.println("C:");
        for(i = 0 ; i < this.size ;i++){
            System.out.print("|");
            for (j = 0 ; j < this.size ; j++){
                System.out.print(" "+matrixC[i][j]+",");
            }
            System.out.print("|\n");
        }
    }
    public int[][] multiply_matrix(int [][] matrixA , int [][] matrixB ){
        int [][] matrixC = new int [this.power2Size][this.power2Size];
        int len = matrixA[0].length;
        if(len == 1){
            matrixC[0][0] = matrixA[0][0]*matrixB[0][0];
            return matrixC;
        }else{
            int split_index = len/ 2;
            int[][] a00 = new int[split_index][split_index];
            int[][] a01 = new int[split_index][split_index];
            int[][] a10 = new int[split_index][split_index];
            int[][] a11 = new int[split_index][split_index];
            int[][] b00 = new int[split_index][split_index];
            int[][] b01 = new int[split_index][split_index];
            int[][] b10 = new int[split_index][split_index];
            int[][] b11 = new int[split_index][split_index];
            for (int i = 0; i < split_index; i++){
                for (int j = 0; j < split_index; j++) {
                    a00[i][j] = matrixA[i][j];
                    a01[i][j] = matrixA[i][j + split_index];
                    a10[i][j] = matrixA[split_index + i][j];
                    a11[i][j] = matrixA[i + split_index][j + split_index];
                    b00[i][j] = matrixB[i][j];
                    b01[i][j] = matrixB[i][j + split_index];
                    b10[i][j] = matrixB[split_index + i][j];
                    b11[i][j] = matrixB[i + split_index][j + split_index];
                }
            }
            int[][] m1 = multiply_matrix(add_matrix(a00,a11, split_index),add_matrix(b00,b11, split_index));
            int[][] m2 = multiply_matrix(add_matrix(a10,a11, split_index),b00);
            int[][] m3 = multiply_matrix(a00,sub_matrix(b01,b11, split_index));
            int[][] m4 = multiply_matrix(a11,sub_matrix(b10,b00, split_index));
            int[][] m5 = multiply_matrix(add_matrix(a00,a01, split_index),b11);
            int[][] m6 = multiply_matrix(sub_matrix(a10,a00, split_index),sub_matrix(b00,b01, split_index));
            int[][] m7 = multiply_matrix(sub_matrix(a01,a11, split_index),add_matrix(b10,b11, split_index));
            int[][] result_matrix_00 = add_matrix(sub_matrix(add_matrix(m1,m4,split_index),m5,split_index),m7,split_index);
            int[][] result_matrix_01 = add_matrix(m3,m5,split_index);
            int[][] result_matrix_10 = add_matrix(m2,m4,split_index);
            int[][] result_matrix_11 = add_matrix(sub_matrix(add_matrix(m1,m3,split_index),m2,split_index),m6,split_index);
            for (int i = 0; i < split_index; i++){
                for (int j = 0; j < split_index; j++) {
                    matrixC[i][j] = result_matrix_00[i][j];
                    matrixC[i][j + split_index] = result_matrix_01[i][j];
                    matrixC[split_index + i][j] = result_matrix_10[i][j];
                    matrixC[i + split_index] [j + split_index] = result_matrix_11[i][j];
                }
            }
            return matrixC;
        }

    }

    public static int [][] add_matrix(int[][] matrixA,int[][] matrixB, int split_index)
    {
        int [][] matrixC = new int[split_index][split_index];
        for (int i = 0; i < split_index; i++){
            for (int j = 0; j < split_index; j++){
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matrixC;
    }
    public static int [][] sub_matrix(int[][] matrixA,int[][] matrixB, int split_index)
    {
        int [][] matrixC = new int[split_index][split_index];
        for (int i = 0; i < split_index; i++){
            for (int j = 0; j < split_index; j++){
                matrixC[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return matrixC;
    }
}
