package problems.graphFlow;

import graph.Flow;

public class Problem2 {

// There is a graph with n nodes. Find number of paths
// from 0-th to (n-1)-th node where paths dont share same nodes
	
	// TODO : There is mistake in process of making g
	//For every node make mode in and out, and weight between them 1,then calculate flow
	private static int sol(int graph[][]) {
		int m = graph.length;
		int n = 2*(m-2)+2;
		int g[][] = new int[n][n];
		
		g[0][(m-1)*2-1] = graph[0][m-1]; // if there is direct path from start to end
		
		for(int i=1;i<m-1;i++) { //End edges
			g[0][i*2-1] = graph[0][i];
			g[i*2][(m-1)*2-1] = graph[i][m-1];
		}
		
		for(int i=1;i<m-1;i++) {
			for(int j=1;j<m-1;j++) {
				g[i*2][j*2-1] = graph[i][j];
			}
		}
		
		for(int i=1;i<m-1;i++) { //Inner weights
			g[i*2-1][i*2] = 1;
		}
		return Flow.fordFulkerson(g, 0, m-1);
	}
	
	public static void main(String[] args) {
		int n = 6;
		int g[][] = new int[n][n];
		g[0][1] = 1;
		g[0][2] = 1;
		g[0][3] = 1;
		g[1][0] = 1;
		g[2][0] = 1;
		g[3][0] = 1;
		
		g[1][4] = 1;
		g[4][1] = 1;
		
		g[2][4] = 1;
		g[2][5] = 1;
		g[2][3] = 1;
		g[4][2] = 1;
		g[5][2] = 1;
		g[3][2] = 1;
		
		g[4][5] = 1;
		g[5][4] = 1;
		
		System.out.println(sol(g));
	}
	
}
