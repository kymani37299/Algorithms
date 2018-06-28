package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Search {

	static class Node {
		Node last;
		int val;
		
		Node(int val,Node last) {
			this.val = val;
			this.last = last;
		}
	}
	
	// Gets path in directed weighted graph
	public static ArrayList<Integer> DFS_path(int graph[][],int start,int end) {
		boolean visited[] = new boolean[graph.length];
		Stack<Node> stack = new Stack<>();
		stack.push(new Node(start,null));
		visited[start] = true;
		while(!stack.isEmpty()) {
			Node curr = stack.pop();
			if(curr.val == end) {
				
				ArrayList<Integer> path = new ArrayList<>();
				while(curr != null) {
					path.add(curr.val);
					curr = curr.last;
				}
				Collections.reverse(path);
				return path;
			}
			for(int i=0;i<graph.length;i++) {
				if(graph[curr.val][i]>0 && !visited[i]) {
					visited[i] = true;
					stack.push(new Node(i,curr));
				}
			}
		}
		
		
		return null;
	}
	
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
