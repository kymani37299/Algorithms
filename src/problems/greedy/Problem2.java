package problems.greedy;

import java.util.Arrays;

public class Problem2 {

	
//	On one side of river there are n people,i-th person weights w[i].
//	You must place people on boats,every boat can support up to 2 persons,and W weight.
//	Calculate min number of boats needed.
//	
//	Ulaz
//	n = 9 W = 100
//	90 20 20 30 50 60 70 90 80
//	Izlaz
//	6
	
	// O(nlogn)
	private static int sol(int n,int W,int arr[]) {
		Arrays.sort(arr);
		int num = 0;
		int start = 0,end = n-1;
		
		while(start<end) {
			if(arr[start]+arr[end]<W)
				start++;
			end--;
			num++;
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		int n = 9;
		int W = 100;
		int arr[] = {90,20,20,30,50,60,70,90,80};
		System.out.println(sol(n,W,arr));
	}
	
}
