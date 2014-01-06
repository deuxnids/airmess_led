package com.example.airmess;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button 		start  = null;
    TextView	status = null;
    ImageView 	imageView;
    private SmsDAO datasource;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("main activity", "created");
        
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(clickListenerStart);
        
        status = (TextView) findViewById(R.id.status);
        imageView = (MyImageView) findViewById(R.id.image);
        
        datasource = new SmsDAO(this);
        datasource.open();

        List<Sms> values = datasource.getAllComments();

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Sms> adapter = new ArrayAdapter<Sms>(this,android.R.layout.simple_list_item_1, values);
      

     
    }

    
    private int createImage(){
    	  	Paint paint = new Paint();
    	    paint.setTextSize(10);
    	    paint.setColor(1);
    	    paint.setTextAlign(Paint.Align.LEFT);
    	    int width = (int) (paint.measureText("salut") + 0.5f); // round
    	    float baseline = (int) (-paint.ascent() + 0.5f); // ascent() is negative
    	    int height = (int) (baseline + paint.descent() + 0.5f);
    	    Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    	    Canvas canvas = new Canvas(image);
    	    canvas.drawText("salut", 0, baseline, paint);
    	    
    	    
    	 return  image.getPixel(1, 1);

    }

    private OnClickListener clickListenerStart = new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			status.setText("running");
    	        Led led = new Led();
    			led.Send();
				status.setText("led running");
				 @SuppressWarnings("unchecked")
				    Sms comment = null;

				      String[] comments = new String[] { "Cool", "Very nice", "Hate it" };
				      int nextInt = new Random().nextInt(3);
				      // save the new comment to the database
				      comment = datasource.createComment(comments[nextInt]);
}
    		};
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}


