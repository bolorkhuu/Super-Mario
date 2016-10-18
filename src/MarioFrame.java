
import javax.swing.JFrame;


public class MarioFrame {

	public MarioFrame(){
		JFrame marioFrame= new JFrame();
		marioFrame.add(new MarioPanel());
		marioFrame.setTitle(" mario ");
		marioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marioFrame.setSize(521, 500); //x y
		marioFrame.setVisible(true);
		marioFrame.setLocationRelativeTo(null);
		marioFrame.setResizable(false);
	}
	
}
