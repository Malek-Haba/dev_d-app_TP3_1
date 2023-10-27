package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
private int nbclient;
public static void main ( String[] args)
{ new Server().start();
}

@Override
	public void run() {
	try {
		ServerSocket ss = new ServerSocket(1234);
		System.out.println("Démarrage du serveur");
		while(true)
		{ Socket s = ss.accept();
		new ClientProcess(s,++nbclient).start();
	}
  }catch(Exception e)
	{e.printStackTrace();
  }
	}

public class ClientProcess extends Thread {
	private int numclient;
	private Socket s;
	public ClientProcess(Socket s, int numclient)
	{
		this.s=s;
		this.numclient=numclient;
	}
	
	@Override
	public void run() {
		System.out.println("le client num : " +numclient+"de l adresse IP"+s.getRemoteSocketAddress());
		try {
			(new PrintWriter(s.getOutputStream())).println("Bienvenue vous etes le client numero"+numclient);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
 }
}