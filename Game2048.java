interface GameRole{
	public boolean win(Board2048 a);
	public boolean fail(Board2048 a);
}

class Game2048 implements GameRole{
	public int score;
	Game2048(){
		this.score = 0;
	}
	public boolean win(Board2048 a){
		return this.fail(a);
	}
	public boolean fail(Board2048 a){
		if(!a.addPoint()){
			if(this.spCheck(a)){
				return false;
			}else{
				return true; 
			}
		}else{
			return true; 
		}
	}
	public boolean spCheck(Board2048 a){
		
	}
	public static void main(String[] args) {
		Board2048 gg = new Board2048();
		Game2048 rule = new Game2048();
		while(true){	
			if( rule.fail(gg) ){
				System.out.println("Game over !!!");
				break;
			}else{
				gg.Show();
				System.out.println("the Socre is :" + rule.score);
				rule.score += gg.Move(gg.getcmd());
			}
		}
	}
}