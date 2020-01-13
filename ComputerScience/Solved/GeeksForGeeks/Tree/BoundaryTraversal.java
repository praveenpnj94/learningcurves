//https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/


/*This is a function problem.You only need to complete the function given below*/
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class GfG
{
	void printBoundary(Node node)
	{
	    if(node == null){
	        return;
	    }
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		List<Integer> leaf = new ArrayList<>();
		System.out.print(node.data+" ");
		leftBdr(node.left,left);
		rightBdr(node.right,right);
		leaf(node,leaf);
		Collections.reverse(right);
		for(int a:left){
		    System.out.print(a+" ");
		}
		for(int b:leaf){
		    System.out.print(b+" ");
		}
		for(int c:right){
		    System.out.print(c+" ");
		}
	}
	void leftBdr(Node node,List<Integer> l){
	    if(node == null){
	        return;
	    }
	    if(node.left!=null){
	        l.add(node.data);
	        leftBdr(node.left,l);
	    }
	    else if(node.right!=null){
	        l.add(node.data);
	        leftBdr(node.right,l);
	    }
	}
	void rightBdr(Node node,List<Integer> l){
	    if(node == null){
	        return;
	    }
	    if(node.right!=null){
	        l.add(node.data);
	        rightBdr(node.right,l);
	    }
	    else if(node.left!=null){
	        l.add(node.data);
	        rightBdr(node.left,l);
	    }
	}
	void leaf(Node node,List<Integer> l){
	    if(node == null){
	        return;
	    }
	    leaf(node.left,l);
	    if(node.left==null && node.right==null){
	        l.add(node.data);
	    }
	    leaf(node.right,l);
	}
}