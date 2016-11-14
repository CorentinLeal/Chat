package main;

import java.net.Socket;

public class Client implements Runnable{

	private static final int PORT=8080;
	private final static String ServerIp="127.0.0.1";
	private Socket socket;
	private String username;
	private ListenerClient listener;
	private SenderClient sender;
	
	public Client(String username, ListenerClient listener, SenderClient sender) {

		this.username=username;
		this.listener=listener;
		this.sender=sender;
	}

	@Override
	public void run() {

		Thread emission = new Thread(new SenderClient());
		emission.start();
		Thread reception = new Thread(new ListenerClient());
		reception.start();
		
	}
	
	
	
}
