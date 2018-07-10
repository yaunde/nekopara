package io.java.nio.zhan;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NIOServer {

	private int port = 8087; // 监听端口
	
	ServerSocketChannel server = null;  // 相当于BIO的
	
	Selector selector = null;
	
	ByteBuffer reciveBuffer = ByteBuffer.allocate(1024);
	ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
	
	Map<SelectionKey, String> sessionMsg = new HashMap<>();
	
	public NIOServer(int port) throws IOException {
		this.port = port;
		// 打开通道，
		server = ServerSocketChannel.open();
		
		// 关卡打开，可以多路复用了
		server.socket().bind(new InetSocketAddress("localhost", 8087));
		
		// 默认为阻塞的，设置为非阻塞
		server.configureBlocking(false);
		
		// “管家开始营业”
		selector = Selector.open();
		
		// 高速管家，BOSS已经准备就绪，等会有客人来了，要通知我一下
		server.register(selector, SelectionKey.OP_ACCEPT);
		
		System.out.println("NIO服务已经启动，监听的端口号是："+ this.port);
		
	}
	
	public void listener() throws IOException {
		// 轮询
		while(true) {
			// 判断以下，当前有没有来注册的，有没有排号的，有没有取号的
			int i = selector.select();
			if (i == 0) {
				continue;
			}
			
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			
			Iterator<SelectionKey> iterator = selectedKeys.iterator();
			
			while (iterator.hasNext()) {
				// 来一个，处理一个
				process(iterator.next());
				
				// 处理完了，打发走了
				iterator.remove();
				
			}
			
		}
	}
	
	public void process(SelectionKey selectionKey) throws IOException {
		// 判断客户有没有跟我们的boss建立好连接
		if (selectionKey.isAcceptable()) {
			
			SocketChannel client = server.accept();
			
			client.configureBlocking(false);
			
			client.register(selector, SelectionKey.OP_READ);
			
		// 是否可以读数据了	
		} else if (selectionKey.isReadable()) {
			
			SocketChannel client = (SocketChannel)selectionKey.channel();
			
			int len = client.read(reciveBuffer);
			
			if (len > 0) {
				
				String msg  = new String( reciveBuffer.array(), 0, len);
				
				sessionMsg.put(selectionKey, msg);
				System.out.println("客户端发来的消息为1："+msg);
			}
			
			client.register(selector, SelectionKey.OP_WRITE);
			
		// 是否可以写数据了
		} else if (selectionKey.isWritable()) {
			
			SocketChannel client = (SocketChannel)selectionKey.channel();
			
			sendBuffer.clear();
			
			sendBuffer.put(new String(sessionMsg.get(selectionKey)+",您好，您的请求已经完成").getBytes());
			
			sendBuffer.flip();
			
			client.write(sendBuffer);
			client.register(selector, SelectionKey.OP_READ);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new NIOServer(8087).listener();
	}
}
