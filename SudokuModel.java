package sudoku;

import java.util.*;
public class SudoModel
{
	private final int boardsize = 9;
	private int[][] board = new int[boardsize][boardsize];
	boolean isWon = false;
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	SudoModel()
	{
		board = initBoard();
		printBoard();
		//play();
	}
	private void play()
	{
		while(!isWon)
		{
			System.out.print("Coors to mark?\n>> ");
			int x = scan.nextInt();
			int y = scan.nextInt();
			System.out.println("down "+x+" | right "+y);
			System.out.println("The number at that location: "+ board[x][y]);
			System.out.print("What do you want to put there?\n>> ");
			int ans = scan.nextInt();
			board[x][y] = ans;
			printBoard();
		}
		
	}
	private int[][] initBoard()
	{
		int num = 0; 
		for(int i = 0; i < boardsize; i++)
		{
			for(int j = 0; j < boardsize; j++)
			{
				int randnum = newRand();
				if(1==whatQuad(i,j))
				{
					checkQuad(1,i,j,randnum);
				}
				if(2==whatQuad(i,j))
				{
					checkQuad(2,i,j,randnum);
				}
				if(3==whatQuad(i,j))
				{
					checkQuad(3,i,j,randnum);
				}
				if(4==whatQuad(i,j))
				{
					checkQuad(4,i,j,randnum);
				}
				if(5==whatQuad(i,j))
				{
					checkQuad(5,i,j,randnum);
				}
				if(6==whatQuad(i,j))
				{
					checkQuad(6,i,j,randnum);
				}
				if(7==whatQuad(i,j))
				{
					checkQuad(7,i,j,randnum);
				}
				if(8==whatQuad(i,j))
				{
					checkQuad(8,i,j,randnum);
				}
				if(9==whatQuad(i,j))
				{
					checkQuad(9,i,j,randnum);
				}
				
			}
		}
		return board;
	}
	private void checkQuad(int quadNum, int i, int j, int randnum)
	{
		if(!safeRow(i,randnum) ||!safeCol(j,randnum) || !safeQuad(quadNum,randnum)) {
			randnum = newRand();
		}
		else {
			board[i][j] = randnum;
		}
	}
	//check if num is safe to put in curr quad
	private boolean safeQuad(int quad, int num)
	{
		int[] quadArr = getQuad(quad);//quadArr is the array of numbers in given quad
		for(int x = 0; x<boardsize; x++) {
			if(quadArr[x] == num)//if num matches a number that already exist in quad
				return false;
		}
		return true;
	}
	private boolean safeCol(int j, int num)
	{
		int[] col = getCol(j);
		for(int x = 0; x<boardsize; x++)
		{
			if(col[x]==num)
				return false;
		}
		return true;
	}
	private boolean safeRow(int i, int num)
	{
		int[] row = getRow(i);
		for(int x = 0; x<boardsize; x++)
		{
			if(row[x]==num)
				return false;
		}
		return true;
	}
	//give coors i and j, find what quad that is
	private int whatQuad(int i, int j)
	{
		if(i<3&& j<3)
		{
			return 1;
		}
		if(i<3&& j>2&&j<6)
		{
			return 2;
		}
		if(i<3&& j >5)
		{
			return 3;
		}
		if(i>2&&i<6&&j<3)
		{
			return 4;
		}
		if(i>2&&i<6&&j>2&&j<6)
		{
			return 5;
		}
		if(i>2&&i<6&&j>5)
		{
			return 6;
		}
		if(i>5&&j<3)
		{
			return 7;
		}
		if(i>5&& j>2 &&j <6)
		{
			return 8;
		}
		if(i>5&& j >5)
		{
			return 9;
		}
		return 0;
	}
	private int[] getQuad(int quad)
	{
		int[] quadArr = new int[9];
		int p = 0;
		if(quad==1)
		{
			for(int i = 0; i< boardsize;i++) {
				for(int j = 0; j<boardsize; j++) {
					if(i<3&& j<3)
					{
						quadArr[p] = board[i][j];
						p++;
					}
				}
			}
		}
		if(quad==2)
		{
			for(int i = 0; i< boardsize;i++) {
				for(int j = 0; j<boardsize; j++) {
					if(i<3&& j>2&&j<6)
					{
						quadArr[p] = board[i][j];
						p++;
					}
				}
			}
		}
		if(quad==3)
		{
			for(int i = 0; i< boardsize;i++) {
				for(int j = 0; j<boardsize; j++) {
					if(i<3&& j >5)
					{
						quadArr[p] = board[i][j];
						p++;
					}
				}
			}
		}
		if(quad==4)
		{
			for(int i = 0; i< boardsize;i++) {
				for(int j = 0; j<boardsize; j++) {
					if(i>2&&i<6&&j<3)
					{
						quadArr[p] = board[i][j];
						p++;
					}
				}
			}
		}
		if(quad==5)
		{
			for(int i = 0; i< boardsize;i++) {
				for(int j = 0; j<boardsize; j++) {
					if(i>2&&i<6&&j>2&&j<6)
					{
						quadArr[p] = board[i][j];
						p++;
					}
				}
			}
		}
		if(quad==6)
		{
			for(int i = 0; i< boardsize;i++) {
				for(int j = 0; j<boardsize; j++) {
					if(i>2&&i<6&&j>5)
					{
						quadArr[p] = board[i][j];
						p++;
					}
				}
			}
		}
		if(quad==7)
		{
			for(int i = 0; i< boardsize;i++) {
				for(int j = 0; j<boardsize; j++) {
					if(i>5&&j<3)
					{
						quadArr[p] = board[i][j];
						p++;
					}
				}
			}
		}
		if(quad==8)
		{
			for(int i = 0; i< boardsize;i++) {
				for(int j = 0; j<boardsize; j++) {
					if(i>5&& j>2 &&j <6)
					{
						quadArr[p] = board[i][j];
						p++;
					}
				}
			}
		}
		if(quad==9)
		{
			for(int i = 0; i< boardsize;i++) {
				for(int j = 0; j<boardsize; j++) {
					if(i>5&& j >5)
					{
						quadArr[p] = board[i][j];
						p++;
					}
				}
			}
		}
		return quadArr;
	}
	private int[] getCol(int col)
	{
		int[] aRow = new int[9];
		int p = 0; 
		for(int i = 0; i < boardsize;i++)
		{
			for(int j = 0; j < boardsize;j++)
			{
				if(j==col)
				{
					aRow[p] = board[i][j];
					p++;
				}
			}
		}
		return aRow;
	}
	private int[] getRow(int row)
	{
		int[] aRow = new int[9];
		int p = 0; 
		for(int i = 0; i < boardsize;i++)
		{
			for(int j = 0; j < boardsize;j++)
			{
				if(i==row)
				{
					aRow[p] = board[i][j];
					p++;
				}
			}
		}
		return aRow;
	}
	private int newRand()
	{
		return rand.nextInt(9)+1;
	}
	private void printBoard()
	{
		for(int i = 0; i < boardsize; i++)
		{
			for(int j = 0; j < boardsize; j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public int[][] getBoard()
	{
		return board;
	}
	public static void main(String[] args)
	{
		new SudoModel();
	}

}
