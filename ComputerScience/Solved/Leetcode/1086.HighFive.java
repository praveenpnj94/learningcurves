//https://leetcode.com/problems/high-five/

class Solution {
    private int K;

    public int[][] highFive(int[][] items) {
        this.K = 5;
        TreeMap<Integer, Queue<Integer>> allScores = new TreeMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!allScores.containsKey(id))
                allScores.put(id, new PriorityQueue<>());
            // insert the score in the min heap
            allScores.get(id).add(score);
            // remove the minimum element from the min heap in case the size of the min heap exceeds 5 
            if (allScores.get(id).size() > this.K)
                allScores.get(id).poll();
        }

        List<int[]> solution = new ArrayList<>();

        for (int id : allScores.keySet()) {
            int sum = 0;
            // min heap contains the top 5 scores
            for (int i = 0; i < this.K; ++i)
                sum += allScores.get(id).poll();
            solution.add(new int[] {id, sum / this.K});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);
    }
}

class Solution {
    private int K;

    public int[][] highFive(int[][] items) {
        this.K = 5;
        TreeMap<Integer, Queue<Integer>> allScores = new TreeMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!allScores.containsKey(id))
                allScores.put(id, new PriorityQueue<>());
            // insert the score in the min heap
            allScores.get(id).add(score);
            // remove the minimum element from the min heap in case the size of the min heap exceeds 5 
            if (allScores.get(id).size() > this.K)
                allScores.get(id).poll();
        }

        List<int[]> solution = new ArrayList<>();

        for (int id : allScores.keySet()) {
            int sum = 0;
            // min heap contains the top 5 scores
            for (int i = 0; i < this.K; ++i)
                sum += allScores.get(id).poll();
            solution.add(new int[] {id, sum / this.K});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);
    }
}

class Solution {
    public int[][] highFive(int[][] items) {
        if(items==null||items.length==0||items[0].length==0){
            return new int[0][0];
        }
        Map<Integer,List<Integer>> m = new TreeMap<>();
        for(int[] s:items){
            int key = s[0];
            int val = s[1];
            if(m.containsKey(key)){
                List<Integer> l = m.get(key);
                l.add(val);
                m.put(key,l);
            }
            else{
                List<Integer> l = new ArrayList<>();
                l.add(val);
                m.put(key,l);
            }
        }
        int[][] res = new int[m.keySet().size()][2];
        int idx=0;
        for(Map.Entry<Integer,List<Integer>> entry: m.entrySet()){
            List<Integer> l = entry.getValue();
            Collections.sort(l,Collections.reverseOrder());
            int i=0;int sum=0;
            while(i<5 && i<l.size()){
                sum+=l.get(i);
                i++;
            }
            res[idx][0]=entry.getKey();
            res[idx][1]=sum/i;
            idx++;
        }
        return res;
    }
}