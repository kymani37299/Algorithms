package string_matching;

import java.util.ArrayList;

public class RabinKarp {
	
	private static final int p = 37;
	private static final long M = (long) pow(10,9) + 9;
	
	private static long pow(int a,int b) {
		long res = 1;
		for(int i=0;i<b;i++) {
			res*=a;
		}
		return res;
	}
	
	//SOMETHING NOT WORKING
	private static ArrayList<Integer> rabinKarp_find(String str,String pattern) {
		ArrayList<Integer> occurences = new ArrayList<Integer>();
		int n = str.length();
		int m = pattern.length();
		
		long base = 1;
		long patHash = 0;
		for(int i=0;i<m;i++) {
			patHash += (pattern.charAt(i)*base)%M;
			base *= p%M;
		}
		
		base = 1;
		
		long h = 0;
		for(int i=0;i<m;i++) {
			h += (str.charAt(i)*base)%M;
			base *= p%M;
		}
		
		if(h==patHash) {
			occurences.add(0);
		}
		
		for(int i=m;i<n;i++){
			h -= (i-m)%M;
			h += (str.charAt(i)*base)%M;
			h /= p;
		}
		
		return occurences;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> occurings = rabinKarp_find("10110111011010","1011");
		System.out.println(occurings);
		ArrayList<Integer> occurings1 = rabinKarp_find("abxabcabcaby","abcaby");
		System.out.println(occurings1);
	}
	
}
