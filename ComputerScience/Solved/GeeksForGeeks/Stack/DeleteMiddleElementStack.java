//https://www.geeksforgeeks.org/delete-middle-element-stack/

/*package whatever //do not write package name here */
import java.io.*;
import java.util.*;
class GFG {
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);

        int testcases=sc.nextInt();

        while(testcases-->0)
        {
            int sizeOfStack =sc.nextInt();

            Stack <Integer> myStack=new Stack<>();

            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);

            }

            if(sizeOfStack==1)
            {
                System.out.println(myStack.peek());
            }
            else
            {
                Geeks obj=new Geeks();
                Stack <Integer> modified=obj.deleteMid(myStack,sizeOfStack,0);

                while(!modified.isEmpty())
                {
                    System.out.print(modified.peek()+" ");
                    modified.pop();
                }
                System.out.println();
            }
        }


    }
}
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class Geeks
{
    //Complete this function
    public Stack<Integer> deleteMid(Stack<Integer>st,int sizeOfStack,int current)
    {
        // If stack is empty or all items 
        // are traversed 
        if (st.isEmpty() || current == sizeOfStack)
            return st;

        // Remove current item 
        int x = st.pop();

        // Remove other items 
        st = deleteMid(st, sizeOfStack, current+1);

        // Put all items back except middle 
        if (current != sizeOfStack/2)
            st.push(x);

        return st;

    }
}
