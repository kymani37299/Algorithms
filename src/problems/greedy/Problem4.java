package problems.greedy;

import java.util.PriorityQueue;

public class Problem4 {
	
//	The fence consists of n planks arranged one after the other, of which m
//	from them broken. We have at our disposal an k boards that can cover several consecutive planks. 
//	The goal is to cover all broken planks. 
//	How many the whole planks must be covered? Calculate the min number.
	
//	Ulaz
//	n = 20 m = 5 k = 3
//	3 10 13 14 19
//	Izlaz
//	2
//	Boards: 3-3, 10-14, 19-19
	
	//O(nlogn)
	private static int sol(int n,int m,int k,int arr[]) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(); //min heap
		for(int i=1;i<m-1;i++) {
			heap.add(arr[i]-arr[i-1]-1);
		}
		int whole = 0;
		for(int i=0;i<m-k;i++) {
			whole += heap.poll();
			
		}
		
		return whole;
	}
	
	public static void main(String[] args) {
		int n = 20;
		int m = 5;
		int k = 3;
		int arr[] = {3,10,13,14,19};
		System.out.println(sol(n, m, k, arr));
	}
	
}
