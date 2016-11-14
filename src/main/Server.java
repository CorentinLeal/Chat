package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

	private static final int PORT=8080;
	private ServerSocket socket;
	private boolean isStopped = false;
	private Thread currentThread;
	
	public Server() {
		super();
	}

	@Override
	public void run() {
		synchronized (this) {
			this.currentThread=Thread.currentThread();
		}
		openServerSocket();
		
		while (!isStopped) {
			Socket clientSocket=null;
			try {
				clientSocket=this.socket.accept();
			} catch (IOException e) {
				if (isStopped) {
					System.out.println("Server stopped.");
					return;
				}
				throw new RuntimeException("Error accepting client connection", e);
			}
			new Thread(new ListenerServer(clientSocket)).start();
		}
		System.out.println("Server Stopped.");
	}
	
	private void openServerSocket(){
		try{
			this.socket = new ServerSocket(this.PORT);
		}catch (IOException e){
			throw new RuntimeException("Cannot open port");
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.run();
	}
}
