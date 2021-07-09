//https://www.interviewbit.com/problems/copy-list/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if(head==null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode original = head;
        RandomListNode clone = null;
        while(original!=null){
            clone = new RandomListNode(original.label);
            map.put(original,clone);
            original = original.next;
        }
        original = head;
        while(original!=null){
            clone = map.get(original);
            clone.next = map.get(original.next);
            clone.random = map.get(original.random);
            original = original.next;
        }
        return map.get(head) ;
    }
}
