import java.awt.Image;

import javax.swing.ImageIcon;


public class Coin {
	public ImageIcon Icon = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/coin.gif"); 
	public Image Img ;
	
	public boolean visible;
	public int x ,dX , y , dY , ay;
	public Coin(){
		Img=Icon.getImage();		
		x=250;
		ay=250;
		y=230;
		dY=-10;
		dX=-7;
		visible=false;
	}
	public void move() {
		if(visible==true){
			x=x+dX;
			y=y+dY;
			ay--;
			if(x<=110 || y<=23){
				x=250;
				ay=250;
				y=230;
			}
			
		}
	}
	public int getAy(){
		return ay;
	}
	public void setAy(int ay){
		this.ay=ay;
	}
	public Image getImage(){
		return Img;
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
	public void setY(int y){
		this.y=y;
	}
}
