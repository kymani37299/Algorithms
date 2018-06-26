package data_structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySerachTree <T,K extends Comparable<K>>{
	
	private Node root;
	
	public void add(T val,K key){
		Node newNode = new Node(val,key);
		if(root==null){
			root = newNode;
			return;
		}
		Node curr = root;
		while(true){
			if(key.compareTo(curr.key)>0){
				if(curr.right==null){
					curr.right = newNode;
					break;
				}else{
					curr = curr.right;
				}
			}else{
				if(curr.left==null){
					curr.left = newNode;
					break;
				}else{
					curr = curr.left;
				}
			}
		}
	}
	
	public void remove(K key){
		Node currParent = null;
		Node curr = root;
		while(curr.key.compareTo(key)!=0){
			currParent = curr;
			if(key.compareTo(curr.key)>0){
				curr = curr.right;
			}else{
				curr = curr.left;
			}
		}
		if(curr.left==null && curr.right==null){
			if(currParent==null){
				root = null;
			}
			else{
				if(currParent.right.key.compareTo(curr.key)==0){
					currParent.right = null;
				}else{
					currParent.left = null;
				}
			}
		}else if(curr.left==null){
			if(currParent==null){
				root = curr.right;
			}else{
				if(currParent.right.key.compareTo(curr.key)==0){
					currParent.right = curr.right;
				}else{
					currParent.left = curr.right;
				}
			}
		}else if(curr.right==null){
			if(currParent==null){
				root = curr.left;
			}else{
				if(currParent.right.key.compareTo(curr.key)==0){
					currParent.right = curr.left;
				}else{
					currParent.left = curr.left;
				}
			}
		}else{
			Node minNode = curr.right;
			while(minNode.left!=null) minNode = minNode.left;
			remove(minNode.key);
			curr.key = minNode.key;
			curr.val = minNode.val;
		}
		
	}
	
	//Itterative pre,post,in,level order
	
	public void preOrder(){
		if(root==null) return;
		Stack<Node> stek = new Stack<>();
		stek.push(root);
		while(!stek.isEmpty()){
			Node curr = stek.pop();
			System.out.println(curr);
			if(curr.right!=null) stek.add(curr.right);
			if(curr.left!=null) stek.add(curr.left);
		}
	}
	
	public void inOrder(){
		if(root==null) return;
		Stack<Node> stek = new Stack<>();
		Node curr = root;
		while(curr!=null){
			stek.push(curr);
			curr = curr.left;
		}
		
		while(!stek.isEmpty()){
			curr = stek.pop();
			System.out.println(curr);
			curr = curr.right;
			if(curr!=null){
				while(curr!=null){
					stek.push(curr);
					curr = curr.left;
				}
			}
		}
	}
	
	public void postOrder(){
		if(root==null) return;
		Stack<Node> stek1 = new Stack<>();
		Stack<Node> stek2 = new Stack<>();
		stek1.push(root);
		while(stek1.isEmpty()){
			Node curr = stek1.pop();
			stek2.push(curr);
			if(curr.right!=null) stek1.add(curr.right);
			if(curr.left!=null) stek1.add(curr.left);
		}
	}
	
	public void levelOrder(){
		if(root==null) return;
		Queue<Node> red = new LinkedList<>();
		red.add(root);
		while(!red.isEmpty()){
			Node curr = red.poll();
			System.out.println(curr);
			if(curr.left!=null) red.add(curr.left);
			if(curr.right!=null) red.add(curr.right);
		}
	}
	
	class Node{
		private T val;
		private K key;
		private Node left;
		private Node right;
		
		public Node(T val,K key){
			this.val = val;
			this.key = key;
		}
		
		@Override
		public String toString() {
			return val.toString();
		}
	}
}
