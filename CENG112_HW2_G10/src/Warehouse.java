import java.util.Arrays;

public class Warehouse<T> implements IStack<T>{
	private T[] stack;
	private int topIndex;
	private boolean initialized = false;

	public Warehouse(int initialCapacity) {
		checkCapacity(initialCapacity); // ???? BAK ????
		
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	}
	
	public void push(T newEntry) {
		checkInitialization(); // ???? BAK ????
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}
	
	private void ensureCapacity() {
		if (topIndex == stack.length - 1) {
			int newLength = 2 * stack.length;
			checkCapacity(newLength); // ???? BAK ????
			stack = Arrays.copyOf(stack, newLength); // ???? BAK ????
		}
	}
	public T peek() {
	    checkInitialization();
	    if(isEmpty())
	    	throw new EmptyStackException(); // ???? BAK ????
	    else 
	    	return stack[topIndex];
	}
	
	public T pop() {
	    checkInitialization();
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
