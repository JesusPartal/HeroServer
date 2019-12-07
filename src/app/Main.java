package app;

import communication.UDPServer;
import model.HeroFactory;
import model.HeroType;
import model.SuperHero;
import model.SuperVillain;

import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main (String[] args) throws SocketException {
        new UDPServer().start();
    }











//    }
//
//    private static void heroProviderService() {
//        try {
//            System.out.println("Starting hero server...");
//            ServerSocket serverSocket = new ServerSocket(8001);
//
//            while (true) {
//                Socket socket = serverSocket.accept();
//
//                objectInputStream = new ObjectInputStream(socket.getInputStream());
//                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//
//                SuperVillain superVillain = (SuperVillain) objectInputStream.readObject();
//
//                System.out.println(superVillain.getStats());
//                SuperHero superHero = (superVillain instanceof model.BadFlyPerson)
//                        ? HeroFactory.buildHero(HeroType.GOODFLYPERSON, superVillain.getHealthPoints(), superVillain.getBadnessPower())
//                        : HeroFactory.buildHero(HeroType.GOODSTRONGMAN, superVillain.getHealthPoints(), superVillain.getBadnessPower());
//                objectOutputStream.writeObject(superHero);
//                System.out.println("Sending SUPERHERO " + superHero.getStats());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

}
