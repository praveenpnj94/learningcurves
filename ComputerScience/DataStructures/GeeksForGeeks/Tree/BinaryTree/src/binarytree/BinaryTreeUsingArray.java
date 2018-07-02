/**
 * 
 */
package binarytree;

/**
 * @author praveen on 01-Jul-2018 11:01:31 PM 2018
 */
public class BinaryTreeUsingArray {

    static int root = 0;
    static String[] str = new String[10];

    public void setRoot(String key) {
        str[0] = key;
    }

    public void setLeft(int i, String key) {
        int index = 2 * i + 1;
        str[index] = key;
    }

    public void setRight(int i, String key) {
        int index = 2 * i + 2;
        str[index] = key;
    }

    public void printTree() {
        for (int i = 0; i < str.length; i++) {
            if (str[i] != null) {
                System.out.print(str[i]+" ");
            }
        }
    }

}
