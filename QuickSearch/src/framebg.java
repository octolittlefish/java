
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public  class framebg extends JFrame implements ActionListener {
	
	JButton but;
	JFrame frame;
	public framebg() {
		
		frame=new JFrame("����ҳ");
		
		 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("./src/daohang.jpg");//���Ǳ���ͼƬ
		JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ�
		frame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
		imgLabel.setBounds(0,0,img.getIconWidth(),  
				img.getIconHeight());//���ñ�����ǩ��λ��
		Container cp=frame.getContentPane();
		cp.setLayout(new BorderLayout());
		but=new JButton("��ʼʹ��");//������ť
	
		cp.add(but,"North");//����ť����봰�ڵ��������
		((JPanel)cp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������
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