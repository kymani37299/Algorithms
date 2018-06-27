package problems.divideAndConquer;

public class Problem3 {

// Find common prefix of array of strings
	
	
	private static String dnq(int l,int r,String arr[]) {
		if(l==r) return arr[l];
		int mid = (l+r)/2;
		String left = dnq(l,mid,arr);
		String right = dnq(mid+1,r,arr);
		int i=0;
		for(;i<Math.min(left.length(),right.length())
				&& left.charAt(i)==right.charAt(i);i++);
		return left.substring(0, i);
	}
	
	private static String sol(String arr[]) {
		return dnq(0,arr.length-1,arr);
	}
	
	public static void main(String[] args) {
		String arr[] = {"asdfgagdagdag",
						"asdgfdsdafsadd",
						"asdqwrqweqettz"};
		
		System.out.println(sol(arr));
	}
	
}
