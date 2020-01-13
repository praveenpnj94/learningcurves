//https://www.geeksforgeeks.org/selection-sort/


class GfG
{
	public static int minSwaps(int[] a, int n)
	{//add code here.
	    int count=0;
	    
	    for(int i=0;i<n;i++){
	        int min=i;
	        
	        for(int j=i+1;j<n;j++){
	            
	            if(a[j]<a[min])
	              min=j;
	        }
	        
	        if(min!=i){
	            int temp=a[min];
	            a[min]=a[i];
	            a[i]=temp;
	            count++;
	        }
	    }
	    return count;
	  
}