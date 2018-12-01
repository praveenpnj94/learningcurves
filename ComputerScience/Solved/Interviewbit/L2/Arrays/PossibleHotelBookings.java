//https://www.interviewbit.com/problems/hotel-bookings-possible/
//https://www.geeksforgeeks.org/find-k-bookings-possible-given-arrival-departure-times/

public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int roomsRequired=0,i=0,j=0;
        while(i<arrive.size()  && j<depart.size() && roomsRequired<=K){
            if(arrive.get(i)<depart.get(j) ){
                i++;
                roomsRequired++;
            }else{
                j++;
                roomsRequired--;
            }
        }
        if(roomsRequired<=K){
            return true;
        }else{
            return false;
        }
    }
}