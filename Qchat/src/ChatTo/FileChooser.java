package ChatTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
  
@SuppressWarnings("serial")
public class FileChooser extends JFrame implements java.io.Serializable{  
    /*JButton open=null;*/
    JFileChooser jfc=new JFileChooser();
    /*public static void main(String[] args) {  
        new FileChooser();  
    }*/
    public  FileChooser(){  
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  
        jfc.showDialog(new JLabel(), "选择");     
    }
    
    public byte[] getFile() {
    	try {
			File file =jfc.getSelectedFile();
			FileInputStream fis =new FileInputStream(file);//创建文件输入流
			byte b[]=new byte[4000];
			fis.read(b);
			return b;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	} 
    
    
    
}
