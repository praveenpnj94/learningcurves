//https://leetcode.com/problems/the-skyline-problem/
//https://github.com/mission-peace/interview/blob/master/src/com/interview/geometry/SkylineDrawing.java
//https://www.youtube.com/watch?v=GSBLe8cKu0s&ab_channel=TusharRoy-CodingMadeSimple

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if(buildings==null||buildings.length==0){
            return result;
        }
        int index=0;
        int n = buildings.length;
        BuildingPoint[] bp = new BuildingPoint[2*n];
        for(int[] b:buildings){
            bp[index]=new BuildingPoint();
            bp[index].x=b[0];
            bp[index].height=b[2];
            bp[index].isStart=true;
            
            bp[index+1]=new BuildingPoint();
            bp[index+1].x=b[1];
            bp[index+1].height=b[2];
            bp[index+1].isStart=false;            
            index+=2;            
        }
        Arrays.sort(bp,new BuildingComparator());
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        map.put(0,1);
        int prevMaxHeight = 0;
        for(BuildingPoint point :bp){
            if(point.isStart){
                map.put(point.height,map.getOrDefault(point.height,0)+1);
            }
            else{
                Integer count = map.get(point.height);
                if(count==1){
                    map.remove(point.height);
                }
                else{
                    map.put(point.height,count-1);
                }
            }
            int currMax = map.lastKey();
            if(prevMaxHeight!=currMax){
                prevMaxHeight = currMax;
                List<Integer> list = new ArrayList<>();
                list.add(point.x);
                list.add(currMax);
                result.add(list);
            }
        }

        return result;
    }
}
class BuildingPoint{
    int x;
    int height;
    boolean isStart;
}
class BuildingComparator implements Comparator<BuildingPoint>{
    
    @Override
    public int compare(BuildingPoint bp1,BuildingPoint bp2){
        if(bp1.x!=bp2.x){
            return bp1.x-bp2.x;
        }
        else{
            if(bp1.isStart && bp2.isStart){
                return bp2.height-bp1.height;
            }
            else if(!bp1.isStart && !bp2.isStart){
                return bp1.height-bp2.height;
            }
            else{
                if(bp1.isStart){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        }
    }
}