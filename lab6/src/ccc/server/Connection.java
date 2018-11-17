//package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Connection {

    static int port = 5005;//  kill -9 $(lsof -t -i:5003)
    static String str = null;
    static byte[] buffer;
    static DatagramPacket packet;
    static InetAddress address;


//    ByteBuffer in = ByteBuffer.allocate(8192);
//    ByteBuffer out = ByteBuffer.allocate(8);


    public void connect() throws UnknownHostException {
        address = InetAddress.getByName("127.0.0.1");
        buffer = new byte[256];
        DatagramPacket in = null;
        DatagramPacket out = null;
        DatagramSocket socket = null;
        SocketAddress socketAddress = new InetSocketAddress(address,port);


    }






    public void test() throws IOException {

        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            byte[] b = new byte[32];

            while(true){
            DatagramPacket dp = new DatagramPacket(b,0,b.length);
            serverSocket.receive(dp);
                String o = dp.toString();
                if (o.equals("ooo")){
                    break;
                }
            }

            DatagramPacket dp2 = new DatagramPacket(b,b.length,address,port);
            serverSocket.send(dp2);

        }
//        int port = 37;
//
//        ByteBuffer in = ByteBuffer.allocate(8192);
//        ByteBuffer out = ByteBuffer.allocate(8);
//        out.order(ByteOrder.BIG_ENDIAN);
//
//        SocketAddress address = new InetSocketAddress(port);
//        DatagramChannel channel = DatagramChannel.open();
//        DatagramSocket socket = channel.socket();
//        socket.bind(address);
//        System.err.println("bound to " + address);
//        while (true) {
//            try {
//                in.clear();
//                SocketAddress client = channel.receive(in);
//                System.err.println(client);
//                long secondsSince1970 = System.currentTimeMillis();
//                out.clear();
//                out.putLong(secondsSince1970);
//                out.flip();
//
//                out.position(4);
//                channel.send(out, client);
//            } catch (Exception ex) {
//                System.err.println(ex);
//            }
//        }
    }


    public String  take(){
        /**
         * Bind the client socket to the port on which you expect to
         * read incoming messages
         */




        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        DatagramSocket serverSocket = null;
        SocketAddress sa = new InetSocketAddress(address,port);

        try  {


            byte[] buffer = new byte[512];



            // Set a timeout of 3000 ms for the client.
            //clientSocket.setSoTimeout(2000);


            while (true) {
                serverSocket = new DatagramSocket(port);
                DatagramPacket in = new DatagramPacket(buffer, 0, buffer.length);

                serverSocket.receive(in);

                String receivedMessage = new String(in.getData(), "UTF-8");
                Scanner recscan = new Scanner(receivedMessage);

                System.out.println(receivedMessage);

                if (recscan.nextLine().equals("test!")){
                    serverSocket.close();
                    sendmessage("hello form server!");


                }else{
                System.out.println("server took!");
                serverSocket.setSoTimeout(2000);
                byteArrayInputStream = new ByteArrayInputStream(buffer);
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                //System.out.println(receivedMessage);
                serverSocket.setSoTimeout(2000);
                serverSocket.close();

                Jsonparseserver jsonparseserver = (Jsonparseserver) objectInputStream.readObject();
                objectInputStream.close();

                String inpunser = jsonparseserver.getO();
                System.out.println(inpunser);


                str = inpunser;
                break;
                }


            }

        } catch (BindException e){
            e.printStackTrace();
            serverSocket.close();
            System.out.println("<><><><><><><><><><><><><><><><><><><>");
        }
        catch (SocketException e) {
            System.out.println("socketexep");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Timeout. Server is closing.");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }

        if (str == null){
            serverSocket.close();
            return null ;

        }

        return str;
    }



    public void sendmessage(String message) throws IOException {




//        SocketAddress address = new InetSocketAddress(port);
//        DatagramChannel datagramChannel = DatagramChannel.open();
        try (DatagramSocket serverSocket = new DatagramSocket()) {
            // The server will generate 3 messages and send them to the client
            System.out.println("server sent:");




            //SocketAddress client = datagramChannel.receive(in);
            //out.order(ByteOrder.BIG_ENDIAN);

            long secondsSince1970 = System.currentTimeMillis();
//            out.clear();
//            out.putLong(secondsSince1970);
//            out.flip();

 //           out.position(4);
            //serverSocket.send(datagramPacket);










                //String message = "{ \"name\":\"Nursat\", \"date\":\"28-05-2000\", \"age\":18}";
                DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName("127.0.0.1"),port+1);

                serverSocket.send(datagramPacket);
                String messagesend = new String (datagramPacket.getData(),"UTF-8");

                System.out.println(messagesend);
                serverSocket.send(datagramPacket);
                serverSocket.close();
                serverSocket.disconnect();
            System.out.println(serverSocket.isConnected()+"/"+serverSocket.isClosed());

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendfile(String consolemessage){
        try (DatagramSocket serverSocket = new DatagramSocket()) {
            File myFile = new File("/home/s242096/str.csv"); // read file

            BufferedReader reader = new BufferedReader(new FileReader (myFile));
            String         line = null;
            String All;
            StringBuilder  stringBuilder = new StringBuilder();
            String         ls = System.getProperty("line.separator");



            try {
                while((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }

                All = consolemessage+"\n"+stringBuilder.toString();
                System.out.println("server sent:");
                System.out.println(All);
            } finally {
                reader.close();
            }

            DatagramPacket DPfile = new DatagramPacket(All.getBytes(),All.length(),InetAddress.getByName("127.0.0.1"),port+1);//"188.227.11.105"
            serverSocket.send(DPfile);


        } catch (SocketException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
