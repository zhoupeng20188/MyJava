package data.structure;

import java.util.Stack;

/**
 * @Author zhoupeng
 * @Date 2020-05-13 15:49
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        System.out.println(stack.pop());
    }
}
