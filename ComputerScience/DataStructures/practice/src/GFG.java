import java.io.*;
import java.util.*;
class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int testcases=sc.nextInt();
        while(testcases-->0)
        {
            int value=sc.nextInt();
            int numberOfCoins=sc.nextInt();
            int coins[]=new int[numberOfCoins];

            for(int i=0;i<numberOfCoins;i++)
            {
                int x=sc.nextInt();
                coins[i]=x;
            }
            Geeks obj=new Geeks();
            System.out.println(obj.numberOfWays(coins,numberOfCoins,value));
        }
    }
}



// } Driver Code Ends
//User function Template for Java


class Geeks
{
    //Complete this function
    public long numberOfWays(int coins[],int numberOfCoins,int value)
    {
        long ways[]=new long[value+1];
        ///We declare an array that will contain the number of--
        //ways to make change for all values from 0 to value
        //This is done as we are working from bottom up. So, obviously, we need to make change for smaller values--
        //before we can make change for the given values.

        ways[0]=1;//We can make change for 0 in 1 ways, that is by choosing nothing.

        for(int coin:coins)//Using a coin, one at a time
        {
            for(int i=1;i<value+1;i++)
            {
                if(i>=coin)//Since it makes no sense to create change for value smaller than coin's denomination
                {
                    //Write your code here
                    //We can make change for i by adding number of ways we previously made change for i-coin
                    ways[i]+=ways[i-coin];
                }
            }
        }
        return ways[value];
    }
}