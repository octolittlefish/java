

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileSave {
	private String writePath = null;

	public FileSave() {
		JFileChooser jChooser2 = new JFileChooser();
		jChooser2.setDialogType(JFileChooser.SAVE_DIALOG);// 设置保存对话框
		jChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int index = jChooser2.showDialog(null, "保存文件");
		if (index == JFileChooser.APPROVE_OPTION) {
			writePath = jChooser2.getSelectedFile().getAbsolutePath();
		}
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
