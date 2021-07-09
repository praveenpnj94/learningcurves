//https://leetcode.com/problems/k-diff-pairs-in-an-array/
//https://www.youtube.com/watch?v=S1HZpd8Jhyw&feature=emb_logo&ab_channel=NareshGupta

class Solution {
    // public int findPairs(int[] nums, int k) {
    //     Set<Pair> set = new LinkedHashSet<>();
    //     Set<Integer> s = new HashSet<>();
    //     for(int i=0;i<nums.length;i++){
    //         int d1=nums[i]-k;
    //         int d2=nums[i]+k;
    //         if(s.contains(d1)){
    //             int a = d1;
    //             int b = nums[i];
    //             if(a>b){
    //                 int temp =a;
    //                 a=b;
    //                 b=temp;
    //             }
    //             set.add(new Pair(a,b));
    //             s.add(nums[i]);
    //         }
    //         if(s.contains(d2)){
    //             int a = d2;
    //             int b = nums[i];
    //             if(a>b){
    //                 int temp =a;
    //                 a=b;
    //                 b=temp;
    //             }
    //             set.add(new Pair(a,b));
    //             s.add(nums[i]);
    //         }
    //         else{
    //             s.add(nums[i]);
    //         }
    //     }
    //     return set.size();
    // }
    
//     public int findPairs(int[] nums, int k) {
//         if (k < 0) {
//             return 0;
//         }
        
//         Arrays.sort(nums);
        
//         int counter = 0;
        
//         int left = 0;
//         int right = 0;
        
//         HashSet<Integer> set = new HashSet<>();
        
//         while (right < nums.length) {
//             int s = nums[right] - nums[left];
            
//             if (s == k && left != right && !set.contains(nums[right])) {
//                 counter++;
//                 set.add(nums[right]);
                
//                 left++;
//                 right++;
//             } else if (s > k) {
//                 left++;
//             } else {
//                 right++;
//             }
//         }
        
//         return counter;
//     }
    
public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int cnt=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:map.keySet()){
            if(k==0){
                if(map.get(num)>1){
                    cnt++;
                }
            }
            else{
                if(map.containsKey(num+k)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
class Pair{
    int x;
    int y;
    
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
    
       @Override
    public boolean equals(Object obj) 
    { 
        Pair p = (Pair)obj;
        return p.x==this.x && p.y==this.y;
    }
    
    @Override
    public int hashCode() 
    { 
        return this.y*10+this.x; 
    } 
}