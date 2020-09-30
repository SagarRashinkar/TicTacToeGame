import java.util.Scanner;

class TicTacToeGame{

	char userSymbol;
	char cpuSymbol;

	Scanner sc = new Scanner(System.in);

	public void printBoard(char[][] board){
	
		for(char[] row : board){
		
			for(char c : row){
			
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public void whoStartMatch(){
	
		int toss = (int)(Math.random()*2);
		if(toss == 0)
			System.out.println("User starts first");
		else
			System.out.println("CPU starts first");
	}

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

	public static void main(String[] args){
		
		char[][] board = {{' ', '|', ' ', '|', ' '},
               		{'-', '+', '-', '+', '-'},
               		{' ', '|', ' ', '|', ' '},
               		{'-', '+', '-', '+', '-'},
               		{' ', '|', ' ', '|', ' '}};
		
		TicTacToeGame obj = new TicTacToeGame();
		obj.printBoard(board);
		
		obj.whoStartMatch();

		obj.chooseLetter();
		System.out.println("User symbol is: "+obj.userSymbol);
		System.out.println("Cpu symbol is: "+obj.cpuSymbol);
	
	}
}
