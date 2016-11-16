package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


public class ListenerServer implements Runnable{

	
	private BufferedReader in;
	private String message,login;
	private ArrayList<PrintWriter> outs = new ArrayList<PrintWriter>();

	public ListenerServer(BufferedReader  in, String login, ArrayList<PrintWriter> outs) {
		this.in=in; 
		this.login = login;
		this.outs = outs;
	}
	
	@Override
	public void run() {
		while(true){
	        try {
	        	
			message = in.readLine();
			for(PrintWriter c : outs){
				c.println(login+" : "+message);
				c.flush();
			}
			System.out.println(login+" : "+message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
