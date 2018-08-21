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
        int num=s.nextInt();
        for(int i=2;i<num;i++){
            if(i==2){
                System.out.print(i+" ");
            }
            else{
                printPrimeNumbers(i);
            }
        }

    }
    
    public static void printPrimeNumbers(int number){
        for(int i=2;i<number;i++){
            if(number%i==0){
                return;
            }
        }
        System.out.print(number+" ");
    }
    
    
}
