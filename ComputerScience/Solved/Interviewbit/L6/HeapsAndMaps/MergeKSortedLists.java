//https://www.youtube.com/watch?v=zLcNwcR6yO4
//https://www.interviewbit.com/problems/merge-k-sorted-lists/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> a) {
	    if(a==null||a.size()==0){
	        return null;
	    }
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(ListNode ln:a){
	        ListNode temp = ln;
	        while(temp!=null){
	            pq.add(temp.val);
	            temp=temp.next;
	        }
	    }
	    ListNode res=null;
	    while(!pq.isEmpty()){
	        res= addNode(pq.poll(),res);
	    }
	    return res;
	}
	public ListNode addNode(int val, ListNode node){
	    if(node==null){
	        return new ListNode(val);
	    }
	    ListNode temp = node;
	    ListNode newNode = new ListNode(val);
	    while(temp.next!=null){
	        temp = temp.next;
	    }
	    temp.next = newNode;
	    return node;
	}
}
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }
    
    private ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }
}
