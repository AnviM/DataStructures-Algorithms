/*
Given two integer arrays A1[ ] and A2[ ] of size N and M respectively. Sort the first array A1[ ] such that all the relative positions of the elements in the first array
are the same as the elements in the second array A2[ ].
Note: If elements are repeated in the second array, consider their first occurance only.
Example :
Input:
N = 11 
M = 4
A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
A2[] = {2, 1, 8, 3}
Output: 
2 2 1 1 8 8 3 5 6 7 9
Explanation: Array elements of A1[] are sorted according to A2[]. So 2 comes first then 1 comes, then comes 8, then finally 3 comes, now we append remaining elements in
sorted order.
Expected Time Complexity: O(N * Log(N)).
Expected Auxiliary Space: O(N).
Asked in :  Amazon, Microsoft.
*/



import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int a[], int N, int b[], int M)
    {
        //Your code here
        int i,j;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<N;i++)
        {
            if(!hm.containsKey(a[i]))
            hm.put(a[i],1);
            else
            hm.put(a[i],hm.get(a[i])+1);
        }
        int l[]=new int[N];
        int p=0;
        for(i=0;i<M;i++)
        {
            j=b[i];
            if(hm.containsKey(j))
            {
                int x=hm.get(j);
                hm.put(j,-1);
                for(int k=1;k<=x;k++)
                {
                l[p]=j;
                p++;
                }
            }
        }
        int index=p;
         for(Map.Entry ele : hm.entrySet()) 
         {
             int value = (int)ele.getValue();
             if(value!=-1)
             {
                 int key=(int)ele.getKey();
                 for(int k=1;k<=value;k++)
                {
                 l[p]=key;
                 p++;
                }
             }
         }
         Arrays.sort(l,index,N);
         return l;
        
    }
}



// { Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	

}
