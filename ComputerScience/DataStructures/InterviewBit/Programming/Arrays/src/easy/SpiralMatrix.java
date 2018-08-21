/**
 * 
 */
package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author praveen
 * on 09-Aug-20188:35:30 PM
 */
public class SpiralMatrix {
	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int x=A.size();
        int y=A.get(0).size();
        int top=0;
        int bottom=x-1;
        int left=0;
        int right=y-1;
        int dir=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        while(left<=right && top<=bottom){
            if(dir==0){
                for(int i=left;i<=right;i++){
                    l.add(A.get(top).get(i));
                }
                top++;
            }
            else if(dir==1){
                for(int j=top;j<=bottom;j++){
                    l.add(A.get(j).get(right));
                }
                right--;
            }
            else if(dir==2){
                for(int k=right;k>=left;k--){
                    l.add(A.get(bottom).get(k));
                }
                bottom--;
            }
            else if(dir==3){
                for(int m=bottom;m>=top;m--){
                    l.add(A.get(m).get(left));
                }
                left++;
            }
            dir=(dir+1)%4;
        }
        return l;
    }
}
