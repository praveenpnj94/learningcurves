//https://www.interviewbit.com/problems/fizzbuzz/

public class Solution {
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> al =new ArrayList<String>();
        for(int i=1;i<=A;i++){
            if(i%15){
                al.add("FizzBuzz");
            }
            else if(i%5){
                al.add("Buzz");
            }
            else if(i%3){
                al.add("Fizz");
            }
            else{
                al.add(String.valueOf(i));
            }
        }
        return al;
    }
}
