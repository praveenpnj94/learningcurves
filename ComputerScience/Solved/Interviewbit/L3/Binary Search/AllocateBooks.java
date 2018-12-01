//https://www.interviewbit.com/problems/allocate-books/
//https://www.geeksforgeeks.org/allocate-minimum-number-pages/

public class Solution {
    public int books(ArrayList<Integer> arr, int m) {
        long sum = 0; 
        int n= arr.size();
       
        // return -1 if no. of books is less than 
        // no. of students 
        if (n < m) 
            return -1; 
       
        // Count total number of pages 
        for (int i = 0; i < n; i++) 
            sum += arr.get(i); 
       
        // initialize start as 0 pages and end as 
        // total pages 
        int start = 0, end = (int) sum; 
        int result = Integer.MAX_VALUE; 
       
        // traverse until start <= end 
        while (start <= end) 
        { 
            // check if it is possible to distribute 
            // books by using mid is current minimum 
            int mid = (start + end) / 2; 
            if (isPossible(arr, n, m, mid)) 
            { 
                // if yes then find the minimum distribution 
                result = Math.min(result, mid); 
       
                // as we are finding minimum and books 
                // are sorted so reduce end = mid -1 
                // that means 
                end = mid - 1; 
            } 
       
            else
                // if not possible means pages should be 
                // increased so update start = mid + 1 
                start = mid + 1; 
        } 
       
        // at-last return minimum no. of  pages 
        return result; 

    }
    
    boolean isPossible(ArrayList<Integer> arr, int n, int m, int curr_min) 
    { 
        int studentsRequired = 1; 
        int curr_sum = 0; 
       
        // iterate over all books 
        for (int i = 0; i < n; i++) 
        { 
            // check if current number of pages are greater 
            // than curr_min that means we will get the result 
            // after mid no. of pages 
            if (arr.get(i) > curr_min) 
                return false; 
       
            // count how many students are required 
            // to distribute curr_min pages 
            if (curr_sum + arr.get(i) > curr_min) 
            { 
                // increment student count 
                studentsRequired++; 
       
                // update curr_sum 
                curr_sum = arr.get(i); 
       
                // if students required becomes greater 
                // than given no. of students,return false 
                if (studentsRequired > m) 
                    return false; 
            } 
       
            // else update curr_sum 
            else
                curr_sum += arr.get(i); 
        } 
        return true; 
    }
    

}
