import java.util.ArrayList;

public class SparseMatrix {
    private int col,row,value;
    private SparseMatrix [] sparseMatrices;
    SparseMatrix(){

    }
    SparseMatrix(int numberOfElement ,int row,int col){
        this.sparseMatrices = new SparseMatrix[numberOfElement+1];
        this.sparseMatrices[0] = new SparseMatrix();
        this.sparseMatrices[0].col = col;
        this.sparseMatrices[0].row = row;
        this.sparseMatrices[0].value = numberOfElement;
    }
    SparseMatrix(int[][]normalMatrix,int col , int row){

        int numberOfElement = findNumberOfElement(normalMatrix,col,row);
        this.sparseMatrices = new SparseMatrix[numberOfElement + 1];
        this.sparseMatrices[0] = new SparseMatrix();
        this.sparseMatrices[0].col = col;
        this.sparseMatrices[0].row = row;
        this.sparseMatrices[0].value = numberOfElement;
        int current = 1;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if (normalMatrix[i][j] != 0){
                    this.sparseMatrices[current] = new SparseMatrix();
                    this.sparseMatrices[current].value = normalMatrix[i][j];
                    this.sparseMatrices[current].row = i;
                    this.sparseMatrices[current].col = j;
                    current++;
                }
            }
        }
    }

    private int findNumberOfElement(int[][]matrix,int col,int row){
        int numberOfElement = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if (matrix[i][j] != 0){
                    numberOfElement++;
                }
            }
        }
        return numberOfElement;
    }

    public SparseMatrix transpose(){
        SparseMatrix copy = new SparseMatrix(this.sparseMatrices[0].value
                ,this.sparseMatrices[0].col,this.sparseMatrices[0].row);
        int n = this.sparseMatrices[0].value,currentCopy;
        if(n>0){
            currentCopy = 1;
            for (int i = 0 ; i < this.sparseMatrices[0].col ; i++){
                for (int j = 1 ; j <= n ; j++){
                    if(this.sparseMatrices[j].col == i){
                        copy.sparseMatrices[currentCopy] = new SparseMatrix();
                        copy.sparseMatrices[currentCopy].row = this.sparseMatrices[j].col;
                        copy.sparseMatrices[currentCopy].col = this.sparseMatrices[j].row;
                        copy.sparseMatrices[currentCopy].value = this.sparseMatrices[j].value;
                        currentCopy++;
                    }
                }
            }
        }
    return copy;
    }
    @Override
    public String toString() {
        /*String returnValue = "[\n";
        for (int i = 1 ; i <= this.sparseMatrices[0].value ; i++){
                returnValue = returnValue +" "+this.sparseMatrices[i].row +" "+this.sparseMatrices[i].col+" "+this.sparseMatrices[0].value +"\n";
        }
        returnValue = returnValue +"\n]\n";
        return returnValue;*/
        return "";
    }
    public void print() {
        System.out.println("[\n");
        for (int i = 1 ; i <= this.sparseMatrices[0].value ; i++) {
            System.out.println(this.sparseMatrices[i].row + " " + this.sparseMatrices[i].col + " " + this.sparseMatrices[i].value);
        }
        System.out.println("]");

    }
}
