import java.util.ArrayList;

class State{
    public int coaf,expon;
    State(int coaf , int expon){
        this.coaf =  coaf;
        this.expon = expon;
    }
    State(){

    }

}
public class Polynomial {
    public ArrayList<State> poly;
    private int degree;

    Polynomial(int degree){
        this.poly = new ArrayList<State>();
        this.degree = degree;
    }
    Polynomial(){
        this.poly = new ArrayList<State>();
    }
    public boolean isZero(Polynomial inputPoly){
        if(inputPoly.poly.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    public int getCoefficients(Polynomial inputPoly,int expon){
        int returnValue = 0;
        if(expon >= 0 && expon <= inputPoly.degree){
            State state ;
            boolean flag = false;
            for(int i = 0 ; i < inputPoly.poly.size() ; i++){
                state = new State();
                state = inputPoly.poly.get(i);
                if (state.expon == expon){
                    returnValue =  state.coaf;
                    flag = false;
                    break;
                }
            }
            if(flag == false) { //cant find expon
                return -1;
            }
        }else{
            System.err.println("Invalid Expon");
            return -1;
        }
        return returnValue;
    }
    public int leadExpo(Polynomial polynomial){
        int max;
        if(polynomial.poly.size() == 0){
            // poly is full
            return -1;
        }else{
            max = polynomial.poly.get(0).expon;
            for(int i = 1 ; i < polynomial.poly.size() ; i++){
                if(polynomial.poly.get(i).expon > max){
                    max = polynomial.poly.get(i).expon;
                }
            }
            return max;
        }
    }
    public void attach(State state ){

            this.poly.add(state);

    }
    public Polynomial add(Polynomial poly1 , Polynomial poly2){
        Polynomial d = new Polynomial();
        State state;
        while ( poly1.poly.size() != 0  || poly2.poly.size() != 0){
            if(poly1.leadExpo(poly1) > poly2.leadExpo(poly2)){
                state = poly1.poly.get(0);
                d.attach(state);
                poly1.poly.remove(0);
            }else if (poly1.leadExpo(poly1) < poly2.leadExpo(poly2)){
                state = poly2.poly.get(0);
                d.attach(state);
                poly2.poly.remove(0);
            }else if(poly1.leadExpo(poly1) == poly2.leadExpo(poly2)){
                state = new State();
                state.expon = poly1.poly.get(0).expon;
                state.coaf = poly1.poly.get(0).coaf + poly2.poly.get(0).coaf;
                d.attach(state);
                poly1.poly.remove(0);
                poly2.poly.remove(0);
            }
        }
        d.leadExpo(d);
        return  d;
    }


}
