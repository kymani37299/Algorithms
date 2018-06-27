package problems.dp;

public class Problem5 {

// There is array of n elements. By placing pharathesis find min value for a[0]-a[1]-...-a[n-1]
	
	private static int sol(int arr[]) {
		int n = arr.length;
		int dp[][] = new int[n][n]; // Upper tirangle is min for range [i,j], lower triangle is max for range [j][i]
		// We can add one more matrix if we want to find positions of pharenthesis
		for(int i=0;i<n;i++) {
			dp[i][i] = arr[i];
		}
		for(int gap=1;gap<n;gap++) {
			for(int i=0;i<n-gap;i++) {
				dp[i][i+gap] = Integer.MAX_VALUE;
				dp[i+gap][i] = Integer.MIN_VALUE;
				for(int k=i;k<i+gap;k++) {
					dp[i][i+gap] = Math.min(dp[i][i+gap],dp[i][k]-dp[i+gap][k+1]);
					dp[i+gap][i] = Math.max(dp[i+gap][i], dp[i][k]-dp[i+gap][k+1]);
				}
			}
		}
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		int arr[] = {1,5,2,3,4};
		System.out.println(sol(arr));
	}
	
}
