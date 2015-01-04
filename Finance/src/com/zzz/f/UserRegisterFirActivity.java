package com.zzz.f;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class UserRegisterFirActivity extends FragmentActivity {
	
	FragmentActivity c;
	
	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		c = this;
		setContentView(R.layout.activity_user_register_fir);
	}
}
