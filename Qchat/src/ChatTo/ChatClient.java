package ChatTo;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

import com.sun.xml.internal.ws.api.message.Packet;


@SuppressWarnings("serial")
public class ChatClient implements java.io.Serializable{
 private DatagramSocket s;
 private InetAddress hostAddress;
 private byte[] buf = new byte[3000];
 private int pport;
 private ArrayList<User> list=null;
 private DatagramPacket dp = new DatagramPacket(buf,buf.length);
 private InetAddress ahosAddress;
 private int iport;

//方法说明：构造器，这里实现接收用户输入和与服务器通讯
  public ChatClient(){
   try{
       //使用构造器，创建使用本机任何可用端口的数据包Socket
       try {
		s = new DatagramSocket();
		pport=s.getLocalPort();
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       //获取本地IP
       hostAddress = InetAddress.getByName("localhost");}
   catch(UnknownHostException e){
       System.out.println("Can;t open socket");
       System.exit(1);}
     }
  
  public void connect(String string) {
	     String outString =string;
	     byte[] buf = outString.getBytes();
	     //打包数据，发送数据
	     DatagramPacket out = new DatagramPacket(buf,buf.length,hostAddress,4000);
	     try {
			s.send(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	     //等待服务器返回}
	   } 
  
  
  
  public void sendFile(byte b[],InetAddress address,int port ){
	     byte[] buf = b;
	     //打包数据，发送数据
	     DatagramPacket out = new DatagramPacket(buf,buf.length,address,port);
	     try {
			s.send(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     //等待服务器返回}
	   } 
  
  
  
 public void send(String string,InetAddress address,int port ){
     String outString =string;
     
     byte[] buf = outString.getBytes();
     //打包数据，发送数据
     DatagramPacket out = new DatagramPacket(buf,buf.length,address,port);
     try {
		s.send(out);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     //等待服务器返回}
   } 
 public String receiveData() throws ClassNotFoundException, IOException{
    try {
		s.receive(dp);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} if (dp.getPort()==4000) {
		  list=getlist(dp.getData());
		  return "";
	} if (dp.getLength()>998) {
		
		 FileSave fileSave=new FileSave();
        fileSave.writeData(dp.getData());
		return "";
	} 
    String s1 = "\n"+new String(dp.getData(),0,dp.getLength())+"(recieved from "+ dp.getAddress() + ", " + dp.getPort() + 
                 ")";
          ahosAddress=dp.getAddress();
          iport=dp.getPort();
          
         System.out.println(s1);
         return s1;
  }  
    public ArrayList<User> getList() {
		return list;
	}
public InetAddress getAhosAddress() {
	return ahosAddress;
}
public void setAhosAddress(InetAddress ahosAddress) {
	this.ahosAddress = ahosAddress;
}
public int getIport() {
	return iport;
}
public void setIport(int iport) {
	this.iport = iport;
}
public void closeSocket() {
	s.close();
}

public InetAddress getHostAddress() {
	return hostAddress;
}

public void setHostAddress(InetAddress hostAddress) {
	this.hostAddress = hostAddress;
}

public int getPport() {
	return pport;
}

public void setPport(int pport) {
	this.pport = pport;
}
@SuppressWarnings("unchecked")
public  ArrayList<User> getlist(byte[] buf) throws IOException, ClassNotFoundException {
	ByteArrayInputStream bStream=new ByteArrayInputStream(buf);
	ObjectInputStream oStream=new ObjectInputStream(bStream);
	return (ArrayList<User>)oStream.readObject();
}


}

