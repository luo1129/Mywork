package com.yrz.atourong.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

public class CircularImage extends am {
	public CircularImage(Context paramContext) {
		super(paramContext);
	}

	public CircularImage(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
	}

	public CircularImage(Context paramContext, AttributeSet paramAttributeSet,
			int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
	}

	public Bitmap a() {
		Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(),
				Bitmap.Config.ARGB_8888);
		Canvas localCanvas = new Canvas(localBitmap);
		Paint localPaint = new Paint(1);
		localPaint.setColor(-16777216);
		localCanvas.drawOval(new RectF(0.0F, 0.0F, getWidth(), getHeight()),
				localPaint);
		return localBitmap;
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.yrz.atourong.widget.CircularImage
 * 
 * JD-Core Version: 0.7.0.1
 */