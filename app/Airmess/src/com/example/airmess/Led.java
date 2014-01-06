package com.example.airmess;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Led 
{
	
	

	
    public void Send() {


    new Thread(new Runnable() {
        public void run() {
			try {
				String msg ="Salut";
				byte buf[] = msg.toString().getBytes();
                InetAddress serverAddress = InetAddress.getByName("192.168.1.87");
                DatagramSocket socket = new DatagramSocket();
                DatagramPacket packet = new DatagramPacket(buf, buf.length,
                        serverAddress, 50000);
                socket.send(packet);
                socket.close();
            } catch (final UnknownHostException e) {

            } catch (final SocketException e) {

            } catch (final IOException e) {

            }
        }
    }).start();

    }
	

}
