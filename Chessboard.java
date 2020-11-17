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
		for(int i =0;i<this.size ;i++){
			for(int j =0;j<this.size;j++){
				System.out.print(" " + chessboard[i][j] + " ");
			}
			System.out.println();
		}
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

