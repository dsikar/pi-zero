from datetime import datetime

 """Class to handle time display as well as formatting incoming data from connected panel"""
class StringFormatting:
     """Formats time to HH:MM:SS and is returned to be display on the data terminal
        @return returns a string containing the new formatted time.
     """
    def getFormattedTime(self):

        now = datetime.datetime.now();
        time = str(now.hour) + ":" + str(now.minute) + ":" + str(now.second);
        return time;

     """Generates the date in the format of "DD-MM-YYYY"
        @return The new formatted date 
     """
    def getFormattedDate(self):
        return datetime.today().strftime('%y-%m-%d');

    def formatPrinterData(String untrimmedData):

        trimmedData = untrimmedData.split(" ");

        for i in range(0, len(trimmedData)):
            if(trimmedData[i].contains("-") || trimmedData[i].contains(":")):
                trimmedData[i] = "";

        return trimmedData;

     """Simply converts a byte to an int.
     * @param singleByte
     * @return a byte shifted to 255
     """
    def byteToInt(byte singleByte):

        return (singleByte & 0xFF);
