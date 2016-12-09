

import java.io.File;

public class fileInsert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
             printFiles(new File("E:/学习视频/极客学院"));
	}
    
	public static void printFiles(File dir) {
		        
		try {
			if (dir.isDirectory()) {
				      File next[]=dir.listFiles();
				
				    for (int i = 0; i < next.length; i++) {
				    	String a=null;
				    	String b=null;
				    	String c=null;
				    	String fileName=null;
					if (next[i].isDirectory()) {
						
						 a=next[i].getAbsolutePath().replaceAll("\\\\","/");
						 
						System.out.println(a);
			            if (next[i].getParent()!=null) {
							c=next[i].getParentFile().getAbsolutePath().replaceAll("\\\\","/");
						}					
						printFiles(next[i]);
						DoMysql.Insert(a, c, fileName, b);
					}
					if (next[i].isFile()) {
						a=next[i].getAbsolutePath().replaceAll("\\\\","/");
						 fileName=next[i].getName();
					     b=fileName.substring(fileName.lastIndexOf(".")+1);
						System.out.println(a);
						 if (next[i].getParent()!=null) {
							 c=next[i].getParentFile().getAbsolutePath().replaceAll("\\\\","/");
							}
						 DoMysql.Insert(a, c, fileName, b);
					}//a是绝对路径，b是后缀，fileName是文件名，c是父级目录
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
