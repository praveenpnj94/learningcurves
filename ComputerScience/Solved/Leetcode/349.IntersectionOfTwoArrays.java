//https://leetcode.com/problems/intersection-of-two-arrays/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        List<Integer> al = new ArrayList<>();
        for(int a:set1){
            if(set2.contains(a)){
                al.add(a);
            }
        }

        int [] output = new int[al.size()];
        int idx = 0;
        for (int a : al) output[idx++] = a;
        return output;
    }
}