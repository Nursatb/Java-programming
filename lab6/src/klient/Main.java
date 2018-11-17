//package klient;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramSocket;
import java.util.Objects;
import java.util.Scanner;

public class Main {//implements Runnable{
    ObjectInputStream input;
    ObjectOutputStream output;
    static int port = 5005; // Порт, такой же, как у сервера
    static String address = "127.0.0.1"; // Адрес сервера



    //@Override
    public static void main(String[] args){

        byte[] b = new byte[]{0,1,2,3,4,5,6,7,8,9};
        Client client = new Client();


    DatagramSocket DS;
    JSONObject outmsg;

    Scanner incmd = new Scanner(System.in);

    Commands command = new Commands();
        System.out.println("Enter port:");
        int curport = incmd.nextInt();
        //client.test();
        while (true){



        try {
            client.connect(5005);//curport
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //client.test("ooo");

        System.out.println("Enter command:");
        String curCmd = incmd.next();

        if (Objects.equals(curCmd, "stop_app")) {
            //mainTree.save();
            System.out.println("Application stopped...");

            break;
        }

        command.nextCommand(curCmd);

        outmsg = command.getOutmsg();



        if (outmsg != null) {

            client.sendmessage(curCmd, outmsg);
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("client w8");
            System.out.println("-------------------------------------------------------------------------------");
            DS = client.takemessage();
            System.out.println("-------------------------------------------------------------------------------");
            //DS.close();
        }

        }



    }
    }


//        System.out.println("-------------------------------------------------------------------------------");
//        client.sendmessage(b);
//        System.out.println("-------------------------------------------------------------------------------");
//        System.out.println("client w8");
//        System.out.println("-------------------------------------------------------------------------------");
//        client.takemessage();
//        System.out.println("-------------------------------------------------------------------------------");





