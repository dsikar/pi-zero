from serialdatatransfer import SerialDataTransfer;
from readersBackup import DataReader;
from byte import Byte;

import sys
import subprocess
import time

class PointInfoPacketConstruction:

    def createPointInformationPacket(self, data):

        varlist = map(int, data.split(','));
        transfer = SerialDataTransfer("/dev/ttyUSB0");

        reader   = DataReader(transfer);
        reader.Start();#executes read thread to process incoming response after sent request

        transfer.Write(varlist);

        read(reader,transfer);

def read(reader, transfer):

    #Responsible for preventing endless rx thread loop
    LoopControl = True;
    strVar = "";
    while(LoopControl):
        data = reader.Read();

        if(len(data) == 1):
            if(data[0] == 0x06):
                #time.sleep(0.5);
        
                data = reader.Read();
                if(len(data) == 0):
                    LoopControl = False;

        if(len(data) > 1):
            transfer.Write([0x06]);
            for index in range(0, len(data)):
                    item = data[index];
                    strVar += str(Byte(item)) + ',';
            LoopControl = False;

    if(LoopControl == False):
       reader.Stop();
       print(strVar);
       if(reader.IsRunning() == False):
           reader.__del__();

if(__name__=='__main__'):

    data = sys.argv[1];

    packetObject = PointInfoPacketConstruction();
    packetObject.createPointInformationPacket(data);

    




