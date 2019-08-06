package packet_structure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Packet {

    private LinkedHashMap<String, Byte> header;
    private LinkedHashMap<String, Byte> content;
    private ArrayList<Byte> totalPacketBytes;

    /**
     * @param header Given HashMap resembling header bytes
     * @param content Given HashMap resembling content bytes
     */
    public Packet(LinkedHashMap<String, Byte> header, LinkedHashMap<String, Byte> content) {
        this.header = header;
        this.content = content;
    }

    /*
     Return bytes function for Packet instance
     */
    public ArrayList<Byte> getByteArray() {
        totalPacketBytes = new ArrayList<>();

        if (header.isEmpty() == false) {
            if (content.isEmpty() == false) {

                for(Map.Entry<String, Byte> headerSet : header.entrySet()){
                    totalPacketBytes.add(headerSet.getValue());
                }
                for(Map.Entry<String, Byte> contentSet : content.entrySet()) {
                    totalPacketBytes.add(contentSet.getValue());

                }
            }
        }
        return totalPacketBytes;
    }

    /**
     * returns the size of the contents of the packet, excludes SOH, FLG, CHECKSUM
     * @return
     */
    public int size(){
        return calculateSize(totalPacketBytes);
    }

    /**
     * Calculates the size of the incompletePacket
     * @param nearlyCompletePacket The packet in need of size calculation
     * @return returns the size of the packet to the invoker.
     */
    byte calculateSize(ArrayList<Byte> nearlyCompletePacket) {
        if(nearlyCompletePacket != null) {
            byte size = (byte) (nearlyCompletePacket.size());
            size++; //increment by one to accommodate the size byte itself
            return size;
        }
        return 0;//0 is returned in the event nearlyCompletePacket is null and as such the packet will be disregarded by the panel upon receival.
    }

}
