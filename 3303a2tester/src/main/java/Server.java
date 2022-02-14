import java.net.*;
/**
 * SYSC 3303 A2
 *
 * The server algorithm creates a DatagramSocket to receive (at P69), checks if
 * the packet is valid, prints out a response, creates a socket for the response
 * and sends the packet to the port it received the request from.
 *
 * @author Sarah Abdallah 101119716
 * @version 2022-02-10
 *
 */
public class Server {

    private String hostName = "Server";
    public static int PORT = 69;
    private DatagramSocket receiveSocket;

    /**
     * Constructor for the server class
     */
    public Server() {
        try {
            receiveSocket = new DatagramSocket(PORT);
        } catch (SocketException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    /**
     * Verify that a packet is valid-
     * A valid packet begins with a zero
     * The second byte is either a read or a write signifier
     * This function counts the number of zeroes after the first two bytes
     * and uses this information to check validity.
     *
     * @param packet- DatagramPacket to be verified
     * @return
     */
    private boolean isPacketValid(DatagramPacket packet) {
        byte data[] = packet.getData();
        if (data[0] != 0) {
            return false;
        }
        if (data[1] != 1 && data[1] != 2) {
            return false;
        }
        int numZeros = 0;
        for (int i = 2; i < data.length; i++) {
            //If the two previous bytes are zero, there was no mode
            if (data[i] == 0 && data[i - 1] !=0) {
                numZeros++;
            }
        }
        return numZeros == 2;
        // There should be two zeroes bc there should be a 0 between
        //the filename and mode, with zero at the end
    }

    /**
     * Gets the DatagramPacket's request type
     *
     * @param packet- DatagramPacket
     * @return Request type
     */
    private Request.Type getRequestType (DatagramPacket packet) {
        byte data[] = packet.getData();
        if (data[1] == 1) {
            return Request.Type.READ;
        } else if (data[1] == 2) {
            return Request.Type.WRITE;
        }
        return null;
    }


    /**
     * Creates a packet based on the type of the request
     *
     * @param type- Request Type
     * @param port
     * @return DatagramPacket
     */
    private DatagramPacket createPacket(Request.Type type, int port) {
        byte data[];

        if (type == Request.Type.READ) {
            data = new byte[] {0, 3, 0, 1};
        } else {
            data = new byte[] {0, 4, 0, 0};
        }

        return Request.createPacket(data, port, data.length);
    }

    /**
     * Runs the server
     * The server waits to receive the packet from the intermediate host and verifies
     * the pack's validity. It then creates a new packet to send back to the intermediate
     */
    public void run() {

        DatagramPacket receivedPacket = Request.receivePacket(receiveSocket, hostName);
        try {
            if (!isPacketValid(receivedPacket)) {
                throw new Exception("Invalid packet!");
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        DatagramPacket responsePacket = createPacket(getRequestType(receivedPacket), receivedPacket.getPort());
        Request.sendPacket(responsePacket, null, hostName);
    }


    public static void main(String[] args) {
        Server server = new Server();
        while (true) { // run forever
            server.run();

            System.out.println();
        }
    }

}

