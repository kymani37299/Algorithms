package data_structures;

public class HashMap2<T> {
	private int size;
	
	private MapList map[];
	
	public HashMap2(int size){
		this.size = size;
		map = new MapList[size];
		for(int i=0;i<size;i++){
			map[i] = new MapList<T>();
		}
	}
	
	private int hash(int x){
		return x%size;
	}
	
	public void add(int key,T value){
		map[hash(key)].add(key, value);
	}
	
	public void remove(int key){
		map[hash(key)].remove(key);
	}
	
	public T get(int key){
		return (T) map[hash(key)].get(key);
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i=0;i<size;i++){
			str += i + ":   " + map[i].toString() + "\n";
		}
		return str;
	}
	
	class MapList<T>{
		
		private Node head;
		
		private void add(int key,T value){
			Node newNode = new Node(key,value);
			if(head==null) {
				this.head = newNode;
				return;
			}
			Node curr = head;
			while(curr.next!=null) curr = curr.next;
			curr.next = newNode;
		}
		
		private void remove(int key){
			if(head==null) return;
			if(head.key == key){
				head = head.next;
			}
			Node curr = head;
			while(curr.next != null && curr.next.key != key) curr = curr.next;
			if(curr.next == null) return;
			curr.next = curr.next.next;
		}
		
		private T get(int key){
			Node curr = head;
			while(curr != null && curr.key != key) curr = curr.next;
			return curr == null ? null : curr.value;
		}
		
		@Override
		public String toString() {
			String str = "";
			Node curr = head;
			while(curr!=null){
				str += curr.value + "->";
				curr = curr.next;
			}
			if(str.isEmpty()) return "";
			return str.substring(0, str.length()-2);
		}
		
		class Node{
			private T value;
			private int key;
			private Node next;
			
			private Node(int key,T value){
				this.value = value;
				this.key = key;
			}
			
			@Override
			public String toString() {
				return value.toString();
			}
		}
	}
	
}
