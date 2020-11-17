import java.util.Scanner;

abstract class Chessboard {
	protected int chessboard[][];
	protected int size,playnum;
	public char play[];
	protected int total;

	public Chessboard(int size,int player){
		this.size = size;
		this.playnum = player;
		this.chessboard = new int[this.size][this.size];
		this.total = 0;
	}

	public void Show(){//打出棋盤面
		System.out.print("\033[H\033[2J");
		System.out.println("Game of 2048!!!");
		for(int i=0;i<this.size;i++){
			for(int j=0;j<this.size;j++){
				System.out.print("  ___  ");
			}
			System.out.println();
			for(int j=0;j<this.size;j++){
				System.out.print(" | " + this.chessboard[i][j] + " | ");
			}
			System.out.println();
			for(int j=0;j<this.size;j++){
				System.out.print("  ---  ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Total point on the table: "+this.total);
	}

	public int[][] checkBoard(){//回傳棋盤
		return this.chessboard;
	}

	public int getSize(){//獲取棋盤長度
		return this.size;
	}
	public int getTotal(){//獲取步數
		return this.total;
	}

	abstract public int Move(int mm);//移動
}

