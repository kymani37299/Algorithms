package sortings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OtherSortings {

	//Divide and conquer
	
    public static void MergeSort(int niz[], int l, int r){
        if (l < r){
        	 int m = l + (r-l)/2;
             MergeSort(niz, l, m);
             MergeSort(niz , m+1, r);
             Queue<Integer> left = new LinkedList<>();
             Queue<Integer> right = new LinkedList<>();
             for(int i=l;i<=m;i++) left.add(niz[i]);
             for(int i=m+1;i<=r;i++) right.add(niz[i]);
             int br=l;
             while(!left.isEmpty() || !right.isEmpty()){
            	 if(left.isEmpty()) niz[br++]  = right.poll();
            	 else if(right.isEmpty()) niz[br++] = left.poll();
            	 else niz[br++] = left.peek() < right.peek() ? left.poll() : right.poll();
             }
            
             
        }
    }
	
    //Memory usage sorts
    
    public static void CountingSort(int niz[]){ //TODO: Add min too
		int max = niz[0];
		for(int i=1;i<niz.length;i++){
			if(niz[i] > max) max = niz[i];
		}
		max++;
		int count[] = new int[max];
		for(int i=0;i<max;i++) count[i] = 0;
		for(int i=0;i<niz.length;i++) count[niz[i]]++;
		for(int i=1;i<max;i++) count[i] = count[i] + count[i-1];
		int newNiz[] = new int[max];
		for(int i=0;i<niz.length;i++){
			newNiz[count[niz[i]]-1] = niz[i];
			count[niz[i]]--;
		}
		for(int i=0;i<niz.length;i++){
			niz[i] = newNiz[i];
		}
	}
	
	public static void RadixSort(int niz[]){
		int max = niz[0];
		for(int i=1;i<niz.length;i++){
			if(niz[i]>max) max = niz[i];
		}
		int maxCif = 0;
		while(max>0){
			max /= 10;
			maxCif++;
		}
		ArrayList<Integer> buckets[] = new ArrayList[10];
		
		for(int k=0;k<=maxCif;k++){
			for(int i=0;i<10;i++) buckets[i] = new ArrayList<Integer>();
			for(int i=0;i<niz.length;i++) buckets[(int) ((niz[i]/(Math.pow(10, k)))%10)].add(niz[i]);
			int br=0;
			for(int i=0;i<10;i++){
				for(int j=0;j<buckets[i].size();j++) niz[br++] = buckets[i].get(j);
			}
		}
	}
	
}
