import java.util.Stack;
/*
 * Also check the CTCI approach if you get time.
 */
public class MinStack {
	long min;
	Stack<Long> stack;

	public MinStack() {
		stack = new Stack<>();
	}

	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(0L);
			min = x;
		} else {
			stack.push(x - min);// Could be negative if min value needs to
								// change
			if (x < min)
				min = x;
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;

		long pop = stack.pop();

		if (pop < 0)
			min = min - pop;// If negative, increase the min value

	}

	public int top() {
		long top = stack.peek();
		if (top > 0) {
			return (int) (top + min);
		} else {
			return (int) (min);
		}
	}

	public int getMin() {
		return (int) min;
	}

	public static void main(String[] args) {
		MinStack s = new MinStack();
		s.push(5);
		s.push(6);
		s.push(3);
		s.push(7);
	}

}
/**
 * Maintain a min element.
 * 
 * Push(x) - If stack is empty push 0 , min = x
 * 		   - Push (x - min)
 * 		   - If x < min , min =x
 * 
 * Pop  - remove top
 * 		   -  If top < 0 , min = min - top
 * 
 * Top - top > 0 , top = top + min
 *         - else ,min
 */
