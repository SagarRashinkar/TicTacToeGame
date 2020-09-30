import java.util.Scanner;
import java.util.Random;

class TicTacToeGame{

	static char userSymbol;
	static char cpuSymbol;
	static int userPos, cpuPos;

	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	public void printBoard(char[][] board){
	
		for(char[] row : board){
		
			for(char c : row){
			
				System.out.print(c);
			}
			System.out.println();
		}
	}

	/*public void whoStartMatch(){
	
		int toss = (int)(Math.random()*2);
		if(toss == 0)
			System.out.println("User starts first");
		else
			System.out.println("CPU starts first");
	}*/

	public void chooseLetter(){
	
		System.out.println("enter your symbol(X/O):");
		userSymbol = sc.next().charAt(0);
		if(userSymbol == 'X'){
		
			cpuSymbol = 'O';
		}
		else if(userSymbol == 'O'){
		
			cpuSymbol = 'X';
		}
		else{
		
			System.out.println("please enter a valid symbol from above!!!");
		}
	}

	public void makeMove(char[][] board){
	
		while(true){
		
			System.out.println("enter position: ");
			userPos = sc.nextInt();
			placePiece(board, userPos, userSymbol);

			cpuPos = rand.nextInt(9)+1;
			placePiece(board, cpuPos, cpuSymbol);
			printBoard(board);
		}
	}

	public void placePiece(char[][] board, int pos, char symbol){
	
		switch(pos){
		
			case 1:
				board[0][0] = symbol;
				break;
			case 2:
				board[0][2] = symbol;
				break;
			case 3:
				board[0][4] = symbol;
				break;
			case 4:
				board[2][0] = symbol;
				break;
			case 5:
				board[2][2] = symbol;
				break;
			case 6:
				board[2][4] = symbol;
				break;
			case 7:
				board[4][0] = symbol;
				break;
			case 8:
				board[4][2] = symbol;
				break;
			case 9:
				board[4][4] = symbol;
				break;
			default:
				break;
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
		
		//obj.whoStartMatch();

		obj.chooseLetter();
		System.out.println("User symbol is: "+userSymbol);
		System.out.println("Cpu symbol is: "+cpuSymbol);

		obj.makeMove(board);
	
	}
}
