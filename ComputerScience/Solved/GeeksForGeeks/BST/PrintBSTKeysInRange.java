//https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/


/*This is a function problem.You only need to complete the function given below*/
/* The structure of a BST node is as follows:
class Node
{
    int key;
    Node left, right;
    Node(int item)
    {
        key = item;
        left = right = null;
    }
} */
class GfG
{   
    void printNearNodes(Node root, int k1, int k2)
    {
        List<Integer> l = new ArrayList<Integer>();
        printNearNodesRecur(root,k1,k2,l);
        Collections.sort(l);
        for(int i:l){
            System.out.print(i+" ");
        }
    } 
    void printNearNodesRecur(Node root, int k1, int k2,List<Integer> l)
    {
        
        if(root==null){
            return;
        }
        if(root.key>=k1 && root.key<=k2){
            //System.out.print(root.key+" ");
            l.add(root.key);
        }
        if(root.key>k1 && root.key>k2){
            printNearNodesRecur(root.left,k1,k2,l);
        }
        else if(root.key<k1 && root.key<k2){
            printNearNodesRecur(root.right,k1,k2,l);
        }
        else{
            printNearNodesRecur(root.left,k1,root.key,l);
            printNearNodesRecur(root.right,root.key,k2,l);
        }
    }    
}
