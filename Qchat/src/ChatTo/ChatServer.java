package ChatTo;
import java.net.*;

import java.io.*;

import java.util.*;

@SuppressWarnings("serial")
public class ChatServer implements java.io.Serializable {
 static ArrayList<User>list=new ArrayList<User>();
 static final int PORT = 4000;
 static int port=0;
 static InetAddress address=null;
 private byte[] buf = new byte[1000];
 private DatagramPacket dgp = new DatagramPacket(buf,buf.length);
 private DatagramSocket sk;

 
 public ChatServer(){
  
     try{
   
   sk = new DatagramSocket(PORT);//创建一个DatagramSocket实例，并将该对象绑定到本机默认IP地址、本机所有可用端口中随机选择的某个端口。
   
   System.out.println("Server started");
 }catch(SocketException e){
   
   System.out.println("cannot open socket");
   
   System.exit(1);
  }
}
  

  public String getData(){
  	try {
		sk.receive(dgp);
	} catch (IOException e) {
		e.printStackTrace();
	}
  	String string=new String(dgp.getData(),0,dgp.getLength());
  	System.err.println(string);
    String rcvd = string+"connect(from address :"+dgp.getAddress()+",port:"+dgp.getPort()+")";
    System.err.println(rcvd);
    
    if (!string.equals("displaylist")) {
    	User user=new User(string, dgp.getAddress(), dgp.getPort());
        list.add(user);
        System.out.println(list.toString());
        System.out.println (rcvd);
        return string;
	}    
    byte[] buf = null;
    System.err.println("display");
	try {
		buf = getbytes(list);
	} catch (IOException e1) {
		e1.printStackTrace();
	}
     DatagramPacket out = new DatagramPacket(buf,buf.length,dgp.getAddress(),dgp.getPort());
     try {
		sk.send(out);
		return "";
	} catch (IOException e) {
		e.printStackTrace();
	}
     return "";
  }


  void java_thread()  
	{  
		  
	     Thread t = new Thread(new Runnable(){  
	            public void run(){  
	            	while(true){
	            		getData();
	            }
	            }});  
	        t.start();  
	} 
  public byte[] getbytes(ArrayList<User> a) throws IOException {
	ByteArrayOutputStream bStream=new ByteArrayOutputStream();
	ObjectOutputStream ooStream=new ObjectOutputStream(bStream);
	ooStream.writeObject(a);
	return bStream.toByteArray();
}
  public static void main(String args[]) {
	ChatServer server=new ChatServer();
	server.java_thread();
	  
}

}//netstat -ano | find ":4000"   taskkill /f /pid:6760 //server未正常关闭时 用这个在cmd里关闭
