
import java.io.*;
import java.util.*;
import java.util.LinkedList;

class GFG
{

    public static void main(String args[])
    {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(-4);
        l.add(3);
        ArrayList<Integer> m = new ArrayList<>();
        m.add(-2);
        m.add(-2);
        merge(l,m);
    }


    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i=0;int j=0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) > b.get(j)) {
                a.add(i, b.get(j));
                i++;
                j++;
            } else {
                i++;
            }
        }

        while (j < b.size()) {
            a.add(b.get(j));
            j++;
        }
        System.out.println(a);
    }
}