package com.zzz.f;

import com.viewpagerindicator.TabPageIndicator;
import com.yrz.atourong.widget.LoginFragment;
import com.yrz.atourong.widget.LoginFragment2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends FragmentActivity implements com.zzz.f.c.e {

	ViewPager a;
	String[] b = { "普通登录", "短信登录" };
	String c;
	private Button e;
	private TextView f;
	private TextView g;
	private Button h;
	private SharedPreferences i;
	private String j = "";
	private String k = "";
	private int l = 0;
	private MyFragmentPageAdapter m;
	private String n;
	// private j o;
	private int p = -1;
	private boolean q = false;
	private Dialog r;
	private boolean s = false;

	View.OnClickListener d = new View.OnClickListener() {

		public void onClick(View paramView) {
			if (State.a().O) {
				State.a().P = true;
			}
			Intent localIntent = new Intent(LoginActivity.this,
					UserRegisterFirActivity.class);
			if ((LoginActivity.this.c != null)
					&& (!LoginActivity.this.c.equals(""))) {
				localIntent.putExtra("goClass", LoginActivity.this.c);
			}
			LoginActivity.this.startActivity(localIntent);
			LoginActivity.this.finish();
		}
	};

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.activity_login);
		Bundle localBundle = getIntent().getExtras();
		this.p = getIntent().getIntExtra("isForgetIntent", -1);
		this.q = getIntent().getBooleanExtra("is_back_to_main", false);
		if (localBundle != null) {
			this.l = localBundle.getInt("main_web_flag");
			this.n = localBundle.getString("fromSubActivity");
			this.c = localBundle.getString("goClass");
		}
		this.i = getSharedPreferences("config_setting", 0);
		this.j = this.i.getString("gesture_lock_user_name", "");
		this.k = this.i.getString("gesture_lock_user_id", "");
		this.m = new MyFragmentPageAdapter(this, getSupportFragmentManager());
		((Button) findViewById(R.id.btn_back))
				.setOnClickListener(new View.OnClickListener() {

					public void onClick(View paramView) {
						if (s) {
							Intent localIntent = new Intent(LoginActivity.this,
									MainActivity.class);
							localIntent.setFlags(67108864);
							LoginActivity.this.startActivity(localIntent);
						}
						LoginActivity.this.finish();
					}
				});
		findViewById(R.id.btn_option).setBackgroundDrawable(null);
		b();
		// this.o = new j(this);
		// this.r = createDialog("设置手势密码", "立即设置", "下次再说", new al(this), new am(
		// this));
		// this.r.setCancelable(false);
		// this.r.setOnKeyListener(new DialogInterface.OnKeyListener() {
		//
		// public boolean onKey(DialogInterface paramDialogInterface,
		// int paramInt, KeyEvent paramKeyEvent) {
		// return paramInt == 84;
		// }
		//
		// });
		// this.r.setOnDismissListener(new DialogInterface.OnDismissListener() {
		//
		// @Override
		// public void onDismiss(DialogInterface dialog) {
		// // TODO Auto-generated method stub
		// // if (LoginActivity.)
		// // {
		// // startActivity(getIntent().setClass(this.a,
		// // SettingGestureLockActivity.class));
		// // finish();
		// // return;
		// // }
		// // LoginActivity.e(this.a).edit().putInt("is_gesture_lock_open",
		// // 1).commit();
		// // for (;;)
		// // {
		// // String str;
		// // try
		// // {
		// // if (this.a.getIntent() == null) {
		// // break;
		// // }
		// // str = this.a.getIntent().getStringExtra("goClass");
		// // if ((str != null) && (!str.equals("")))
		// // {
		// // if (!str.equals("go_contact")) {
		// // break label153;
		// // }
		// // new p(this.a).a();
		// // }
		// // this.a.getIntent().removeExtra("goClass");
		// // }
		// // catch (Exception localException)
		// // {
		// // localException.printStackTrace();
		// // }
		// // break;
		// // label153:
		// // Intent localIntent = this.a.getIntent();
		// // Class localClass = Class.forName(str);
		// // localIntent.setClass(this.a, localClass);
		// // if (w.L.y != null) {
		// // localIntent.putExtras(w.L.y);
		// // }
		// // this.a.startActivity(localIntent);
		// // }
		// }
		//
		// });
	}

	private void b() {
		this.e = ((Button) findViewById(R.id.btn_back));
		this.e.setVisibility(0);
		this.f = ((TextView) findViewById(R.id.tv_title));
		this.f.setText("登录");
		this.g = ((TextView) findViewById(R.id.tv_subtitle));
		this.g.setVisibility(8);
		this.h = ((Button) findViewById(R.id.btn_option));
		this.h.setText("  注册   ");
		this.h.setVisibility(0);
		this.h.setOnClickListener(this.d);
		this.a = ((ViewPager) findViewById(R.id.pager));
		this.a.setAdapter(this.m);
		TabPageIndicator localTabPageIndicator = (TabPageIndicator) findViewById(R.id.indicator);
		// localTabPageIndicator.a = -6710887;
		localTabPageIndicator.setViewPager(this.a);
		localTabPageIndicator.setVisibility(8);
		this.a.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				a.setCurrentItem(a.getCurrentItem());
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	public class MyFragmentPageAdapter extends FragmentPagerAdapter {
		public MyFragmentPageAdapter(LoginActivity paramLoginActivity,
				FragmentManager paramn) {
			super(paramn);
		}

		public Fragment getItem(int paramInt) {
			if (paramInt == 0) {
				LoginFragment locala = new LoginFragment();
				locala.a(d);
				locala.eR = LoginActivity.this;
				// locala.T = LoginActivity.a(this.a);
				return locala;
			}
			LoginFragment2 localm = new LoginFragment2();
			localm.eR = LoginActivity.this;
			return localm;
		}

		public int getCount() {
			return 1;
		}

		public CharSequence getPageTitle(int paramInt) {
			return b[(paramInt % b.length)].toUpperCase();
		}

	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		// abcdefg
		// this.i.edit().putInt("gesture_surplus_times", 5).commit();
		// new b(this).a();
		// for (;;)
		// {
		// int i1;
		// try
		// {
		// List localList = a.b();
		// if (!localList.isEmpty())
		// {
		// localObject2 = "";
		// i1 = 0;
		// if (i1 < localList.size())
		// {
		// Cookie localCookie = (Cookie)localList.get(i1);
		// if (!"PHPSESSID".equals(localCookie.getName())) {
		// break label453;
		// }
		// localObject3 = localCookie.getName() + "=" + localCookie.getValue() +
		// ";domain=" + localCookie.getDomain();
		// break label457;
		// }
		// this.o.a((String)localObject2);
		// Log.i("ACCOUNTACTIVITY", "COOKIE_SAVE—" + (String)localObject2);
		// }
		// }
		// catch (Exception localException1)
		// {
		// String str;
		// localException1.printStackTrace();
		// continue;
		// Intent localIntent = getIntent();
		// localIntent.setClass(this, Class.forName(str));
		// if (w.L.y != null) {
		// localIntent.putExtras(w.L.y);
		// }
		// startActivity(localIntent);
		// continue;
		// }
		// try
		// {
		// w.L.t = false;
		// r.a();
		// sendBroadcast("HOME_HOOK_HOME_LOGIN");
		// w.L.b = true;
		// setResult(101);
		// if (this.p != -1) {
		// break label446;
		// }
		// if (!w.L.z.b.equals(this.k)) {
		// break label403;
		// }
		// if (getIntent() != null)
		// {
		// str = getIntent().getStringExtra("goClass");
		// if ((str != null) && (!str.equals("")))
		// {
		// if (!str.equals("go_contact")) {
		// continue;
		// }
		// new p(this).a();
		// }
		// getIntent().removeExtra("goClass");
		// finish();
		// }
		// }
		// catch (Exception localException2)
		// {
		// if (this.l != 20) {
		// continue;
		// }
		// setResult(20);
		// return;
		// this.s = false;
		// if (this.r.isShowing()) {
		// continue;
		// }
		// this.r.show();
		// continue;
		// }
		// finally
		// {
		// if (this.l != 20) {
		// break label444;
		// }
		// setResult(20);
		// }
		// if (this.l == 20) {
		// setResult(20);
		// }
		// return;
		// label403:
		// label444:
		// label446:
		// finish();
		// continue;
		// label453:
		// Object localObject3 = localObject2;
		// label457:
		// i1++;
		// Object localObject2 = localObject3;
		// }
	}

}
