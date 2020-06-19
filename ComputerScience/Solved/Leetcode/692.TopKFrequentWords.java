//https://leetcode.com/problems/top-k-frequent-words/
//https://leetcode.com/discuss/interview-question/542597/
//Top K Frequently Mentioned Keywords

class Solution {
    // public List<String> topKFrequent(String[] words, int k) {
    //     HashMap<String,Integer> m = new HashMap<>();
    //     for(String s:words){
    //         m.put(s,m.getOrDefault(s,0)+1);
    //     }
    //     List<String> ls = new ArrayList<>(m.keySet());
    //     Collections.sort(ls, (a,b)-> (m.get(a)).equals(m.get(b))?a.compareTo(b):m.get(b)-m.get(a));
    //     return ls.subList(0,k);
    // }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w2, w1) -> count.get(w1).equals(count.get(w2)) ?
                w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
        }

        List<String> ans = new ArrayList();
        for(int i=0;i<k;i++){
            ans.add(heap.poll());
        }
        return ans;
    }
}