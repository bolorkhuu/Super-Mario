
import javax.swing.JFrame;


public class Start {
	public Start(){
		JFrame marioFrame1= new JFrame();
		marioFrame1.add(new welcome());
		marioFrame1.setTitle(" mario ");
		marioFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marioFrame1.setSize(521, 500); //x y
		marioFrame1.setVisible(true);
		marioFrame1.setLocationRelativeTo(null);
		marioFrame1.setResizable(false);
	}
	public static void main(String[] args) {
		new Start();
	}
}
