//https://leetcode.com/problems/next-greater-element-i/
//https://www.youtube.com/watch?v=8BDKB2yuGyg&ab_channel=NickWhite

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // if (nums1 == null || nums1.length == 0) {
        //     return nums1;
        // }
        // int n = nums2.length;
        // Stack <Integer> st = new Stack < > ();
        // HashMap < Integer, Integer > map = new HashMap < > ();
        // for (int i = n - 1; i >= 0; i--) {
        //     if (st.isEmpty()) {
        //         map.put(nums2[i], -1);
        //         st.push(nums2[i]);
        //     } else {
        //         while (!st.isEmpty() && st.peek() <= nums2[i]) {
        //             st.pop();
        //         }
        //         if (st.isEmpty()) {
        //             map.put(nums2[i], -1);
        //             st.push(nums2[i]);
        //         } else {
        //             int num = st.peek();
        //             map.put(nums2[i], num);
        //             st.push(nums2[i]);
        //         }
        //     }
        // }
        // int[] res = new int[nums1.length];
        // for (int j = 0; j < nums1.length; j++) {
        //     res[j] = map.get(nums1[j]);
        // }
        // return res;
        
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}