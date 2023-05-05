public class Main {
    public static void main(String[] args) {
        convert cnv = new convert();
        String infix = "A+B*C-D";
        String prefix = "-*+ABCD";
        String postfix = "AB+C*D-";
        System.out.println(cnv.infixToPostfix(infix));
        System.out.println(cnv.infixToPrefix(infix));
        System.out.println(cnv.prefixToInfix(prefix));
        System.out.println(cnv.prefixToPostfix(prefix));
        System.out.println(cnv.postfixToInfix(postfix));
        System.out.println(cnv.postfixToPrefix(postfix));
    }
}