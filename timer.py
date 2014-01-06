#!/usr/bin/python
import time;  # This is required to include time module.
from threading import Timer

def hello(start, interval, count):
    ticks = time.time()
    t = Timer(interval - (ticks-start-count*interval), hello, [start, interval, count+1])
    t.start()
    print "Number of ticks since 12:00am, January 1, 1970:", ticks, " #", count 

dt = 0.0025 # interval in sec
t = Timer(dt, hello, [round(time.time()), dt, 0]) # start over at full second, round only for testing here
t.start()
