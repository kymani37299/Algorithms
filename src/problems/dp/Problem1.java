package problems.dp;

public class Problem1 {

	// Calculate subarray of array with minimum sum
	
	// Time: O(n) Memory: O(n)
	private static int sol(int arr[]) {
		int n = arr.length;
		int pf[] = new int[n]; //prefix sum
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += arr[i];
			pf[i] = sum;
		}
		int maxPf = 0;
		int minSum = 0; // Empty array if there is no negative
		for(int i=0;i<n;i++) {
			minSum = Math.min(pf[i]-maxPf, minSum);
			maxPf = Math.max(pf[i], maxPf);
		}
		return minSum;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,-4,2,-3,2,4,-1,-3,2,-1};
		System.out.println(sol(arr));
	}
	
	
}
