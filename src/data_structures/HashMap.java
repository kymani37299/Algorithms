package data_structures;

//HashMap with double hashing

public class HashMap {
	
	private Cell cells[];
	private final int size = 13;
	
	public HashMap(){
		cells = new Cell[size];
	}
	
	public void add(int key,int value){
		Cell polje = new Cell(key,value);
		int h = this.hashFunction(key, 0);
		int br = 1;
		while(cells[h]!=null){
			h = this.hashFunction(key, br);
			br++;
			if(br>size){
				System.out.println("Tabela je puna");
				return;
			}
		}
		cells[h] = polje;
	}
	
	public int get(int key){
		int h = this.hashFunction(key, 0);
		int br=1;
		if(cells[h]==null){
			System.out.println("Nema takvog elementa u tabeli");
			return -1;
		}
		
		while(cells[h].getKey() != key){
			h = this.hashFunction(key, br);
			br++;
			if(br>size || cells[h] == null){
				System.out.println("Nema takvog elementa u tabeli");
				return -1;
			}
		}
		return cells[h].getValue();
	}
	
	private int h1(int key){
		return (key*key + 4*key + 3)%size;
	}
	
	private int h2(int key){
		return 1 + (3*key+5)%12;
	}
	
	
	private int hashFunction(int key,int i){
		return (h1(key)+i*h2(key))%size;
	}
	
	public boolean isFull(){
		for(int i=0;i<size;i++){
			if(cells[i]==null) return false;
		}
		return true;
	}
	
	public boolean isEmpty(){
		for(int i=0;i<size;i++){
			if(cells[i]!=null) return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i=0;i<size;i++){
			if(cells[i]==null){
				str += i+"\n";
			}else{
				str += i + " " + cells[i].getKey() + "\n";
			}
		}
		
		return str;
	}
	
	class Cell {
		
		private int key;
		private int value;
		
		public Cell(int key){
			this.key = key;
			this.value = 0;
		}
		
		public Cell(int key,int value){
			this.value = value;
			this.key = key;
		}
		
		public int getKey(){
			return this.key;
		}
		
		public int getValue(){
			return this.value;
		}
		
		public void setValue(int value){
			this.value = value;
		}
	}
}
