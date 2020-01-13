//https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/


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
} */
class Tree
{
    // /* Function to get the maximum width of a binary tree*/
    int getMaxWidth(Node root)
    {
        // Base case 
        if (root == null) 
            return 0; 
          
        // Initialize result 
        int maxwidth = 0; 
          
        // Do Level order traversal keeping  
        // track of number of nodes at every level 
        Queue<Node> q = new LinkedList<>(); 
        q.add(root); 
        while (!q.isEmpty())  
        { 
            // Get the size of queue when the level order 
            // traversal for one level finishes 
            int count = q.size(); 
              
            // Update the maximum node count value 
            maxwidth = Math.max(maxwidth, count); 
              
            // Iterate for all the nodes in  
            // the queue currently 
            while (count-- > 0)  
            { 
                // Dequeue an node from queue 
                Node temp = q.remove(); 
              
                // Enqueue left and right children  
                // of dequeued node 
                if (temp.left != null)  
                { 
                    q.add(temp.left); 
                } 
                if (temp.right != null)  
                { 
                    q.add(temp.right); 
                } 
            } 
        } 
        return maxwidth; 
    }
    int getMaxWidth2(Node node)  
    { 
        int maxWidth = 0; 
        int width; 
        int h = height(node); 
        int i; 
   
        /* Get width of each level and compare  
           the width with maximum width so far */
        for (i = 1; i <= h; i++)  
        { 
            width = getWidth(node, i); 
            if (width > maxWidth) 
                maxWidth = width; 
        } 
   
        return maxWidth; 
    } 
   
    /* Get width of a given level */
    int getWidth(Node node, int level)  
    { 
        if (node == null) 
            return 0; 
   
        if (level == 1) 
            return 1; 
        else if (level > 1) 
            return getWidth(node.left, level - 1) 
                    + getWidth(node.right, level - 1); 
        return 0; 
    }

}
