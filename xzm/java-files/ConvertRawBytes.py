#python version to be used on the raspberry pi
import Codes as codes;

 """Class to convert incoming raw data bytes into a readable string to be presented to the user."""
class ConvertRawBytes:

    formattedData = []; #python idiom add item to list and then convert back to string after.

    mode = 0;
    sensitivity = 0;

    flgBits = []; #int array
    #formattedDataList = []; #string array

    channelAddress = "";
    loopType = "";

     """Constructor that truncates data to what the pc data logger application
        @param unconvertedBytes"""
    def ConvertRawBytes(byte[] unconvertedBytes):

        if(unconvertedBytes != null):

            channelAddress = String.valueOf(unconvertedBytes[15]);                                  #channel address
            filterLoopType(unconvertedBytes[28]);

            formattedData.append(new StringFormatting().getFormattedDate()+", ");                   #0
            formattedData.append(new StringFormatting().getFormattedTime()+", ");                   #1
            formattedData.append(unconvertedBytes[14]+", ");                                        #2 node
            formattedData.append(convertLoopByte(unconvertedBytes[16])+", ");                       #3 loop
            formattedData.append(byteToInt(unconvertedBytes[18])+", ");                             #4 point number

            if(checkAreaType(unconvertedBytes[25])):
                formattedData.append(byteToInt(unconvertedBytes[26])+", ");                         #5 zone number
            
            else:
                formattedData.append("Sector Not Zone, ");

            deviceType = byteToInt(unconvertedBytes[21]);

            for i in range(0, len(codes.deviceCodes)):
                if(deviceType == i):
                    formattedData.append(codes.deviceCodes[i]+", ");                                      #6 device type
                    break;

            formattedData.append(combineBytes(unconvertedBytes[23],unconvertedBytes[24])+", ");     #7 group to which device is assigned

            formattedData.append(byteToInt(unconvertedBytes[32])+", ");                             #8 raw value of channel 1
            formattedData.append(convertUnitsOfMeasure(unconvertedBytes[38])+", ");                 #9 units for channel 1
            formattedData.append(byteToInt(unconvertedBytes[33])+", ");                             #10 raw value of channel 2
            formattedData.append(convertUnitsOfMeasure(unconvertedBytes[39])+", ");                 #11 units for channel 2
            formattedData.append(byteToInt(unconvertedBytes[34])+", ");                             #12 raw data value of channel 3
            formattedData.append(convertUnitsOfMeasure(unconvertedBytes[40])+", ");                 #13 units for channel 3


            for i in range(0, len(codes.faultCodes)):
                if(unconvertedBytes[47] == 1):
                    formattedData.append(codes.faultCodes[i]+", ");                                       #14 fault status
                    break;

            for i in range(0, len(codes.faultCodes)):
                if(unconvertedBytes[46] == i):
                    formattedData.append(codes.alarmCodes[i]+", ");                                       #15 alarm status
                    break;

            splitBytes(unconvertedBytes[31]); #splits the share byte into nibbles thus giving mode and sensitivity a value

            formattedData.append(mode+", ");                                                        #16 Device mode
            formattedData.append(sensitivity+", ");                                                 #17 Device sensitivity

            formattedData.append(byteToInt(unconvertedBytes[35])+", ");                             #18 Long term average available (LTA FLAGS)
            formattedData.append(byteToInt(unconvertedBytes[36])+", ");                             #19 Long term average current value   (Raw LTA)
            formattedData.append(byteToInt(unconvertedBytes[37])+", ");                             #20 Long term average dirtiness value % Dirtiness

            flgBits = getBitsFromByte(unconvertedBytes[13]);#convert the byte to 8 bits and checks fields that represent status

            if(flgBits[0] == 0):                                                                     #21 input forced status
                formattedData.append("False, ");
            else:
                formattedData.append("True, ");

            if(flgBits[1] == 0):                                                                     #22 Untested/failed status
                formattedData.append("False, ");
            else:
                formattedData.append("True, ");

            if(flgBits[2] == 0):                                                                     #23 Input isolated status
                formattedData.append("False, ");
            else:
                formattedData.append("True, ");

            if(flgBits[3] == 0):                                                                     #24 Output isolated status
                formattedData.append("False, ");
            else:
                formattedData.append("True, ");

            if(flgBits[4] == 0):                                                                     #25 Out of compensation status
                formattedData.append("False ");
            else:
                formattedData.append("True ");

            #formattedDataList = formattedData.toString().split(", ");

    def ConvertRawBytes():

    def getFormattedLine():

        formattedData.append("\n");
        return formattedData.toString();

    def checkAreaType(int type):
        if(type == 0):
            return true;
        return false;

    def  getFormattedDataList():
        return this.formattedData;

    def getChannelAddress():
        return this.channelAddress;

    def getLoopType():
        return this.loopType;

    def combineBytes(int msb, int lsb):

        int value = (msb << 8) | lsb;
        return value;

    def void splitBytes(int sharedByte):

        sensitivity = sharedByte & 0x0F;
        mode = (sharedByte >> 4) & 0x0F;

    def byteToInt(byte singleByte):
        return (singleByte & 0xFF);

    def void filterLoopType(int loopType):
        switch(loopType):
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

    def convertUnitsOfMeasure(int unitToBeConverted):
        unitOfConversion = "";

        switch (unitToBeConverted):
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

        return unitOfConversion;

    def createDeviceInfoTitle(byte[] data):

        pointTitle = new StringBuilder();
        pointTitle.append("Point " + byteToInt(data[18]) + "     ");

        deviceType = byteToInt(data[21]);

        for i in range(0, len(codes.deviceCodes)):
            if (deviceType == i):
                pointTitle.append(codes.deviceCodes[i] + " ");                                            #device type
                break;

        return pointTitle.toString();

    def convertLoopByte(int loopByte):

        loop = "";
        switch(loopByte):

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

        return loop;

    def getBitsFromByte(byte flgByte):

        bits = [];
        bits[0] = byteToInt((byte) (flgByte & 0x01));
        bits[1] = byteToInt((byte) (flgByte & 0x02));
        bits[2] = byteToInt((byte) (flgByte & 0x04));
        bits[3] = byteToInt((byte) (flgByte & 0x08));
        bits[4] = byteToInt((byte) (flgByte & 0x10));
        bits[5] = byteToInt((byte) (flgByte & 0x20));
        bits[6] = byteToInt((byte) (flgByte & 0x40));
        bits[7] = byteToInt((byte) (flgByte & 0x80));

        return bits;
