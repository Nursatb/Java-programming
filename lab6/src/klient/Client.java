//package klient;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.*;

public class Client implements Serializable {

    private BufferedReader in;
    private PrintWriter out;
    static int port;//  kill -9 $(lsof -t -i:5003)
    static String str = null;
    static byte[] buffer;
    static DatagramPacket packet;
    static InetAddress address;
Jsonparseserver jsonparseserver;


    public void connect(int curport) throws IOException, InterruptedException {
        port = curport;
        address = InetAddress.getByName("127.0.0.1");//"192.168.10.1"
        DatagramSocket socket = null;
        SocketAddress socketAddress = new InetSocketAddress(address,port);
        System.out.println("client");
        boolean answ;







        try {
            socket.connect(socketAddress);
            answ = socket.isConnected();
            socket.close();
            if (answ == false){
                System.out.println("pfrhsnj");
                System.exit(0);
            }

        } catch (Exception ex) {

        }
    }







    public void test(){

        try (DatagramSocket clienttestSocket = new DatagramSocket()) {
            byte[] data = new byte[512];
            String testmsg = port+"\n"+port+"\n";
            DatagramPacket datagramPacket = new DatagramPacket(
                    testmsg.getBytes(),testmsg.length(),
                    InetAddress.getByName("localhost"),port);

            clienttestSocket.send(datagramPacket);
            clienttestSocket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("sucsessfully sent");



//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        takemessage();
//        try {
//            DatagramSocket clienttestSocket = new DatagramSocket();
//            //DatagramSocket clienttestSocket = new DatagramSocket(port+1);
//            byte[] buffer = new byte[512];
//
//            while (true) {
//
//                //clienttestSocket.connect(InetAddress.getByName("localhost"),port+1);
//                clienttestSocket.setSoTimeout(3000);
//                clienttestSocket.getSoTimeout();
//                System.out.println("fff");
//                DatagramPacket in = new DatagramPacket(buffer, 0, buffer.length);
//                System.out.println("fff");
//
//                clienttestSocket.receive(in);
////                clienttestSocket.disconnect();
////                clienttestSocket.close();
//                System.out.println("fff");
//                String receivedMessage = new String(in.getData(), "UTF-8");
//
//                System.out.println("client took:");
//                System.out.println(receivedMessage);
//                if (receivedMessage != null){
//                    clienttestSocket.disconnect();
//                    clienttestSocket.close();
//
//                    break;}
//
//
//            }
////            clienttestSocket.disconnect();
////            clienttestSocket.close();
//        }catch (SocketTimeoutException e){
//            e.printStackTrace();
//            System.out.println("сервер не ответил");
//        }catch (SocketException e1) {
//            e1.printStackTrace();
//        } catch (UnsupportedEncodingException e1) {
//            e1.printStackTrace();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//
//            System.out.println("сервер не ответил");
//            return;
//
//        }


    }


    public void sendmessage(String cmd,JSONObject message){
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            // The server will generate 3 messages and send them to the client
            //System.out.println("test");
//            jsonparseserver.set(message);
//            jsonparseserver = jsonparseserver.getJsonser();
            //System.out.println(jsonparseserver.toJSONString());


                String outmessage = (cmd+"\n"+message.toString()+"\n");
                String outsermssg;

                Jsonparseserver jsonparseserver = new Jsonparseserver(outmessage);


                byte[] data = new byte[512];
                //serializat
//                File file = new File("/Users/nursat/workspace/lab6/ss.txt");
//                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ByteArrayOutputStream dd = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(dd);
                oos.writeObject(jsonparseserver);
                oos.close();

                data = dd.toByteArray();


                //System.out.println(outsermssg);



                DatagramPacket datagramPacket = new DatagramPacket(
                        data,data.length,
                        InetAddress.getByName("127.0.0.1"),port);//192.168.10.1

                clientSocket.send(datagramPacket);

            System.out.println(clientSocket.getBroadcast());

                String messagesent = new String (datagramPacket.getData(),"UTF-8");
                System.out.println("client sent!");

                //System.out.println(messagesent);


        } catch (SocketException e) {
            System.out.println("Server isn't works!");

            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("Server isn't works!");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Server isn't works!!!d");
            e.printStackTrace();
        }

    }

    DatagramSocket DS;
    public DatagramSocket takemessage(){

        /**
         * Bind the client socket to the port on which you expect to
         * read incoming messages
         */
        try (DatagramSocket clientSocket = new DatagramSocket(port+1)) {

            byte[] buffer = new byte[512];

            // Set a timeout of 3000 ms for the client.
            clientSocket.setSoTimeout(5000);

            while (true) {

                //System.out.println(clientSocket.getBroadcast());


                DatagramPacket in  = new DatagramPacket(buffer, 0, buffer.length);
//                if(in.equals(null)){
//                    System.out.println("serv bla");
//                    System.exit(0);
//                }

                clientSocket.receive(in);

                String receivedMessage = new String(in.getData(),"UTF-8");
                System.out.println("client took:");
                System.out.println(receivedMessage);
                System.out.println();
                DS = clientSocket;


            }
        } catch (SocketTimeoutException n){
            System.out.println("Время вышло! Сервер сделал все что смог");

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Timeout. Client is closing.");
        }
        return DS;

    }









}
