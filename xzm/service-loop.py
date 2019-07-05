#!/usr/bin/env python
import urllib2
#import commands
import subprocess
import shlex
import time
import datetime

counter = 0;

while(True):
    startTime = datetime.datetime.now();

    response = urllib2.urlopen("http://3.9.146.52/service.php?action=r")
    content = response.read();
    counter = counter + 1;
    print("Loop "+str(counter));
    print "Packet in jobs list : \n"+content
    jobrun = False;
    if(len(content) > 1):
        action = "python /var/www/html/MXSpeak/packetizer/pointinfotest.py " + content;
        payload = subprocess.check_output(shlex.split(action));
        if len(payload) > 1: #for some reason printing an empty payload still constitutes to greater than 0, so we use 1 instead
            print "Payload response to serviced packet : \n"+payload; 
            reply = "http://3.9.146.52/service.php?action=w&payload=" + payload
            #print reply
            response = urllib2.urlopen(reply)
	else:
            print "No device recorded for this point",
	jobrun = True;
    
    if (jobrun == False):
    	time.sleep(1)

    endTime = datetime.datetime.now();
    difference = endTime - startTime;
    difference = (difference.total_seconds() * 1000);

    print("Time taken to run Loop " + str(counter)+ " = " + str(difference));

