//https://www.interviewbit.com/problems/magician-and-chocolates/

public class Solution {
    public int nchoc(int time, ArrayList<Integer> arrayList) {
    double maximum = 0;
    //maximum heap
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(arrayList.size(), Collections.reverseOrder());
    priorityQueue.addAll(arrayList);
     
    for(int count=0; count<time; count++) {
        int element = priorityQueue.poll();
        maximum += element;
        priorityQueue.add((int) Math.floor(element/2));
    }
     
    return (int) (maximum%(Math.pow(10, 9)+7));
    }
}