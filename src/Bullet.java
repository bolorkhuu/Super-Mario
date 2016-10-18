import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;


public class Bullet {
	
	public int x, y , dX ,dY;
	public boolean visible;
	
	public Image img;
	public ImageIcon icon1 = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/bullet.gif");
	public Bullet(int startX, int startY){
		x=startX;
		y=startY;
		
		img = icon1.getImage();
		visible = false;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x= x;
	}
	public void setY(int y){
		this.y= y;
	}
	public void setDX(int dX){
		this.dX=dX;
	}
	public Image getImage(){
		return img;
	}
	public void move(){
		x=x+dX;
		y=y+dY;
		if(y>390){
			visible=false;
		}
	}
	public boolean getVisible(){
		return visible;
	}
	public void setVisible(boolean visible){
		this.visible=visible;
	}
	public void kPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_DOWN){
			visible =true;
			dX=10;
			dY=1;
			x=250;
			y=360;
			FireballSound();
		}
	}
	public void kReleased(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_DOWN && visible ==true){
			visible =true;
			dX=-10;
			dY=2;
		}
	}
	 public void FireballSound() {
		    try{
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/music/fireball.wav"));
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
