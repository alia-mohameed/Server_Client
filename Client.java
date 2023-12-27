import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception{

        try{
            int port = 8777;
            String host = "localhost";

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Socket connection = new Socket("localhost", port);

            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
            DataInputStream dis = new DataInputStream(connection.getInputStream());

            System.out.print("Enter a string to be sent: ");
            String input = br.readLine();

            dos.writeUTF(input);
            System.out.println("String sent.");

            input = dis.readUTF();
            System.out.println("The server responds: " + input);

//            System.out.print("Are you a princess or a troll? ");
//            Scanner obj = new Scanner(System.in);
//            String input = obj.nextLine();
//            if(input.equals("r")){
//                Red_Sea red_sea = new Red_Sea(port, host);
//                red_sea.start();
//
//            }else if(input.equals("t")){
//                Troll troll = new Troll(port, host);
//                troll.start();
//            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}