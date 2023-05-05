import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Polynomial poly1 = new Polynomial(4);
        Polynomial poly2 = new Polynomial(7);
        poly1.attach(new State(3,4));
        poly1.attach(new State(12,2));
        poly2.attach(new State(16,7));
        poly2.attach(new State(2,4));
        poly2.attach(new State(3,1));
        Polynomial polynomial = new Polynomial();
        polynomial = polynomial.add(poly1,poly2);
        for (int i = 0 ; i < polynomial.poly.size() ; i++){
            System.out.println(polynomial.poly.get(i).coaf +" "+polynomial.poly.get(i).expon +"\n");
        }
    }
}