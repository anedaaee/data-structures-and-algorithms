import java.util.Scanner;

public class LargNumberProduct {
    private long number1,number2 , result1 , result2;
    public LargNumberProduct(){
        this.getNumbers();
        this.result1 = this.prod(this.number1 , this.number2);
        this.result2 = this.prod2(this.number1 , this.number2);
        System.out.println(this.result1);
        System.out.println(this.result2);
    }
    private void getNumbers(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number 1: ");
        this.number1 = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter number2: ");
        this.number2 = scanner.nextLong();
        scanner.nextLine();
    }
    private int getNumberOfDigit(long number){
        int numberOfDigit = 0;

        while(number != 0){
            number /= 10;
            numberOfDigit++;
        }

        return numberOfDigit;
    }
    private int max(int u , int v){
        if(u > v){
            return u;
        }else{
            return v;
        }
    }
    private long prod(long u , long v){

        long x,y,w,z;

        int n,m;

        n = this.max(this.getNumberOfDigit(u),this.getNumberOfDigit(v));

        if(u==0 || v==0){
            return   0;
        }else if (n < 2){
            return u * v;
        }else{
            m = n/2;

            int i = 1;
            for(int j = 0 ; j < m ; j++){
                i *= 10;
            }

            x = u / i;
            y = u % i;
            w = v / i;
            z = v % i;

            return prod(x,w)*i*i + (prod(x,z)+prod(w,y))*i + prod(y,z);
        }

    }
    private long prod2(long u , long v){

        long x,y,w,z,r,p,q;

        int n,m;

        n = this.max(this.getNumberOfDigit(u),this.getNumberOfDigit(v));

        if(u==0 || v==0){
            return   0;
        }else if (n < 2){
            return u * v;
        }else{
            m = n/2;

            int i = 1;
            for(int j = 0 ; j < m ; j++){
                i *= 10;
            }

            x = u / i;
            y = u % i;
            w = v / i;
            z = v % i;
            r = prod2(x+y,w+z);
            p = prod2(x,w);
            q = prod2(y,z);
            return p*i*i + (r-p-q)*i + q;
        }

    }
}
