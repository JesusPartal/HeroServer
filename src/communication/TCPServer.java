package communication;

import model.HeroFactory;
import model.HeroType;
import model.SuperHero;
import model.SuperVillain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer extends Thread {
    private ServerSocket serverSocket;
    private boolean running = false;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public TCPServer() throws IOException {
        serverSocket = new ServerSocket(8000);
    }

    @Override
    public void run() {
        running = true;
        while(running) {
            try {
                Socket socket = serverSocket.accept();

                objectInputStream = new ObjectInputStream(socket.getInputStream());
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                SuperVillain superVillain = (SuperVillain) objectInputStream.readObject();

                System.out.println(superVillain.getStats());
                SuperHero superHero = (superVillain instanceof model.BadFlyPerson)
                        ? HeroFactory.buildHero(HeroType.GOODFLYPERSON,
                                                superVillain.getHealthPoints(),
                                                superVillain.getBadnessPower())
                        : HeroFactory.buildHero(HeroType.GOODSTRONGMAN,
                                                superVillain.getHealthPoints(),
                                                superVillain.getBadnessPower());
                objectOutputStream.writeObject(superHero);
                System.out.println("Sending Superhero " + superHero.getStats());



            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

}
