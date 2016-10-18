import java.awt.Image;

import javax.swing.ImageIcon;


public class Koopa {
	public int a, x, y , dX ,dY;
	public Image imgR, imgL , currentImage;
	public ImageIcon icon1= new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/koopaR.gif");
	public ImageIcon icon2= new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/koopaL.gif");
	public boolean visible;
	public Koopa(){
		x=900;
		y=356;
		imgR= icon1.getImage();
		imgL= icon2.getImage();
		dY=0;
		dX=-2;
		currentImage=imgL;
	}
	public void move(){
		x=x+dX;
		y=y+dY;
		if(y>=500 || x<-700){
			y=356;
			x=-700;
			dY=0;
			dX=2;
			currentImage=imgR;
		}
		if(x>1500){
			currentImage=imgL;
			y=356;
			x=1500;
			dX=-2;
		}
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
	public void setDX(int dX){
		this.dX=dX;
	}
	public void setDY(int dY){
		this.dY=dY;
	}
}
