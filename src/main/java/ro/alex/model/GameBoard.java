package ro.alex.model;

/*
 * @author Alexandru Comsa
 */

public class GameBoard {

	private static final int QUEEN = 999;
	public int[][] solution;

	public GameBoard(int N) {
		solution = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solution[i][j] = 0;
			}
		}
	}

	public int[][] solve(int N) {
		if(placeQueens(0, N)){
			return solution;
			
		}else{
			System.out.println("NO SOLUTION EXISTS");
			return solution;
		}
	}

	public boolean placeQueens(int queen, int N) {
		// will place the Queens one at a time, for column wise
		if(queen==N){
			//if we are here that means we have solved the problem
			return true;
		}
		for (int row = 0; row < N; row++) {
			// check if queen can be placed row,col
			if (canPlace(solution, row, queen)) {
				// place the queen
				solution[row][queen] = QUEEN;
				// solve  for next queen
				if(placeQueens(queen+1, N)){
					return true;
				}
				//if we are here that means above placement didn't work
				//BACKTRACK
				solution[row][queen]=0;
			}
		}
		//if we are here that means we haven't found solution
		return false;

	}

	// check if queen can be placed at matrix[row][column]
	public boolean canPlace(int[][] matrix, int row, int column) {
		// since we are filling one column at a time,
		// we will check if no queen is placed in that particular row
		for (int i = 0; i < column; i++) {
			if (matrix[row][i] == QUEEN) {
				return false;
			}
		}
		// we are filling one column at a time,so we need to check the upper and
		// diagonal as well
		// check upper diagonal
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (matrix[i][j] == QUEEN) {
				return false;
			}
		}

		// check lower diagonal
		for (int i = row, j = column; i < matrix.length && j >= 0; i++, j--) {
			if (matrix[i][j] == QUEEN) {
				return false;
			}
		}
		// if we are here that means we are safe to place Queen at row,column
		return true;
	}

}
