package sortings;

public class InsertionSorting {
	
	public static void InsertionSort(int niz[]){
		for(int i=1;i<niz.length;i++){
			int j=i;
			while(j>0 && niz[j-1] > niz[j]){
				int tmp = niz[j];
				niz[j] = niz[j-1];
				niz[j-1] = tmp;
				j--;
			}
		}
	}
	
	public static void ShellSort(int niz[]){
		int gap = niz.length/2;
		while(gap>0){
			for(int i=gap;i<niz.length;i++){
				int j=i;
				while(j >= gap && niz[j-gap] > niz[j]){
					int t = niz[j-gap];
					niz[j-gap] = niz[j];
					niz[j] = t;
					j -= gap;
				}
			}
			gap /= 2;
		}
	}
	
}
