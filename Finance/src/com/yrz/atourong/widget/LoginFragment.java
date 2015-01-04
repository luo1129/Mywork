package com.yrz.atourong.widget;

import com.zzz.f.R;
import com.zzz.f.d.aj;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginFragment extends MyFragment {
	public static String P = "Mobile2/Auth/login";
	public static String Q = "Mobile2/Public/verify";
	public com.zzz.f.c.e eR;
	public CheckBox S;
	public int T;
	Dialog U;
	private final String V = "Mobile2/Auth/isNeedCode";
	private CustomEditTextLeftIcon W;
	private CustomEditTextLeftIcon X;
	private CustomEditTextLeftIconPwd Y;
	private Dialog Z;
	private ImageView aa;
	private View ab;
	private View ac;
	private View ad;
	private RelativeLayout ae;
	private int af = 0;
	private String ag;
	private com.zzz.f.d.aj ah;
	private Context ai;
	private CircularImage cImage;
	private SharedPreferences ak;
	private com.zzz.f.d.b al;
	private TextView am;
	private RelativeLayout an;
	private View.OnClickListener ao;

	private void E() {
		com.a.a.a.j localj = new com.a.a.a.j();
		localj.a("uid", this.ag);
		// a("Mobile2/User/userInfo", localj, new l(this));
	}

	private void F() {
		// a("Mobile2/Auth/isNeedCode", new com.a.a.a.j(), new d(this));
	}

	private void b(String paramString) {
		// com.yrz.atourong.b.a.a(paramString, 1, new c(this, paramString));
	}

	public void A() {
		this.W = ((CustomEditTextLeftIcon) this.ac
				.findViewById(R.id.edit_username));
		this.Y = ((CustomEditTextLeftIconPwd) this.ac
				.findViewById(R.id.edit_pwd));
		this.X = ((CustomEditTextLeftIcon) this.ac
				.findViewById(R.id.edit_dynamic_code));
		this.ad = this.ac.findViewById(R.id.tv_forgetpwd);
		this.aa = ((ImageView) this.ac.findViewById(R.id.iv_test));
		this.ab = this.ac.findViewById(R.id.rl_login);
		this.S = ((CheckBox) this.ac.findViewById(R.id.ck));
		this.ae = ((RelativeLayout) this.ac.findViewById(R.id.rl_code));
		this.cImage = ((CircularImage) this.ac
				.findViewById(R.id.gesture_login_iv_userimg));
		this.am = ((TextView) this.ac.findViewById(R.id.login_regist_hongbao));
		this.an = ((RelativeLayout) this.ac
				.findViewById(R.id.login_bottom_rl_regist));
		this.am.setOnClickListener(this.ao);
	}

	public void B() {
		Drawable localDrawable1 = this.getResources().getDrawable(
				R.drawable.icon_account);
		Drawable localDrawable2 = this.getResources().getDrawable(
				R.drawable.icon_pwd);
		this.W.setHint("用户名、手机号码或邮箱");
		this.W.setIcon(localDrawable1);
		if (this.T != 0) {
			this.W.setText(D());
		}
		this.Y.setHint("登录密码");
		this.Y.setIcon(localDrawable2);
		this.aa.setOnClickListener(new View.OnClickListener() {

			public void onClick(View paramView) {
				C();
			}
		});

		this.ab.setOnClickListener(new View.OnClickListener() {

			public void onClick(View paramView) {
				// String str1 = a.b(this.a).getEdtText().trim();
				// String str2 = a.c(this.a).getEdtText().trim();
				// String str3 = a.d(this.a).getEdtText().trim();
				// if (str1.equals("")) {
				// al.a(this.a.c(), "用戶名不能为空");
				// return;
				// }
				// if (str2.equals("")) {
				// al.a(this.a.c(), "密码不能为空");
				// return;
				// }
				// if ((a.e(this.a) >= 2) && (str3.equals(""))) {
				// al.a(this.a.c(), "请填写验证码");
				// return;
				// }
				// this.a.a(str1, str2, str3);
			}
		});
		C();
		this.ad.setOnClickListener(new View.OnClickListener() {

			public void onClick(View paramView) {
				// getActivity().startActivity(new Intent(this.a.c(),
				// ForgetPasswordFirstActivity.class));
			}
		});
	}

	public void C() {
		// com.yrz.atourong.b.a.a(Q, new j(this));
	}

	String D() {
		try {
			String str = getActivity().getSharedPreferences("user_info", 0)
					.getString("USER_NAME", "");
			return str;
		} catch (Exception localException) {
		}
		return "";
	}

	@Override
	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		this.ac = paramLayoutInflater
				.inflate(2130903150, paramViewGroup, false);
		A();
		B();
		F();
		this.Z = createDialog("网络连接失败，是否重新连接网络", "是", "取消",
				new View.OnClickListener() {
					public void onClick(View paramView) {
						if (Z.isShowing()) {
							Z.dismiss();
						}
						if (!a(getActivity())) {
							if (!Z.isShowing()) {
								Z.show();
							}
							return;
						}
						C();
					}
				}, new View.OnClickListener() {

					public void onClick(View paramView) {
						if (Z.isShowing()) {
							Z.dismiss();
						}
						getActivity().finish();
					}
				});
		this.Z.setOnKeyListener(new DialogInterface.OnKeyListener() {

			@Override
			public boolean onKey(DialogInterface dialog, int keyCode,
					KeyEvent event) {
				// TODO Auto-generated method stub
				if (keyCode == 4) {
					getActivity().finish();
				}
				return false;
			}
		});
		return this.ac;
	}

	public void a(View.OnClickListener paramOnClickListener) {
		this.ao = paramOnClickListener;
	}

	void a(String paramString) {
		try {
			SharedPreferences.Editor localEditor = this.getActivity()
					.getSharedPreferences("user_info", 0).edit();
			localEditor.putString("USER_NAME", paramString);
			localEditor.commit();
			return;
		} catch (Exception localException) {
		}
	}

	public void a(String paramString1, String paramString2, String paramString3) {
		// this.U = com.yrz.atourong.ui.a.h.createLoadingDialog(c(), "加载中...",
		// true);
		// if (!this.U.isShowing()) {
		// this.U.show();
		// }
		this.ab.setClickable(false);
		this.ab.setBackgroundColor(Color.rgb(209, 207, 204));
		// com.a.a.a.j localj = new com.a.a.a.j();
		// localj.a("account", paramString1);
		// localj.a("password", paramString2);
		// localj.a("code", paramString3);
		// a(P, localj, new k(this, paramString2, paramString1));
	}

	public void onActivityCreated(Bundle paramBundle) {
		super.onActivityCreated(paramBundle);
		this.ai = getActivity();
		this.ak = ai.getSharedPreferences("config_setting", 0);
		this.ag = this.ak.getString("UID", "");
		// this.al = com.yrz.atourong.d.b.a(this.ai, 100000000L, 2147483647);
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		if (!"".equals(this.ag)) {
			this.ah = aj.a(this.ai);
			E();
		}
	}

	public void onResume() {
		super.onResume();
		if ((!this.Z.isShowing()) && (!a(getActivity()))) {
			this.Z.show();
		}
	}

	public static boolean a(Context paramContext) {
		if (paramContext != null) {
			NetworkInfo localNetworkInfo = ((ConnectivityManager) paramContext
					.getSystemService("connectivity")).getActiveNetworkInfo();
			if (localNetworkInfo != null) {
				return localNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	public Dialog createDialog(String paramString1, String paramString2,
			String paramString3, View.OnClickListener paramOnClickListener1,
			View.OnClickListener paramOnClickListener2) {
		View localView = LayoutInflater.from(getActivity()).inflate(2130903237,
				null);
		TextView localTextView = (TextView) localView.findViewById(2131166114);
		Button localButton1 = (Button) localView.findViewById(2131166116);
		Button localButton2 = (Button) localView.findViewById(2131166117);
		DisplayMetrics localDisplayMetrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay()
				.getMetrics(localDisplayMetrics);
		int i = localDisplayMetrics.widthPixels;
		LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(
				-1, -1);
		localLayoutParams.width = ((int) (0.88D * i));
		localTextView.setLayoutParams(localLayoutParams);
		if (Build.VERSION.SDK_INT < 12) {
			localButton1.setBackgroundResource(2130837603);
			localButton2.setBackgroundResource(2130837605);
		} else {
			localButton1.setBackgroundResource(2130837602);
			localButton2.setBackgroundResource(2130837604);
		}

		localTextView.setText(paramString1);
		localButton1.setText(paramString2);
		localButton2.setText(paramString3);
		localButton1.setOnClickListener(paramOnClickListener1);
		localButton2.setOnClickListener(paramOnClickListener2);
		Dialog localDialog = new Dialog(getActivity(), 2131492958);
		localDialog.setContentView(localView);
		return localDialog;

	}
}
