package ChatTo;

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

	public void writeData( byte[] b) {
		try {

			FileOutputStream fos = new FileOutputStream(writePath);
			System.err.println(writePath);
			int j=b.length;
			
			fos.write(b, 0, j);
			fos.close();
                       
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
