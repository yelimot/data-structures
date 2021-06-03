
public class BinaryNode<T> {
	private T data;
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;
	
	public BinaryNode() {
		this(null);
	}
	
	public BinaryNode(T dataPortion) {
		this(dataPortion, null, null);
	}
	
	public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild) {
		data = dataPortion;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T newData) {
		data = newData;
	}
	
	public BinaryNode<T> getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(BinaryNode<T> newLeftChild) {
		leftChild = newLeftChild;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public BinaryNode<T> getRightChild() {
		return rightChild;
	}
	
	public void setRightChild(BinaryNode<T> newRightChild) {
		rightChild = newRightChild;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	public boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}
	
	public int getNumberOfNodes() {
		int leftNodes = 0;
		int rightNodes = 0;
		if (rightChild != null)
			rightNodes = rightChild.getNumberOfNodes();
		if (leftChild != null)
			leftNodes = leftChild.getNumberOfNodes();
		return 1+rightNodes+leftNodes;
	}
	
	public int getHeight() {
		return getHeight(this);
	}
	
	private int getHeight(BinaryNode<T> node) {
		int height = 0;
		if (node != null)
			height = 1+Math.max(getHeight(node.leftChild),getHeight(node.rightChild));
		return height;
	}	
	
	public BinaryNode<T> copy(){
		BinaryNode<T> copied = new BinaryNode<>(data);
		if (rightChild!=null)
			copied.setRightChild(rightChild.copy());
		if (leftChild!=null)
			copied.setLeftChild(leftChild.copy());
		return copied;
	}
	
}
