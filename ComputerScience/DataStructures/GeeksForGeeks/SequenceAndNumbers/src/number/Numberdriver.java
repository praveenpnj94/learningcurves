/**
 * 
 */
package number;


/**
 * @author Praveen
 * on 08-Aug-2018 12:48:25 PM
 */
public class Numberdriver {
    public static void main(String[] args) {
        /**** code for testing Catalan Number *********/
        for (int i = 0; i < 5; i++) {
           //System.out.print(CatalanNumber.getCatalanNumber(i) + " ");
           System.out.print(CatalanNumber.getCatalanNumberUsingDynamicProgramming(i) + " ");
           //System.out.print(CatalanNumber.getCatalanNumberUsingBinaryCoefficient(i) + " ");
        }
         
        /************************************************/
    }
}
