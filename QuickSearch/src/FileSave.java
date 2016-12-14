

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.JFrame;

public class FileSave extends JFrame implements java.io.Serializable {
	private String writePath = null;

	public FileSave() {
		JFileChooser jChooser2;
		try { 
			//UIManager.put("FileChooser.cancelButtonText", "Cancel Button"); //修改取消
			//UIManager.put("FileChooser.saveButtonText", "保存文件"); //修改保存
			UIManager.put("FileChooser.openButtonText", "保存文件");//修改打开
            UIManager.setLookAndFeel(//关键句1  
            UIManager.getSystemLookAndFeelClassName());//关键句2  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
		jChooser2=new JFileChooser();  
		jChooser2.setDialogTitle("复制文件");   
        this.setSize(400, 300);  
        this.setLocation(500, 500);  
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //this.setVisible(true);  
        jChooser2.showOpenDialog(this); 
        writePath = jChooser2.getSelectedFile().getAbsolutePath();//显示选中文件的名称
		 
	}

	public void writeData( File file) {
		try {
			FileInputStream fis =new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(writePath);
			byte b[]=new byte[500];
			while (fis.read(b)!=-1) {          //如果不返回-1，说明还有数据，继续写入文件
			       fos.write(b);			
			}
			fos.close();
			fis.close();
                       
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
