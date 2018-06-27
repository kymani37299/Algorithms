package problems.dp;

public class Problem4 {

// There is matrix(nxn) filled with 0's and 1's.
// Find max size of square submatrix filled with 0's.
	
	
	//Time: O(n^2)  Memory: O(n^2)
	private static int sol(int mat[][]) {
		int n = mat.length;
		
		int dp[][] = new int[n][n]; // size of max size submatrix that has lower right edge in i j
		
		int max = 0;
		
		
		for(int i=0;i<n;i++) {
			dp[i][0] = mat[i][0]^1; //if 1 then 0 , if 0 then 1
			dp[0][i] = mat[0][i]^1;
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				if(mat[i][j]==1) {
					dp[i][j] = 0;
				}else {
					dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
					max = Math.max(dp[i][j], max);
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int mat[][] = { {1,0,0,1,1,1,0},
						{0,1,0,0,0,1,1},
						{0,1,0,1,0,1,1},
						{1,1,0,0,0,0,1},
						{1,1,1,0,0,0,0},
						{1,1,0,0,0,0,0},
						{1,1,0,0,1,1,1}};
		System.out.println(sol(mat));
	}
	
}
