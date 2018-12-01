public class Solution {
    public String convertToTitle(int A) {
        int columnNumber = A;
        StringBuilder columnName = new StringBuilder(); 
  
        while (columnNumber > 0) 
        { 
            // Find remainder 
            int rem = columnNumber % 26; 
  
            // If remainder is 0, then a  
            // 'Z' must be there in output 
            if (rem == 0) 
            { 
                columnName.append("Z"); 
                columnNumber = (columnNumber / 26) - 1; 
            } 
            else // If remainder is non-zero 
            { 
                columnName.append((char)((rem - 1) + 'A')); 
                columnNumber = columnNumber / 26; 
            } 
        }
        return columnName.reverse().toString();
    }
}
