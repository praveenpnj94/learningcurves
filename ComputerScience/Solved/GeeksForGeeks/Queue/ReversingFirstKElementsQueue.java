//https://www.geeksforgeeks.org/reversing-first-k-elements-queue/

class GfG
{
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
      int n = q.size();
      int rem = n-k;
      Stack<Integer> s = new Stack<>();
      for(int i=0;i<k;i++){
          s.push(q.peek());
          q.remove();
      }
      while(!s.isEmpty()){
          q.add(s.pop());
      }
      for(int j=0;j<rem;j++){
          int t = q.peek();
          q.remove();
          q.add(t);
      }
      return q;
    }
}
