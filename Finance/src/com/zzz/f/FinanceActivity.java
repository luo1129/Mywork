package com.zzz.f;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;



//import com.zfl.webapp.util.ManageApplication;
//import com.zfl.webapp.util.SharedPClass;
//import com.zfl.webapp.view.account.LognActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yrz.atourong.widget.PagerSlidingTabStrip;

public class FinanceActivity extends FragmentActivity {
	public static List<Map<String, Object>> listData = new ArrayList();
	public static List<Map<String, Object>> listDataA = new ArrayList();
	public static Map<String, Object> listMap = new HashMap();
	public static Map<String, Object> listMapA = new HashMap();
	private Button head_btn_left;
	private Button head_btn_right;
	private ImageButton head_btn_showLeft_public;
	private TextView head_textview_public;
	private View.OnClickListener myOnClickListener;
	private ArrayList<Fragment> pagerItemList = new ArrayList();
	private TextView tx_temp1;
	private TextView tx_temp2;
	private View view_temp1;
	private View view_temp2;
	private ViewPager viewpager1;

	private String[] s = { "精 选", "日益升", "企益融", "鑫益宝", "速兑通" };
	private SharedPreferences t;
	private PagerSlidingTabStrip u;
	private ViewPager n;

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		ManageApplication.getInstance().addActivity(this);
		setContentView(R.layout.activity_manage_finance);
		// initData();
		// initView();
		// initMainUIListener();
	    this.n = ((ViewPager)findViewById(R.id.pager));
	    this.u = ((PagerSlidingTabStrip)findViewById(R.id.tabs));
	    int i1 = (int)TypedValue.applyDimension(1, 4.0F, getResources().getDisplayMetrics());
	    this.n.setPageMargin(i1);
	    n.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
	    u.setViewPager(n);
	}

	protected void onResume() {
		super.onResume();
		// if (SharedPClass.getParam("freshlist", this).equals("1")) {
		// freshData();
		// }
		// if (SharedPClass.getParam("lognin", this).equals("1")) {
		// this.head_btn_left.setVisibility(8);
		// return;
		// }
		// this.head_btn_left.setVisibility(0);
	}

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "精 选", "日益升", "企益融", "鑫益宝", "速兑通" };

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			return SuperAwesomeCardFragment.newInstance(position);
		}

	};
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name: com.zfl.webapp.view.finance.FinanceActivity JD-Core Version:
 * 0.7.1
 */