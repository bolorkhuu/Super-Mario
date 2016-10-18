import java.awt.Image;

import javax.swing.ImageIcon;


public class Tree {
	public int x, y , dX;
	public Image imgR,  currentImage;
	public ImageIcon icon1= new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/marioTree.png");
	public boolean visible;
	public Tree(){
		x=560;
		y=350;
		imgR= icon1.getImage();
		dX=-3;
		imgR  =icon1.getImage();
		currentImage=imgR;
		visible=true;
	}
	public void move(){
		x=x+dX;
	}
	public boolean getVisible(){
		return visible;
	}
	public void setVisible(boolean visible){
		this.visible=visible;
	}
	public Image getImage(){
		return currentImage;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x=x;
	}
}
