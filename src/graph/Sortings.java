package graph;

import java.util.ArrayList;
import java.util.Stack;

public class Sortings {

	
	//TODO: Do itterative topological
	
	public static void topologicalSort(int graf[][],int v,Stack<Integer> stack,ArrayList<Integer> visited){
		for(int i=0;i<graf.length;i++){
			if(graf[v][i]!=0 && !visited.contains(i)){
				visited.add(i);
				topologicalSort(graf,i,stack,visited);
			}
		}
		stack.push(v);
	}
	
}
