package com.yrz.atourong.widget;

import com.zzz.f.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomEditTextMark extends LinearLayout {
	private TextView a;
	private TextView b;
	private EditText c;
	private Button d;

	public CustomEditTextMark(Context paramContext) {
		super(paramContext);
	}

	public CustomEditTextMark(Context paramContext,
			AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		View localView = LayoutInflater.from(paramContext).inflate(
				R.layout.custom_edit_mark, this, true);
		this.a = ((TextView) localView.findViewById(R.id.tv_text_account));
		this.c = ((EditText) localView.findViewById(R.id.edt_text_input));
		this.d = ((Button) localView.findViewById(R.id.btn_text_delete));
		this.b = ((TextView) localView.findViewById(R.id.text_note));
		// this.c.addTextChangedListener(new ac(this));
		// this.d.setOnClickListener(new ad(this));
	}

	public Button getDeleteBT() {
		return this.d;
	}

	public EditText getEditTextET() {
		return this.c;
	}

	public String getEdtText() {
		return this.c.getText().toString().trim();
	}

	public String getText() {
		return this.a.getText().toString();
	}

	public void setEdtText(String paramString) {
		this.c.setText(paramString);
	}

	public void setHint(String paramString) {
		this.c.setHint(paramString);
	}

	public void setInputType(int paramInt) {
		this.c.setInputType(paramInt);
	}

	public void setText(String paramString) {
		this.a.setText(paramString);
	}

	public void setTextNote(String paramString) {
		this.b.setText(paramString);
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name: com.yrz.atourong.widget.CustomEditTextMark JD-Core Version:
 * 0.7.0.1
 */