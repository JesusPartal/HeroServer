package communication;

import java.io.IOException;
import java.net.*;

public class UDPServer extends Thread {
    private DatagramSocket datagramSocket;
    private boolean running;
    private byte[] buffer = new byte[1];
    private int connectionsCounter = 0;

    public UDPServer() throws SocketException {
        datagramSocket = new DatagramSocket(8001);
    }

    @Override
    public void run() {
        running = true;
        System.out.println("Server started");

        while(running) {
            System.out.println("listening");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                datagramSocket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();

            packet = new DatagramPacket(buffer, buffer.length, address, port);
            String received = new String(packet.getData(), 0, packet.getLength());


            try {
                datagramSocket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(received.equals("s")) {
                connectionsCounter++;
                System.out.println("New client connected");
                System.out.println("Total connections: " + connectionsCounter);
                try {
                    new TCPServer().start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (received.equals("e")) {
                connectionsCounter--;
                System.out.println("Client disconnected");
                System.out.println("Total connections: " + connectionsCounter);
                running = false;
                continue;
            } else {
                System.out.println(received);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        datagramSocket.close();
    }
}
