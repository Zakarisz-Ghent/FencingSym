package character;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Blade {
private int length;
private int Speed;
private int XSpeed;
private int YSpeed;
public Point handle;
public Point tip;
public int block;
public int lunge;
public BufferedImage pic;
private Point target;
public Blade(int length, int speed, Point handle, int block, int lunge, BufferedImage pic) {
	super();
	this.length = length;
	Speed = speed;
	this.handle = handle;
	this.block = block;
	this.lunge = lunge;
	this.pic = pic;
	XSpeed=0;
	YSpeed=0;
	
}
//sets the location of target for balde movement
public void setTarge(Point mouse){
	double dis=Math.sqrt((tip.x-mouse.x)*(tip.x-mouse.x)+(tip.y-mouse.y)*(tip.y-mouse.y));
	if(dis<length){
		target=new Point(mouse.getLocation());
	}else{
		target=ontoCircle(mouse, handle, length);
	}
}
/*p=point to convert
 * c=center of circle
 * r=radius
 * converts point to closest point on circle
 * 
 */
private Point ontoCircle(Point p,Point c,int r){
	double vX=p.x-c.x;
	double vY=p.y-c.y;
	double magV=Math.sqrt(vX*vX+vY*vY);
	double aX=c.x+vX/magV*r;
	double aY=c.y+vY/magV*r;
	Point tip=new Point((int)aX,(int)aY);
	return tip;
}
void move(){
	if(tip.x<target.x){
		
	}
}
}
