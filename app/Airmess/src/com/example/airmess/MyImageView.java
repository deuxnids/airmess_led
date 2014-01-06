package com.example.airmess;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class MyImageView extends ImageView {
	  public MyImageView(Context context) {
	        super(context);  
	        Log.d("MyImageView", "created");
	    }
	    // Constructor for inflating via XML
	   public MyImageView(Context context, AttributeSet attrs) {
		   super(context, attrs);         
	        Log.d("MyImageView", "created");

	    }

	   public void onMeasure(int wms, int hms){
		    setMeasuredDimension(MeasureSpec.getSize(wms), MeasureSpec.getSize(hms));
		}
	   
	   
	   public Bitmap textAsBitmap(String text, float textSize, int textColor) {
			 Log.d("textAsBitmap", text);

		    Paint paint = new Paint();
		    paint.setTextSize(textSize);
		    paint.setColor(Color.RED);
		    paint.setTextAlign(Paint.Align.LEFT);
		    int width = (int) (paint.measureText(text) + 0.5f); // round
		    float baseline = (int) (-paint.ascent() + 0.5f); // ascent() is negative
		    int height = 16;
		    Log.d("textAsBitmap width", String.valueOf(width));
		    Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		    Canvas canvas = new Canvas(image);
		    canvas.drawText(text, 0, baseline, paint);
		      for(int x = 1; x < 28; x = x+1) {
				    Log.d("textAsBitmap", String.valueOf(Color.red(image.getPixel(x, 10))));
		       }
		    return image;
		}
	    
		@Override
	    protected void onDraw(Canvas canvas) {
			super.dispatchDraw(canvas);
			 Log.d("MyImageView", "onDraw");
			 canvas.drawBitmap(textAsBitmap("salut", 12, 25), 50, 150, null);
	    }       
}
