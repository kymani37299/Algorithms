package problems.backtracking;

public class Problem1 {

// Print all permutations of n numbers
	
	private static void bt(StringBuilder buffer,boolean numbers[]) {
		boolean empty = true;
		for(int i=0;i<numbers.length;i++) { // It can be easier if i used arraylist,but i think this is more efficient
			if(!numbers[i]){
				empty = false;
				buffer.append(i+1);
				numbers[i] = true;
				bt(buffer,numbers);
				numbers[i] = false;
				buffer.setLength(buffer.length()-1);
			}
		}
		if(empty){
			System.out.println(buffer.toString());
			return;
		}
	}
	
	private static void sol(int n) {
		boolean numbers[] = new boolean[n]; // is i+1'th number used,false by default
		bt(new StringBuilder(),numbers);
	}
	
	
	public static void main(String[] args) {
		sol(3);
	}
}
