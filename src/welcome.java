import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class welcome extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public Image img1 , mgl , eng , mrio;
	public ImageIcon icon1 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/logo.gif");
	public ImageIcon icon2 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/mongolei.gif");
	public ImageIcon icon3 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/imgres.jpeg");
	public ImageIcon icon4 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/spmarioao3.gif");

	public static Font font1 = new Font("Monospaced", Font.BOLD, 18);
	public static Font font2 = new Font("Monospaced", Font.BOLD, 14);

	public welcome(){
		
		setBackground(Color.black);
		img1 = icon1.getImage();
		mgl = icon2.getImage();
		eng = icon3.getImage();
		mrio = icon4.getImage();
		addKeyListener(new AC());
		setFocusable(true);

		
		new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				repaint();
			}
		}).start();	
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(mgl, 300, 40, null);
		g2d.drawImage(eng, 380, 40, null);

		g2d.drawImage(img1, 100, 100, null);
		
		g2d.drawImage(mrio, 200, 300 , null);
		
		g2d.setFont(font1);
        g2d.setColor(Color.white);
        g2d.drawString("press enter to start", 150, 250);
        g2d.drawString("тоглохыг хүсвэл ENTER -г дарна уу", 100, 270);
		
        g2d.setFont(font1);
        g2d.setColor(Color.pink);
        g2d.drawString("forbidden in ", 80, 80);
        
        g2d.setFont(font1);
        g2d.setColor(Color.RED);
        g2d.drawString("WORLD 1-4", 200, 420);
	}
	public class AC extends KeyAdapter{
		public void keyReleased(KeyEvent e){
		
		}
		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			
			if(key== KeyEvent.VK_ENTER){
				new MarioFrame();
				
			}
		}
	}

	
	
}
