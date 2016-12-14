import java.io.File;
import java.util.Date;




public class InsertThread {
         public InsertThread() {
   		  new thread1().start();  
   		  System.err.println("start");
         }   
         
         
     public class thread1 extends Thread{
     		public thread1() {
     			
     		}
     		@SuppressWarnings("deprecation")
			public void run() {
     			System.err.println("run");
     			Date date=null;
     			while (true) {
     				date=new Date();
     				if (date.getHours()==23&&date.getMinutes()==30) {//23.30清空数据库然后插入数据
						
						DoMysql.delete();
						
						fileInsert.printFiles(new File("E:"));
							System.out.println(123);

						try {
							Thread.sleep(300000);//5min
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
     				try {
     					thread1.sleep(5000);
     				} catch (InterruptedException e) {
     					e.printStackTrace();
     				}
     			}
     			
     		}
     		
     	}
}
