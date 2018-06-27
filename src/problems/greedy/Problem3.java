package problems.greedy;

public class Problem3 {

// There is array of length n.You can perform operation where you can switch 2 adjacent elements with their sum.
// Calculate max length of palindrome you can get with performing this operation.
//	
//	Ulaz
//	n = 6
//	20 10 40 20 20 30
//	Izlaz
//	4
//	(20 10) 40 20 20 30 -> 30 40 (20 20) 30 -> 30 40 40 30
	
	//O(n)
	private static int sol(int n,int arr[]) {
		int start = 0,end = n-1;
		int startVal = arr[start],endVal = arr[end];
		int size = 0;
		
		while(start<end) {
			if(startVal==endVal) {
				size+=2;
				start++;
				end--;
				startVal = arr[start];
				endVal = arr[end];
			}if(startVal<endVal) {
				if(start+1==end) return -1;
				start++;
				startVal += arr[start];
			}else {
				if(end-1==start) return -1;
				end--;
				endVal += arr[end];
			}
		}
		if(start==end) size++;
		
		return size;
	}
	
	public static void main(String[] args) {
		int arr[] = {20,10,40,20,20,30};
		System.out.println(sol(arr.length,arr));
	}
}
