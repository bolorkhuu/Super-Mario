import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;


public class Mario {
	
	public int x,dX,y,dY,newX1,newX2,newX3,newX4,newX5,newX6,newX7,newX8,newX9,newX10,newX11,newX12,newX13,newX14,newX15;
	public ImageIcon s = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/fire-mario1Stop.png");
	public ImageIcon j = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/fire-mario1Jump.png");
	public ImageIcon g = new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/fire-mario1.gif");
	
	public ImageIcon ls =new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/fire-mario1LeftStop.png");
	public ImageIcon lj =new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/fire-mario1LeftJump.png");
	public ImageIcon lg =new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/fire-mario1Sp.gif");
	public ImageIcon startIcon =new ImageIcon("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/picm/klein.gif");

	
	public Image stop= s.getImage();
	public Image jump = j.getImage();
	public Image going= g.getImage();
	public Image startImg= startIcon.getImage();
	
	public Image leftStop =ls.getImage();
	public Image leftJump =lj.getImage();
	public Image leftGoing= lg.getImage();
	public Image currentImage;
	public boolean done, rechts, high , moveRight , moveLeft;
	public int  hoch , tief ; // 4 for jump() 
	public Mario(){
		currentImage= startImg; // start of game
		rechts=true;//
		done=true; // if jumped then true;
		high=false;// if y==maxY then high true
		moveRight =true;
		moveLeft  =true;
		x=250;// absolutely x coordinate
		y=368;// absolutely y coordinate
				
		hoch =292;// 288 new hoch
		tief =356;
	
		newX1 =524;  
		newX2 =0;
		newX3 =-524;
		newX4 =-524-524;
		newX5 =-524-524-524;
		newX6 =-524-524-524-524;
		newX7 =-524-524-524-524-524;
		newX8 =-524-524-524-524-524-524;
		newX9 =-524-524-524-524-524-524-524;
		newX10 =-524-524-524-524-524-524-524-524;
		newX11 =-524-524-524-524-524-524-524-524-524;
		newX12 =-524-524-524-524-524-524-524-524-524-524;
		newX13 =-524-524-524-524-524-524-524-524-524-524-524;
		newX14 =-524-524-524-524-524-524-524-524-524-524-524-524;
		newX15 =-524-524-524-524-524-524-524-524-524-524-524-524-524;		
	}
	public void move(){
		System.out.println(newX2);
		newX1= newX1 +dX;
		newX2= newX2 +dX;
		newX3= newX3 +dX;
		newX4= newX4 +dX;
		newX5= newX5 +dX;
		newX6= newX6 +dX;
		newX7= newX7 +dX;
		newX8= newX8 +dX;
		newX9= newX9 +dX;
		newX10= newX10 +dX;
		newX11= newX11 +dX;
		newX12= newX12 +dX;
		newX13= newX13 +dX;
		newX14= newX14 +dX;
		newX15= newX15 +dX;
}
	public Image getImage(){
		return currentImage;
	}
	public void setImage(Image newImage){
		currentImage= newImage;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getDY(){
		return dY;
	}
	public int getHoch(){
		return hoch;
	}
	public int getTief(){
		return tief;
	}
	public void setX(int x){ // not used
		this.x= x;
	}
	public void setY(int y){
		this.y= y;
	}
	public void setHoch(int hoch){
		this.hoch=hoch;
	}
	public void setTief(int tief){
		this.tief=tief;
	}
	public void jump(){
		if(y>=hoch && high ==false && done ==false){
			y=y-3;
			if(y<=hoch){
				y=hoch;
			high=true;
			}
		}
		if(y<=tief && high ==true && done == false){
			y=y+5;
			if(y>=tief){
				y=tief;
				done=true;
				high=false;
				if(rechts==true && dX==0){
					currentImage=stop;
				}
				if(rechts==false && dX==0){
					currentImage=leftStop;
				}
			}
		}
	}
	public void moveSet(){
			//if((newX2>=0 && newX2<646) || (newX2>738 && newX2<974) || (newX2>1064 && newX2<1238)){
				//tief=356;
				//}
			if(newX2>=646 && newX2<=650 && y>=288){
				moveRight=false;
			}
			else{
				moveRight=true;
			}
			//if((newX2>=646 && newX2<=738)|| (newX2>=974 && newX2<=1064) || (newX2>=1238 && newX2<=1326) ){
				//tief=288;
				//}
	}
	public void kPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			moveSet();
			rechts= true;
			if(moveRight==true){
				dX=2;
			}
			if(moveRight==false){
				dX=0;
			}
			if(done==true){
			    currentImage = going;
			}
			if(done==false){
				currentImage=jump;
			}
			}
		if(key ==KeyEvent.VK_LEFT){
			moveSet();
			rechts= false;
			if(moveLeft==true){
				dX=-2;
			}
			if(done==true){
				currentImage = leftGoing;
			}
			if(done==false){
				currentImage = leftJump;
			}
		    }
		if(key ==KeyEvent.VK_UP){
			done=false;
			JumpSound();
			if(rechts==true ){
				currentImage = jump;
			}
			if(rechts==false){
				currentImage = leftJump;
			}
		}
	}
	public void kReleased(KeyEvent e){
		int key = e.getKeyCode();
		if(key== KeyEvent.VK_RIGHT){
			currentImage =stop;
			rechts=true;
			dX=0;
		}
		if(key==KeyEvent.VK_LEFT){
			currentImage = leftStop;
			rechts=false;
			dX=0;
		}
	}
	 public void JumpSound() {
			
		    try{
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Volumes/Arbeit/workspaces/JAVA/workspace/Mario/music/jump.wav"));
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
