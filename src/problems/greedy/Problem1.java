package problems.greedy;

public class Problem1 {

// There are n glasses,some are faced up(1) some faced down(1). One turn is turning i,i+1,...i+k-1 glasses
// in opposite state.Calclate min turns to make all glasses face up.
//	
//	Input
//	n = 7 k = 3
//	0 0 1 0 1 0 0
//	Output
//	3
	
	
	//O(kn) I think its possible in O(n)
	
	private static int sol(int n,int k,int arr[]) {
		int turns = 0;
		for(int i=0;i<=arr.length-k;i++) {
			if(arr[i]==0) {
				for(int j=0;j<k;j++) {
					arr[i+j] = (arr[i+j]+1)&1;
				}
				turns++;
			}
		}
		
		for(int i=arr.length-k+1;i<arr.length;i++) {
			if(arr[i]==0) {
				return -1;
			}
		}
		
		return turns;
	}
	
	public static void main(String[] args) {
		int n = 7;
		int k = 3;
		int glasses[] = {0,0,1,0,1,0,0};
		System.out.println(sol(n,k,glasses));
	}
}
