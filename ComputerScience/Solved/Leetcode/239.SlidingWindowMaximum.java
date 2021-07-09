//https://leetcode.com/problems/sliding-window-maximum/
//https://www.youtube.com/watch?v=39grPZtywyQ&ab_channel=IDeserve
//https://www.youtube.com/watch?v=XDJKHtXJHBY&ab_channel=ApniKaksha

class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || a.length <= 1) {
			return a;
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			if (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
    }
}