package problems.dp;

public class Problem2 {

// Bob has n boards with length a[i](infinite number of boards with that lengh) a[i]<a[i+1]. Calculate minimum number of boards to make board with length m
	
	// Time: O(mn)  Memory: O(m)
	private static int sol(int n,int m,int arr[]) {
		
		int dp[] = new int[m+1]; // minimum boards to make board with length i
		dp[0] = 0;
		for(int i=1;i<=m;i++) {
			dp[i] = Integer.MAX_VALUE-1;
			for(int j=0;j<n;j++) {
				int left = i-arr[j];
				if(left>=0) {
					dp[i] = Math.min(dp[left]+1, dp[i]);
				}else{ // if a[i] < a[i+1]
					break;
				}
			}
		}
		
		return dp[m];
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,5,11};
		System.out.println(sol(4,14,arr));
	}
	
}
