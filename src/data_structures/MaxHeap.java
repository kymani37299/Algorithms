package data_structures;

public class MaxHeap {

	private int heap[];
	int maxSize;
	int size;
	
	public MaxHeap(int size){
		this.heap = new int[size];
		this.maxSize=size;
		this.size=0;
	}
	
	public void add(int value){
		if(size>=maxSize) return;
		int pos = this.size++;
		this.heap[pos] = value;
		int i = this.getParent(pos);
		while(i!=-1){
			if(heap[i]<heap[pos]){
				this.swap(i,pos);
				pos = i;
				i = this.getParent(i);
			}else{
				break;
			}
		}
	}
	
	public boolean isEmpty(){
		return this.size==0;
	}
	
	public int removeMax(){
		if(this.size==0) return -1;
		int max = heap[0];
		this.size--;
		this.heap[0] = this.heap[this.size];
		int pos = 0;
		int left = getLeft(0);
		int right = getRight(0);
		while(true){
			if(left!=-1 && right!=-1){
				int gv = heap[left] > heap[right] ? left : right;
				if(heap[gv] > heap[pos]){
					this.swap(gv,pos);
					pos = gv;
					left = getLeft(pos);
					right = getRight(pos);
				}else{
					break;
				}
			}
			else if(left!=-1 && heap[left] > heap[pos]){
				this.swap(left, pos);
				pos = left;
				left = getLeft(pos);
				right = getRight(pos);
			}else if(right!=-1 && heap[right] > heap[pos]){
				this.swap(right, pos);
				pos = right;
				left = getLeft(pos);
				right = getRight(pos);
			}else{
				break;
			}
		}
		return max;
	}
	
	private int getParent(int x){
		if(x==0) return -1;
		return  (x-1)/2;
	}
	
	private int getLeft(int x){
		int left = 2*x+1;
		if(left>this.size) return -1;
		return left;
	}
	
	private int getRight(int x){
		int right = 2*x+2;
		if(right>this.size) return -1;
		return right;
	}
	
	private void swap(int i,int j){
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
	
}
