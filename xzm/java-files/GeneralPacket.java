package mx_packets;

import java.util.ArrayList;
import Interfaces.Local_Headers;

/**
 * Abstract generalised class that takes universal operations and provides them to all subclasses of this superclass
 */
public abstract class GeneralPacket implements Local_Headers{

    protected final byte SOH = 0x01;
    protected final byte FLG = 0x00;


    public ArrayList<Byte> localHeader6(){

        ArrayList<Byte> tempHeaderArray6 = new ArrayList<>();

        tempHeaderArray6.add(SIGNATURE);
        tempHeaderArray6.add(NETWORK_NODE);
        tempHeaderArray6.add(CHANNEL);
        tempHeaderArray6.add(DESTINATION_CHANNEL_ADDRESS);
        tempHeaderArray6.add(DESTINATION_TASK);
        tempHeaderArray6.add(SOURCE_CHANNEL_ADDRESS);
        tempHeaderArray6.add(SOURCE_TASK);
        tempHeaderArray6.add(MARKER);

        return tempHeaderArray6;
    }

     public byte[] getByteSequence(ArrayList<Byte> packet){

         if(packet != null) {
             byte[] compatibleArray = new byte[packet.size()];
             for (int i = 0; i < packet.size(); i++) {
                 compatibleArray[i] = packet.get(i);
             }
             return compatibleArray;
         }
         return null;//should not occur if instance creation is genuine
     }

    int calculateChecksum(ArrayList<Byte> incompletePacket) {

        int modulo = 256;
        int sum = 0;

        for(int i = 1; i < incompletePacket.size(); i++) {
            int b = (int)incompletePacket.get(i) & 0XFF;
            sum += b;
        }
        sum = sum % modulo;
        return sum;//checksum value
    }

    /**
     * Calculates the size of the incompletePacket
     * @param nearlyCompletePacket The packet in need of size calculation
     * @return returns the size of the packet to the invoker. Any insertion to the packet frame is then done at the invokers location
     */
    byte calculateSize(ArrayList<Byte> nearlyCompletePacket) {
        if(nearlyCompletePacket != null) {
            byte size = (byte) (nearlyCompletePacket.size() - 2); //remove SOH FLG CHKSUM
            size++; //increment by one to accommodate the size byte itself
            return size;
        }
        return 0;//0 is returned in the event nearlyCompletePacket is null and as such the packet will be disregarded by the panel upon receival.
    }
}
