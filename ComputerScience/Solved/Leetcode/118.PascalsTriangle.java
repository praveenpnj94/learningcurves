//https://leetcode.com/problems/pascals-triangle/

// class Solution {
//     int[][] arr = new int[1000][1000];
//     public List<List<Integer>> generate(int numRows) {
//         List<List<Integer>> list = new ArrayList<>();
//         for(int i=1;i<=numRows;i++){
//             list.add(util(i));
//         }
//         return list;
//     }
//     public List<Integer> util(int n){
//         List<Integer> al = new ArrayList<>();
//         for(int i=1;i<=n;i++){
//             al.add(helper(n,i));
//         }
//         return al;
//     }
//     public int helper(int i, int j){
//         if(j==1||j==i){
//             return arr[i][j]=1;
//         }
//         if(arr[i][j]!=0){
//             return arr[i][j];
//         }
//         return arr[i][j]=helper(i-1,j-1)+helper(i-1,j);
//     }
// }

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}