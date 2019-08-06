package packet_structure;

import java.util.LinkedHashMap;
import Interfaces.Local_Headers;
import Interfaces.Packet_IDs;

/**
 * Header class implementing speak 6 header
 */
public class Header implements Local_Headers, Packet_IDs {

    private boolean isIgnored;
    LinkedHashMap<String, Byte> header;

    public Header() {

        header = new LinkedHashMap<>();
        header.put("signature", SIGNATURE);
        header.put("networkNode", NETWORK_NODE);
        header.put("channel", CHANNEL);
        header.put("destinationChannelAddress", DESTINATION_CHANNEL_ADDRESS);
        header.put("destinationTask", DESTINATION_TASK);
        header.put("sourceChannelAddress", SOURCE_CHANNEL_ADDRESS);
        header.put("sourceTask", SOURCE_TASK);
        header.put("marker", MARKER);
        header.put("packetID", spkd_ID_POINT_INFO_REQUEST);
        header.put("reserved", RESERVED);
    }
    /**
     * Returns default populated speak 6 hashmap.
     */
    public LinkedHashMap<String, Byte> getHeaderTemplate() {

        if (isIgnored) {
            header.remove("reserved");
        }
        return header;
    }
    public void ignoredReserved(boolean val){
        isIgnored = val;
    }
}
