import java.io.*;

import java.net.*;
/**
 * SYSC 3303 A2
 *
 * The Request class contains the type of requests that can be sent and received
 * Read Requests, Write Requests, and Invalid Requests
 * Also creates, sends, and receives packets (to be used by client, host, and server)
 * Recall: Datagrampackets are data containers and Datagramsockets
 * are used to send and receive the packets.
 *
 * @author Sarah Abdallah 101119716
 * @version 2022-02-10
 */
public class Request {

    public enum Type {READ, WRITE, INVALID};

    /**
     * Formats the packet's contents by looping through
     * the data of the packet and constructing a string from the bytes.
     *
     * @param packet - Datapacket to be formatted
     * @return String that displays the packet's contents
     */
    private static String getString(DatagramPacket packet) {
        StringBuilder builder = new StringBuilder();
        byte data[] = packet.getData();
        builder.append("Bytes: ");
        for(int i = 0; i < packet.getLength(); i++) {
            builder.append("   " + data[i]);
        }
        String dataString = new String(data, 0, packet.getLength());
        builder.append(" --- String: " + dataString);

        return builder.toString();
    }

    /**
     * Creates a new DataPacket using the byte array and the intended port
     *
     * @param data - the byte array
     * @param port - port number on which the packet is created
     * @param length - length of packet
     * @return DatagramPacket
     */
    public static DatagramPacket createPacket(byte[] data, int port, int length) {
        try {
            return new DatagramPacket(data, length, InetAddress.getLocalHost(), port);
        } catch(UnknownHostException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }


    /**
     * Sends the packet to the intended Socket
     * Note: if a socket has not been passed, a new one is created
     * and closed if nothing is passed
     *
     * @param packet - packet to be sent
     * @param socket - intended socket
     * @param host - host
     */
    public static void sendPacket(DatagramPacket packet, DatagramSocket socket, String host) {
        String packetData = getString(packet);
        System.out.println("[ " + host +" ] is sending " + packetData);
        try {
            DatagramSocket sendSocket = socket != null ? socket : new DatagramSocket();
            sendSocket.send(packet);
            if (socket == null) {
                sendSocket.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Packet is received at socket
     *
     * @param socket - intended socket for receive
     * @param host - host
     * @return DatagramPacket
     */
    public static DatagramPacket receivePacket(DatagramSocket socket, String host) {
        byte data[] = new byte[100];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        try {
            System.out.println("[ " + host + " ] is waiting to receive the packet");
            socket.receive(packet);
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        String packetData = getString(packet);
        System.out.println("[ " + host + " ] has received " + packetData);
        return packet;
    }


}
