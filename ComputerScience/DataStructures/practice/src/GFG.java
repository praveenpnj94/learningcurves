

import java.io.*;
import java.util.*;

public class GFG {
    public static int compress(char[] chars) {
        int i=0;
        if(chars==null||chars.length==0){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        while(i<chars.length){
            int j=i;
            while(j<chars.length && chars[j]==chars[i]){
                j++;
            }
            int count = j-i;
            sb.append(chars[i]);
            if(count>1){
                sb.append(count+"");
            }
            i=j;
        }
        return sb.length();
    }


    public static void main(String[] args) {
        char[] c = {'a','a','b','b','c','c','c'};
        System.out.println(compress(c));
    }
}
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x =x;
        this.y =y;
    }
}