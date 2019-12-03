package app;

import communication.StatusMessage;
import communication.StatusMessageType;
import model.HeroFactory;
import model.HeroType;
import model.SuperHero;
import model.SuperVillain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class HeroServer {
    private static ObjectOutputStream objectOutputStream;
    private static ObjectInputStream objectInputStream;
    private DatagramSocket socket;
    private static int port = 8000;
    private static int counterConnections = 0;
    private static boolean packageReceived = false;

    public HeroServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public static void main (String[] args) {
        try {
            HeroServer server = new HeroServer(port);
            server.connectionService();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connectionService() throws IOException {

        while(true) {
            DatagramPacket request = new DatagramPacket(new byte[1], 1);
            socket.receive(request);


            String connection = "Connected";
            byte[] buffer = connection.getBytes();

            InetAddress clientAddress = request.getAddress();
            int clientPort = request.getPort();

            DatagramPacket response = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
            socket.send(response);
            if(request.toString() != null) {
                System.out.println("Client connected");
                heroProviderService();
            }

        }
    }

    private static void heroProviderService() {
        try {
            System.out.println("Starting hero server...");
            ServerSocket serverSocket = new ServerSocket(8000);

            while (true) {
                Socket socket = serverSocket.accept();

                objectInputStream = new ObjectInputStream(socket.getInputStream());
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                SuperVillain superVillain = (SuperVillain) objectInputStream.readObject();

                System.out.println(superVillain.getStats());
                SuperHero superHero = (superVillain instanceof model.BadFlyPerson)
                        ? HeroFactory.buildHero(HeroType.GOODFLYPERSON, superVillain.getHealthPoints(), superVillain.getBadnessPower())
                        : HeroFactory.buildHero(HeroType.GOODSTRONGMAN, superVillain.getHealthPoints(), superVillain.getBadnessPower());
                objectOutputStream.writeObject(superHero);
                System.out.println("Sending SUPERHERO " + superHero.getStats());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
