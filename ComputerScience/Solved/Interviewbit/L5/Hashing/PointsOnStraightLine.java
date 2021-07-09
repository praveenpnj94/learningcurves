//https://www.interviewbit.com/problems/points-on-the-straight-line/

public class Solution {
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a==null||b==null||a.size()==0||b.size()==0){
            return 0;
        }
        int m = a.size();
        int n= b.size();
        int x=0;
        int[][] input = new int[m][2];
        for(int i=0;i<a.size();i++){
            input[x][0]=a.get(i);
            input[x][1]=b.get(i);
            x++;
        }
        return maxPoints(input);
    }
    
    public int maxPoints(int[][] points) {
        if (points == null||points.length==0) return 0;
        
        int solution = 0;
        
        for (int i = 0; i < points.length; i++)
        {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++)
            {
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];
                
                if (deltaX == 0 && deltaY == 0)
                {
                    duplicate++;
                    continue;
                }
                
                int gcd = gcd(deltaX, deltaY);
                int dX = deltaX / gcd;
                int dY = deltaY / gcd;
                
                map.put(dX + "," + dY, map.getOrDefault(dX + "," + dY, 0) + 1);
                max = Math.max(max, map.get(dX + "," + dY));
            }
            
            solution = Math.max(solution, max + duplicate + 1);
        }
        
        return solution;
    }
    
    public int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
}
