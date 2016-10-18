import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MarioPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public Image backG1 , backG2 ,backG3 , backG4 , backG5, backG6, backG7, backG8, backG9, backG10, backG11, backG12, backG13, backG14, backG15;
	public ImageIcon prinzess = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/mario-bros-princess-peach.gif");
	public ImageIcon icon1 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm1.png");
	public ImageIcon icon2 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm2.png");
	public ImageIcon icon3 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm1.png");
	public ImageIcon icon4 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm1.png");
	public ImageIcon icon5 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm5.png");
	public ImageIcon icon6 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm6.png");
	public ImageIcon icon7 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm7.png");
	public ImageIcon icon8 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm8.png");
	public ImageIcon icon9 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm1.png");
	public ImageIcon icon10= new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm15.png");
	public ImageIcon icon11= new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm11.png");
	public ImageIcon icon12= new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm1.png");
	public ImageIcon icon13= new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm13.png");
	public ImageIcon icon14= new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm14.png");
	public ImageIcon icon15= new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/Bilder/nm15.png");
	
	public ImageIcon ss = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/fire-mario1Stop.png");
	public Image stop= ss.getImage();
	
	public Image prinz= prinzess.getImage();
	public Mario mario;
	public Koopa koopa;
	public Tree tree;
	public Coin marioCoin , counterCoin;
	public QBlock qBlock;
	public BreakBlock breakBlock;
	public static Font font = new Font("Monospaced", Font.BOLD, 24);
	public static Font font1 = new Font("Monospaced", Font.BOLD, 12);
	public static Font font2 = new Font("Monospaced", Font.BOLD, 30);

	public int punkt=10000;
	public int coin =0;
	public Bullet bullet;
	public double time=300;
	
	public boolean fvisible;
	public MarioPanel(){
		
		marioCoin= new Coin();
		mario = new Mario();
		counterCoin = new Coin();
		bullet =  new Bullet(250, mario.getY()-40);
		breakBlock =new BreakBlock();
		qBlock = new QBlock();
		koopa = new Koopa();//524-mario.newX3
		tree = new Tree();
		fvisible=true;
		

		addKeyListener(new ActionClass());
		setFocusable(true);
		backG1= icon1.getImage();
		backG2 =icon2.getImage();
		backG3 =icon3.getImage();
		backG4 =icon4.getImage();
		backG5 =icon5.getImage();
		backG6 =icon6.getImage();
		backG7 =icon7.getImage();
		backG8 =icon8.getImage();
		backG9 =icon9.getImage();
		backG10=icon10.getImage();
		backG11 =icon11.getImage();
		backG12 =icon12.getImage();
		backG13 =icon13.getImage();
		backG14 =icon14.getImage();
		backG15 =icon15.getImage();
		new Timer(15, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mario.move();
				mario.jump();
				bullet.move();
				counterCoin.move();
				breakBlock.move();
				qBlock.move();
				koopa.move();
				tree.move();
				repaint();
			}
		}).start();	
		
	}
	public boolean getfVisible(){
		return fvisible;
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// Mario -Background -Pictures
		g2d.drawImage(backG1, 524-mario.newX1, 0, null); // newX1=524
		g2d.drawImage(backG2, 524-mario.newX2,-2, null); // newX2=0
		g2d.drawImage(backG3, 524-mario.newX3, 0, null); // newX3=-524
		g2d.drawImage(backG4, 524-mario.newX4, 0, null);
		g2d.drawImage(backG5, 524-mario.newX5, 0, null);
		g2d.drawImage(backG6, 524-mario.newX6, 0, null);
		g2d.drawImage(backG7, 524-mario.newX7, 0, null);
		g2d.drawImage(backG8, 524-mario.newX8, 0, null);
		g2d.drawImage(backG9, 524-mario.newX9, 0, null);
		g2d.drawImage(backG10, 524-mario.newX10, 0, null);
		g2d.drawImage(backG11, 524-mario.newX11, 0, null);
		g2d.drawImage(backG12, 524-mario.newX12, 0, null);
		g2d.drawImage(backG13, 524-mario.newX13, 0, null);
		g2d.drawImage(backG14, 524-mario.newX14, 0, null);
		g2d.drawImage(backG15, 524-mario.newX15, 0, null);
		
		// script of labels
		 g2d.setFont(font);
         g2d.setColor(Color.white);
         g2d.drawString("MARIO", 20, 20);
         g2d.drawString("" + punkt, 20, 38);
         
         g2d.drawImage(marioCoin.getImage(),110,23, null);
         g2d.drawString(" x" + coin, 116, 38);
         
         g2d.drawString("WORLD", 210, 20);
         g2d.drawString("1-4", 216, 38);
         
         time-=0.01;
         String s = Double.toString(time);
         s = s.substring(0, 6);
         
         g2d.drawString("TIME", 310, 20);
         g2d.drawString(""+s , 316, 38);
         g2d.drawImage(prinz, 400, 00, null);
         
         // bullet
         if(bullet.visible==true){
        	 if(mario.rechts==true){
        		 bullet.dX=8;
        		 }
        	 else{
        		 bullet.dX=-8;
        	 }
         g2d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
         }
         
        
      // Koopa
         
         if( (bullet.getX()>=koopa.getX()-10 && bullet.getX()<=koopa.getX()+10 && bullet.visible==true) ){
        	 koopa.setDY(5);
        	 bullet.visible=false;
        	 
        	 g2d.setFont(font1);
	         g2d.setColor(Color.white);
	         g2d.drawString("100", 270, 350);   
	     	coin++;
			punkt+=10;
        	 
         }
    	g2d.drawImage(koopa.getImage(),koopa.getX(), koopa.getY(), null);
         // win message
    	if(mario.newX2 >=4482 && mario.newX2<=4850){
    		 g2d.setFont(font2);
	         g2d.setColor(Color.red);
	         g2d.drawString("-YOU WIN-", 200, 220); 
    	}
    	
    	//tree
    	  if( (tree.getX()>=mario.getX()-10 && tree.getX()<=mario.getX()+10) ){
    		  powerup();
         	 tree.setVisible(false);
         	 mario.setImage(stop);
         	 mario.setY(356);
         	 }
    	if(tree.getVisible()==true){
    		g2d.drawImage(tree.getImage(), tree.getX(), tree.getY(), null);
    	}
        // Super-Mario picture
 		g2d.drawImage(mario.getImage(), mario.getX(), mario.getY(), null);
         
 		// setting of jump high
 		if((mario.newX2 >=252 && mario.newX2<=306) || (mario.newX2 >=384 && mario.newX2<=572) || (mario.newX2 >=2252 && mario.newX2<=2372)  || (mario.newX2 >=2808 && mario.newX2<=2868)  || (mario.newX2 >=3006 && mario.newX2<=3092)  || (mario.newX2 >=3202 && mario.newX2<=3258)  || (mario.newX2 >=3304 && mario.newX2<=3358)  || (mario.newX2 >=3398 && mario.newX2<=3450)){
			mario.setHoch(288);
		}
 		else{
 			mario.setHoch(200);
 		}
 	    // coins counter
		if((mario.newX2 >=262 && mario.newX2<=300 && mario.high==true) || (mario.newX2 >=432 && mario.newX2<=460 && mario.high==true) || (mario.newX2 >=504 && mario.newX2<=530 && mario.high==true) || (mario.newX2 >=2302 && mario.newX2<=2324 && mario.high==true)  || (mario.newX2 >=3210 && mario.newX2<=3240 && mario.high==true) || (mario.newX2 >=3314 && mario.newX2<=3344 && mario.high==true) || (mario.newX2 >=3400 && mario.newX2<=3424 && mario.high==true)){
			counterCoin.visible=true;
			g2d.drawImage(counterCoin.getImage(), counterCoin.getX(), counterCoin.getY(), null);
			coin++;
			punkt+=10;
			CoinSound();
			g2d.setFont(font1);
	         g2d.setColor(Color.white);
	         g2d.drawString("160", 270, counterCoin.getAy());      
		}
		// breaking block
		if(mario.newX2 >=398 && mario.newX2<=422 && mario.high==true){
			breakBlock.visible=true;
			g2d.drawImage(breakBlock.getImage(), 524-mario.newX2+ 133, breakBlock.getY(),null);
		}
		if(mario.newX2 >=470 && mario.newX2<=490 && mario.high==true){
			breakBlock.visible=true;
			g2d.drawImage(breakBlock.getImage(), 524-mario.newX2+ 199, breakBlock.getY(),null);
		}
		if(mario.newX2 >=534 && mario.newX2<=560 && mario.high==true){
			breakBlock.visible=true;
			g2d.drawImage(breakBlock.getImage(), 524-mario.newX2+ 199+66, breakBlock.getY(),null);
		}
		if(mario.newX2 >=2276 && mario.newX2<=2292 && mario.high==true){
			breakBlock.visible=true;
			g2d.drawImage(breakBlock.getImage(), 524-mario.newX5+429, breakBlock.getY(), null);
		}
		if(mario.newX2 >=2338 && mario.newX2<=2352 && mario.high==true){
			breakBlock.visible=true;
			g2d.drawImage(breakBlock.getImage(), 524-mario.newX5+429+63, breakBlock.getY(), null);
		}
		if(mario.newX2 >=2824 && mario.newX2<=2850 && mario.high==true){
			breakBlock.visible=true;
			g2d.drawImage(breakBlock.getImage(), 524-mario.newX6+462, breakBlock.getY(), null);
		}
		if(mario.newX2 >=3022 && mario.newX2<=3040 && mario.high==true){
			breakBlock.visible=true;
			g2d.drawImage(breakBlock.getImage(), 524-mario.newX7+132, breakBlock.getY(), null);
		}
		if(mario.newX2 >=3062 && mario.newX2<=3078 && mario.high==true){
			breakBlock.visible=true;
			g2d.drawImage(breakBlock.getImage(), 524-mario.newX7+132+33, breakBlock.getY(), null);
		}
		
		
		if(mario.newX2 >=252 && mario.newX2<=306 && mario.high==true){
			qBlock.visible=true;
			g2d.drawImage(qBlock.getImage(), 524-mario.newX2, qBlock.getY(),null);
		}
		if(mario.newX2 >=432 && mario.newX2<=460 && mario.high==true){
			qBlock.visible=true;
			g2d.drawImage(qBlock.getImage(), 524-mario.newX2+166, qBlock.getY(),null);
		}
		if(mario.newX2 >=504 && mario.newX2<=530 && mario.high==true){
			qBlock.visible=true;
			g2d.drawImage(qBlock.getImage(), 524-mario.newX2+232, qBlock.getY(),null);
		}
		if(mario.newX2 >=2310 && mario.newX2<=2322 && mario.high==true){
			qBlock.visible=true;
			g2d.drawImage(qBlock.getImage(), 524-mario.newX5+429+33, qBlock.getY(),null);
		}
		if(mario.newX2 >=3210 && mario.newX2<=3240 && mario.high==true){
			qBlock.visible=true;
			g2d.drawImage(qBlock.getImage(), 524-mario.newX7+330, qBlock.getY(),null);
		}
		if(mario.newX2 >=3314 && mario.newX2<=3344 && mario.high==true) {
			qBlock.visible=true;
			g2d.drawImage(qBlock.getImage(), 524-mario.newX7+429, qBlock.getY(),null);
		}
		if(mario.newX2 >=3400 && mario.newX2<=3424 && mario.high==true) {
			qBlock.visible=true;
			g2d.drawImage(qBlock.getImage(), 524-mario.newX8, qBlock.getY(),null);
		}
	}
	public class ActionClass extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			mario.kReleased(e);
			bullet.kReleased(e);
		}
		public void keyPressed(KeyEvent e){
			mario.kPressed(e);
			bullet.kPressed(e);
		}
	}
	
	public void CoinSound() {
		
	    try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/music/coin.wav"));
            AudioFormat af     = audioInputStream.getFormat();
            int size      = (int) (af.getFrameSize() * audioInputStream.getFrameLength());
            byte[] audio       = new byte[size];
            DataLine.Info info      = new DataLine.Info(Clip.class, af, size);
            audioInputStream.read(audio, 0, size);
            
           // for(int i=0; i < 32; i++) {
                Clip clip = (Clip) AudioSystem.getLine(info);
                clip.open(af, audio, 0, size);
                clip.start();
           // }
        }catch(Exception e){ e.printStackTrace(); }
        
 
	}
    public void powerup(){
	    try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/music/powerup.wav"));
            AudioFormat af     = audioInputStream.getFormat();
            int size      = (int) (af.getFrameSize() * audioInputStream.getFrameLength());
            byte[] audio       = new byte[size];
            DataLine.Info info      = new DataLine.Info(Clip.class, af, size);
            audioInputStream.read(audio, 0, size);
            
           // for(int i=0; i < 32; i++) {
                Clip clip = (Clip) AudioSystem.getLine(info);
                clip.open(af, audio, 0, size);
                clip.start();
           // }
        }catch(Exception e){ e.printStackTrace(); }
	}
}

