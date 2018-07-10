package io.java.bio.zhan;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

	private ServerSocket server;
	
	public BIOServer(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("BIO server is started; the port is :" + port);
		} catch (IOException e) {
			System.out.println("服务端启动出错了");
			e.printStackTrace();
		}
	}
	
	public void listener() throws IOException {
		while(true) {
			Socket client = server.accept();
			InputStream is = client.getInputStream();
			byte[] buffer = new byte[1024];
			
			int len = is.read(buffer);
			if (len > 0) {
				String result = new String(buffer, 0, len);
				System.out.println("the client sent the massage is :" + result);
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			new BIOServer(8087).listener();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
