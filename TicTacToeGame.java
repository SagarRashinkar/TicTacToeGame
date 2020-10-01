import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


class TicTacToeGame{

	static ArrayList<Integer> userPosition = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();

	String user,cpu;
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
			while(userPosition.contains(userPos) || cpuPosition.contains(userPos)){
			
				System.out.println("position is already taken please choose another");
				userPos = sc.nextInt();
			}
			placePiece(board, userPos, userSymbol, "user");
			checkWinner();

			cpuPos = rand.nextInt(9)+1;
			while(userPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)){
			
				cpuPos = rand.nextInt(9)+1;
			}
			placePiece(board, cpuPos, cpuSymbol, "cpu");
			printBoard(board);
			checkWinner();
		}
	}

	public void placePiece(char[][] board, int pos, char symbol, String player){
	
		if(player.equals("user")){
		
			userPosition.add(pos);
		}
		else if(player.equals("cpu")){
		
			cpuPosition.add(pos);
		}

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

	public void checkWinner(){
		List topRow = Arrays.asList(1, 2, 3);
        	List midRow = Arrays.asList(4, 5, 6);
        	List botRow = Arrays.asList(7, 8, 9);
        	List leftCol = Arrays.asList(1, 4, 7);
        	List midCol = Arrays.asList(2, 5, 8);
        	List rightCol = Arrays.asList(3, 6, 9);
        	List cross1 = Arrays.asList(1, 5, 9);
        	List cross2 = Arrays.asList(7, 5, 3);

		List<List> winner = new ArrayList<List>();
		winner.add(topRow);
		winner.add(midRow);
		winner.add(botRow);
		winner.add(leftCol);
		winner.add(midCol);
		winner.add(rightCol);
		winner.add(cross1);
		winner.add(cross2);

		for(List l : winner){
		
			if(userPosition.containsAll(l)){
			
				System.out.println("user is winner!!!");
				System.exit(0);
			}
			else if(cpuPosition.containsAll(l)){
			
				System.out.println("cpu is winner!!!");
				System.exit(0);
			}
			else if(userPosition.size()+cpuPosition.size() == 9){
			
				System.out.println("match is tie!!!");
				System.exit(0);
			}
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
