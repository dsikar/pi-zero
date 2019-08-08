package mx_packets;

import java.nio.charset.MalformedInputException;
import java.util.LinkedHashMap;

import data_formatting.HTTP_Handler;
import jci.android_data_logger.MZXService;
import jci.android_data_logger.MainActivity;
import packet_structure.Frame;
import packet_structure.Header;
import packet_structure.Packet;

public class Point_Info_Packet {

    //private String piURL = "http://192.168.4.1/broker.php?action=";
    //private String serverURL = "http://3.9.146.52/broker_backup.php?action=";
    public static String ID = "";
    private String ip_address = "3.8.97.201";

    private String serverURL;
    private HTTP_Handler http_handler = new HTTP_Handler();

    private Byte nodeValue;
    private Byte loopValue;
    private Byte pointValue;

    private LinkedHashMap<String, Byte> pointInfoTemplate;
    private LinkedHashMap<String, Byte> headerTemplate;

    private MZXService mzxService; //reference to mzx service to allow write operations

    public Point_Info_Packet(MZXService mzxService){
        this.mzxService = mzxService;
    }

    /**
     * setNodeValue
     * @param nodeVal
     */
    public void setNodeValue(Byte nodeVal) {
        this.nodeValue = nodeVal;
    }
    public void setLoopValue(Byte loopValue) {
        this.loopValue = loopValue;
    }
    public void setPointValue(Byte pointValue) {
        this.pointValue = pointValue;
    }
    public Byte getLoopValue(){ return this.loopValue; }

    /**
     * builds and sends request packet
     */
    public void sendRequestPacket(final String stringDataToBeSentToServer){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Header header = new Header();
                header.ignoredReserved(true);

                headerTemplate = header.getHeaderTemplate();

                Point_Info_Content point_info_content = new Point_Info_Content();
                pointInfoTemplate = point_info_content.getRequestTemplate();

                pointInfoTemplate.put("panelNumber", nodeValue);//allows change of value behind specified keyword
                pointInfoTemplate.put("loopNumber",  loopValue);
                pointInfoTemplate.put("pointNumber", pointValue);

                Packet packet = new Packet(headerTemplate, pointInfoTemplate);//combines the two hashmap arrays into a packet object
                Frame frame = new Frame(packet);

                if(MainActivity.WIFI_CONNECTION){
                    serverURL = "http://"+ip_address+"/broker.php?id="+ID+"&action=";
                    http_handler.sendDataViaHTTP(serverURL, frame.getByteArray(), stringDataToBeSentToServer);//constructs a
                }
                else {
                    mzxService.write(frame.getByteArray());//calling this function places the frame in a write queue ready for data transfer
                }

            }
        }).start();
    }
}
