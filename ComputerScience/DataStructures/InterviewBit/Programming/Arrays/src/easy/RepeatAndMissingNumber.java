/**
 * 
 */
package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author praveen
 * on 17-Aug-20181:09:14 AM
 */
public class RepeatAndMissingNumber {
    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        
        List<Integer> unsorted= A;
        Collections.sort(unsorted);
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(long i=0;i<unsorted.size()-1;i++){
            if(unsorted.get((int)i)==unsorted.get((int)i+1)){
                l.add(unsorted.get((int)i));
                l.add(unsorted.get((int)i)+1);
                break;
            }
        }
        return l;
    }
}
