package packet_structure;

import java.util.ArrayList;

/**
 * @author jgillsr
 * Class contains the implementation of the PTP frame data link layer;
 */
public class Frame {

    private final byte SOH = 0x01;
    private static byte FLG = 0x00;
    private final int ACK = 0x06;
    private final int MODULO = 256;

    private final int SIZE_INDEX = 2;

    private Packet packet;

    public Frame(Packet packet){
        this.packet = packet;
    }


    /**
     * function to return a packet instance
     * @return returns a packet instance
     */
    public Packet getPacket(){
        return packet;
    }

    /**
     * function to return byte array of frame instance
     * @return returns a byte array resembling a complete request packet
     */
    public byte[] getByteArray(){

        ArrayList<Byte> bytes = new ArrayList<>();
        bytes.add(SOH);

        bytes.add(FLG);
        bytes.addAll(packet.getByteArray()); //get bytes array of packet contents only.
        bytes.add(SIZE_INDEX,(byte) packet.size()); //calculates size and inserts it at said index
        bytes.add((byte)checksum(bytes)); //calculates checksum and places it at end of packet

        if(FLG == 15)
            FLG = 0;    //reset the flag to 0 to prevent going out of bounds

        FLG = (byte) (FLG + 1);
        return convertToStandardArray(bytes);
    }
    /**
     * calculates checksum of incomplete packet to make it complete
     * @param incompletePacket
     * @return
     */
    private int checksum(ArrayList<Byte> incompletePacket){
        int sum = 0;

        for(int i = 1; i < incompletePacket.size(); i++) {
            int b = (int)incompletePacket.get(i) & 0XFF;
            sum += b;
        }
        sum = sum % MODULO;
        return sum;//return checksum to complete incomplete packet
    }
    /**
     * Takes an ArrayList interpretation of a byte sequence and converts it to a fixed size byte array for sending down the line
     * @param packet
     * @return a standard 1 dimensional byte array as opposed to an arraylist collection
     */
    public byte[] convertToStandardArray(ArrayList<Byte> packet){

        if(packet != null) {
            byte[] compatibleArray = new byte[packet.size()];
            for (int i = 0; i < packet.size(); i++) {
                compatibleArray[i] = packet.get(i);
            }
            return compatibleArray;
        }
        return null;//should not occur if instance creation is genuine
    }


}
