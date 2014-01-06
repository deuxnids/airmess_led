package com.example.airmess;

public class Sms {
	  // Notez que l'identifiant est un long
	  private long id;
	  private String message;

	
	  public Sms() {
		    super();
		  }
	  
	  public Sms(long id, String message) {
	    super();
	    this.id = id;
	    this.message = message;

	  }

	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }

	  // Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
	    return message;
	  }

	  

	}