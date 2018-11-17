//package server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

class MyThread extends Thread{

    String inputmssg = null;
    Connection connection = new Connection();
    public MyThread(String threadname) {
        super(threadname);
    }

    public void setInputmssg(String inputmssg) {
        this.inputmssg = inputmssg;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {



        ///////////////////////////////////////////////////////////////

//4 LAB
//        Human kid = new Human(" Малыш ");
//        Human.Cyborg karl = new Human.Cyborg(" Карлсон "){
//            @Override
//            public void look_to(Human human,String n){
//                System.out.println(human.getName()+" смотрит на "+human.getName());
//            }
//        };
//        karl.look_to(kid," Малыш ");
//        kid.get_state(State.GOT_ANGRY);
//        karl.say(karl,kid,Location.SOFA,Location.ROOF,Time.NIGHT
//                ,Time.MORNING,karl,Product.FORCEMEAT,State.SETTLE_DOWN);


        ////////////////////////////////////////////////////////////////


        BufferedReader br = new BufferedReader(new StringReader(inputmssg));

        TreeSetCompare mainTree = new TreeSetCompare();
        mainTree.setConnection(connection);
        Json cmdParse = new Json();
        String cmdIn = null;
        String Jsonstr = null;
        try {
            cmdIn = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Jsonstr = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

//                System.out.println("//////" + cmdIn);
//                System.out.println("//////" + Jsonstr);

        Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                mainTree.save();
                //System.out.println(11111111);
            } catch (IOException e) {
                //e.printStackTrace();
            }
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        Scanner path = new Scanner(System.getenv("PATH"));
        path.useDelimiter(":");

        String pathStr;
        String check = null;

        while (path.hasNext()) {

            pathStr = path.next();

            if (pathStr.substring(pathStr.length()-4,pathStr.length()).equals("5lab"))
                check = pathStr;

        }
        path.close();
        //System.out.println("ch1");
        try {
            mainTree.setPath(check);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mainTree.readElements();
        mainTree.writeElements();

        //System.out.println("ch2");
        try {
            cmdParse.nextCommand(cmdIn, mainTree, Jsonstr);
        } catch (NoSuchElementException m) {
            m.getMessage();
            System.out.println("LOL");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("ch3");
        try {
            mainTree.save();
        } catch (IOException e) {
            e.printStackTrace();
        }








    }






}
