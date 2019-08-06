package data_formatting;

import Interfaces.Codes;

/**
 * Class to convert incoming raw data bytes into a readable string to be presented to the user.
 */
public class ConvertRawBytes implements Codes{

    private StringBuilder formattedData = new StringBuilder();

    public  int mode;
    public int sensitivity;

    private int[] flgBits;
    private String[] formattedDataList;

    private String channelAddress;
    private String loopType;

    /**
     * Constructor that truncates data to what the pc data logger application
     * @param unconvertedBytes
     */
    public ConvertRawBytes(byte[] unconvertedBytes){

        if(unconvertedBytes != null){

            channelAddress = String.valueOf(unconvertedBytes[15]);                                  //channel address
            filterLoopType(unconvertedBytes[28]);

            formattedData.append(new StringFormatting().getFormattedDate()+", ");                   //0
            formattedData.append(new StringFormatting().getFormattedTime()+", ");                   //1
            formattedData.append(unconvertedBytes[14]+", ");                                        //2 node
            formattedData.append(convertLoopByte(unconvertedBytes[16])+", ");                       //3 loop
            formattedData.append(byteToInt(unconvertedBytes[18])+", ");                             //4 point number

            if(checkAreaType(unconvertedBytes[25])){
                formattedData.append(byteToInt(unconvertedBytes[26])+", ");                         //5 zone number
            }
            else{
                formattedData.append("Sector Not Zone, ");
            }

            int deviceType = byteToInt(unconvertedBytes[21]);
            for(int i = 0; i < deviceCodes.length; i++){
                if(deviceType == i){
                    formattedData.append(deviceCodes[i]+", ");                                      //6 device type
                    break;
                }
            }

            formattedData.append(combineBytes(unconvertedBytes[23],unconvertedBytes[24])+", ");     //7 group to which device is assigned

            formattedData.append(byteToInt(unconvertedBytes[32])+", ");                             //8 raw value of channel 1
            formattedData.append(convertUnitsOfMeasure(unconvertedBytes[38])+", ");                 //9 units for channel 1
            formattedData.append(byteToInt(unconvertedBytes[33])+", ");                             //10 raw value of channel 2
            formattedData.append(convertUnitsOfMeasure(unconvertedBytes[39])+", ");                 //11 units for channel 2
            formattedData.append(byteToInt(unconvertedBytes[34])+", ");                             //12 raw data value of channel 3
            formattedData.append(convertUnitsOfMeasure(unconvertedBytes[40])+", ");                 //13 units for channel 3


            for(int i = 0; i < faultCodes.length;i++) {
                if(unconvertedBytes[47] == i){
                    formattedData.append(faultCodes[i]+", ");                                       //14 fault status
                    break;
                }
            }

            for(int i = 0; i < alarmCodes.length; i++){
                if(unconvertedBytes[46] == i){
                    formattedData.append(alarmCodes[i]+", ");                                       //15 alarm status
                }
            }

            splitBytes(unconvertedBytes[31]); //splits the share byte into nibbles thus giving mode and sensitivity a value

            formattedData.append(mode+", ");                                                        //16 Device mode
            formattedData.append(sensitivity+", ");                                                 //17 Device sensitivity

            formattedData.append(byteToInt(unconvertedBytes[35])+", ");                             //18 Long term average available (LTA FLAGS)
            formattedData.append(byteToInt(unconvertedBytes[36])+", ");                             //19 Long term average current value   (Raw LTA)
            formattedData.append(byteToInt(unconvertedBytes[37])+", ");                             //20 Long term average dirtiness value % Dirtiness

            flgBits = getBitsFromByte(unconvertedBytes[13]);//convert the byte to 8 bits and checks fields that represent status

            if(flgBits[0] == 0)                                                                     //21 input forced status
                formattedData.append("False, ");
            else
                formattedData.append("True, ");

            if(flgBits[1] == 0)                                                                     //22 Untested/failed status
                formattedData.append("False, ");
            else
                formattedData.append("True, ");

            if(flgBits[2] == 0)                                                                     //23 Input isolated status
                formattedData.append("False, ");
            else
                formattedData.append("True, ");

            if(flgBits[3] == 0)                                                                     //24 Output isolated status
                formattedData.append("False, ");
            else
                formattedData.append("True, ");

            if(flgBits[4] == 0)                                                                     //25 Out of compensation status
                formattedData.append("False ");
            else
                formattedData.append("True ");

            formattedDataList = formattedData.toString().split(", ");
        }

    }
    public ConvertRawBytes(){

    }
    public String getFormattedLine(){

        formattedData.append("\n");
        return formattedData.toString();
    }

    private boolean checkAreaType(int type){
        if(type == 0){
            return true;
        }
        return false;
    }

    public String[] getFormattedDataList(){
        return this.formattedDataList;
    }
    public String getChannelAddress(){
        return this.channelAddress;
    }
    public String getLoopType(){
        return this.loopType;
    }

    private int combineBytes(int msb, int lsb){

        int value = (msb << 8) | lsb;
        return value;
    }

    private void splitBytes(int sharedByte){

        sensitivity = sharedByte & 0x0F;
        mode = (sharedByte >> 4) & 0x0F;

    }

    private int byteToInt(byte singleByte){

        return (singleByte & 0xFF);
    }

    private void filterLoopType(int loopType){
        switch(loopType){
            case 0:
                this.loopType = "Thorn";
                break;
            case 1:
                this.loopType = "MX Digital";
                break;
            case 2:
                this.loopType = "Not Loop";
                break;
            case 3:
                this.loopType = "ZetFas";
                break;
            case 4:
                this.loopType = "STI";
                break;
            default:
                break;
        }
    }

    private String convertUnitsOfMeasure(int unitToBeConverted){
        String unitOfConversion;

        switch (unitToBeConverted){
            case 0:
                unitOfConversion = "Invalid";
                break;

            case 1:
                unitOfConversion = "°C";
                break;

            case 2:
                unitOfConversion = "°F";
                break;

            case 3:
                unitOfConversion = "ppm";
                break;

            case 4:
                unitOfConversion = "%/ft";
                break;

            case 5:
                unitOfConversion = "%/m";
                break;

            case 6:
                unitOfConversion = "Y-value";
                break;

            case 7:
                unitOfConversion = "amps";
                break;

            case 8:
                unitOfConversion = "volts";
                break;

            case 9:
                unitOfConversion = "Not installed";
                break;

            case 10:
                unitOfConversion = "mA";
                break;

            default:
                unitOfConversion = "N/A";
                break;

        }
        return  unitOfConversion;

    }

    public String createDeviceInfoTitle(byte[] data) {
        StringBuilder pointTitle = new StringBuilder();
        pointTitle.append("Point " + byteToInt(data[18]) + "     ");

        int deviceType = byteToInt(data[21]);
        for (int i = 0; i < deviceCodes.length; i++) {
            if (deviceType == i) {
                pointTitle.append(deviceCodes[i] + " ");                                            //device type
                break;
            }
        }
        return pointTitle.toString();
    }

    public String convertLoopByte(int loopByte){

        String loop;
        switch(loopByte){


            case 1:
                loop = "A";
                break;

            case 2:
                loop = "B";
                break;

            case 3:
                loop = "C";
                break;

            case 4:
                loop = "D";
                break;

            case 5:
                loop = "E";
                break;

            case 6:
                loop = "F";
                break;

            case 7:
                loop = "G";
                break;

            case 8:
                loop = "H";
                break;

            case 9:
                loop = "J";
                break;

            case 10:
                loop = "K";
                break;

            case 255:
                loop = "All loops";
                break;

            default:
                loop = "Unknown(-)";
                break;
        }
        return loop;
    }

    private int[] getBitsFromByte(byte flgByte){

        int[] bits = new int[8];
        bits[0] = byteToInt((byte) (flgByte & 0x01));
        bits[1] = byteToInt((byte) (flgByte & 0x02));
        bits[2] = byteToInt((byte) (flgByte & 0x04));
        bits[3] = byteToInt((byte) (flgByte & 0x08));
        bits[4] = byteToInt((byte) (flgByte & 0x10));
        bits[5] = byteToInt((byte) (flgByte & 0x20));
        bits[6] = byteToInt((byte) (flgByte & 0x40));
        bits[7] = byteToInt((byte) (flgByte & 0x80));

        return bits;
    }
}
