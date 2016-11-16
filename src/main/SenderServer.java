package main;

import java.io.PrintWriter;
import java.util.Scanner;

public class SenderServer implements Runnable{

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
	
	public SenderServer(PrintWriter out) {
		this.out = out;
	}

	@Override
	public void run() {
		 sc = new Scanner(System.in);
		  
		  while(true){
			    System.out.println("Message de :");
				message = sc.nextLine();
				out.println(message);
			    out.flush();
			  }
	}

}
