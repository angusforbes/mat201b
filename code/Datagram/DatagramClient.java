
import java.io.*;
import java.net.*;
import java.util.*;

public class DatagramClient {

  private int PORT = 49999;
  private String ADDRESS = "127.0.0.1";
  private String MESSAGE = "Angus";
  
  private DatagramSocket socket = null;

  public static void main(String[] args) { 
    new DatagramClient();
  }

  public DatagramClient() {
    try {
      sendMessage();
    } catch (IOException ioe) {
      System.err.println("Error! Couldn't send message to " + ADDRESS + " on port " + PORT);
    }
  }

  public void sendMessage() throws IOException
  {
    // create a datagram socket
    socket = new DatagramSocket();

    // send request
    byte[] bufSend = MESSAGE.trim().getBytes();
    InetAddress inetAddress = InetAddress.getByName(ADDRESS);
    DatagramPacket packet = new DatagramPacket(bufSend, bufSend.length, inetAddress, PORT);
    socket.send(packet);

    // get response
    byte[] bufReceive = new byte[1024]; 
    packet = new DatagramPacket(bufReceive, bufReceive.length);
    socket.receive(packet);

    // display response
    String received = new String(packet.getData(), 0, packet.getLength());
    System.out.println(received);

    socket.close();
  }
}

