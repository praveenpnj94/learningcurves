/* IMPORTANT: Multiple classes and nested static classes are supported */


//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        long testcases=s.nextLong();
        for(long i=0L;i<testcases;i++){
            int seat=s.nextInt();
            printDetails(seat);
        }

    }
    
    public static void printDetails(int seat){
        int rem=seat%12;
        int quot=seat/12;
        if(rem==0){
            rem=12;
        }
        int oppositeSeat=0;
        if(rem==12){
            oppositeSeat=12*(quot-1)+1;
        }
        else{
         oppositeSeat=12*quot+13-rem;   
        }
        String seatType="";
        if(rem==1||rem==6||rem==7||rem==12){
            seatType="WS";
        }
        else if(rem==2||rem==5||rem==8||rem==11){
            seatType="MS";
        }
        else{
            seatType="AS";
        }
        System.out.println(oppositeSeat+" "+seatType);
    }

}
