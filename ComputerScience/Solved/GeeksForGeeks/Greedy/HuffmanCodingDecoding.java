//https://www.techiedelight.com/huffman-coding/
//https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/

//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;
class minHeapNode {
    char data;
    int freq;
    minHeapNode left, right;
    minHeapNode(char data, int freq){
        left = right = null;
        this.data = data;
        this.freq = freq;
    }
}
class heapComparator implements Comparator<minHeapNode> {
    public int compare(minHeapNode h1, minHeapNode h2) {
        if (h1.freq < h2.freq) {
            return 1;
        } else if (h1.freq > h2.freq) {
            return -1;
        }
        return 0;
    }
}
class GFG {

    static PriorityQueue<minHeapNode> heapq;
    static HashMap<Character, Integer> freqMap;
    static HashMap<Character, String> codes;

    static void storeCodes(minHeapNode root, String str) {
        if(root==null)return;
        if(root.data != '$')codes.put(root.data, str);
        storeCodes(root.left, str + "0");
        storeCodes(root.right, str + "1");
    }

    static void encodeString(){
        minHeapNode left, right, top;
        for (Map.Entry<Character, Integer> val:freqMap.entrySet()) {
            heapq.add(new minHeapNode(val.getKey(), val.getValue()));
        }
        while (heapq.size() != 1) {
            left = heapq.poll();
            right = heapq.poll();
            top = new minHeapNode('$', left.freq + right.freq);
            top.left = left;
            top.right = right;
            heapq.add(top);
        }
        storeCodes(heapq.peek(), "");
    }

    static void calcFreq(String str) {
        for (int i=0; i<str.length(); i++) {
            Integer j = freqMap.get(str.charAt(i));
            freqMap.put(str.charAt(i), (j == null) ? 1 : j + 1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String str = br.readLine().trim();
            heapq = new PriorityQueue<minHeapNode>(new heapComparator());
            codes = new HashMap<Character, String>();
            freqMap = new HashMap<Character, Integer>();
            String encodedString = "";
            calcFreq(str);
            encodeString();
            for(int i=0; i<str.length(); i++){
                encodedString+=codes.get(str.charAt(i));
            }
            Txt g = new Txt();
            System.out.println(g.decodeString(heapq.peek(), encodedString));
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class Txt {
    // your required to complete this function
    // this function should return the encoded string
    // see the main function for the minHeapNode reference
    String decodeString(minHeapNode root, String S){
        StringBuilder output = new StringBuilder();
        minHeapNode base = root;
        while (!S.isEmpty()){
            if (S.charAt(0) == '1'){
                base = base.right;
                S = S.substring(1);
            }
            else {
                base = base.left;
                S = S.substring(1);
            }
            if (base.left == null && base.right == null){
                output.append(base.data);
                base = root;
            }

        }
        return output.toString();
    }
}
