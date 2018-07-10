package io.java.bio.zhan;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class BIOClient {

	public static void main(String[] args) {
		int port = 8087;
		Socket socket = null;
		OutputStream os = null;
		try {
			// 第一个参数还不能写IP
			socket = new Socket("localhost", port);
			
			os = socket.getOutputStream();
			
			os.write("报个到".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != socket) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void other(String[] args) {
		int port = 8087;
		try (
			Socket socket = new Socket("localhost", port);
			OutputStream os =socket.getOutputStream();
		){
			
			os.write("报个到".getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
