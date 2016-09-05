import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/articles/implement-stack-using-queues/
 * 
 * There are multiple solutions to this. 
 * 1) Push O(1) Pop O(n) Two Queues- THE ONE WE ARE USING-RUNTIME IS GOOD FOR THIS ONE
 * Here we keep on adding to the end of queue and when we need to pop , we
 * move all the elements but the last one to another queue and remove the
 * last element.
 * 
 * 2) Push O(n) Pop O(1) Two queues - Reverse of the method 1
 * 
 * 3) Push O(n) Pop O(1) One Queue - Here while pushing an element, we
 * remove other elements and push it to the enf of the same queue.The problem with this solution is 
 * we need to compute the size of Queue which is again O(n);
 */

public class StackUsingQueue {
	private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;
    
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
