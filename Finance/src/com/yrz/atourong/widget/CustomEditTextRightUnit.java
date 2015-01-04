package com.yrz.atourong.widget;

import com.zzz.f.R;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomEditTextRightUnit extends LinearLayout {
	protected EditText a;
	protected TextView b;

	public CustomEditTextRightUnit(Context paramContext) {
		super(paramContext);
	}

	public CustomEditTextRightUnit(Context paramContext,
			AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		View localView = LayoutInflater.from(paramContext).inflate(R.layout.custom_edit_rightunittext,
				this, true);
		this.a = ((EditText) localView.findViewById(R.id.edt_text_input));
		this.b = ((TextView) localView.findViewById(R.id.tv_unit));
	}

	public EditText getET() {
		return this.a;
	}

	public String getEdtText() {
		return this.a.getText().toString();
	}

	public void setHint(String paramString) {
		this.a.setHint(paramString);
	}

	public void setInputType(int paramInt) {
		this.a.setInputType(paramInt);
	}

	public void setText(String paramString) {
		this.a.setText(paramString);
	}

	public void setTextChangeListener(TextWatcher paramTextWatcher) {
		this.a.addTextChangedListener(paramTextWatcher);
	}

	public void setUnit(String paramString) {
		this.b.setText(paramString);
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name: com.yrz.atourong.widget.CustomEditTextRightUnit JD-Core
 * Version: 0.7.0.1
 */