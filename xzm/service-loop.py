#!/usr/bin/env python
import urllib2
#import commands
import subprocess
import shlex
import time
import datetime

counter = 0;
timeDelay = 0.3; 
consecutiveRuns = 0;

while(True):
    startTime = datetime.datetime.now();

    response = urllib2.urlopen("http://3.9.146.52/service.php?action=r")
    content = response.read();
    counter = counter + 1;
    print("\nLoop "+str(counter));
    print "Packet in jobs list : \n"+content
    jobrun = False;
    if(len(content) > 1):
	consecutiveRuns = 0;
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
    else:
        consecutiveRuns = consecutiveRuns + 1;

    #Currently this condition will assign timeDelay redundantly, should be made more efficient.
    if(consecutiveRuns > 30):
        timeDelay = 1.8;   #sleep for 1.8seconds due to period of inactivity;
    else:
        timeDelay = 0.2;  #if a http request comes in then decrease the delay as we expect further traffic to arrive. 

    if (jobrun == False):
    	time.sleep(timeDelay); #1

    endTime = datetime.datetime.now();
    difference = endTime - startTime;
    difference = (difference.total_seconds() * 1000);

    print("Time taken to run Loop " + str(counter)+ " = " + str(difference));

