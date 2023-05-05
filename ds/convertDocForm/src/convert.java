import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class convert {
    public boolean isOperator(char c)
    {
        return (!(c >= 'a' && c <= 'z') &&
                !(c >= '0' && c <= '9') &&
                !(c >= 'A' && c <= 'Z'));
    }

    public int getPriority(char C)
    {
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        else if (C == '^')
            return 3;
        return 0;
    }


    public String infixToPrefix(String infix)
    {
        Stack<Character> operators = new Stack<Character>();
        Stack<String> operands = new Stack<String>();

        for (int i = 0; i < infix.length(); i++)
        {
            if (infix.charAt(i) == '(')
            {
                operators.push(infix.charAt(i));
            }
            else if (infix.charAt(i) == ')')
            {
                while (!operators.empty() &&
                        operators.peek() != '(')
                {
                    String op1 = operands.pop();
                    String op2 = operands.pop();
                    char op = operators.pop();
                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }
            }
            else if (!isOperator(infix.charAt(i)))
            {
                operands.push(infix.charAt(i) + "");
            }
            else
            {
                while (!operators.empty() &&
                        getPriority(infix.charAt(i)) <=
                                getPriority(operators.peek()))
                {
                    String op1 = operands.pop();
                    String op2 = operands.pop();
                    char op = operators.pop();
                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                operators.push(infix.charAt(i));
            }
        }
        while (!operators.empty())
        {
            String op1 = operands.pop();
            String op2 = operands.pop();
            char op = operators.pop();
            String tmp = op + op2 + op1;
            operands.push(tmp);
        }
        return operands.pop();
    }
    public String infixToPostfix(String infix)
    {
        String result = new String("");
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < infix.length(); ++i) {
            char ch = infix.charAt(i);
            if (Character.isLetterOrDigit(ch))
                result = result + ch;
            else if (ch == '(')
                stack.push(ch);
            else if (ch == ')') {
                while (!stack.isEmpty()
                        && stack.peek() != '(') {
                    result = result + stack.pop();
                }
                stack.pop();
            }
            else
            {
                while (!stack.isEmpty()
                        && getPriority(ch) <= getPriority(stack.peek())) {
                    result =result+ stack.pop();
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "wrong input";
            result = result + stack.peek();
            stack.pop();
        }

        return result;
    }
    String postfixToInfix(String postfix)
    {
        Stack<String> s = new Stack<String>();

        for (int i = 0; i < postfix.length(); i++)
        {
            if (!isOperator(postfix.charAt(i))) {
                s.push(postfix.charAt(i) + "");
            }
            else
            {
                String op1 = s.pop();
                String op2 = s.pop();
                s.push("(" + op2 + postfix.charAt(i) +
                        op1 + ")");
            }
        }
        return s.peek();
    }
    public String prefixToInfix(String prefix)
    {
        Stack<String> stack = new Stack<>();
        int l = prefix.length();
        for(int i = l - 1; i >= 0; i--)
        {
            char c = prefix.charAt(i);
            if (isOperator(c))
            {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp);
            }
            else
            {
                stack.push(c + "");
            }
        }
        return stack.pop();
    }
    public String prefixToPostfix(String prefix)
    {
        Stack<String> s = new Stack<String>();
        int length = prefix.length();
        for (int i = length - 1; i >= 0; i--)
        {
            if (isOperator(prefix.charAt(i)))
            {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                String temp = op1 + op2 + prefix.charAt(i);
                s.push(temp);
            }
            else {
                s.push(prefix.charAt(i) + "");
            }
        }
        return s.pop();
    }
    public String postfixToPrefix(String postfix)
    {
        Stack<String> s = new Stack<String>();
        int length = postfix.length();
        for (int i = 0; i < length; i++) {
            if (isOperator(postfix.charAt(i))) {
                String op1 = s.pop();
                String op2 = s.pop();
                String temp = postfix.charAt(i) + op2 + op1;
                s.push(temp);
            }
            else {
                s.push(postfix.charAt(i) + "");
            }
        }
        String result = "";
        for (String i : s)
            result = result + i;
        return result;
    }

}

