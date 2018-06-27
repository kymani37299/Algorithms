package problems.dp;

public class Problem3 {

// Thief with backpack with volume N broke into shop with valuable items.
// In shop there is M items,every item has value v[i],volume z[i] (i [1,M]).
// Get most value thief can get in his backpack.
	
	
	// Time: O(nm)  Memory: O(nm)
	private static int sol(int n,int m,int v[],int z[]) {
		
		int dp[][] = new int[n+1][m]; // Most value with backpack size i and with first j+1 items
		
		//First row
		for(int i=0;i<=n;i++) {
			dp[i][0] = 0;
		}
		if(z[0]<=n) {
			dp[z[0]][0] = v[0];
		}
		
		for(int i=1;i<m;i++) {
			dp[0][i] = dp[0][i-1];
			for(int j=1;j<=n;j++) {
				dp[j][i] = Math.max(dp[j][i-1],dp[j-1][i]);
				if(j>=z[i]){
					dp[j][i] = Math.max(dp[j-z[i]][i-1]+v[i],dp[j][i]);
				}
			}
		}
		return dp[n][m-1];
	}
	
	public static void main(String[] args) {
		int z[] = {5,15,10,2,3};
		int v[] = {11,15,11,7,8};
		System.out.println(sol(15,5,v,z));
	}
	
}
