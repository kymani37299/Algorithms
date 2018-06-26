package graph;

import java.util.ArrayList;

public class MST {
	public static int[][] primsAlghoritm(int graf[][]){
		int mst[][] = new int[graf.length][graf.length];
		for(int i=0;i<graf.length;i++){
			for(int j=0;j<graf.length;j++) mst[i][j] = Integer.MAX_VALUE;
		}
		ArrayList<Integer> visited = new ArrayList<>();
		visited.add(0);
		while(visited.size()<graf.length){
			int min = Integer.MAX_VALUE;
			int startEdge = -1;
			int endEdge = -1;
			for(Integer v : visited){
				for(int i=0;i<graf.length;i++){
					if(!visited.contains(i) && graf[v][i]<min){
						min = graf[v][i];
						startEdge = v;
						endEdge = i;
					}
				}
			}
			mst[startEdge][endEdge] = min;
			visited.add(endEdge);
		}
		
		return mst;
	}
	
	public static int[][] kruskalsAlgorithm(int graf[][]){
		return null; //TODO
	}
}
