package com.yrz.atourong.widget;

import com.zzz.f.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomEditTextLeftIconPwd extends LinearLayout {
	protected TextView a;
	protected EditText b;
	protected Button c;
	protected ImageView d;

	public CustomEditTextLeftIconPwd(Context paramContext) {
		super(paramContext);
	}

	public CustomEditTextLeftIconPwd(Context paramContext,
			AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		View localView = LayoutInflater.from(paramContext).inflate(
				R.layout.custom_edit_lefttextpwd, this, true);
		this.d = ((ImageView) localView.findViewById(R.id.iv_icon));
		this.b = ((EditText) localView.findViewById(R.id.edt_text_input));
		this.c = ((Button) localView.findViewById(R.id.btn_text_delete));
		this.a = ((TextView) localView.findViewById(R.id.text_note));
		this.b.addTextChangedListener(new TextWatcher() {

			public void afterTextChanged(Editable paramEditable) {
				if (paramEditable.length() > 0) {
					c.setVisibility(0);
					return;
				}
				c.setVisibility(8);
			}

			public void beforeTextChanged(CharSequence paramCharSequence,
					int paramInt1, int paramInt2, int paramInt3) {
			}

			public void onTextChanged(CharSequence paramCharSequence,
					int paramInt1, int paramInt2, int paramInt3) {
			}
		});
		this.b.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			public void onFocusChange(View paramView, boolean paramBoolean) {
				if ((paramBoolean) && (!a.getText().equals(""))) {
					a.setVisibility(0);
				}
				if ((paramBoolean) && (b.getText().toString().length() > 0)) {
					c.setVisibility(0);
					return;
				}
				a.setVisibility(8);
				c.setVisibility(8);
			}
		});
		this.c.setOnClickListener(new View.OnClickListener() {

			public void onClick(View paramView) {
				b.setText("");
			}
		});
	}

	public EditText getET() {
		return this.b;
	}

	public String getEdtText() {
		return this.b.getText().toString();
	}

	public void setHint(String paramString) {
		this.b.setHint(paramString);
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
 * 
 * Qualified Name: com.yrz.atourong.widget.CustomEditTextLeftIconPwd
 * 
 * JD-Core Version: 0.7.0.1
 */