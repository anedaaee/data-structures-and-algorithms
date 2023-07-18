import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Instant start,end;
        Duration duration;
        long millisecondsNormal,mimillisecondsStrassen1,mimillisecondsStrassen2;
        List<Time> times = new ArrayList<>();
        for(int i = 1 ; i <= 300 ; i++){
            try{
                System.out.println("i: "+1);
                int[][] A = matrixMult.generateMatrix(i);
                int[][] B = matrixMult.generateMatrix(i);
                matrixMult mm = new matrixMult(A,B,i);
                start = Instant.now();
                int[][] normalMult = mm.normalMult();
                end = Instant.now();
                duration = Duration.between(start, end);
                millisecondsNormal = duration.toNanos();

                matrixMult.printMatrix(normalMult,i);
                mm.makeMatrixSizePower2();
                start = Instant.now();
                int[][]strassenMatrixMult1Result =  mm.strassenMatrixMult1(mm.A,mm.B,mm.n);
                end = Instant.now();
                duration = Duration.between(start, end);
                mimillisecondsStrassen1 = duration.toNanos();
                matrixMult.printMatrix(strassenMatrixMult1Result,mm.n);
                int[][]strassenMatrixMult2Result =mm.strassenMatrixMult2(mm.A,mm.B,mm.n);
                start = Instant.now();
                matrixMult.printMatrix(strassenMatrixMult2Result,mm.n);
                end = Instant.now();
                duration = Duration.between(start, end);
                mimillisecondsStrassen2 = duration.toNanos();
                times.add(new Time(i,millisecondsNormal,mimillisecondsStrassen1,mimillisecondsStrassen2));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        File file = new File("./data.csv");
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
        for(Time time : times){
            System.out.println(time);
            fileWriter.append(time.toString());
        }
        fileWriter.close();
    }
}