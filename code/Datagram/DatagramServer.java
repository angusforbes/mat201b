import java.io.*;
import java.net.*;
import java.util.*;


public class DatagramServer extends Thread {
  
  private int PORT = 49999;
  private DatagramSocket socket = null;
      
  public void run() {

    try {
      socket = new DatagramSocket(PORT);
    } catch (SocketException se) {
      System.err.println("Couldn't open socket on port " + PORT);
    }

    System.out.println("Datagram server listening on port " + PORT);

    boolean isRunning = true;

    while (isRunning) {
      try {
	// receive request
	byte[] bufReceive = new byte[1024];
	DatagramPacket packet = new DatagramPacket(bufReceive, bufReceive.length);
	socket.receive(packet);
	String receiveMessage = new String(packet.getData(), 0, packet.getLength());
	System.out.println("Server received: " + receiveMessage);

	// send the response to the client
	int port = packet.getPort();
	InetAddress address = packet.getAddress();
	String respondMessage = "Hello " + receiveMessage + " at " + address + ", I received your message on port " + port;
	byte[] bufSend = respondMessage.getBytes();

	packet = new DatagramPacket(bufSend, bufSend.length, address, port);
	socket.send(packet);
      
      } catch (IOException ioe) {
	System.err.println("Error! There was a problem in the server!");
	ioe.printStackTrace();
	isRunning = false;
      }
    }
    socket.close();
  }

  public static void main(String[] args) { 
        new DatagramServer().start();


  }

}

