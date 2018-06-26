package sortings;

public class SelectionSorting {

	public static void SelectionSort(int niz[]){
		for(int i=0;i<niz.length-1;i++){
			int min = i;
			for(int j=i;j<niz.length;j++){
				if(niz[j] < niz[min]) min = j;
			}
			int tmp = niz[i];
			niz[i] = niz[min];
			niz[min] = tmp;
		}
	}
	
	public static void HeapSort(int niz[]){
		for(int i=0;i<niz.length;i++){
			int curr = i;
			while(curr!=0){
				int parent = (curr-1)/2;
				if(niz[parent] < niz[curr]){
					int tmp = niz[curr];
					niz[curr] = niz[parent];
					niz[parent] = tmp;
					curr = parent;
				}else break;
			}
		}
		int heapSize = niz.length;
		while(heapSize>0){
			int tmp = niz[0];
			niz[0] = niz[heapSize-1];
			niz[heapSize-1] = tmp;
			heapSize--;
			int curr = 0;
			while(true){
				int left = curr*2 + 1;
				int right = left+1;
				if(left>=heapSize) break;
				if(right<heapSize){
					int max = niz[left] > niz[right] ? left : right;
					if(niz[max] > niz[curr]){
						tmp = niz[max];
						niz[max] = niz[curr];
						niz[curr] = tmp;
						curr = max;
					}else break;
				}else if(niz[left] > niz[curr]){
					tmp = niz[left];
					niz[left] = niz[curr];
					niz[curr] = tmp;
					curr = left;
				}else break;
				
			}
		}
	}
	
}
