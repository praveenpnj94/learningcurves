/**
 * 
 */
package number;


/**
 * @author Praveen
 * on 08-Aug-2018 2:23:46 PM
 */
public class BinaryCoefficient {
    public static long getBinaryCoefficient(int n,int k) {
        long res=1;
        for(int i=0;i<k;i++) {
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
}
