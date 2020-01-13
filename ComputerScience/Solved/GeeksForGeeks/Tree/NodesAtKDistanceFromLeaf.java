//https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class GfG
{
    static int maxsize = 100;
    static int count;
    public static int printKDistantfromLeaf(Node node, int k)
    {
        int[] path = new int[maxsize];
        boolean[] visited = new boolean[maxsize];
        count =0;
        printKDistantfromLeafUtil(node,path,visited,k,0);
        return count;
    }
    
    public static void printKDistantfromLeafUtil(Node node,int[] path,boolean[] visited,int k,int pathLen){
        if(node == null){
            return;
        }
        path[pathLen]=node.data;
        visited[pathLen] = false; 
        pathLen++;
        
        if(node.left==null && node.right == null && pathLen-k-1>=0 && visited[pathLen-k-1]==false){
            count++;
            visited[pathLen-k-1]=true;
            return;
        }
        printKDistantfromLeafUtil(node.left,path,visited,k,pathLen);
        printKDistantfromLeafUtil(node.right,path,visited,k,pathLen);
    }
    
    
}