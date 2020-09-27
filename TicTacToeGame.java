class TicTacToeGame{


	public void printBoard(char[][] board){
	
		for(char[] row : board){
		
			for(char c : row){
			
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		char[][] board = {{' ', '|', ' ', '|', ' '},
               		{'-', '+', '-', '+', '-'},
               		{' ', '|', ' ', '|', ' '},
               		{'-', '+', '-', '+', '-'},
               		{' ', '|', ' ', '|', ' '}};
		
		TicTacToeGame obj = new TicTacToeGame();
		obj.printBoard(board);
	}
}
