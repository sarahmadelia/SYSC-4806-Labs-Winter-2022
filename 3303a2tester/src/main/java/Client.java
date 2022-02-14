import java.io.*;

import java.net.*;

/**
 * SYSC 3303 A2
 *
 * The Client algorithm creates a DatagramSocket to use both send and receive
 * the DatagramPacket, prints out the information within the packet,
 * and sends the packet.
 *
 * @author Sarah Abdallah 101119716
 * @version 2022-02-10
 */


public class Client {

    private String hostName ="Client";
    public static int PORT = 23;
    DatagramSocket sendReceiveSocket;

    /**
     * Constructor for the client class.
     */
    public Client() {
        try {
            sendReceiveSocket = new DatagramSocket();
        }catch(SocketException se) {
            se.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates the format of the read or write request
     *
     * @param reqType - type of request within packet
     * @param filename - name of file within packet
     * @param mode - mode within packet
     * @return byte array of packet contents
     */
    private byte[] createPacketFormat(Request.Type reqType, String filename, String mode) {
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            //The first byte is always 0
            byteStream.write(0);
            if (reqType == Request.Type.READ) {
                //read request format 0 1
                byteStream.write(1);
            } else if (reqType == Request.Type.WRITE) {
                //write request format 0 2
                byteStream.write(2);
            }
            //convert filename from string to bytes
            byteStream.write(filename.getBytes());
            byteStream.write(0);
            //convert mode from string to bytes
            byteStream.write(mode.getBytes());
            byteStream.write(0);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Runs the client:
     *
     * The process is repeated 11 times and it alternates between read and write
     * The client creates a pack to be sent on Port 23, sends it to the host
     * Receives a packet back from host at the socket.
     */
    public void run() {
        //Repeat 11 times
        for(int i=0; i<11; i++) {
            Request.Type reqType;
            if(i==10) {
                reqType = Request.Type.INVALID;
            }else if (i%2 == 0) { //alternate between read and write, five each
                reqType = Request.Type.READ;
            }else{
                reqType = Request.Type.WRITE;
            }
            byte data[]= createPacketFormat(reqType, "test.txt", "ocTEt");
            DatagramPacket packet = Request.createPacket(data, PORT, data.length);
            Request.sendPacket(packet, sendReceiveSocket, hostName);
            Request.receivePacket(sendReceiveSocket, hostName);
            System.out.println();

        }

    }

    public static void main(String[] args) {
        Client client = new Client();

        client.run();

    }


}

