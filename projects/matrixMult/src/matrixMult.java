import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class matrixMult {
    public final int threshold = 64;
    public int size;
    public int n;
    public int [][] A;
    public int [][] B;
    matrixMult(int[][] A , int[][] B,int size) throws Exception {
        if(A[0].length == B.length){
            this.size = size;
            this.A = A;
            this.B = B;
        }else{
            throw new Exception("we cant mult this two matrix");
        }
    }
    public void makeMatrixSizePower2(){
        int n=1;
        while(true){
            if( n > this.A.length && n > this.A[0].length && n > this.B.length && n > this.B[0].length ){
                break;
            }
            n = 2 * n;
        }
        int [][] newA = new int[n][n];
        int [][] newB = new int[n][n];
        for(int[] newARow : newA){
            Arrays.fill(newARow,0);
        }
        for(int[] newBRow : newB){
            Arrays.fill(newBRow,0);
        }
        for(int i = 0 ; i < this.size ; i++){
            for(int j = 0 ; j < this.size ; j++){
                newA[i][j] = this.A[i][j];
                newB[i][j] = this.B[i][j];
            }
        }
        this.A = newA;
        this.B = newB;
        this.n = n;
    }
    public int [][] normalMult(){
        int [][] result = new int[this.size][this.size];
        for(int i = 0 ; i < this.size ; i++){
            for(int j = 0 ; j < this.size; j++){
                for (int k = 0; k < this.size; k++) {
                    result[i][j] += this.A[i][k] * this.B[k][j];
                }
            }
        }
        return result;
    }
    public int [][] normalMultReturn(int[][] A , int [][]B){
        int rows1 = A.length;
        int cols1 = A[0].length;
        int cols2 = B[0].length;

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
    public int [][] get11(int n , int[][]matrix){
        int[][] M11 = new int[n/2][n/2];
        for(int i = 0 ; i < n/2 ; i++){
            for(int j = 0 ; j < n/2 ; j++){
                M11[i][j] = matrix[i][j];
            }
        }
        return M11;
    }
    public int [][]  get12(int n , int[][]matrix){
        int[][] M12 = new int[n/2][n/2];
        for(int i = 0 ; i < n/2 ; i++){
            for(int j = 0 ; j < n/2 ; j++){
                M12[i][j] = matrix[i][j + n/2];
            }
        }
        return M12;
    }
    public int [][]  get21(int n , int[][]matrix){
        int[][] M21 = new int[n/2][n/2];
        for(int i = 0 ; i < n/2 ; i++){
            for(int j = 0 ; j < n/2 ; j++){
                M21[i][j] = matrix[i + n/2][j];
            }
        }
        return M21;
    }
    public int [][]  get22(int n , int[][]matrix){
        int[][] M22 = new int[n/2][n/2];
        for(int i = 0 ; i < n/2 ; i++){
            for(int j = 0 ; j < n/2 ; j++){
                M22[i][j] = matrix[i + n/2][j + n/2];
            }
        }
        return M22;
    }
    public int[][] sum(int [][] A , int [][] B,int n){
        int [][] sum = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                sum[i][j] = A[i][j]+B[i][j];
            }
        }
        return sum;
    }
    public int[][] minus(int [][] A , int [][] B,int n){
        int [][] minus = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                minus[i][j] = A[i][j]-B[i][j];
            }
        }
        return minus;
    }
    public int[][] getResult(int[][] result11,int[][] result12,int[][] result21,int[][] result22,int n){
        int [][] result = new int[n][n];
        for(int i = 0 ; i < n/2 ; i++){
            for(int j = 0 ; j < n/2 ; j++){
                result[i][j] = result11[i][j];
            }
        }
        for(int i = 0 ; i < n/2 ; i++){
            for(int j = 0 ; j < n/2 ; j++){
                result[i][j + n/2] = result11[i][j];
            }
        }
        for(int i = 0 ; i < n/2 ; i++){
            for(int j = 0 ; j < n/2 ; j++){
                result[i + n/2][j] = result11[i][j];
            }
        }
        for(int i = 0 ; i < n/2 ; i++){
            for(int j = 0 ; j < n/2 ; j++){
                result[i + n/2][j + n/2] = result11[i][j];
            }
        }
        return result;
    }
    public int[][] strassenMatrixMult1(int[][]A,int[][]B,int n){
        if( n <= this.threshold){
            int[][] result = this.normalMultReturn(A,B);
            return result;
        }else{
            int[][] A11 = get11(n,A);
            int[][] A12 = get12(n,A);
            int[][] A21 = get21(n,A);
            int[][] A22 = get22(n,A);
            int[][] B11 = get11(n,B);
            int[][] B12 = get12(n,B);
            int[][] B21 = get21(n,B);
            int[][] B22 = get22(n,B);
            int[][] result11 = this.sum(this.strassenMatrixMult1(A11,B11,n/2),this.strassenMatrixMult1(A12,B21,n/2),n/2);
            int[][] result12 = this.sum(this.strassenMatrixMult1(A11,B12,n/2),this.strassenMatrixMult1(A12,B22,n/2),n/2);
            int[][] result21 = this.sum(this.strassenMatrixMult1(A21,B11,n/2),this.strassenMatrixMult1(A22,B21,n/2),n/2);
            int[][] result22 = this.sum(this.strassenMatrixMult1(A21,B12,n/2),this.strassenMatrixMult1(A22,B22,n/2),n/2);
            int[][] result = this.getResult(result11,result12,result21,result22,n);
            return result;
        }
    }
    public int[][] strassenMatrixMult2(int[][]A,int[][]B,int n){
        if( n <= this.threshold){
            int [][] result = this.normalMultReturn(A,B);
            return result;
        }else{
            int [][] A11 = get11(n,A);
            int [][] A12 = get12(n,A);
            int [][] A21 = get21(n,A);
            int [][] A22 = get22(n,A);
            int [][] B11 = get11(n,B);
            int [][] B12 = get12(n,B);
            int [][] B21 = get21(n,B);
            int [][] B22 = get22(n,B);
            int [][] m1 = this.strassenMatrixMult2(this.sum(A11,A22,n/2),this.sum(B11,B22,n/2),n/2);
            int [][] m2 = this.strassenMatrixMult2(this.sum(A21,A22,n/2),B11,n/2);
            int [][] m3 = this.strassenMatrixMult2(A11,this.minus(B12,B22,n/2),n/2);
            int [][] m4 = this.strassenMatrixMult2(A22,this.minus(B21,B11,n/2),n/2);
            int [][] m5 = this.strassenMatrixMult2(this.sum(A11,A12,n/2),B22,n/2);
            int [][] m6 = this.strassenMatrixMult2(this.minus(A21,A11,n/2),this.minus(B11,B12,n/2),n/2);
            int [][] m7 = this.strassenMatrixMult2(this.minus(A12,A22,n/2),this.sum(B21,B22,n/2),n/2);
            int [][] result11 = this.sum(m1,this.minus(m4,this.sum(m5,m7,n/2),n/2),n/2);
            int [][] result12 = this.sum(m3,m5,n/2);
            int [][] result21 = this.sum(m2,m4,n/2);
            int [][] result22 = this.sum(m1,this.minus(m3,this.sum(m2,m6,n/2),n/2),n/2);
            int [][] result = this.getResult(result11,result12,result21,result22,n);
            return result;
        }
    }
    public static int[][] generateMatrix(int n){
        int [][] matrix = new int[n][n];
        Random random = new Random();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                matrix[i][j] = random.nextInt(10) + 1 ;
            }
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix,int n){
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < n ;j++){
                System.out.print(","+matrix[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
