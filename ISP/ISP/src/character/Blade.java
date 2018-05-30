package character;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class Blade {
private boolean control;
private Line2D.Double line;
private int length;
private int Speed;
private int XSpeed;
private int YSpeed;
public Point handle;
public Point tip;
public int block;
public int blockCD;
public int lungeCD;
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
	line=new Line2D.Double(tip, handle);
}
//sets the location of target for balde movement
public void setTarget(Point mouse){
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
	Point to=new Point((int)aX,(int)aY);
	return to;
}
public void bladeMove(Point mouse){
	if(control){
	Point xy=ontoCircle(mouse,handle,length);
	move(xy);
	}else{
		if(tip.x!=target.x&&tip.y!=target.y){
		Point xy=ontoCircle(target,handle,length);
		move(xy);
		}else{
			control=true;
			this.bladeMove(mouse);
		}
	}
}
public Boolean colisionBlade(Blade b1,Blade b2){
	if(b1.getTip()==b2.getTip()){
		if(b1.getBlock()==0&&b2.getBlock()==0){
		b1.setBlockCD(b1.getBlock());
		b2.setBlockCD(b2.getBlock());
		b1.setControl(false);
		b2.setControl(false);
		b1.setTarget(new Point(b1.tip.x-200,b1.tip.y+100));
		b2.setTarget(new Point(b2.tip.x+200,b2.tip.y+100));
		return true;
		}else{
			return false;
		}
	}
	else if(b1.getLine().contains(b2.getTip())){
		if(b1.getBlockCD()==0){
			b1.setBlockCD(b1.getBlock());
			b2.setControl(false);
			b2.setTarget(new Point(b2.tip.x+200,b2.tip.y+100));
			return true;
		}else return false;
	}else if(b2.getLine().contains(b1.getTip())){
		if(b2.getBlockCD()==0){
			b2.setBlockCD(b2.getBlock());
			b1.setControl(false);
			b1.setTarget(new Point(b1.tip.x-200,b1.tip.y+100));
			return true;
		}else return false;
	}else return false;
}
void move(Point target){
	if(tip.x<target.x){
		int Xchange=target.x-tip.x;
		if(tip.y<target.y){
			int Ychange=target.y-tip.y;
			double multiple=1/(Xchange+Ychange)/Xchange;
			XSpeed=(int) (Speed*multiple);
			YSpeed=Speed-XSpeed;
			tip=new Point((int)(tip.getX()+XSpeed),(int)(tip.getY()+YSpeed));
		}
	}
}
public int getSpeed() {
	return Speed;
}
public void setSpeed(int speed) {
	Speed = speed;
}
public int getXSpeed() {
	return XSpeed;
}
public void setXSpeed(int xSpeed) {
	XSpeed = xSpeed;
}
public int getYSpeed() {
	return YSpeed;
}
public void setYSpeed(int ySpeed) {
	YSpeed = ySpeed;
}
public Point getHandle() {
	return handle;
}
public void setHandle(Point handle) {
	this.handle = handle;
}
public Point getTip() {
	return tip;
}
public void setTip(Point tip) {
	this.tip = tip;
}
public int getLunge() {
	return lunge;
}
public void setLunge(int lunge) {
	this.lunge = lunge;
}
public BufferedImage getPic() {
	return pic;
}
public void setPic(BufferedImage pic) {
	this.pic = pic;
}
public Point getTarget() {
	return target;
}

public boolean isControl() {
	return control;
}
public Line2D.Double getLine() {
	return line;
}
public int getLength() {
	return length;
}
public int getBlock() {
	return block;
}
public int getBlockCD() {
	return blockCD;
}
public void setBlockCD(int blockCD) {
	this.blockCD = blockCD;
}
public int getLungeCD() {
	return lungeCD;
}
public void setLungeCD(int lungeCD) {
	this.lungeCD = lungeCD;
}
private void setControl(boolean control) {
	this.control = control;
}

}
