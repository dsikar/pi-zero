package data_formatting;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class to handle time display as well as formatting incoming data from connected panel
 */
public class StringFormatting {
    /**
     * Formats time to HH:MM:SS and is returned to be display on the data terminal
     * @return returns a string containing the new formatted time.
     */
    public String getFormattedTime(){

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        return String.format("%02d:%02d:%02d",hours, minute, seconds);
    }

    public Calendar getCalendarInstance(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }

    /**
     * Generates the date in the format of "DD-MM-YYYY"
     * @return The new formatted date
     */
    public String getFormattedDate(){

        String specificFormat = "dd-MM-yyyy";
        String currentDate = new SimpleDateFormat(specificFormat).format(new Date());
        return  currentDate;
    }

    /**
     * Translates data coming from port to UI screen in a readable format
     * @param arg0 Unformatted data to be formatted
     * @return Formatted data
     */
    public String formatData(byte[] arg0){

        StringBuilder response = new StringBuilder();

        response.append("\n\nIncoming Data ===============================\n\n");

        if(arg0.length == 1){
            response.append("Acknowledgement Byte (ACK) : "+ arg0[0]);
        }
        else if(arg0.length > 1) {
            for (int i = 0; i < arg0.length; i++) {
                response.append("Data Byte : ["+(i)+"] : "+ (arg0[i] & 0xFF) + "\n"); //bitwise AND operation to get byte format display that we want.
            }
        }
        else{
            response.append("Something has gone wrong. Please try again");
        }

        //at the moment a string is used to carry the formatted message to the handler in the UI thread.
        //The use of a string for the means of transportation is likely to be changed soon.
        return response.toString();
    }
    public String formatData1(byte[] bytes){

        StringBuilder response = new StringBuilder();
        response.append("\n\nIncoming Data ===============================\n\n");

        if(bytes.length == 1){
            response.append("Acknowledgement Byte (ACK) : "+ bytes[0]);
        }
        else if(bytes.length > 1) {

            response.append( "Data for point---["+ byteToInt(bytes[18])+"]---\n\n");

            response.append( "Reply Status: "+                   byteToInt(bytes[12])+"\n");
            response.append( "Flags : "+                         byteToInt(bytes[13])+"\n");
            response.append( "Node : "+                          byteToInt(bytes[14])+"\n");
            response.append( "Channel : "+                       byteToInt(bytes[15])+"\n");
            response.append( "Channel Address : "+               byteToInt(bytes[16])+"\n");
            response.append( "Point Category : "+                byteToInt(bytes[17])+"\n");
            response.append( "Point Number : "+                  byteToInt(bytes[18])+"\n");
            response.append( "Logical Point Number : "+          byteToInt(bytes[19])+"\n");
            response.append( "Logical Point Zone : "+            byteToInt(bytes[20])+"\n");
            response.append( "Device Type : "+                   byteToInt(bytes[21])+"\n");
            response.append( "Auxiliary Point Attributes : "+    byteToInt(bytes[22])+"\n");
            response.append( "Group MSB : "+                     byteToInt(bytes[23])+"\n");
            response.append( "Group LSB : "+                     byteToInt(bytes[24])+"\n");
            response.append( "Area Type : "+                     byteToInt(bytes[25])+"\n");
            response.append( "Area Number : "+                   byteToInt(bytes[26])+"\n");
            response.append( "Sector ID : "+                     byteToInt(bytes[27])+"\n");
            response.append( "Loop Type : "+                     byteToInt(bytes[28])+"\n");
            response.append( "Raw Identity : "+                  byteToInt(bytes[29])+"\n");
            response.append( "Actual Device Type : "+            byteToInt(bytes[30])+"\n");
            response.append( "Mode & Sensitivity : "+            byteToInt(bytes[31])+"\n");
            response.append( "Raw Analogue Value 1 : "+          byteToInt(bytes[32])+"\n");
            response.append( "Raw Analogue Value 2 : "+          byteToInt(bytes[33])+"\n");
            response.append( "Raw Analogue Value 3 : "+          byteToInt(bytes[34])+"\n");
            response.append( "LTA Flags : "+                     byteToInt(bytes[35])+"\n");
            response.append( "Raw LTA : "+                       byteToInt(bytes[36])+"\n");
            response.append( "% Dirtiness : "+                   byteToInt(bytes[37])+"\n");
            response.append( "Unit of Measure 1 : "+             byteToInt(bytes[38])+"\n");
            response.append( "Unit of Measure 2 : "+             byteToInt(bytes[39])+"\n");
            response.append( "Unit of Measure 3 : "+             byteToInt(bytes[40])+"\n");
            response.append( "Converted Value 1 : "+             byteToInt(bytes[41])+"\n");
            response.append( "Converted Value 2 : "+             byteToInt(bytes[42])+"\n");
            response.append( "Converted Value 3 : "+             byteToInt(bytes[43])+"\n");
            response.append( "Instantaneous Active State : "+    byteToInt(bytes[44])+"\n");
            response.append( "Instantaneous Fault State : "+     byteToInt(bytes[45])+"\n");
            response.append( "Confirmed Active State : "+         byteToInt(bytes[46])+"\n");
            response.append( "Confirmed Fault State : "+          byteToInt(bytes[47])+"\n");
            response.append( "Acknowledged Active State : "+      byteToInt(bytes[48])+"\n");
            response.append( "Acknowledged Fault State : "+       byteToInt(bytes[49])+"\n");
            response.append( "Output Forced Mode : "+             byteToInt(bytes[50])+"\n");
            response.append( "Output Unforced State : "+          byteToInt(bytes[51])+"\n");
            response.append( "Output Forced State : "+            byteToInt(bytes[52])+"\n");
            response.append( "ClientID MSB : "+                   byteToInt(bytes[53])+"\n");
            response.append( "ClientID LSB : "+                   byteToInt(bytes[54])+"\n\n");
            response.append( "CHECKSUM : "+                       byteToInt(bytes[55])+"\n");

        }
        else{
            response.append( "Something has gone wrong. Please try again");
        }

        //at the moment a string is used to carry the formatted message to the handler in the UI thread.
        //The use of a string for the means of transportation is likely to be changed soon.
        return response.toString();
    }

    public String[] formatPrinterData(String untrimmedData){

        String[] trimmedData = untrimmedData.split(" ");

        for(int i = 0; i < trimmedData.length; i++){
            if(trimmedData[i].contains("-") || trimmedData[i].contains(":")) {
                trimmedData[i] = "";
            }
        }

        return trimmedData;
    }


    /**
     * Simply converts a byte to an int.
     * @param singleByte
     * @return a byte shifted to 255
     */
    private int byteToInt(byte singleByte){

        return (singleByte & 0xFF);
    }
}
