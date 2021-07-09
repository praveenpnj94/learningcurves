//https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> m1 = new LinkedHashMap<>();
        for (Integer n : nums1) m1.put(n,m1.getOrDefault(n,0)+1);
        Map<Integer,Integer> m2 = new LinkedHashMap<>();
        for (Integer n : nums2) m2.put(n,m2.getOrDefault(n,0)+1);

        List<Integer> al = new ArrayList<>();
        for(int a:m1.keySet()){
            if(m2.containsKey(a)){
                int x= m1.get(a);
                int y = m2.get(a);
                int cnt = x>y?y:x;
                for(int i=0;i<cnt;i++){
                    al.add(a);
                }
            }
        }

        int [] output = new int[al.size()];
        int idx = 0;
        for (int a : al) output[idx++] = a;
        return output;
    }
}