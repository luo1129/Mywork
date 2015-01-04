package com.yrz.atourong.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.io.PrintStream;

public abstract class am extends ImageView {
	private static final Xfermode a = new PorterDuffXfermode(
			android.graphics.PorterDuff.Mode.DST_IN);
	private Bitmap b;
	private Paint c;

	public am(Context paramContext) {
		super(paramContext);
	}

	public am(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
	}

	public am(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
	}

	public abstract Bitmap a();

	protected void onDraw(Canvas paramCanvas) {
		Drawable localDrawable = getDrawable();
		if (localDrawable == null) {
			return;
		}
		try {
			if (this.c == null) {
				this.c = new Paint();
				this.c.setFilterBitmap(false);
				this.c.setXfermode(a);
			}
			float f = getWidth();
			int i = paramCanvas.saveLayer(0.0F, 0.0F, f, getHeight(), null, 31);
			localDrawable.setBounds(0, 0, getWidth(), getHeight());
			localDrawable.draw(paramCanvas);
			if ((this.b == null) || (this.b.isRecycled())) {
				this.b = a();
			}
			Bitmap localBitmap = this.b;
			Paint localPaint1 = this.c;
			Paint localPaint2 = new Paint();
			localPaint2.setColor(-1);
			localPaint2.setStyle(Paint.Style.STROKE);
			localPaint2.setStrokeWidth(5.0F);
			localPaint2.setAntiAlias(true);
			paramCanvas.drawCircle(f / 2.0F, f / 2.0F, f / 2.0F, localPaint2);
			paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint1);
			paramCanvas.restoreToCount(i);
			return;
		} catch (Exception localException) {
			StringBuilder localStringBuilder = new StringBuilder()
					.append("Attempting to draw with recycled bitmap. View ID = ");
			System.out.println("localStringBuilder==" + localStringBuilder);
		}
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.yrz.atourong.widget.am
 * 
 * JD-Core Version: 0.7.0.1
 */