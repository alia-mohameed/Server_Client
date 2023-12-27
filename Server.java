//class name: CSCI 715, last modified time: 7:47 pm, author: Alia Mohamed
import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    public static void main(String[] args) throws Exception{
        try{
            int port = 8777;
            int numClient = 0;
            //create a server on the port number
            ServerSocket server = new ServerSocket(port);
            System.out.println("The Server is Running.");

            while(true){
                numClient++;
                Socket sockk = server.accept(); //connect to any requesting clients
                System.out.println("Client #"+numClient+" is connected.");

                //create a helper to assist the client
                ClientHelper helper = new ClientHelper(sockk, numClient);
                helper.start();
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}

//import java.net.*;
//import java.io.*;
//import java.util.*;
//
//public class Server {
//    public static void main(String[] args) throws Exception{
//        try{
//            int port = 8777;
//            int numClient = 0;
//            ServerSocket server = new ServerSocket(port);
//            System.out.println("The Server is Running.");
//
//            while(true){
//                numClient++;
//                Socket sockk = server.accept();
//                System.out.println("Client #"+numClient+" is connected.");
//
//                ClientHelper helper = new ClientHelper(sockk, numClient);
//                helper.start();
//            }
//
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//
//    }
//}