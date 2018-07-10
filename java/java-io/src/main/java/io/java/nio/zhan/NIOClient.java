package io.java.nio.zhan;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {

	SocketChannel client= null;
	
	InetSocketAddress serverAddress = new InetSocketAddress("localhost", 8000);
	//	InetSocketAddress serverAddress = new InetSocketAddress(8087);
	
	Selector selector = null;
	
	ByteBuffer reciveBuffer = ByteBuffer.allocate(1024);
	ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
	
	public NIOClient() throws IOException {
		// 先开路
		client = SocketChannel.open();
		
		client.configureBlocking(false);
		
		client.connect(serverAddress);
		
		selector = Selector.open();
		
		client.register(selector, SelectionKey.OP_CONNECT);
		
	}
	
	public void session() throws IOException {
		// 先要判断是否已经建立链接
		if (client.isConnectionPending()) {
			client.finishConnect();
			System.out.println("");
			client.register(selector, SelectionKey.OP_WRITE);
		}
	}
	
	public void process(String name) throws IOException {
		boolean unFinish = true;
		while(true) {
			int i = selector.select();
			if (i == 0) {
				continue;
			}
			
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = keys.iterator();
			
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				if (key.isWritable()) {
					client.write(sendBuffer);
					
					client.register(selector, SelectionKey.OP_READ);
				} else if (key.isReadable()) {
					
					reciveBuffer.clear();
					int len = client.read(reciveBuffer);
					if (len > 0) {
						reciveBuffer.flip();
						System.out.println("获取到服务端反馈的信息：" + new String(reciveBuffer.array(),0,len));
						client.register(selector, SelectionKey.OP_WRITE);
						unFinish = false;
					}
					
				}
				
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		new NIOClient().session();
	}
}
