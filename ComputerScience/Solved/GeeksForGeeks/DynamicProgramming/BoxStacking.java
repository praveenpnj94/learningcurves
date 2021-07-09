//https://practice.geeksforgeeks.org/problems/box-stacking/1#
//https://www.thealgorists.com/Algo/DynamicProgramming/LongestIncreasingSubsequence/BoxStacking
//https://www.youtube.com/watch?v=9mod_xRB-O0

class Geeks 
{
    public static int maxHeight(int height[], int width[], int length[], int n)
   {
       if(n==0){
           return 0;
       }
       Box[] box = new Box[3*n];
       
       int idx = 0;
       for(int i=0;i<n;i++){
           box[idx] = new Box();
           box[idx].l=Math.max(length[i],width[i]);
           box[idx].w=Math.min(length[i],width[i]);
           box[idx].h=height[i];
           
           idx++;
           box[idx] = new Box();
           box[idx].l=Math.max(height[i],width[i]);
           box[idx].w=Math.min(height[i],width[i]);
           box[idx].h=length[i];
           
           idx++;
           box[idx] = new Box();
           box[idx].l=Math.max(height[i],length[i]);
           box[idx].w=Math.min(height[i],length[i]);
           box[idx].h=width[i];
           
           idx++;
       }
       int N = 3*n;
       int[] heights = new int[N];
       
        Arrays.sort(box,new BoxComparator());
       
        int maxHeight = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j <i; j++){
                if(box[j].w > box[i].w 
                      && box[j].l > box[i].l){
    
                    heights[i] = Math.max(heights[i],heights[j]);
                }
            }
            heights[i]+= box[i].h;
        
            maxHeight = Math.max(maxHeight, heights[i]);
        }
    
        return maxHeight;
       
   }
}
class Box{
    int l;
    int w;
    int h;
    
}
class BoxComparator implements Comparator<Box>{
    
    public int compare(Box b1, Box b2){
        return b2.l*b2.w - b1.l*b1.w;
        
    }
}