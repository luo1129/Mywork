package com.yrz.atourong.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.a.a.a.j;
import com.yrz.atourong.widget.CustomEditTextLeftIcon;
import com.zzz.f.R;

public class LoginFragment2 extends MyFragment {
	public static String P = "Mobile2/Index/login_sms?";
	public static String Q = "Mobile2/Index/sendLoginMobileCode";
	public com.zzz.f.c.e eR;
	private CustomEditTextLeftIcon S;
	private CustomEditTextLeftIcon T;
	private Button U;
	private MyCountDownTimer V;
	private View W;
	private View X;

	public void A() {
		this.S = ((CustomEditTextLeftIcon) this.X
				.findViewById(R.id.edit_mobile_num));
		this.T = ((CustomEditTextLeftIcon) this.X
				.findViewById(R.id.edit_dynamic_code));
		this.W = this.X.findViewById(R.id.rl_login);
		this.U = ((Button) this.X.findViewById(R.id.btn_gain_dn));
	}

	public void B() {
		Drawable localDrawable1 = getResources().getDrawable(R.drawable.mobile);
		Drawable localDrawable2 = getResources()
				.getDrawable(R.drawable.dy_code);
		this.S.setHint("手机号码");
		this.S.setIcon(localDrawable1);
		this.T.setHint("动态码");
		this.T.setIcon(localDrawable2);
		this.W.setOnClickListener(new View.OnClickListener() {

			public void onClick(View paramView) {
				// this.a.a(m.a(this.a).getEdtText(), m.b(this.a).getEdtText());
			}
		});
		this.V = new MyCountDownTimer(120000L, 1000L);
		this.U.setOnClickListener(new View.OnClickListener() {

			public void onClick(View paramView) {
				// this.a.C();
				// try {
				// ac.a().a(this.a.c(), new Handler(), m.b(this.a));
				// return;
				// } catch (Exception localException) {
				// localException.printStackTrace();
				// }
			}
		});
	}

	public void C() {
		// j localj = new j();
		// localj.a("mobile", this.S.getEdtText());
		// a(Q, localj, new p(this));
	}

	@Override
	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		this.X = paramLayoutInflater.inflate(2130903222, paramViewGroup, false);
		A();
		B();
		return this.X;
	}

	public void a(String paramString1, String paramString2) {
		// j localj = new j();
		// localj.a("mobile", paramString1);
		// localj.a("code", paramString2);
		// a(P, localj, new q(this));
	}

	@Override
	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
	}

	@Override
	public void onResume() {
		try {
			// ac.a().a(c());
			super.onResume();
			return;
		} catch (Exception localException) {
			for (;;) {
				localException.printStackTrace();
			}
		}
	}

	public class MyCountDownTimer extends CountDownTimer {
		public MyCountDownTimer(long paramLong1, long paramLong2) {
			super(paramLong1, paramLong2);
		}

		public void onFinish() {
			// m.d(this.a).setText(" 重新获取 ");
			// m.d(this.a).setClickable(true);
		}

		public void onTick(long paramLong) {
			// m.d(this.a).setClickable(false);
			// m.d(this.a).setText(" 动态码(" + paramLong / 1000L + ")");
		}
	}
}
