import java.net.*;
import java.io.*;

public class Server{

	private ServerSocket serv = null;

	public Server(int port){
		try {
		    serv = new ServerSocket(port);
		Socket accept = serv.accept();	
		    System.out.println("Server Created!");
		BufferedReader br= new BufferedReader(new InputStreamReader(accept.getInputStream()));
		String temp = br.readLine();
		System.out.println(temp);
		if (temp!=null) {
		PrintStream ps = new PrintStream(accept.getOutputStream());
		ps.println("Got something");
}
		} 
		catch (IOException e) {
		    System.out.println("Could not listen on port: " + port);
		    System.exit(-1);
		}
			

	}

	

	
	public void destroy(){
		try{
		   serv.close();
		   System.out.println("Server Closed!");
		}catch (IOException e){
		    System.out.println("Could not close server");
		    System.exit(-1);
		}
	}
	
}
