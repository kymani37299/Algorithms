package string_matching;

import java.util.ArrayList;

public class KMP {
	
	private static int[] makePrefixTable(String pattern) {
		int n = pattern.length();
		int pi[] = new int[n];
		int j = 0;
		pi[0] = 0;
		for(int i=1;i<n;i++) {
			if(pattern.charAt(i)==pattern.charAt(j)) {
				j++;
				pi[i] = j;
			}else{
				if(j==0) {
					pi[i] = 0;
				}else {
					i--;
					j = pi[j-1];
				}
			}
		}
		return pi;
	}
	
	private static ArrayList<Integer> KMP_find(String str,String pattern) {
		ArrayList<Integer> occurings = new ArrayList<Integer>();
		int pi[] = makePrefixTable(pattern);
		int n = str.length();
		int m = pattern.length();
		int j = 0;
		for(int i=0;i<n;i++) {
			if(str.charAt(i)==pattern.charAt(j)) {
				j++;
				if(j==m) {
					occurings.add(i-m+1);
					j = pi[j-1];
				}
			}else {
				if(j!=0) {
					i--;
					j = pi[j-1];
				}
			}
		}
		
		return occurings;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> occurings = KMP_find("10110111011010","1011");
		System.out.println(occurings);
		ArrayList<Integer> occurings1 = KMP_find("abxabcabcaby","abcaby");
		System.out.println(occurings1);
	}
	
}
