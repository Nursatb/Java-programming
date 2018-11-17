//package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Refinement {
    public void take() {
        try {

            DatagramSocket ds = new DatagramSocket(5003);
            while (true) {

                DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
                ds.receive(pack);
                System.out.println(new String(pack.getData()));

            }

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void test() throws IOException {
        DatagramChannel dchannel = DatagramChannel.open();

        dchannel.socket().bind(new InetSocketAddress(5003));

        ByteBuffer buf = ByteBuffer.allocate(48);

        //dchannel.read(buf);

        buf.clear();
        dchannel.receive(buf);


        String converted = new String(buf.array(), "UTF-8");;
        System.out.println(converted);
        buf.clear();
        buf.put(converted.getBytes());
        buf.flip();

        int bytesSent = dchannel.send(buf,new InetSocketAddress(5003));

    }
}
