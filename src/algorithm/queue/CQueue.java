package algorithm.queue;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
public class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack1.isEmpty() && stack2.isEmpty()) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();
    }
}