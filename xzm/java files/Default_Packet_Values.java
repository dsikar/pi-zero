package Interfaces;

/**
 * Interface containing the core packet contents of a point info rreque
 */
public interface Default_Packet_Values {

    byte PANEL_NUMBER              =                 (byte) 0x00;
    byte CHANNEL_ADDRESS           =                 (byte) 0x0C;
    byte LOOP_NUMBER               =                 (byte) 0x01;
    byte POINT_CATEGORY            =                 (byte) 0x00;
    byte POINT_NUMBER              =                 (byte) 0xFF;
    byte LOGICAL_POINT_NUMBER      =                 (byte) 0x00;
    byte LOGICAL_POINT_ZONE        =                 (byte) 0xFE;
    byte DEVICE_CATEGORY           =                 (byte) 0x00;
    byte GROUP_MSB                 =                 (byte) 0x00;
    byte GROUP_LSB                 =                 (byte) 0x01;
    byte OUTPUT_POINT_STATE_STORE  =                 (byte) 0x03;
    byte RESERVED_1                =                 (byte) 0x00;
    byte RESERVED_2                =                 (byte) 0x00;
    byte MULTI_AREA_TYPE           =                 (byte) 0x03;
    byte AREA                      =                 (byte) 0xFF;
    byte AREAS                     =                 (byte) 0xFF;
    byte DEVICE_TYPE               =                 (byte) 0x7F;
    byte REQUEST_TYPE              =                 (byte) 0x00;
    byte SEARCH_TYPE               =                 (byte) 0x0A;
}
