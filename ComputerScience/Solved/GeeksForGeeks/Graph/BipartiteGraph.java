//https://www.geeksforgeeks.org/bipartite-graph/

/*Complete the function below*/
class GfG
{
	  boolean isBipartite(int G[][],int V)
      {
          int[] col = new int[V];
          Arrays.fill(col,-1);
          for(int i=0;i<V;i++){
              if(col[i]==-1){
                  if(util(G,i,col,V)==false){
                      return false;
                  }
              }
          }
          return true;
       }
       
       boolean util(int G[][],int i,int[] col,int V){
           col[i]=1;
           Queue<Integer> q = new LinkedList<>();
           q.add(i);
           while(!q.isEmpty()){
               int u = q.poll();
            // Return false if there is a self-loop  
            if (G[u][u] == 1) 
               return false;   
       
             // Find all non-colored adjacent vertices 
            for (int v = 0; v < V; v++) 
            { 
                // An edge from u to v exists and 
                // destination v is not colored 
                if (G[u][v] ==1 && col[v] == -1) 
                { 
                    // Assign alternate color to this 
                    // adjacent v of u 
                    col[v] = 1 - col[u]; 
                    q.add(v); 
                } 
       
                // An edge from u to v exists and  
                // destination v is colored with same 
                // color as u 
                else if (G[u][v] ==1 && col[v] ==  
                                         col[u]) 
                    return false; 
            }
           }
           return true;
       }
}