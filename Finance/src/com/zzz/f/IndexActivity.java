package com.zzz.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.zfl.webapp.setui.IndexObject;
//import com.zfl.webapp.setui.Indexdapter;
//import com.zfl.webapp.util.ManageApplication;
//import com.zfl.webapp.util.SharedPClass;
//import com.zfl.webapp.view.account.LognActivity;
//import com.zfl.webapp.view.finance.FinanceActivity;
//import com.zfl.webapp.view.finance.FinanceDeailActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aphidmobile.flip.FlipViewController;

public class IndexActivity extends Activity implements View.OnClickListener {

	private int C = -1;
	private FlipViewController F;
	private FlipViewController G;
	private FlipViewController H;
	private FlipViewController I;
	private FlipViewController J;
	private FlipViewController K;
	private Button L;
	private LinearLayout N;
	private Button f;
	private Button g;
	private TextView d;
	private TextView e;
	private FrameLayout n;
	private FrameLayout o;
	private LinearLayout p;
	private ImageView s;
	private TextView t;
	private TextView u;
	private ImageView w;
	private TextView v;
	private TextView x;
	private LinearLayout y;
	private LinearLayout q;
	private TextView r;
	private Activity h;

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		ManageApplication.getInstance().addActivity(this);
		setContentView(R.layout.activity_home);
		// initData();
		// initItems();
		// initMainUIListener();
		this.h = this;
		this.f = ((Button) findViewById(R.id.btn_back));
		this.f.setVisibility(4);
		this.g = ((Button) findViewById(R.id.btn_option));
		this.g.setPadding(0, 0, 10, 0);
		this.g.setBackgroundColor(0);
		this.g.setText("快速注册");
		this.g.setVisibility(View.VISIBLE);
		this.g.setOnClickListener(this);
		this.d = ((TextView) findViewById(R.id.tv_title));
		this.d.setText("鑫合汇");
		this.e = ((TextView) findViewById(R.id.tv_subtitle));
		this.e.setVisibility(8);
		this.n = ((FrameLayout) findViewById(R.id.home_bottom_new_fl));
		this.o = ((FrameLayout) findViewById(R.id.home_bottom_guess_fl));
		this.p = ((LinearLayout) findViewById(R.id.home_bottom_loading));
		this.s = ((ImageView) findViewById(R.id.home_activity_iv));
		this.t = ((TextView) findViewById(R.id.home_month_left_tv));
		this.u = ((TextView) findViewById(R.id.home_month_right_tv));
		this.w = ((ImageView) findViewById(R.id.home_top_type_iv));
		this.v = ((TextView) findViewById(R.id.home_top_type_tv));
		this.x = ((TextView) findViewById(R.id.home_top_percent_tv));
		this.y = ((LinearLayout) findViewById(R.id.home_top_type_ll));
		this.q = ((LinearLayout) findViewById(R.id.home_top_ll_time_limit));
		this.r = ((TextView) findViewById(R.id.home_top_tv_time_limit));
		this.t.getPaint().setFakeBoldText(true);
		this.u.getPaint().setFakeBoldText(true);
		// this.k = createLoadingDialog(this, "加载中", true);
		// c();
		f();
	}

	protected void onResume() {
		super.onResume();
		// if (SharedPClass.getParam("lognin", this).equals("1")) {
		// this.head_btn_left.setVisibility(8);
		// return;
		// }
		// this.head_btn_left.setVisibility(0);
		h();

		if (State.a().d) {
			this.g.setVisibility(4);
			if (!State.a().N) {
				this.g.setVisibility(0);
			}
		}
	}

	private void c() {
		this.C = -1;
		if (this.n.getVisibility() == 0) {
			this.n.setVisibility(8);
		}
		if (this.o.getVisibility() == 0) {
			this.o.setVisibility(8);
		}
		if (this.p.getVisibility() == 8) {
			this.p.setVisibility(0);
		}
	}

	private void f() {
		this.C = 0;
		this.d.setText("新客专享");
		if (this.o.getVisibility() == 0) {
			this.o.setVisibility(8);
		}
		if (this.p.getVisibility() == 0) {
			this.p.setVisibility(8);
		}
		if (this.n.getVisibility() == 8) {
			this.n.setVisibility(0);
		}
	}

	private void g() {
		this.C = 1;
		this.d.setText("猜你喜欢");
		if (this.n.getVisibility() == 0) {
			this.n.setVisibility(8);
		}
		if (this.p.getVisibility() == 0) {
			this.p.setVisibility(8);
		}
		if (this.o.getVisibility() == 8) {
			this.o.setVisibility(0);
		}
	}

	private void h() {
		this.L = ((Button) findViewById(R.id.home_new_submit_bt));
		this.F = ((FlipViewController) findViewById(R.id.home_new_timer_hh));
		this.G = ((FlipViewController) findViewById(R.id.home_new_timer_h));
		this.H = ((FlipViewController) findViewById(R.id.home_new_timer_mm));
		this.I = ((FlipViewController) findViewById(R.id.home_new_timer_m));
		this.J = ((FlipViewController) findViewById(R.id.home_new_timer_ss));
		this.K = ((FlipViewController) findViewById(R.id.home_new_timer_s));
		this.N = ((LinearLayout) findViewById(R.id.home_new_loading));
		this.F.setAdapter(new FlipViewAdapter(this, 1, 10, true));
		this.G.setAdapter(new FlipViewAdapter(this, 1, 10, false));
		this.H.setAdapter(new FlipViewAdapter(this, 1, 6, true));
		this.I.setAdapter(new FlipViewAdapter(this, 1, 10, false));
		this.J.setAdapter(new FlipViewAdapter(this, 1, 6, true));
		this.K.setAdapter(new FlipViewAdapter(this, 1, 10, false));
		this.L.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_option:

			startActivity(new Intent(this, UserRegisterFirActivity.class));

			break;
		case R.id.home_new_submit_bt:
			
			startActivity(new Intent(this, LoginActivity.class));
			
			break;
		}
	}

	private class FlipViewAdapter extends BaseAdapter {
		int a;
		boolean b;
		Context c;
		private int d = 10;
		private LayoutInflater e;

		public FlipViewAdapter(Context paramContext, int paramInt1,
				int paramInt2, boolean paramBoolean) {
			this.d = paramInt2;
			this.c = paramContext;
			this.b = paramBoolean;
			this.e = LayoutInflater.from(paramContext);
			this.a = paramInt1;
		}

		public int getCount() {
			return this.a;
		}

		public Object getItem(int paramInt) {
			return Integer.valueOf(paramInt);
		}

		public long getItemId(int paramInt) {
			return (paramInt + 1) % 10;
		}

		@SuppressWarnings("deprecation")
		public View getView(int paramInt, View paramView,
				ViewGroup paramViewGroup) {
			ViewHolder localb1;
			if (paramView == null) {
				localb1 = new ViewHolder();
				paramView = this.e
						.inflate(R.layout.page, paramViewGroup, false);
				localb1.a = ((TextView) paramView.findViewById(R.id.text));
				paramView.setTag(localb1);
				if (this.b) {
					paramView.setBackgroundDrawable(this.c.getResources()
							.getDrawable(R.drawable.flipview_item_left));
				} else {
					paramView.setBackgroundDrawable(this.c.getResources()
							.getDrawable(R.drawable.flipview_right));
				}
			} else {
				localb1 = (ViewHolder) paramView.getTag();

			}

			localb1.a.setText(paramInt % this.d + "");

			return paramView;
		}

		public boolean hasStableIds() {
			return true;
		}
	}

	private class ViewHolder {
		TextView a;
	}

}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name: com.zfl.webapp.view.index.IndexActivity JD-Core Version:
 * 0.7.1
 */