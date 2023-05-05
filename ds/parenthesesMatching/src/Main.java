import java.util.Scanner;
import java.util.Stack;

public class Main {
    static private Scanner scanner = new Scanner(System.in);
    static private Stack<Character> stack = new Stack<Character>();
    public static void main(String[] args) {
        String parantheses = scanner.nextLine();
        char checkChar;
        boolean flag = true;
        int cntr = 0;
        while(cntr < parantheses.length()){
            switch (parantheses.charAt(cntr)){
                case '(':
                    stack.push(parantheses.charAt(cntr));
                    break;
                case '{':
                    stack.push(parantheses.charAt(cntr));
                    break;
                case '[':
                    stack.push(parantheses.charAt(cntr));
                    break;
                case ')':
                    checkChar = stack.pop();
                    if(checkChar == '('){
                        flag = true;
                    }else{
                        flag = false;
                    }
                    break;
                case '}':
                    checkChar = stack.pop();
                    if(checkChar == '{'){
                        flag = true;
                    }else{
                        flag = false;
                    }
                    break;
                case ']':
                    checkChar = stack.pop();
                    if(checkChar == '['){
                        flag = true;
                    }else{
                        flag = false;
                    }
                    break;
            }
            if(flag == false){
                break;
            }else{
                cntr ++;
            }
        }
        if(flag == true && stack.empty()){
            System.out.println("correct");
        }else{
            System.out.println("incorrect");
        }
    }
}