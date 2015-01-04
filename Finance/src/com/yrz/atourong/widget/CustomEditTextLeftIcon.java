package com.yrz.atourong.widget;


import com.zzz.f.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannedString;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class CustomEditTextLeftIcon extends LinearLayout {
	protected TextView a;
	protected EditText b;
	protected Button c;
	protected ImageView d;
	protected RelativeLayout e;

	public CustomEditTextLeftIcon(Context paramContext) {
		super(paramContext);
	}

	public CustomEditTextLeftIcon(Context paramContext,
			AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		View localView = LayoutInflater.from(paramContext).inflate(R.layout.custom_edit_lefttexti,
				this, true);
		this.e = ((RelativeLayout) localView.findViewById(R.id.accountLinear));
		this.d = ((ImageView) localView.findViewById(R.id.iv_icon));
		this.b = ((EditText) localView.findViewById(R.id.edt_text_input));
		this.c = ((Button) localView.findViewById(R.id.btn_text_delete));
		this.a = ((TextView) localView.findViewById(R.id.text_note));
		///abcdefg//
//		this.b.addTextChangedListener(new t(this));
//		this.b.setOnFocusChangeListener(new u(this));
//		this.c.setOnClickListener(new v(this));
	}

	public void a() {
		this.e.setFocusable(true);
		this.e.setFocusableInTouchMode(true);
	}

	public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
		RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams) this.b
				.getLayoutParams();
		localLayoutParams
				.setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
		this.b.setLayoutParams(localLayoutParams);
	}

	public void b() {
		this.b.setTransformationMethod(PasswordTransformationMethod
				.getInstance());
	}

	public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
		RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams) this.c
				.getLayoutParams();
		localLayoutParams
				.setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
		this.c.setLayoutParams(localLayoutParams);
	}

	public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
		this.b.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
	}

	public Button getDeleteBT() {
		return this.c;
	}

	public EditText getET() {
		return this.b;
	}

	public String getEdtText() {
		return this.b.getText().toString();
	}

	public float getY() {
		int[] arrayOfInt = new int[2];
		this.e.getLocationInWindow(arrayOfInt);
		return arrayOfInt[1];
	}

	public void setBackgroundColor(int paramInt) {
		this.e.setBackgroundColor(paramInt);
	}

	public void setDeleteButtonSize(int paramInt) {
		RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams) this.c
				.getLayoutParams();
		localLayoutParams.width = paramInt;
		localLayoutParams.height = paramInt;
		this.c.setLayoutParams(localLayoutParams);
	}

	public void setHint(SpannedString paramSpannedString) {
		this.b.setHint(paramSpannedString);
	}

	public void setHint(String paramString) {
		this.b.setHint(paramString);
	}

	public void setHintTextColor(int paramInt) {
		this.b.setHintTextColor(paramInt);
	}

	public void setIcon(Drawable paramDrawable) {
		this.d.setBackgroundDrawable(paramDrawable);
		this.d.setVisibility(0);
	}

	public void setInputType(int paramInt) {
		this.b.setInputType(paramInt);
	}

	public void setText(String paramString) {
		this.b.setText(paramString);
	}

	public void setTextChangeListener(TextWatcher paramTextWatcher) {
		this.b.addTextChangedListener(paramTextWatcher);
	}

	public void setTextNote(String paramString) {
		this.a.setText(paramString);
	}

	public void setTextSize(int paramInt) {
		this.b.setTextSize(paramInt);
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name: com.yrz.atourong.widget.CustomEditTextLeftIcon JD-Core
 * Version: 0.7.0.1
 */