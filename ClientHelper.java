//class name: CSCI 715, last modified time: 7:47 pm, author: Alia Mohamed
import java.net.*;
import java.io.*;
import java.util.*;

public class ClientHelper extends Thread{
    Socket sock;
    int number;

    //class constructor
    public ClientHelper(Socket s, int n){
        this.sock = s;
        this.number = n;
    }

    //threads requested by red_sea and troll clients
    public String clean_and_cook(){ return "Red Sea cleaned and cooked"; }
    public String Dinner(){
        return "Red Sea set up the dinner table";
    }
    public String Movie(){ return "Red Sea picked up the movie"; }

    public String enter_cabin(){
        return "The troll entered the cabin";
    }
    public String eat_dinner(){
        return "the troll ate dinner";
    }
    public String watch_movie(){
        return "the troll watched the movie";
    }


    public void run(){
        try{
            //create input and output streams to communicate with clients
            DataInputStream is = new DataInputStream(sock.getInputStream());
            DataOutputStream os = new DataOutputStream(sock.getOutputStream());
            PrintWriter out = new PrintWriter(os);

            //red the message sent by the client
            String messgae = is.readUTF();
            System.out.println("Client message: "+ messgae);

            //message format "name (troll, red_sea) method number"
            //create switch to pick the method needed
            String[] methodID = messgae.split(" "); //parse the request message
            if(methodID[0].equals("red_sea")) { //methods used by red_sea
                switch (methodID[1]) {
                    case "1":
                        os.writeUTF(clean_and_cook());
                        break;
                    case "2":
                        os.writeUTF(Dinner());
                        break;
                    case "3":
                        os.writeUTF(Movie());
                        break;
                    default:
                        os.writeUTF("Unexpected method ID");
                        break;
                }
            }else if(methodID[0].equals("troll")){ //methods used by troll
                switch (methodID[1]) {
                    case "1":
                        os.writeUTF(enter_cabin());
                        break;
                    case "2":
                        os.writeUTF(eat_dinner());
                        break;
                    case "3":
                        os.writeUTF(watch_movie());
                        break;
                    default:
                        os.writeUTF("Unexpected method ID");
                        break;
                }
            }else{
                os.writeUTF("Unexpected user.");
            }

            System.out.println( "String sent." );

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}


//import java.net.*;
//import java.io.*;
//import java.util.*;
//
//public class ClientHelper extends Thread{
//    Socket sock;
//    int number;
//
//    public ClientHelper(Socket s, int n){
//        this.sock = s;
//        this.number = n;
//    }
//
//    public String clean_and_cook(){ return "Red Sea cleaned and cooked"; }
//    public String Dinner(){
//        return "Red Sea set up the dinner table";
//    }
//    public String Movie(){ return "Red Sea picked up the movie"; }
//
//    public String enter_cabin(){
//        return "The troll entered the cabin";
//    }
//    public String eat_dinner(){
//        return "the troll ate dinner";
//    }
//    public String watch_movie(){
//        return "the troll watched the movie";
//    }
//
//
//    public void run(){
//        try{
//            DataInputStream is = new DataInputStream(sock.getInputStream());
//            DataOutputStream os = new DataOutputStream(sock.getOutputStream());
//            PrintWriter out = new PrintWriter(os);
//
//            String messgae = is.readUTF();
//            System.out.println("Client message: "+ messgae);
////            message format "name (troll, red_sea) method number"
////            create switch to pick the method needed
//            String[] methodID = messgae.split(" ");
//            if(methodID[0].equals("red_sea")) {
//                switch (methodID[1]) {
//                    case "1":
//                        os.writeUTF(clean_and_cook());
//                        break;
//                    case "2":
//                        os.writeUTF(Dinner());
//                        break;
//                    case "3":
//                        os.writeUTF(Movie());
//                        break;
//                    default:
//                        os.writeUTF("Unexpected method ID");
//                        break;
//                }
//            }else if(methodID[0].equals("troll")){
//                switch (methodID[1]) {
//                    case "1":
//                        os.writeUTF(enter_cabin());
//                        break;
//                    case "2":
//                        os.writeUTF(eat_dinner());
//                        break;
//                    case "3":
//                        os.writeUTF(watch_movie());
//                        break;
//                    default:
//                        os.writeUTF("Unexpected method ID");
//                        break;
//                }
//            }else{
//                os.writeUTF("Unexpected user.");
//            }
//
//            System.out.println( "String sent." );
//
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//}
