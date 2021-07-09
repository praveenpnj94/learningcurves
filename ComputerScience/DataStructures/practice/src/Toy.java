/*  ACM Mid-Central Programming competition 2016 Problem ?: Building Toy
    solution by Andy Harrington
    recursive try of all permutations of lengths and ways to add on
*/

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Toy {
    static int n;
    static int maxSidesTriangle;
    static double[] xZero, yZero, xOne, yOne;
    static int[] length;
    static int CHECK = 0;
    static double checkMaxDistance = 0;
    static String bestResult = "";
    static double maxDistance,
            eps = -1E-3;
    public static void main(String[] args) throws Exception {
        if (args.length > 0) CHECK = Integer.parseInt(args[0]);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = br.readLine();
        if (CHECK >= 1) System.err.println(l);
        Scanner sc = new Scanner(l);
        n = sc.nextInt();
        length = new int[n];
        for (int i = 0; i < n; i++)
            length[i] = sc.nextInt();
        xZero = new double[n];
        yZero = new double[n];
        xOne = new double[n];
        yOne = new double[n];
        maxDistance = 0;
        maxSidesTriangle = n - (n+1)%2;
        System.out.println(permute(0));
        if(CHECK == 1) System.err.println(bestResult);
    }

    static void swap(int[] perm, int i, int j)
    {
        int temp = perm[i];
        perm[i] = perm[j];
        perm[j] = temp;
    }

    static double permute(int p)
    {
        if (p == maxSidesTriangle) {
            filter(p);
            return maxDistance;
        }
        for (int j = p; j < n; j++) {
            swap(length, p, j);
            if (p%2 == 1)
                permute(p+1);
            else if (p == 0 ) {
                xOne[0] = length[0];
                permute(1);
            }
            else {
                buildEdge(p-1, p-2);
                if (p > 3)
                    buildEdge(p-1, p-3);
            }
            swap(length, p, j);
        }
        return maxDistance;
    }

    static void buildEdge(int s, int e)
    {
        double d = length[e];
        double rOne = length[s], rTwo = length[s+1];
        double dx = xOne[e] - xZero[e], dy = yOne[e] - yZero[e];
        double E = (rOne*rOne - rTwo*rTwo + d*d)/(2*d);
        double inRadical = rOne*rOne - E*E;
        if (inRadical <= 0) {
            filter(s);
            return;
        }
        double f = sqrt(inRadical);

        for (int k = 0; k < 2; k++) {
            yOne[s] = yZero[s+1] = yZero[e] + (f*dx + E*dy)/d;
            if (yOne[s] <= eps)
                filter(s);
            else {
                if (yOne[s] > maxDistance)
                    maxDistance = yOne[s];
                xOne[s] = xZero[s+1] = xZero[e] + (E*dx - f*dy)/d;
                yZero[s] = yZero[e]; xZero[s] = xZero[e];
                xOne[s+1] = xOne[e]; yOne[s+1] = yOne[e];
                permute(s+2);
            }
            f = -f;
        }
    }

    static String segSequence(int V)
    {
        String s = "" + length[0];
        for (int i = 1; i < V; i += 2)
            s += "\n     " + xZero[i] + " " + yZero[i] + " " + xOne[i] + " " + yOne[i] +
                    " " + xOne[i+1] + " " + yOne[i+1];
        return s;
    }

    static void filter(int V)
    {
        if (CHECK == 0) return;
        double thisTop = 0;
        for (int i = 1; i < V; i += 2) {
            thisTop = max(thisTop, yOne[i]);
        }
        if (thisTop > checkMaxDistance) {
            checkMaxDistance = thisTop;
            bestResult = "Max: " + thisTop + " " + segSequence(V);
            if (CHECK >= 2) System.err.println(bestResult);
        }
    }

}
