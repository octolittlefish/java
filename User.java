package ChatTo;

import java.net.InetAddress;

@SuppressWarnings("serial")
public class User implements java.io.Serializable {
     private String username;
     private InetAddress address;
     private int port;
     public User(String username,InetAddress address,int port) {
		this.username=username;
		this.address=address;
		this.port=port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public InetAddress getAddress() {
		return address;
	}
	public void setAddress(InetAddress address) {
		this.address = address;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", address=" + address+ ", port=" + port + "]";
	} 
	
}
