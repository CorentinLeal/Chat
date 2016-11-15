package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

	private static final int PORT=5050;
	private ServerSocket socket;
	private boolean isStopped = false;
	private Thread currentThread;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private Thread t1,t2;
	private String login;
	
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
			try {
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				out = new PrintWriter(clientSocket.getOutputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			out.println("Entrez votre login :");
			out.flush();
			
			try {
				login = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t1 = new Thread(new ListenerServer(in,login));
			t1.start();
			t2 = new Thread(new SenderServer(out));
			t2.start();
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
