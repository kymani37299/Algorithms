package problems.divideAndConquer;

public class Problem1 {
	
	// Find second biggest element in array
	
	
	
	private static Vec2 dnq(int i,int j,int arr[]){
		if(i==j) return new Vec2(arr[i],0);
		int mid = (i+j)/2;
		Vec2 left = dnq(i,mid,arr);
		Vec2 right = dnq(mid+1,j,arr);
		
		if(left.x>right.x) {
			if(left.y>right.x){
				return new Vec2(left.x,left.y);
			}else{
				return new Vec2(left.x,right.x);
			}
		}else{
			if(right.y>left.x) {
				return new Vec2(right.x,right.y);
			}else{
				return new Vec2(right.x,left.x);
			}
		}
	}
	
	private static int sol(int arr[]) {
		Vec2 sol = dnq(0,arr.length-1,arr);
		return sol.y;
	}
	
	public static void main(String[] args) {
		int arr[] = {5,2,1,4,5,1,6,8};
		System.out.println(sol(arr));
	}
	
}

class Vec2 {
	int x;
	int y;
	public Vec2(int x,int y) {
		this.x=x;
		this.y=y;
	}
}