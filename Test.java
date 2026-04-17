
public class Test {

    public static void main(String[] args) {
        TDAStack<Integer> stack = new ListStack<Integer>();
        stack.push(2);
        stack.push(5);
        stack.push(10);
        stack.push(7);
        stack.show();
        System.out.printf("%d%n", stack.pop());
        System.out.printf("%d%n", stack.pop());
        stack.show();
        System.out.printf("%d%n", stack.pop());
        System.out.printf("%d%n", stack.pop());
        stack.show();
        stack.push(1);
        stack.push(10);
        stack.push(100);
        stack.show();
    }
}
