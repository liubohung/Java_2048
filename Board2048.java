import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Board2048 extends Chessboard{
	public Board2048(){
		super(4,1);
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
				System.out.print(" | ");
				if(this.chessboard[i][j] != 0)
					System.out.print(this.chessboard[i][j]);
				else
					System.out.print(" ");
				System.out.print(" | ");
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

	public int getcmd(){
		System.out.println("     w^     ");
		System.out.println("<a   s\\/   d>");
		System.out.print("please move: ");
		Scanner sc = new Scanner(System.in);
		String m = sc.next();
		
		int re = 0;
		switch(m.charAt(0)){
			case 'a'://向左動
				re =3;
			break;
			case 's'://向下動
				re = 1;
			break;
			case 'd'://向右動
				re =2;
			break;
			case 'w'://向上動
				re =4;
			break;
		}
		return re;
	}

	public int Move(int mm){//移動方向加減
		int score = 0;
		System.out.print(mm);
		ArrayList<Integer> arrlist = new ArrayList<Integer>(this.size);
		switch(mm){//方向換邊
			case 1://向下動
				for(int i = 0; i < this.size ;i++){ 
					for(int j = 0;j < this.size ;j++){
						if(this.chessboard[j][i] != 0){
							arrlist.add(this.chessboard[j][i]);
							this.chessboard[j][i] = 0;
						}
					}
					if(arrlist.isEmpty()){
						continue;
					}else{
						for(int j = this.size-1, k=arrlist.size()-1 ; k > -1 ; j--,k--){
							this.chessboard[j][i] = arrlist.get(k);
						}
					}
					arrlist.clear();
				}
			break;
			case 2://向右動
				for(int i = 0; i < this.size ;i++){ 
					for(int j = 0;j < this.size ;j++){
						if(this.chessboard[i][j] != 0){
							arrlist.add(this.chessboard[i][j]);
							this.chessboard[i][j] = 0;
						}
					}
					if(arrlist.isEmpty()){
						continue;
					}else{
						for(int j = this.size-1, k = arrlist.size()-1 ; k > -1 ; j--,k--){
							this.chessboard[i][j] = arrlist.get(k);
						}
					}
					arrlist.clear();
				}
			break;
			case 3://向左動
				for(int i = 0; i < this.size ;i++){ 
					for(int j = 0;j < this.size ;j++){
						if(this.chessboard[i][j] != 0){
							arrlist.add(this.chessboard[i][j]);
							this.chessboard[i][j] = 0;
						}
					}
					if(arrlist.isEmpty()){
						continue;
					}else{
						for(int j = 0, k = 0 ; k < arrlist.size() ; j++,k++){
							this.chessboard[i][j] = arrlist.get(k);
						}
					}
					arrlist.clear();
				}
			break;
			case 4://向上動
				for(int i = 0; i < this.size ;i++){ 
					for(int j = 0;j < this.size ;j++){
						if(this.chessboard[j][i] != 0){
							arrlist.add(this.chessboard[j][i]);
							this.chessboard[j][i] = 0;
						}
					}
					if(arrlist.isEmpty()){
						continue;
					}else{
						for(int j = 0, k=0 ; k < arrlist.size(); j++,k++){
							this.chessboard[j][i] = arrlist.get(k);
						}
					}
					arrlist.clear();
				}
			break;
		}
		arrlist = null;
		switch(mm){//相同的消除
			case 1://向下動
				for(int i=0;i<this.size - 1;i++){ 
					for(int j=0;j<this.size ;j++){
						if(this.chessboard[i][j] == this.chessboard[i+1][j] && this.chessboard[i][j] != 0){
							this.chessboard[i+1][j] += this.chessboard[i][j];
							this.chessboard[i][j] = 0;
							this.total --;
							score ++;
						}
					}
				}
			break;
			case 2://向右動
				for(int i=0;i<this.size;i++){
					for(int j=0;j<this.size-1;j++){
						if(this.chessboard[i][j] == this.chessboard[i][j+1] && this.chessboard[i][j] != 0){
							this.chessboard[i][j+1] += this.chessboard[i][j];
							this.chessboard[i][j] = 0;
							this.total --;
							score ++;
						}
					}
				}
			break;
			case 3://向左動
				for(int i=0;i<this.size;i++){
					for(int j = 1;j<this.size;j++){
						if(this.chessboard[i][j] == this.chessboard[i][j-1] && this.chessboard[i][j] != 0){
							this.chessboard[i][j-1] += this.chessboard[i][j];
							this.chessboard[i][j] = 0;
							this.total --;
							score ++;
						}
					}
				}
			break;
			case 4://向上動
				for(int i=1;i<this.size;i++){
					for(int j=0;j<this.size;j++){
						if(this.chessboard[i][j] == this.chessboard[i-1][j] && this.chessboard[i][j] != 0){
							this.chessboard[i-1][j] += this.chessboard[i][j];
							this.chessboard[i][j] = 0;
							this.total --;
							score ++;
						}
					}
				}
			break;
		}
		arrlist = new ArrayList<Integer>(this.size);
		switch(mm){//方向換邊
			case 1://向下動
				for(int i = 0; i < this.size ;i++){ 
					for(int j = 0;j < this.size ;j++){
						if(this.chessboard[j][i] != 0){
							arrlist.add(this.chessboard[j][i]);
							this.chessboard[j][i] = 0;
						}
					}
					for(int x :arrlist)
						System.out.print(x);
					if(arrlist.isEmpty()){
						continue;
					}else{
						for(int j = this.size-1, k=arrlist.size()-1 ; k > -1 ; j--,k--){
							this.chessboard[j][i] = arrlist.get(k);
						}
					}
					arrlist.clear();
				}
			break;
			case 2://向右動
				for(int i = 0; i < this.size ;i++){ 
					for(int j = 0;j < this.size ;j++){
						if(this.chessboard[i][j] != 0){
							arrlist.add(this.chessboard[i][j]);
							this.chessboard[i][j] = 0;
						}
					}
					if(arrlist.isEmpty()){
						continue;
					}else{
						for(int j = this.size-1, k = arrlist.size()-1 ; k > -1 ; j--,k--){
							this.chessboard[i][j] = arrlist.get(k);
						}
					}
					arrlist.clear();
				}
			break;
			case 3://向左動
				for(int i = 0; i < this.size ;i++){ 
					for(int j = 0;j < this.size ;j++){
						if(this.chessboard[i][j] != 0){
							arrlist.add(this.chessboard[i][j]);
							this.chessboard[i][j] = 0;
						}
					}
					if(arrlist.isEmpty()){
						continue;
					}else{
						for(int j = 0, k = 0 ; k < arrlist.size() ; j++,k++){
							this.chessboard[i][j] = arrlist.get(k);
						}
					}
					arrlist.clear();
				}
			break;
			case 4://向上動
				for(int i = 0; i < this.size ;i++){ 
					for(int j = 0;j < this.size ;j++){
						if(this.chessboard[j][i] != 0){
							arrlist.add(this.chessboard[j][i]);
							this.chessboard[j][i] = 0;
						}
					}
					if(arrlist.isEmpty()){
						continue;
					}else{
						for(int j = 0, k=0 ; k < arrlist.size(); j++,k++){
							this.chessboard[j][i] = arrlist.get(k);
						}
					}
					arrlist.clear();
				}
			break;
		}
		arrlist = null;
		return score;
	}

	public boolean addPoint(){//增加新點
		//如果可以增加新點則回傳 ture 
		//反之則回傳 ture
		if(this.total == this.size * this.size){
			return false ;
		}else{
			Random rand = new Random();
			int i=0;
			while(true){
				int x = rand.nextInt(this.getSize());
				int y = rand.nextInt(this.getSize());
				if(this.chessboard[x][y] == 0){
					this.chessboard[x][y] = 2;
					break;
				}
			}
			this.total ++;
			return true;
		}
	}

	public static void main(String[] args) {
		Board2048 gg = new Board2048();
		while(true){	
			gg.addPoint();
			gg.Show();
			gg.Move(gg.getcmd());
		}
	}
}
