package app;

import communication.GetHeroC;

import java.rmi.Naming;

public class MainServerRMI {

   public static void main(String[] args) throws Exception {
       GetHeroC serverRMI = new GetHeroC();
       Naming.rebind("GET", serverRMI);
       System.out.println("Server Started");
   }
}
