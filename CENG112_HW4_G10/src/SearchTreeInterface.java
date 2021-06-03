
public interface SearchTreeInterface<T> {
	public void setTree(T rootData);
	public void setTree(T rootData, BST<T> leftTree, BST<T> rightTree);
	public T getRootData();
	public boolean isEmpty();
	public void clear();
	public T getEntry(T entry);
	public boolean contains(T entry);
	public T add(T entry);
	public BinaryNode<T> getRoot();
	public void setRoot(BinaryNode<T> root);
	public void inorderTraverse();
}
