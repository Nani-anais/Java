
public class DemoStack {

	public static void main(String[] args) {
		Stack stack = new Stack();

		// Push elements into the stack
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		// Print the stack
		System.out.println("Stack elements after pushes:");
		stack.printStack();

		// Peek the top element
		System.out.println("Top element is: " + stack.peek());

		// Pop elements from the stack
		System.out.println("Popped element: " + stack.pop());
		System.out.println("Popped element: " + stack.pop());

		// Print the stack again after popping
		System.out.println("Stack elements after pops:");
		stack.printStack();

		// Peek again after popping
		System.out.println("Top element after popping is: " + stack.peek());

		// Check if the stack is empty
		System.out.println("Is stack empty? " + stack.isEmpty());

		// Check the size of the stack
		System.out.println("Current size of stack: " + stack.size());
	}

}
