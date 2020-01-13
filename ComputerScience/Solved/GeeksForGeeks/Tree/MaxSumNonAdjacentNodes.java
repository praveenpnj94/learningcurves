//https://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/
class GFG
{
    static int getMaxSum(Node node)
    {
        if (node == null)  
            return 0;  
        HashMap<Node,Integer> mp=new HashMap<>(); 
        return getMaxSumUtil(node, mp); 
    }
    
    public static int getMaxSumUtil(Node node, HashMap<Node,Integer> mp)  
    {  
        if (node == null)  
            return 0;  
    
        // If node is already processed then return calculated  
        // value from map  
        if(mp.containsKey(node)) 
            return mp.get(node); 
    
        //  take current node value and call for all grand children  
        int incl = node.data + sumOfGrandChildren(node, mp);  
    
        //  don't take current node value and call for all children  
        int excl = getMaxSumUtil(node.left, mp) +  
                   getMaxSumUtil(node.right, mp);  
    
        //  choose maximum from both above calls and store that in map  
        mp.put(node,Math.max(incl, excl));  
    
        return mp.get(node);  
    }
    
    public static int sumOfGrandChildren(Node node, HashMap<Node,Integer> mp)  
    {  
        int sum = 0;  
        //  call for children of left child only if it is not NULL  
        if (node.left!=null)  
            sum += getMaxSumUtil(node.left.left, mp) +  
                   getMaxSumUtil(node.left.right, mp);  
    
        //  call for children of right child only if it is not NULL  
        if (node.right!=null)  
            sum += getMaxSumUtil(node.right.left, mp) +  
                   getMaxSumUtil(node.right.right, mp);  
        return sum;  
    } 

    static int getMaxSum(Node root)
    {
        // add your code here
        if(root==null)
        return 0;
        if(root.left==null&&root.right==null)
        return root.data;
        if(root.left==null)
        return Math.max(root.data+getMaxSum(root.right.right)+getMaxSum(root.right.left),getMaxSum(root.left)+getMaxSum(root.right));
        if(root.right==null)
        return Math.max(root.data+getMaxSum(root.left.right)+getMaxSum(root.left.left),getMaxSum(root.left)+getMaxSum(root.right));
    
        int k=getMaxSum(root.left.left)+getMaxSum(root.right.right)+getMaxSum(root.left.right)+getMaxSum(root.right.left);
        return Math.max(root.data+k,getMaxSum(root.left)+getMaxSum(root.right));
       
        
    }
}