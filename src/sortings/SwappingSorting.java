package sortings;

import java.util.Stack;

public class SwappingSorting {

	public static void BubbleSort(int niz[]){
		boolean b = false;
		int n = niz.length;
		do{
			b = false;
			for(int i=0;i<n-1;i++){
				if(niz[i] > niz[i+1]){
					int tmp = niz[i];
					niz[i] = niz[i+1];
					niz[i+1] = tmp;
					b = true;
				}
			}
			n--;
		}while(b);
	}
	
	public static void QuickSort(int niz[]){
		Stack<Integer> stackL = new Stack<>();
		Stack<Integer> stackR = new Stack<>();
		stackL.push(0);
		stackR.push(niz.length-1);
		while(!stackL.isEmpty()){
			int l = stackL.pop();
			int r = stackR.pop();
			if(l>=r) continue;
			int left = l;
			int right = r;
			int pivot = niz[r];
			do{
				while(niz[left] < pivot) left++;
				while(niz[right]>=pivot && right!=left) right--;	
				int tmp = niz[right];
				niz[right] = niz[left];
				niz[left] = tmp;
			}while(left!=right);
			int tmp = niz[right];
			niz[right] = niz[r];
			niz[r] = tmp;
			stackL.push(right+1);
			stackR.push(r);
			stackL.push(l);
			stackR.push(right-1);
		}
	}
	
}
