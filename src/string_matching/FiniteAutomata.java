package string_matching;

import java.util.ArrayList;
import java.util.HashMap;

public class FiniteAutomata {
	
	static class Vec2 {
		char ch;
		int ind;
		public Vec2(char ch,int ind) {
			this.ch = ch;
			this.ind = ind;
		}
		
		@Override
		public int hashCode() {
			return ch*1000+ind;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Vec2) {
				Vec2 vec2 = (Vec2) obj;
				return vec2.ch==this.ch && vec2.ind==this.ind;
			}
			return super.equals(obj);
		}
	}
	
	private static int getNextState(String pattern,int state,char ch) {
		int n = pattern.length();
		if(state<n && ch == pattern.charAt(state)){
			return state+1;
		}
		
		for(int i = state;i>0;i--) {
			if(pattern.charAt(i-1)==ch) {
				int j=0;
				for(;j<i-1;j++) {
					if(pattern.charAt(j)!=pattern.charAt(state-i+j+1)){
						break;
					}
				}
				if(j== i-1){
					return i;
				}
			}
		}
		return 0;
	}
	
	
	
	private static HashMap<Vec2,Integer> getStateTable(String pattern) {
		int n = pattern.length();
		HashMap<Vec2,Integer> map = new HashMap<>();
		for(int state=0;state<=n;state++) {
			for(char ch='a';ch<='z';ch++) {
				int nextState = getNextState(pattern,state,ch);
				map.put(new Vec2(ch,state),nextState);
			}
			for(char ch='A';ch<='Z';ch++) {
				int nextState = getNextState(pattern,state,ch);
				map.put(new Vec2(ch,state),nextState);
			}
			for(char ch='0';ch<='9';ch++) {
				int nextState = getNextState(pattern,state,ch);
				map.put(new Vec2(ch,state),nextState);
			}
		}
		return map;
	}
	
	private static ArrayList<Integer> finiteAutomata_find(String str,String pattern) {
		ArrayList<Integer> occurences = new ArrayList<>();
		int n = str.length();
		int m = pattern.length();
		
		HashMap<Vec2,Integer> stateTable = getStateTable(pattern);
		int state = 0;
		for(int i=0;i<n;i++) {
			state = stateTable.get(new Vec2(str.charAt(i),state));
			if(state==m) {
				occurences.add(i-m+1);
			}
		}
		return occurences;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> occurings = finiteAutomata_find("10110111011010","1011");
		System.out.println(occurings);
		ArrayList<Integer> occurings1 = finiteAutomata_find("abxabcabcaby","abcaby");
		System.out.println(occurings1);
	}
	
}
