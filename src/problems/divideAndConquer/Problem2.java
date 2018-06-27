package problems.divideAndConquer;

public class Problem2 {

//One element in array is occuring more than n/2 times,what is that element
	
	private static int dnq(int i,int j,int arr[]) {
		if(i==j) return arr[i];
		int mid = (i+j)/2;
		int l = dnq(i,mid,arr);
		int r = dnq(mid+1,j,arr);
		if(l==r) {
			return l;
		}
		int countL = 0;
		for(int k=i;k<mid;k++) {
			if(arr[k]==l) countL++;
		}
		int countR = 0;
		for(int k=mid+1;k<=j;k++) {
			if(arr[k]==r) countR++;
		}
		return countL > countR ? l : r;
	}
	
	private static int sol(int arr[]) {
		return dnq(0,arr.length-1,arr);
	}
	
	public static void main(String[] args) {
		int arr[] = {4,2,2,2,3,2,2,4,5,5,2,2};
		System.out.println(sol(arr));
	}
	
}
