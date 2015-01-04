package com.yrz.atourong.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;

public class AnieLayout extends LinearLayout {
	private float a = 0.0F;
	private float b = 0.0F;
	private ViewTreeObserver.OnPreDrawListener c = null;

	public AnieLayout(Context paramContext) {
		super(paramContext);
	}

	public AnieLayout(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
	}

	public AnieLayout(Context paramContext, AttributeSet paramAttributeSet,
			int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
	}

	public void setAccordionPivotWidth(float paramFloat) {
		setScaleX(paramFloat);
		setPivotX(getWidth());
	}

	public void setAccordionPivotZero(float paramFloat) {
		setScaleX(paramFloat);
		setPivotX(0.0F);
	}

	public void setCube(float paramFloat) {
		setTranslationX(paramFloat * getWidth());
		setRotationY(90.0F * paramFloat);
		setPivotX(0.0F);
		setPivotY(getHeight() / 2);
	}

	public void setCubeBack(float paramFloat) {
		setTranslationX(paramFloat * getWidth());
		setRotationY(90.0F * paramFloat);
		setPivotY(getHeight() / 2);
		setPivotX(getWidth());
	}

	public void setGlide(float paramFloat) {
		setTranslationX(paramFloat * getWidth());
		setRotationY(90.0F * paramFloat);
		setPivotX(0.0F);
	}

	public void setGlideBack(float paramFloat) {
		setTranslationX(paramFloat * getWidth());
		setRotationY(90.0F * paramFloat);
		setPivotX(0.0F);
		setPivotY(getHeight() / 2);
	}

	public void setRotateDown(float paramFloat) {
		setTranslationX(paramFloat * getWidth());
		setRotation(20.0F * paramFloat);
		setPivotY(getHeight());
		setPivotX(getWidth() / 2);
	}

	public void setRotateUp(float paramFloat) {
		setTranslationX(paramFloat * getWidth());
		setRotation(-20.0F * paramFloat);
		setPivotY(0.0F);
		setPivotX(getWidth() / 2);
	}

	public void setTableHorizontalPivotWidth(float paramFloat) {
		setRotationY(-90.0F * paramFloat);
		setPivotX(getWidth());
		setPivotY(getHeight() / 2);
	}

	public void setTableHorizontalPivotZero(float paramFloat) {
		setRotationY(90.0F * paramFloat);
		setPivotX(0.0F);
		setPivotY(getHeight() / 2);
	}

	public void setTableVerticalPivotHeight(float paramFloat) {
		setRotationX(90.0F * paramFloat);
		setPivotX(getWidth() / 2);
		setPivotY(getHeight());
	}

	public void setTableVerticalPivotZero(float paramFloat) {
		setRotationX(-90.0F * paramFloat);
		setPivotX(getWidth() / 2);
		setPivotY(0.0F);
	}

	public void setXFraction(float paramFloat) {
		this.b = paramFloat;
		if (getWidth() == 0) {
			if (this.c == null) {
				this.c = new ViewTreeObserver.OnPreDrawListener() {

					@Override
					public boolean onPreDraw() {
						// TODO Auto-generated method stub
						getViewTreeObserver().removeOnPreDrawListener(c);
						setXFraction(b);
						return true;
					}

				};
				getViewTreeObserver().addOnPreDrawListener(this.c);
			}
			return;
		}
		setTranslationX(paramFloat * getWidth());
	}

	public void setYFraction(float paramFloat) {
		this.a = paramFloat;
		if (getHeight() == 0) {
			if (this.c == null) {
				this.c = new ViewTreeObserver.OnPreDrawListener() {

					@Override
					public boolean onPreDraw() {
						// TODO Auto-generated method stub
						getViewTreeObserver().removeOnPreDrawListener(c);
						setYFraction(a);
						return true;
					}

				};
				getViewTreeObserver().addOnPreDrawListener(this.c);
			}
			return;
		}
		float f = paramFloat * getHeight();
		Log.v("translationY set", f + " ");
		setTranslationY(f);
	}

	public void setYFractionH(float paramFloat) {
		this.a = paramFloat;
		if (getHeight() == 0) {
			if (this.c == null) {
				this.c = new ViewTreeObserver.OnPreDrawListener() {

					@Override
					public boolean onPreDraw() {
						// TODO Auto-generated method stub
						getViewTreeObserver().removeOnPreDrawListener(c);
						setYFractionH(a);
						return true;
					}

				};
				getViewTreeObserver().addOnPreDrawListener(this.c);
			}
			return;
		}
		float f = this.a;
		Log.v("translationY set", f + " ");
		setTranslationY(f);
	}

	public void setZoomFromCornerPivotHG(float paramFloat) {
		setScaleX(paramFloat);
		setScaleY(paramFloat);
		setPivotX(getWidth());
		setPivotY(getHeight());
	}

	public void setZoomFromCornerPivotHeight(float paramFloat) {
		setScaleX(paramFloat);
		setScaleY(paramFloat);
		setPivotX(0.0F);
		setPivotY(getHeight());
	}

	public void setZoomFromCornerPivotHeightY(float paramFloat) {
		setPivotX(0.0F);
		setPivotY(getHeight());
	}

	public void setZoomFromCornerPivotWidth(float paramFloat) {
		setScaleX(paramFloat);
		setScaleY(paramFloat);
		setPivotX(getWidth());
		setPivotY(0.0F);
	}

	public void setZoomFromCornerPivotZero(float paramFloat) {
		setScaleX(paramFloat);
		setScaleY(paramFloat);
		setPivotX(0.0F);
		setPivotY(0.0F);
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name: com.yrz.atourong.widget.AnieLayout JD-Core Version: 0.7.0.1
 */