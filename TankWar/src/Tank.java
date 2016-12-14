import java.awt.*;
import java.awt.event.*;

public class Tank {
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	
	TankWar tc;//持有对方引用
	
	private int x, y;
    private boolean bL=false,bU=false,bR=false,bD=false;
    enum direction{L,LU,U,RU,R,RD,D,LD,STOP};
    
    private direction dir=direction.STOP;
    private direction ptdir=direction.D;
    
	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Tank(int x,int y,TankWar tc){
		this(x, y);
		this.tc=tc;
	}
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		
		switch(ptdir){
		   case L:g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y+Tank.HEIGHT/2);break;
		   case LU:g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y);break;
		   case U:g.drawLine(x+Tank.WIDTH/2, y+Tank.WIDTH/2, x+Tank.WIDTH/2, y);break;
		   case RU:g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y);break;
		   case R:g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y+Tank.HEIGHT/2);break;
		   case RD:g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y+Tank.HEIGHT);break;
		   case D:g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH/2, y+Tank.HEIGHT);break;
		   case LD:g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y+Tank.HEIGHT);break;
		}
		
		move();
	}
	
	void move(){
		switch(dir){
		   case L:x-=XSPEED;break;
		   case LU:x-=XSPEED;y-=YSPEED;break;
		   case U:y-=YSPEED;break;
		   case RU:x+=XSPEED;y-=YSPEED;break;
		   case R:x+=XSPEED;break;
		   case RD:x+=XSPEED;y+=YSPEED;break;
		   case D:y+=YSPEED;break;
		   case LD:x-=XSPEED;y+=YSPEED;break;
		   case STOP:break;
		}
		
		if (this.dir!=direction.STOP) {
			this.ptdir=this.dir;
		}
	}
	
	
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		
		case KeyEvent.VK_LEFT :
			bL=true;
			break;
		case KeyEvent.VK_UP :
			bU=true;
			break;
		case KeyEvent.VK_RIGHT :
			bR=true;
			break;
		case KeyEvent.VK_DOWN :
			bD=true;
			break;
		}
		locateDirection();
	}
	
	void locateDirection(){
		if (bL&&!bU&&!bR&&!bD) {
			dir=direction.L;
		}
		else if (bL&&bU&&!bR&&!bD) {
			dir=direction.LU;
		}
		else if (!bL&&bU&&!bR&&!bD) {
			dir=direction.U;
		}
		else if (!bL&&bU&&bR&&!bD) {
			dir=direction.RU;
		}
		else if (!bL&&!bU&&bR&&!bD) {
			dir=direction.R;
		}
		else if (!bL&&!bU&&bR&&bD) {
			dir=direction.RD;
		}
		else if (!bL&&!bU&&!bR&&bD) {
			dir=direction.D;
		}
		else if (bL&&!bU&&!bR&&bD) {
			dir=direction.LD;
		}
		else if (!bL&&!bU&&!bR&&!bD) {
			dir=direction.STOP;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_CONTROL:
			fire();
			break;
		case KeyEvent.VK_LEFT :
			bL=false;
			break;
		case KeyEvent.VK_UP :
			bU=false;
			break;
		case KeyEvent.VK_RIGHT :
			bR=false;
			break;
		case KeyEvent.VK_DOWN :
			bD=false;
			break;
		}
		locateDirection();
	}
	
	public Missile fire(){
		int x=this.x+Tank.WIDTH/2-Missile.WIDTH/2;
		int y=this.y+Tank.HEIGHT/2-Missile.HEIGHT/2;
	  	Missile m=new Missile(x, y, ptdir);
	  	tc.missiles.add(m);
	  	return m;
	}
	
	
		
}