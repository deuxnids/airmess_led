#!/usr/bin/env python
import MySQLdb

class Db:

	def __init__(self):
		self.user = "localUser"

	def fetch(self):
		db = MySQLdb.connect("localhost","root","airmess","airmess" )
		massages = []
		# prepare a cursor object using cursor() method
		cursor = db.cursor()

		# Prepare SQL query to INSERT a record into the database.
		sql = "SELECT Message FROM Sms order by Date DESC limit 5" 
		try:
			# Execute the SQL command
			cursor.execute(sql)
			# Fetch all the rows in a list of lists.
			messages = cursor.fetchall()

		except:
			print "Error: unable to fetch data"

		# disconnect from server
		db.close()

		return messages









		
