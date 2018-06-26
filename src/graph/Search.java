package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Search {

	public static void DFS(int graf[][],int start){
		boolean visited[] = new boolean[graf.length];
		Stack<Integer> stek = new Stack<>();
		stek.push(start);
		visited[start] = true;
		while(!stek.isEmpty()){
			int curr = stek.pop();
			System.out.println(curr);
			for(int i=0;i<graf.length;i++){
				if(graf[curr][i]==1 && !visited[i]){
					visited[i] = true;
					stek.push(i);
				}
			}
		}
	}
	
	public static void BFS(int graf[][],int start){
		boolean visited[] = new boolean[graf.length];
		Queue<Integer> red = new LinkedList<>();
		red.add(start);
		visited[start] = true;
		while(!red.isEmpty()){
			int curr = red.poll();
			System.out.println(curr);
			for(int i=0;i<graf.length;i++){
				if(graf[curr][i]==1 && !visited[i]){
					visited[i] = true;
					red.add(i);
				}
			}
		}
	}
	
}
