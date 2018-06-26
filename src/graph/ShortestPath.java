package graph;

import java.util.ArrayList;

public class ShortestPath {
	public static int[] dijkstra(int graf[][] ,int start){
		int n = graf.length;
		int min[] = new int[n];
		for(int i=0;i<n;i++) min[i] = Integer.MAX_VALUE;
		min[start] = 0;
		ArrayList<Integer> visited = new ArrayList<>();
		visited.add(start);
		while(visited.size()!=n){
			int minEdge = Integer.MAX_VALUE;
			int edge = -1;
			for(Integer v : visited){
				for(int i=0;i<n;i++){
					if(min[v] + graf[v][i] < min[i]) min[i] = min[v] + graf[v][i];
					if(!visited.contains(i) && graf[v][i] < minEdge){
						minEdge = graf[v][i];
						edge = i;
					}
				}
			}
			visited.add(edge);
		}
		return min;
		
	}
	
	public static int[] bellmanFord(int graf[][],int start,int end){
		return null; //TODO
	}
	
	public static int[][] floydWarshall(int graf[][]){
		int n = graf.length;
		int dm[][] = new int[n][n]; //distance matrix
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) dm[i][j] = graf[i][j];
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(dm[i][j] > dm[i][k] + dm[k][j]){
						dm[i][j] = dm[i][k] + dm[k][j];
					}
				}
			}
		}
		return dm;
	}
}
