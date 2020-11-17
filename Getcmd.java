import java.util.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class DelegatedObservable extends Observable {
	public void clearChanged(){
		super.clearChanged();
	}
	public void setChanged(){
		super.setChanged();
	}
}

class Getcmd extends JFrame implements KeyListener {
	private DelegatedObservable obs;
	private static JPanel jp = new JPanel();
	private int x;
	private int y;

	Getcmd(){
		obs = new DelegatedObservable();
		this.x = x;
		this.y = y;
		this.add(jp);

		this.setSize(0, 0);// 防止記憶體洩露
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addObserver(Observer ob){
		obs.addObserver(ob);
	}

	public static void main(String[] args) {
		Getcmd rb = new Getcmd();
		rb.addKeyListener(rb);
		// PPObserver aa = new PPObserver();
		// rb.addObserver(aa);
		Game2048 rule = new Game2048();
		rb.addObserver(rule);
	}

	public void keyTyped(KeyEvent e) {
	
	}
	public void keyPressed(KeyEvent e) {
		char a = e.getKeyChar();
		switch(a){
			case 'a' :
			case 's' :
			case 'd' :
			case 'w' :
				obs.setChanged();
				obs.notifyObservers(new Character(a));
			break;
			case 'q':
				System.out.println("quit!!!");
				System.exit(0);
			break;
			default:
				System.out.println("error please input again!");	
		}
	}
	public void keyReleased(KeyEvent e) {
	
	}

}