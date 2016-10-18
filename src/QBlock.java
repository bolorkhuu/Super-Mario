import java.awt.Image;

import javax.swing.ImageIcon;


public class QBlock {

	public Image img;
	public ImageIcon icon1= new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/movedQBlock1.png");
	public int x;
	public int y , dY;
	public boolean visible;
	public QBlock(){
		img=icon1.getImage();
		x=250;
		y=260;
		visible=false;
	}
	public void move(){

	}
	public Image getImage(){
		return img;
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
}