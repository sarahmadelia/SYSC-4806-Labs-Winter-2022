import java.net.*;
/**
 * SYSC 3303 A2
 *
 * The IntermediateHost algorithm creates a DatagramSocket to receive (on P23)
 * and creates a DatagramSocket to send and receive.
 * This happens for as long as the program runs.
 *
 * @author Sarah Abdallah 101119716
 * @version 2022-02-10
 */
public class IntermediateHost {

    private String hostName = "Intermediate Host";
    private DatagramSocket receiveSocket;
    private DatagramSocket sendReceiveSocket;

    /**
     * Constructor for the Intermediate host class.
     */
    public IntermediateHost() {
        try {
            receiveSocket = new DatagramSocket(Client.PORT);
            sendReceiveSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Runs the host:
     * The host receives the client's packet at the receiveSocket and
     * creates this packet on the server's port and sends the packet to the server.
     *
     * The host then waits to receive the packet back from the server and
     * creates this packet on the client port to be sent back to the client
     *
     */
    public void run() {

        DatagramPacket clientPacket = Request.receivePacket(receiveSocket, hostName);
        DatagramPacket newPacket = Request.createPacket(clientPacket.getData(), Server.PORT, clientPacket.getLength());
        Request.sendPacket(newPacket, sendReceiveSocket, hostName);

        //Wait
        DatagramPacket serverPacket = Request.receivePacket(sendReceiveSocket, hostName);
        DatagramPacket newServerPacket = Request.createPacket(serverPacket.getData(), clientPacket.getPort(), serverPacket.getLength());
        Request.sendPacket(newServerPacket, null, hostName);
    }

    public static void main(String[] args) {
        IntermediateHost intermediateHost = new IntermediateHost();
        while (true) {
            //this goes on forever, as per the assignment description
            intermediateHost.run();

            System.out.println();
        }
    }
}





