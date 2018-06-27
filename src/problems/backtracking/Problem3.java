package problems.backtracking;

import java.util.Arrays;

public class Problem3 {

// Given chess board , and position of knight, print turns of knight on board so it visits every cell just once
	
	private static final int xMov[] = {1,1,-1,-1,2,2,-2,-2};
	private static final int yMov[] = {2,-2,2,-2,1,-1,1,-1};
	
	private static boolean bt(int currMov,int x,int y,int board[][]) {
		if(currMov==64) {
			return true;
		}
		for(int i=0;i<xMov.length;i++) {
			int xNext = x+xMov[i];
			int yNext = y+yMov[i];
			if(xNext>=0 && yNext>=0 && xNext<8 && yNext<8 && board[xNext][yNext]==-1) {
				board[xNext][yNext] = currMov;
				if(bt(currMov+1,xNext,yNext,board)) {
					return true;
				}
				board[xNext][yNext] = -1;
			}
		}
		return false;
	}
	
	
	private static void sol(int x,int y) {
		int board[][] = new int[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				board[i][j] = -1;
			}
		}
		board[x][y] = 0;
		bt(1,x,y,board);
		for(int i=0;i<8;i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
	public static void main(String[] args) {
		sol(2,3);
	}
	
}
