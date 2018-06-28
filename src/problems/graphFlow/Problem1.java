package problems.graphFlow;

import graph.Flow;

public class Problem1 {

//	N candidates applied for M jobs ads, where each candidate said which
//	Jobs from given M would work. Each candidate will receive exactly one candidate each and every one
//	kadnidat will do exactly one job. How many people can be employed?
	
	private static int sol(int n,int m,int jobs[][]) { //jobs is n*m , 1 i-th person wants j-th job , 0 if not
		int graph[][] = new int[n+m+2][n+m+2];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				graph[i][j+n] = jobs[i][j];
			}
		}
		
		for(int i=0;i<n;i++){
			graph[n+m][i] = 1; //start
		}
		
		for(int i=0;i<m;i++) {
			graph[i+n][n+m+1] = 1; //end
		}
		
		return Flow.fordFulkerson(graph, n+m, n+m+1);
	}
	
	public static void main(String[] args) {
		int n = 5;
		int m = 4;
		int jobs[][] = new int[n][m];
		jobs[0][1] = 1;
		jobs[0][2] = 1;
		
		jobs[1][1] = 1;
		jobs[1][2] = 1;
		
		jobs[2][1] = 1;
		jobs[2][2] = 1;
		
		jobs[3][3] = 1;
		
		jobs[4][3] = 1;
		
		System.out.println(sol(n, m, jobs));
	}
	
}
