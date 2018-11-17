//package server;

import java.net.UnknownHostException;
import java.util.Scanner;

public class Mainserver {//implements Runnable


    //@Override
    public static void main(String[] args){

        Connection connection = new Connection();
        try {
            connection.connect();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String mm = null;
        while (true){


            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("server w8");
            System.out.println("-------------------------------------------------------------------------------");
            String inputmssg;

            Scanner scanner;
            scanner = new Scanner(System.in);
                //mm = scanner.next();
            //System.out.println("f");
                inputmssg = connection.take();
            if(inputmssg ==null){
                break;
            }

                //mm = scanner.next();
//            if (mm.equals("stop_app")){
//                System.exit(0);
//            }



            System.out.println("-------------------------------------------------------------------------------");


            if (inputmssg != null) {
                MyThread Aa = new MyThread("server_1");
                Aa.setInputmssg(inputmssg);

                Aa.run();


//        connection.sendmessage();
//        System.out.println("-------------------------------------------------------------------------------");




            }
        }


    }
}




