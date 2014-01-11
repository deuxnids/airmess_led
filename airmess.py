#!/usr/bin/python
# -*- coding: utf-8 -*-

'''
from gui_classes import *
import sys
import time
      
def main():
    
    app = QtGui.QApplication(sys.argv)
    ex = Example()
    sys.exit(app.exec_())


if __name__ == '__main__':
	
	main()
		
'''


from led_classes import *
from db_classes import *
import time


db 				= Db()
transmission 	= Transmission()
window			= Window(transmission)


transmission.warmUp()
time.sleep(1)
#transmission.wakeUp()

while(-1):
	for message in (db.fetch()):
		print message[0]
		window.write(message[0])
		
		for i in range(  (window.width-96)   ):
			tick = time.time()
			window.move(i)
			wait = 4/100.0 - (time.time()-tick)
			time.sleep(float(wait))
			prev = tick
			tick = time.time()
			if (abs(0.04-(tick-prev))>0.01*0.04):
				print abs(0.04-(tick-prev))
			
		time.sleep(1)

	

