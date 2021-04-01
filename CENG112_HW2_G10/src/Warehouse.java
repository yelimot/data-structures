import java.util.Arrays;
import java.util.EmptyStackException;

public class Warehouse<T> implements IStack<T>{
	private T[] stack;
	private int topIndex;

	public Warehouse(int initialCapacity) {
		
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
	}

	public void push(T newEntry) {
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}
	
	private void ensureCapacity() {
		if (topIndex == stack.length - 1) {
			int newLength = 2 * stack.length;
			stack = Arrays.copyOf(stack, newLength);
		}
	}
	public T peek() {
		T top = null;
	    if(!isEmpty())
	    	top = stack[topIndex];
	    return top;
	}
	
	public T pop() {
	    if(isEmpty()) {
	    	throw new EmptyStackException();
	    }
	    else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}	
	}
	
	public boolean isEmpty() {
		return topIndex < 0;
	}
	
	public void clear() {
		while(!isEmpty()) {
			pop();
		}
	}
}
