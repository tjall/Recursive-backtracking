import java.util.Arrays;

public class Sudoku {
	public static void main(String[] args) {
		int[][] board = {{5,3,0,0,7,0,0,0,0},
				         {6,0,0,1,9,5,0,0,0},
				         {0,9,8,0,0,0,0,6,0},
				         {8,0,0,0,6,0,0,0,3},
				         {4,0,0,8,0,3,0,0,1},
				         {7,0,0,0,2,0,0,0,6},
				         {0,6,0,0,0,0,2,8,0},
				         {0,0,0,4,1,9,0,0,5},
				         {0,0,0,0,8,0,0,7,9}};
		printboard(board);
		solve(board,0,0);
		printboard(board);
		
		//System.out.println(checkcol(board,1,6) && checkrow(board,1,6));
		
	}
	

	
	
	public static boolean solve(int[][] board,int row,int col) {
		if(col >= board.length) {
			row ++;
			col = 0;
		}
		if(row >= board.length) {
			return true;
		}
		if(board[row][col] > 0) {
			return solve(board,row,col +1 );
		}
	if(board[row][col] == 0) {
		for(int i = 1 ; i < board.length+1; i++) { 
			
			if(safe(board,row,col,i) == false) {
				board[row][col] = i;
				//printboard(board);
				if(solve(board, row, col +1 ) == true) {
					//printboard(board);
					return true;
				}
			}
		}
		board[row][col] = 0;
		return false;
	}
	else {
		return solve(board, row, col +1);
	}
}
	
	public static boolean checkcol(int[][] board, int row, int p) {
		for(int i = 0; i < board.length;i++) {
			if(board[row][i] == p) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkrow(int[][] board, int col, int p) {
		for(int i = 0; i < board.length;i++) {
			if(board[i][col] == p) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean safe(int[][] board, int row, int col, int p) {
		return checkcol(board,row,p) || checkrow(board,col,p)||square_dance(board,row,col,p);
	}
	
	public static void printboard(int[][] board) {
		for(int i = 0; i < board.length ;i++) {
			for(int j = 0; j< board.length; j++) {
				System.out.print(" "+board[i][j]);
				
			}
			System.out.println();
		}
		System.out.println();
	}


	public static boolean square_dance(int[][] board,int row, int col, int p) {
		int cornerRow = (row / 3) * 3;
        int cornerCol = (col / 3) * 3;
        for (int i = cornerRow; i < cornerRow + 3; i++) {
            for (int j = cornerCol; j < cornerCol + 3; j++) {
                if (board[i][j] == p){ 
                    return true;
                }
            }
        }
        return false;
    }
	
		
		
}
