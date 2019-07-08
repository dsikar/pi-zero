#!/bin/bash
SERVICE="service-loop.py"
if pgrep -f "$SERVICE" >/dev/null
then
    echo "$SERVICE is running"
else
    nohup python /home/pi/service-loop.py &
    echo "$SERVICE stopped, starting service."
fi
