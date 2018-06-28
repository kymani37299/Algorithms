package graph;

import java.util.ArrayList;

public class Flow {
	
	public static int fordFulkerson(int graph[][],int start,int end) {
		int n = graph.length;
		int rg[][] = new int[n][n]; //resigual graph
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				rg[i][j] = graph[i][j];
			}
		}
		while(true) {
			ArrayList<Integer> path = Search.DFS_path(rg, start, end);
			if(path==null) {
				break;
			}
			int min = Integer.MAX_VALUE-1;
			for(int i=0;i<path.size()-1;i++) {
				min = Math.min(min, rg[path.get(i)][path.get(i+1)]);
			}
			
			for(int i=0;i<path.size()-1;i++) {
				int curr = path.get(i);
				int next = path.get(i+1);
				rg[curr][next] -= min;
				rg[next][curr] += min;
			}
		}
		int flow = 0;
		for(int i=0;i<n;i++) {
			flow+= rg[end][i];
		}
		return flow;
	}
	
}
