package searching;

public class BinarySearch {

	public static int firstGreaterOfEqual(int arr[],int a){
		if(arr==null || arr.length==0) return -1;
		int l = 0;
		int r = arr.length-1;
		while(l<r){
			int m = l + (r-l)/2;
			if(arr[m]>=a){
				r = m;
			}else{
				l = m+1;
			}
		}
		if(arr[l]<a) return -1;
		else return l;
	}
	
	public static int lastLess(int arr[],int a){
		if(arr==null || arr.length==0) return -1;
		int l = 0;
		int r = arr.length-1;
		while(l<r){
			int m = l + (r-l+1)/2;
			if(arr[m]>=a){
				r = m-1;
			}else{
				l = m;
			}
		}
		if(arr[l]>=a) return -1;
		return l;
	}
	
}
