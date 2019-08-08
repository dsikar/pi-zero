package mx_packets;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import Interfaces.Default_Packet_Values;

/**
 * Content Class providing populated packet
 */
public class Point_Info_Content implements Default_Packet_Values {

    private LinkedHashMap<String, Byte> point_info_content;

    /**
     * Constructor containing thread to populate request frame with default values
     */
    public Point_Info_Content() {

        point_info_content = new LinkedHashMap<>();

        point_info_content.put("panelNumber"        ,PANEL_NUMBER);
        point_info_content.put("channelAddress"     ,CHANNEL_ADDRESS);
        point_info_content.put("loopNumber"         ,LOOP_NUMBER);
        point_info_content.put("pointCategory"      ,POINT_CATEGORY);
        point_info_content.put("pointNumber"        ,POINT_NUMBER);
        point_info_content.put("logicalPointNumber" ,LOGICAL_POINT_NUMBER);
        point_info_content.put("logicalPointZone"   ,LOGICAL_POINT_ZONE);
        point_info_content.put("deviceCategory"     ,DEVICE_CATEGORY);
        point_info_content.put("groupMSB"           ,GROUP_MSB);
        point_info_content.put("groupLSB"           ,GROUP_LSB);
        point_info_content.put("outputStateStore"   ,OUTPUT_POINT_STATE_STORE);
        point_info_content.put("reserved1"          ,RESERVED_1);
        point_info_content.put("reserved2"          ,RESERVED_2);
        point_info_content.put("multiAreaType"      ,MULTI_AREA_TYPE);

        int firstVal = 0; //quicker way of assigning area type
        int secondVal = 7;
        for (int i = 0; i < 30; i++) {
            point_info_content.put("areas" + firstVal + ".." + secondVal, AREAS);
            firstVal += 8;
            secondVal += 8;
        }
        point_info_content.put("area"        ,AREA);
        point_info_content.put("deviceType"  ,DEVICE_TYPE);
        point_info_content.put("requestType" ,REQUEST_TYPE);
        point_info_content.put("searchType"  ,SEARCH_TYPE);
    }

    /**
     * Function to return populated default HashMap
     * @return A HashMap template allowing byte values assigned to keys to be changed
     */
    public LinkedHashMap<String, Byte> getRequestTemplate() {
        return point_info_content;
    }

    /**
     * Function to return bytes array, not currently used
     * @param hashMap Hashmap as param
     * @return An Arraylist of contents bytes
     */
    public ArrayList<Byte> getByteArray(LinkedHashMap<String, Byte> hashMap) {

        ArrayList<Byte> bytes = new ArrayList<>();

        for (int idx = 0; idx < hashMap.size(); idx++) {
            bytes.add(hashMap.get(idx));
        }
        return bytes;
    }

}
