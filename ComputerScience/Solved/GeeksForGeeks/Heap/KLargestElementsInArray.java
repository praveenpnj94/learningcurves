//https://leetcode.com/problems/kth-largest-element-in-an-array/solution/
//https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/


public class FindMaxKElementInArray {
    public static void main(String[] args) {
        int[] array = new int[] {4, 10, 3, 5, 1};
        System.out.println(new FindMaxKElementInArray().findKthLargest(array, 2));
    }
 
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int i : nums) {
            q.offer(i);
 
            if (q.size() > k) {
                q.poll();
            }
        }
        System.out.println(q); //To print all k Largest elements
        return q.peek(); //To print kth Largest element
    }
}