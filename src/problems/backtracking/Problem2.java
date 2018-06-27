package problems.backtracking;

public class Problem2 {

// Print all combinations of n numbers
	
	private static void bt(int lastNum,StringBuilder buffer,boolean numbers[]) {
		System.out.println(buffer.toString());
		for(int i=lastNum;i<numbers.length;i++) { // to avoid permutations,always write in acsending order
			if(!numbers[i]){
				buffer.append(i+1);
				numbers[i] = true;
				bt(i,buffer,numbers);
				numbers[i] = false;
				buffer.setLength(buffer.length()-1);
			}
		}
	}
	
	private static void sol(int n) {
		boolean numbers[] = new boolean[n]; // is i+1'th number used,false by default
		bt(0,new StringBuilder(),numbers);
	}
	
	
	public static void main(String[] args) {
		sol(3);
	}
	
}
