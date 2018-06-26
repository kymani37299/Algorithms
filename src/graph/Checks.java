package graph;

import java.util.Stack;

public class Checks {

	public static boolean isCyclic(int graf[][]){
		int depth[] = new int[graf.length];
		for(int i=0;i<graf.length;i++) depth[i] = -1;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		depth[0] = 0;
		while(!stack.isEmpty()){
			int curr = stack.pop();
			for(int i=0;i<graf.length;i++){
				if(graf[curr][i]==1){
					if(depth[i]==-1){ 
						stack.push(i);
						depth[i] = depth[curr]+1;
					}else{
						if(depth[curr] <= depth[i]) return true;
					}
					
				}
			}
		}
		return false;
	}
	
}
