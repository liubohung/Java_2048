import java.util.*;
interface GameRole{
	public boolean win(Board2048 a);
	public boolean fail(Board2048 a);
}

class Game2048 implements Observer{
	public int score;
	public Board2048 gg ;
	Game2048(){
		this.gg = new Board2048();
		this.score = 0;
	}
	public boolean win(Board2048 a){
		return this.fail(a);
	}
	public boolean fail(Board2048 a){
		if(!a.addPoint()){
			return this.spCheck(a); 
		}else{
			return false; 
		}
	}

	public boolean spCheck(Board2048 a){
		boolean re = true;
		int[][] arr = a.checkBoard();
		for(int i =0 ;i < a.getSize();i++){
			for(int j =0 ;j<a.getSize()-1;j++){
				if(arr[i][j] == arr[i][j+1]){
					re = false;
					return re;
				}
			}	
		}
		return re;
	}

	@SuppressWarnings("all")
	public void update(Observable obj,Object arg){
		// if(arg instanceof Character){
		// 	System.out.println("Good is work:"+((Character)arg));
		// }
		if( this.fail(this.gg) ){
			System.out.print("\033[H\033[2J");
			System.out.println("Game over !!!");
		}else{
			int re = 0;
			switch(((Character)arg)){
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
			this.score += this.gg.Move(re);
			this.gg.Show();
			System.out.println("the Socre is :" + this.score);
			System.out.println("     w^     ");
			System.out.println("<a   s\\/   d>");
			System.out.print("please move: ");
			
		}
	}

	public static void main(String[] args) {
		Game2048 rule = new Game2048();
		while(true){	
			if( rule.fail(rule.gg) ){
				System.out.println("Game over !!!");
				break;
			}else{
				rule.gg.Show();
				System.out.println("the Socre is :" + rule.score);
				rule.score += rule.gg.Move(rule.gg.getcmd());
			}
		}
	}
}