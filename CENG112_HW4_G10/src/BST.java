
public class BST <T> implements SearchTreeInterface<T>{
	
	private BinaryNode<T> root;
	
	public BST() {
		root = null;
	}
	
	public BST(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	
	public BST(T rootData, BST<T> leftTree, BST<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	}
	
	public void setTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}
	
	private void privateSetTree(T rootData, BST<T> leftTree, BST<T> rightTree) {
		root = new BinaryNode<>(rootData);
		if(leftTree!=null)
			root.setLeftChild(leftTree.root);
		if(rightTree!=null)
			root.setRightChild(rightTree.root);
	}
	
	
	
	public BinaryNode<T> getRoot() {
		return root;
	}
	
	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}
	
	public void setTree(T rootData,BST<T> right,BST<T> left) {
		privateSetTree(rootData,right,left);
	}
	
	
	
	
	
	public T getRootData() {
		T rootNode = null;
		if (root != null)
			rootNode = root.getData();
		return rootNode;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void clear() {
		root = null;
	} 	
	
	public boolean containsByRating(T entry) {
		return getEntryByRating(entry) != null;
	}
	
	public T getEntryByRating(T entry) {
		return findEntryByRating((BinaryNode<T>) getRoot(), entry);
	}

	private T findEntryByRating(BinaryNode<T> rootNode, T entry) {
		T result = null;
		
		if (rootNode != null) {
			
			Restaurant rootEntry = (Restaurant)rootNode.getData();
			if (entry.equals(rootEntry))
				result = (T)rootEntry;
			else if (rootEntry.getRating() < ((Restaurant)entry).getRating())
				result = findEntryByRating(rootNode.getLeftChild(), entry);
			else
				result = findEntryByRating(rootNode.getRightChild(), entry);
		}
		return result;
	}	
	
	// * * * * * * * * * * * * * * * * * * * * * * * *
	
	public T addByPrice(T newEntry) {
		T result = null;
		if (isEmpty())
			setRoot(new BinaryNode<>(newEntry));
		else
			result = addEntryByPrice(getRoot(), newEntry);
		return result;
	}
	
	private T addEntryByPrice(BinaryNode<T> rootNode,T newEntry) {
		assert rootNode != null;
		T result = null;
		Food newFood = (Food)rootNode.getData();
		
		if (newFood.getPrice() == ((Food)newEntry).getPrice()) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}
		else if (newFood.getPrice() < ((Food)newEntry).getPrice()) {
			if (rootNode.hasLeftChild())
				result = addEntryByPrice(rootNode.getLeftChild(), newEntry);
			else
				rootNode.setLeftChild(new BinaryNode<>(newEntry));
		}
		else {
			assert (newFood.getPrice() > ((Food)newEntry).getPrice());
			if (rootNode.hasRightChild())
				result = addEntryByPrice(rootNode.getRightChild(), newEntry);
			else
				rootNode.setRightChild(new BinaryNode<>(newEntry));
		}
		return result;
	}
	
	public T addByStock(T newEntry) {
		T result = null;
		if (isEmpty())
			setRoot(new BinaryNode<>(newEntry));
		else
			result = addEntryByStock(getRoot(), newEntry);
		return result;
	}
	
	private T addEntryByStock(BinaryNode<T> rootNode,T newEntry) {
		assert rootNode != null;
		T result = null;
		Food newFood = (Food)rootNode.getData();
		
		if (newFood.getStock() == ((Food)newEntry).getStock()) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}
		else if (newFood.getStock() < ((Food)newEntry).getStock()) {
			if (rootNode.hasLeftChild())
				result = addEntryByStock(rootNode.getLeftChild(), newEntry);
			else
				rootNode.setLeftChild(new BinaryNode<>(newEntry));
		}
		else {
			assert (newFood.getStock() > ((Food)newEntry).getStock());
			if (rootNode.hasRightChild())
				result = addEntryByStock(rootNode.getRightChild(), newEntry);
			else
				rootNode.setRightChild(new BinaryNode<>(newEntry));
		}
		return result;
	}
	
	public T addByRating(T newEntry) {
		T result = null;
		if (isEmpty())
			setRoot(new BinaryNode<>(newEntry));
		else if (this.contains(newEntry)) {
			return result;
		}
		else
			result = addEntryByRating(getRoot(), newEntry);
		return result;
	}
	
	private T addEntryByRating(BinaryNode<T> rootNode,T newEntry) {
		assert rootNode != null;
		T result = null;
		Restaurant newRestaurant = (Restaurant)rootNode.getData();
		
		if (newRestaurant.getRating() == ((Restaurant)newEntry).getRating()) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}
		else if (newRestaurant.getRating() < ((Restaurant)newEntry).getRating()) {
			if (rootNode.hasLeftChild())
				result = addEntryByRating(rootNode.getLeftChild(), newEntry);
			else
				rootNode.setLeftChild(new BinaryNode<>(newEntry));
		}
		else {
			assert (newRestaurant.getRating() > ((Restaurant)newEntry).getRating());
			if (rootNode.hasRightChild())
				result = addEntryByRating(rootNode.getRightChild(), newEntry);
			else
				rootNode.setRightChild(new BinaryNode<>(newEntry));
		}
		return result;
	}
	
	public T addByTime(T newEntry) {
		T result = null;
		if (isEmpty())
			setRoot(new BinaryNode<>(newEntry));
		else
			result = addEntryByTime(getRoot(), newEntry);
		return result;
	}
	
	private T addEntryByTime(BinaryNode<T> rootNode,T newEntry) {
		assert rootNode != null;
		T result = null;
		Restaurant newRestaurant = (Restaurant)rootNode.getData();
		
		if (newRestaurant.getDeliveryTime() == ((Restaurant)newEntry).getDeliveryTime()) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}
		else if (newRestaurant.getDeliveryTime() < ((Restaurant)newEntry).getDeliveryTime()) {
			if (rootNode.hasLeftChild())
				result = addEntryByTime(rootNode.getLeftChild(), newEntry);
			else
				rootNode.setLeftChild(new BinaryNode<>(newEntry));
		}
		else {
			assert (newRestaurant.getDeliveryTime() > ((Restaurant)newEntry).getDeliveryTime());
			if (rootNode.hasRightChild())
				result = addEntryByTime(rootNode.getRightChild(), newEntry);
			else
				rootNode.setRightChild(new BinaryNode<>(newEntry));
		}
		return result;
	}
	
	public void updatePriceTraversal(BinaryNode<Food> node) {
		if(node!=null) {
			updatePriceTraversal(node.getRightChild());
		    node.getData().updatePrice();
			updatePriceTraversal(node.getLeftChild());
		}
	}
	
	public void updateStockTraversal(BinaryNode<Food> node) {
		if(node!=null) {
			updateStockTraversal(node.getRightChild());
		    node.getData().updateStock();
		    updateStockTraversal(node.getLeftChild());
		}
	}
	
	
	public void inorderTraverseAscendingFood(BinaryNode<Food> node) {
		if(node!=null) {
			inorderTraverseAscendingFood(node.getRightChild());
			System.out.println(node.getData().getName() + "   -   " + node.getData().getPrice() + "   -   " + node.getData().getStock());
			inorderTraverseAscendingFood(node.getLeftChild());
		}
	}
	
	public void inorderTraverseDescendingFood(BinaryNode<Food> node) {
		if(node!=null) {
			inorderTraverseDescendingFood(node.getLeftChild());
			System.out.println(node.getData().getName() + "   -   " + node.getData().getPrice() + "   -   " + node.getData().getStock());
			inorderTraverseDescendingFood(node.getRightChild());
		}
	}
	
	public void inorderTraverseDescendingRestaurant(BinaryNode<Restaurant> node) {
		if(node!=null) {
			inorderTraverseDescendingRestaurant(node.getLeftChild());
			System.out.println(node.getData().getName() + "   -   " + node.getData().getRating() + "   -   " + node.getData().getCuisine());
			inorderTraverseDescendingRestaurant(node.getRightChild());
		}
	}
	
	public void removeFoodByPrice(BinaryNode<Food> node) {
		
	}
	
//	public BinaryNode<Restaurant> shortestDeliveryTimePizza(BinaryNode<Restaurant> rootNode) {
//		if (rootNode.hasLeftChild()) {
//			if (rootNode.getData().getCuisine().equals(" Pizza")) {
//				rootNode = shortestDeliveryTimePizza(rootNode.getLeftChild());
//			}
//			else
//				shortestDeliveryTimePizza(rootNode.getLeftChild());
//		}
//		return rootNode;
//	}
	
	public BinaryNode<Restaurant> shortestDeliveryTimePizza(BinaryNode<Restaurant> rootNode) {
		if (rootNode.hasLeftChild()) {
			if (rootNode.getData().getCuisine().equals(" Pizza")) {
				rootNode = shortestDeliveryTimePizza(rootNode.getLeftChild());
			}
			else
				shortestDeliveryTimePizza(rootNode.getLeftChild());
		}
		return rootNode;
	}
	
//	public BinaryNode<Food> removeByPrice(BinaryNode<Food> rootNode) {
//		if (rootNode != null) {
//			Food rootData = rootNode.getData();
//			double comparisonPrice = 80.0;
//			if (comparisonPrice >= rootData.getPrice()) {
//				BinaryNode<Food> rightChild = rootNode.getRightChild();
//				rootNode.setRightChild(removeByPrice(rightChild));
//			}
//			else if {
//				
//				
//			}
//		}
//	}
	
	


//		
////		Restaurant tempNode = null;
////		if(node!=null) {
////			shortestDeliveryTimePizza(node.getLeftChild());
////			if (node.getData().getCuisine().equals(" Pizza")) {
////				tempNode = node.getData();
////			}
////			shortestDeliveryTimePizza(node.getRightChild());
////		}
////		return (Restaurant) tempNode;
//		
//		BinaryNode<Restaurant> tempNode = node;
//		tempNode.setData(node.getData());
//		if(node!=null) {
//			shortestDeliveryTimePizza(node.getLeftChild());
//			shortestDeliveryTimePizza(node.getRightChild());
//			if (node.getData().getCuisine() == " Pizza") {
//				tempNode.setData(node.getData());
//			System.out.println(tempNode.getData().getCuisine());
//			}
//		}
//	}
	

	@Override
	// I already implemented this method with by different (byPrice, byStock...) options.
	public T add(T entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override 
	// I already implemented this method with both descending and ascending options.
	public void inorderTraverse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getEntry(T entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T entry) {
		// TODO Auto-generated method stub
		return false;
	}

}