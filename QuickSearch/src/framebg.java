
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public  class framebg extends JFrame implements ActionListener {
	
	JButton but;
	JFrame frame;
	public framebg() {
		
		frame=new JFrame("导航页");
		
		 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("./src/daohang.jpg");//这是背景图片
		JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
		frame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
		imgLabel.setBounds(0,0,img.getIconWidth(),  
				img.getIconHeight());//设置背景标签的位置
		Container cp=frame.getContentPane();
		cp.setLayout(new BorderLayout());
		but=new JButton("开始使用");//创建按钮
	
		cp.add(but,"North");//将按钮添加入窗口的内容面板
		((JPanel)cp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。
		frame.setSize(img.getIconWidth(),  
				img.getIconHeight());
		
		
		
		
		frame.setVisible(true);
		but.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				butactionPerformed(evt);
				
			}
		});
}
public static void main (String[] args) {
	framebg v=new framebg();


}
private void butactionPerformed(ActionEvent e) {
	if(e.getSource()==but){  
        
    //SearchFile fl=new SearchFile();
	// TODO Auto-generated method stub
	new SearchFile().setVisible(true);
	frame.setVisible(false);
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}


}