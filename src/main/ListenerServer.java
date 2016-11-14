package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ListenerServer implements Runnable{

	private Socket clientSocket;

	public ListenerServer(Socket clientSocket) {
		this.clientSocket=clientSocket;
	}
	
	@Override
	public void run() {
		try {
			InputStream inputStream = clientSocket.getInputStream();
			OutputStream outputStream = clientSocket.getOutputStream();
			outputStream.write(("ok").getBytes());
			
			System.out.println(inputStream.read());
			
			outputStream.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
