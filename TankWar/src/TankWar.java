import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankWar extends Frame {

	private static final long serialVersionUID = 1L;
	public static final int GAME_WIDTH = 800;
	public static final int GAME_Height = 600;// 设置宽度和高度用常量
	/**
	 * @param args
	 */
	Tank mytTank = new Tank(50, 50,this);
    List<Missile>missiles=new ArrayList<Missile>();
	Image offImage = null;

	// repaint的时候默认运行update，update方法里运行paint，这里重写update，加入了自己的代码，然后调用paint
	// 双缓冲解决图片震动
	public void update(Graphics g) {
		if (offImage == null) {
			offImage = this.createImage(GAME_WIDTH, GAME_Height);
		}
		Graphics gOffScreen = offImage.getGraphics();// 为offImage获得画笔
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);// 设置界面背景色
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_Height);// 画一次刷新一次界面
		gOffScreen.setColor(c);
		paint(gOffScreen);// 用offimage和画笔作画
		g.drawImage(offImage, 0, 0, null);// 把画画到前面来

	}

	public void paint(Graphics g) {// 在一个页面上画画
		String aString=missiles.size()+"";
		g.drawString("missiles count: "+aString, 10, 50);
		
		for (int i = 0; i < missiles.size(); i++) {
			Missile m=missiles.get(i);
			m.draw(g);
		}
		mytTank.draw(g);
	}

	public void lauchFrame() {
		this.setLocation(400, 300);
		this.setSize(GAME_WIDTH, GAME_Height);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		this.addKeyListener(new KeyMonitor());
		this.setResizable(false);
		this.setBackground(Color.GREEN);
		setVisible(true);

		new Thread(new PaintThread()).start();// 启动定时重画线程
	}

	public static void main(String[] args) {
		TankWar tc = new TankWar();
		tc.lauchFrame();

	}

	private class PaintThread implements Runnable {

		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			mytTank.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
            mytTank.keyReleased(e);        
		}
	}

}
