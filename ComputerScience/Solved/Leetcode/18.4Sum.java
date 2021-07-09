//https://leetcode.com/problems/4sum/
//https://www.youtube.com/watch?v=bixvM1-28us&ab_channel=GoodTecher
//https://www.youtube.com/watch?v=zAA8M-a314s&ab_channel=LogicToCode

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j!=i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int l = j+1;
                int r = nums.length-1;
                while(l<r){
                    int sum = nums[l]+nums[r]+nums[j]+nums[i];
                    if(sum<target){
                        l++;
                    }
                    else if(sum>target){
                        r--;
                    }
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[l]);
                        quad.add(nums[r]);
                        res.add(quad);
                        
                        l++;
                        r--;
                        
                        while(l<r && nums[l]==nums[l-1]){
                            l++;
                        }
                        
                        while(l<r && nums[r]==nums[r+1]){
                            r--;
                        }              
                    }
                }
            }
        }
        return res;
    }
}


/*** */

public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, 0, 4, target);
}
private List<List<Integer>> kSum (int[] nums, int start, int k, int target) {
    int len = nums.length;
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(k == 2) { //two pointers from left and right
        int left = start, right = len - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                List<Integer> path = new ArrayList<Integer>();
                path.add(nums[left]);
                path.add(nums[right]);
                res.add(path);
                while(left < right && nums[left] == nums[left + 1]) left++;
                while(left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            } else if (sum < target) { //move left
                left++;
            } else { //move right
                right--;
            }
        }
    } else {
        for(int i = start; i < len - (k - 1); i++) {
            if(i > start && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
            for(List<Integer> t : temp) {
               t.add(0, nums[i]);
            }                    
            res.addAll(temp);
        }
    }
    return res;
}



class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            // if(i!=0 && nums[i]==nums[i-1]){
            //     continue;
            // }
            for(int j=i+1;j<nums.length-2;j++){
                // if(j!=i+1 && nums[j]==nums[j-1]){
                //     continue;
                // }
                int l = j+1;
                int r = nums.length-1;
                while(l<r){
                    int sum = nums[l]+nums[r]+nums[j]+nums[i];
                    if(sum<target){
                        l++;
                    }
                    else if(sum>target){
                        r--;
                    }
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[l]);
                        quad.add(nums[r]);
                        if(!res.contains(quad)){
                            res.add(quad);
                        }
                        
                        l++;
                        r--;
                        
//                         while(l<r && nums[l]==nums[l-1]){
//                             l++;
//                         }
                        
//                         while(l<r && nums[r]==nums[r+1]){
//                             r--;
//                         }              
                    }
                }
            }
        }
        return res;
    }
}