package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
        	
            Socket clientSocket = new Socket("localhost", 1234); // Connectez-vous au serveur sur localhost (127.0.0.1) et le port 1234
          
			System.out.println("je suis connecté");
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String serverMessage = reader.readLine(); // Lisre le message envoyé par le serveur
            System.out.println(serverMessage);

            clientSocket.close(); // : fermeture de la Socket

        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }}




