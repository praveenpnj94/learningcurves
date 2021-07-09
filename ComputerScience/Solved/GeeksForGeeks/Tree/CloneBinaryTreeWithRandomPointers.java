//https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
//https://www.techiedelight.com/clone-a-binary-tree-with-random-pointers/

/*Complete the function below
Node is as follows:
class Tree{
	int data;
	Tree left,right,random;
	Tree(int d){
		data=d;
		left=null;
		right=null;
		random=null;
	}
}*/
class GfG{
    public static Tree cloneTree(Tree tree){
        if(tree == null){
            return null;
        }
        		// create a map to store mappings from a node to its clone
		Map<Tree, Tree> map = new HashMap<>();

		// clone data, left and right pointers for each node of the original
		// binary tree and put references into the map
		cloneLeftRightPointers(tree, map);

		// update random pointers from the original binary tree into the map
		updateRandomPointers(tree, map);

		// return the cloned root node
		return map.get(tree);
     }
     
     
     	// Recursive function to copy random pointers from the original binary tree
	// into the cloned binary tree using the map
	public static void updateRandomPointers(Tree root, Map<Tree, Tree> map)
	{
		// base case
		if (map.get(root) == null) {
			return;
		}

		// update the random pointer of cloned node
		map.get(root).random = map.get(root.random);

		// recur for left and right subtree
		updateRandomPointers(root.left, map);
		updateRandomPointers(root.right, map);
	}

	// Recursive function to clone the data, left and right pointers for
	// each node of a binary tree into a given map
	public static Tree cloneLeftRightPointers(Tree root, Map<Tree, Tree> map)
	{
		// base case
		if (root == null) {
			return null;
		}

		// clone all fields of the root node except the random pointer

		// create a new node with same data as root node
		map.put(root, new Tree(root.data));

		// clone the left and right subtree
		map.get(root).left = cloneLeftRightPointers(root.left, map);
		map.get(root).right = cloneLeftRightPointers(root.right, map);

		// return cloned root node
		return map.get(root);
	}
}