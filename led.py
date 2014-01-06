#!/usr/bin/env python

from led_classes import *
import time
from datetime import datetime

transmission = Transmission()
print "Welcome!"
transmission.autoset()
time.sleep(1)
transmission.warmUp()
time.sleep(1)
transmission.wakeUp()
time.sleep(1)

start_time = datetime.now()

for k in range(1,10000000):
	time.sleep(0.1)
	diff = (datetime.now()- start_time) 
	print diff
	if (diff.seconds > 20):
		transmission.heartrate()	
		transmission.heartrate()
		start_time = datetime.now()
	transmission.sendBlackScreen()

