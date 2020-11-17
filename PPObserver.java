import java.util.*;

class PPObserver implements Observer{
	public char a = 'l';
	public void update(Observable obj,Object arg){
		if(arg instanceof Character){
			this.a = ((Character)arg);
			System.out.println("Good is work:"+ this.a);
		}
	}
}