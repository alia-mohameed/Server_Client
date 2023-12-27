//class name: CSCI 715, last modified time: 7:47 pm, author: Alia Mohamed
import java.io.*;
import java.net.*;

public class Troll extends Thread{
    public static void main(String[] args) throws Exception{

        try{
            //specify the port number and host name
            int port = 8777;
            String host = "localhost";

            //create a BufferReader and socket to connect and send messages to the server
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Socket connection = new Socket(host, port);
            System.out.println("Troll connection established");

            //create a BufferReader and socket to connect and send messages to the server
            DataOutputStream os = new DataOutputStream(connection.getOutputStream());
            DataInputStream is = new DataInputStream(connection.getInputStream());

            System.out.print("Enter a thread_name and method ID to be sent: ");
            String input = br.readLine();

            //send the message to the server
            os.writeUTF(input);
            System.out.println("String sent.");

            //read the message sent from the server
            input = is.readUTF();
            System.out.println("The server responds: " + input);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}


//import java.io.*;
//import java.net.*;
//
//public class Troll extends Thread{
//    public static void main(String[] args) throws Exception{
//
//        try{
//            int port = 8777;
//            String host = "localhost";
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            Socket connection = new Socket(host, port);
//            System.out.println("Troll connection established");
//
//            DataOutputStream os = new DataOutputStream(connection.getOutputStream());
//            DataInputStream is = new DataInputStream(connection.getInputStream());
//
//            System.out.print("Enter a thread_name and method ID to be sent: ");
//            String input = br.readLine();
//
//            os.writeUTF(input);
//            System.out.println("String sent.");
//
//            input = is.readUTF();
//            System.out.println("The server responds: " + input);
//
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//}
