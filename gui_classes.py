#!/usr/bin/env python

from   PyQt4 import QtGui
from   PyQt4 import QtCore

from led_classes import *
from db_classes import *
import time


class Example(QtGui.QWidget):
    
	def __init__(self):
		super(Example, self).__init__()
		self.stop = False
		self.running = False
		self.initUI()

	def initUI(self):

		QtGui.QToolTip.setFont(QtGui.QFont('arial'))

		self.setToolTip('This is a <b>QWidget</b> widget')

		btn = QtGui.QPushButton('On', self)
		btn.resize(btn.sizeHint())
		btn.move(50, 50)       
		btn.clicked.connect(self.runLed)

		btn2 = QtGui.QPushButton('Off', self)
		btn2.resize(btn.sizeHint())
		btn2.move(150, 50)       
		btn2.clicked.connect(self.stopLed)


		self.label = QtGui.QLabel(self)
		self.label.setText('Welcome to airmess')
		self.label.setGeometry(50, 150, 200, 30)


		self.setGeometry(100, 40, 400, 400)
		self.setWindowTitle('Airmess')    
		self.show()

	def stopLed(self):
		self.stop=True

	def runLed(self):

		if(self.running==False):
			self.running=True
			db 				= Db()
			transmission 	= Transmission()
			window			= Window(transmission)


			transmission.warmUp()
			time.sleep(1)
			transmission.wakeUp()
			
			while(-1):

				for message in (db.fetch()):
					self.label.setText(message[0])
					print message[0]
					window.write(message[0])
					t1 = time.time()
					for i in range(  (window.width-96)   ):
						
						window.move(i)
						wait = 4/100.0 - (time.time()-t1)
						time.sleep(float(wait))

						QtGui.QApplication.processEvents()
						if self.stop:
							break
						print (time.time()-t1-4/100.0)*10000
						t1 = time.time()
	
					if self.stop:
						break

					time.sleep(1)

				
				if self.stop:
					self.stop = False
					self.running=False
					break
'''

			messages = ["Dine", "Alex","Corinne","Bernard"]

			while(-1):
				for message in messages:

					window.write(message)
					for i in range(  10   ):
						window.move(96)
						time.sleep(10/100.0/(i+1.0)/(i+1.0))

						QtGui.QApplication.processEvents()
						if self.stop:
							break

					if self.stop:
						break
				if self.stop:
					self.stop = False
					self.running=False
					break

'''



		
