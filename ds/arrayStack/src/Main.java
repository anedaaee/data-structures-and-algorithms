public class Main {
    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(4);
        arrayStack.push(20);
        arrayStack.push(12);
        arrayStack.push(5);
        arrayStack.push(7);
        arrayStack.push(2);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.top());
        System.out.println(arrayStack.top());
    }
}