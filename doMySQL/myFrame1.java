/*
 * myFrame1.java
 *
 * Created on __DATE__, __TIME__
 */

package doMySQL;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author  __USER__
 */
public class myFrame1 extends javax.swing.JFrame {

	/** Creates new form myFrame1 */
	public myFrame1() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new HomePanel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenu6 = new javax.swing.JMenu();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 606,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 435,
				Short.MAX_VALUE));

		jMenuBar1.setBackground(new java.awt.Color(255, 102, 153));

		jMenu1.setText("\u5b66\u751f\u7ba1\u7406");

		jMenu3.setText("\u5f55\u5165\u4e0e\u67e5\u8be2");

		jMenuItem1.setText("\u5f55\u5165");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem1);

		jMenuItem2.setText("\u67e5\u8be2");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem2);

		jMenu1.add(jMenu3);

		jMenu6.setText("\u4fee\u6539\u4fe1\u606f");

		jMenuItem3.setText("\u4fee\u6539");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu6.add(jMenuItem3);

		jMenu1.add(jMenu6);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("\u6210\u7ee9\u7ba1\u7406");

		jMenuItem4.setText("\u6210\u7ee9\u5f55\u5165");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem4);

		jMenuItem5.setText("\u8003\u52a1\u67e5\u8be2");
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem5ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem5);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
		new kaowuchaxun().setVisible(true);
	}

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
		new chengjiluru().setVisible(true);
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		new xiugai().setVisible(true);
	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		new chaxun().setVisible(true);

	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		new luru().setVisible(true);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new myFrame1().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables

}