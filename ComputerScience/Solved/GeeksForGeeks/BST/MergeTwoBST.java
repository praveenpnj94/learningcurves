/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left, right;
	Node(int d){
		data=d;
		left=right=null;
	}
}*/
class GfG
{
	public static void merge(Node root1 , Node root2)
    {
            List<Integer> l1 = new ArrayList<Integer>();
            List<Integer> l2 = new ArrayList<Integer>();
            inorder(root1,l1);
            inorder(root2,l2);
            mergeTwoLists(l1,l2);
    }
    public static void inorder(Node root, List<Integer> l){
        if(root==null){
            return;
        }
        inorder(root.left,l);
        l.add(root.data);
        inorder(root.right,l);
    }
    public static void mergeTwoLists(List<Integer> l1,List<Integer> l2){
        List<Integer> res = new ArrayList<Integer>();
        int s1 = l1.size();
        int s2 = l2.size();
        int i = 0;
        int j = 0;
        while(i<s1 && j<s2){
            if(l1.get(i)<l2.get(j)){
                res.add(l1.get(i));
                i++;
            }
            else{
                res.add(l2.get(j));
                j++;
            }
        }
        while(i<s1){
                res.add(l1.get(i));
                i++;
        }
        while(j<s2){
                res.add(l2.get(j));
                j++;
        }
        for(int num:res){
            System.out.print(num+" ");
        }
        
    }
}
