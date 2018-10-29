import java.util.Random;
public class eight_queens {
	public static void main(String[] args) {
		int rows = 8;
		int cols = 8;
		int[][] board= new int[rows][cols];
		solve(board,0);
		printboard(board,rows,cols);
		
	}
	
	public static boolean solve(int[][] board,int pos) {
		
		if( pos == 8) {
			return true;
			
		}
		for(int i = 0; i < 8; i++) {
			if(attacked(board,i,pos)==false) {
				board[i][pos] = 1;
				if(solve(board,pos +1)== true)
					return true;
				
				else {
					board[i][pos] = 0;
				}
			}
		}
		return false;
		
		
	}
	
	public static void printboard(int[][] board, int rows, int cols) {
		
		for(int i = 0; i < rows ;i++) {
			for(int j = 0; j< cols; j++) {
				System.out.print(" "+board[i][j]);
				
			}
			System.out.println();
			
		}
	}
	
	public static boolean attacked(int[][] board, int row, int col) {
		for(int i = 0; i <8; i++) {
			if(board[row][i] == 1) {
				return true;
			}
		}
		
		
		for(int l = row, k = col;l >= 0 &&k >= 0; l--, k--) {
			
			if(board[l][k] == 1) {
				return true;
			}
		}
		
		for(int j = row ,p = col; j < 8 &&p >= 0; j++, p--) {
			if(board[j][p] == 1) {
				return true;
			}
		}
		
		
		
		
		return false;
	}
	
}
