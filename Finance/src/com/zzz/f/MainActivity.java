package com.zzz.f;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.TabActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
//import com.zfl.webapp.util.ManageApplication;
//import com.zfl.webapp.util.SharedPClass;
//import com.zfl.webapp.view.account.PersonActivity;
//import com.zfl.webapp.view.finance.FinanceActivity;
//import com.zfl.webapp.view.index.IndexActivity;
//import com.zfl.webapp.view.more.MoreActivity;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
	private ImageView finance;
	private RelativeLayout finance_layout;
	private ImageView index;
	private RelativeLayout index_layout;
	private BroadcastReceiver mHomeKeyEventReceiver = new BroadcastReceiver() {
		String SYSTEM_HOME_KEY = "homekey";
		String SYSTEM_HOME_KEY_LONG = "recentapps";
		String SYSTEM_REASON = "reason";

		public void onReceive(Context paramAnonymousContext,
				Intent paramAnonymousIntent) {
			String str;
			// if (paramAnonymousIntent.getAction().equals(
			// "android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
			// str = paramAnonymousIntent.getStringExtra(this.SYSTEM_REASON);
			// if (!TextUtils.equals(str, this.SYSTEM_HOME_KEY)) {
			// break label66;
			// }
			// if (!SharedPClass.getParam("uid", MainActivity.this)
			// .equals("0")) {
			// new SharedPClass("gesturepwd", "1", MainActivity.this);
			// }
			// }
			// label66: while ((!TextUtils.equals(str,
			// this.SYSTEM_HOME_KEY_LONG))
			// || (!SharedPClass.getParam("gesturepwd", MainActivity.this)
			// .equals("1"))) {
			// return;
			// }
			// Intent localIntent = new Intent(MainActivity.this,
			// GesturePwdActivity.class);
			// MainActivity.this.startActivity(localIntent);
		}
	};
	private ImageView more;
	private RelativeLayout more_layout;
	private ImageView person;
	private RelativeLayout person_layout;
	private TabHost tabHost;

	private void initTab() {
		this.tabHost = getTabHost();
		this.tabHost.addTab(this.tabHost.newTabSpec("tag_index")
				.setIndicator("tag_index")
				.setContent(new Intent(this, IndexActivity.class)));
		this.tabHost.addTab(this.tabHost.newTabSpec("tag_finance")
				.setIndicator("tag_finance")
				.setContent(new Intent(this, FinanceActivity.class)));
		this.tabHost.addTab(this.tabHost.newTabSpec("tag_person")
				.setIndicator("tag_person")
				.setContent(new Intent(this, PersonActivity.class)));
		this.tabHost.addTab(this.tabHost.newTabSpec("tag_more")
				.setIndicator("tag_more")
				.setContent(new Intent(this, MoreActivity.class)));
	}

	private void initView() {
		this.index_layout = ((RelativeLayout) findViewById(R.id.index_layout));
		this.finance_layout = ((RelativeLayout) findViewById(R.id.finance_layout));
		this.person_layout = ((RelativeLayout) findViewById(R.id.person_layout));
		this.more_layout = ((RelativeLayout) findViewById(R.id.more_layout));
		this.index_layout.setOnClickListener(new ViewOnClickListener());
		this.finance_layout.setOnClickListener(new ViewOnClickListener());
		this.person_layout.setOnClickListener(new ViewOnClickListener());
		this.more_layout.setOnClickListener(new ViewOnClickListener());
		this.index = ((ImageView) findViewById(R.id.index));
		this.finance = ((ImageView) findViewById(R.id.finance));
		this.person = ((ImageView) findViewById(R.id.person));
		this.more = ((ImageView) findViewById(R.id.more));
	}

	private void setBottomViewLayoutUnSelect() {
		this.index.setImageResource(R.drawable.tab_icon_home_bg);
		this.finance.setImageResource(R.drawable.tab_icon_finance_bg);
		this.person.setImageResource(R.drawable.tab_icon_account_bg);
		this.more.setImageResource(R.drawable.tab_icon_more_bg);
	}

	protected void dialog() {
		AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
		localBuilder.setMessage("ȷ���˳���");
		localBuilder.setTitle("��ʾ");
		localBuilder.setPositiveButton("ȷ��",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface paramAnonymousDialogInterface,
							int paramAnonymousInt) {
						paramAnonymousDialogInterface.dismiss();
						MainActivity.this.finish();
						ManageApplication.getInstance().exit();
					}
				});
		localBuilder.setNeutralButton("ȡ��",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface paramAnonymousDialogInterface,
							int paramAnonymousInt) {
						paramAnonymousDialogInterface.dismiss();
					}
				});
		localBuilder.create().show();
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		ManageApplication.getInstance().addActivity(this);
		setContentView(R.layout.main);
		initTab();
		initView();
		this.index.setImageResource(R.drawable.tab_icon_home_sel);
		registerReceiver(this.mHomeKeyEventReceiver, new IntentFilter(
				"android.intent.action.CLOSE_SYSTEM_DIALOGS"));
	}

	protected void onDestroy() {
		super.onDestroy();
	}

	public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
		if (paramInt == 4) {
			dialog();
			return true;
		}
		return super.onKeyDown(paramInt, paramKeyEvent);
	}

	protected void onResume() {
		super.onResume();
		// if (SharedPClass.getParam("gesturepwd", this).equals("1")) {
		// startActivity(new Intent(this, GesturePwdActivity.class));
		// }
	}

	public void turnToTab(String paramString) {
		setBottomViewLayoutUnSelect();
		this.tabHost.setCurrentTabByTag(paramString);
		if ("tag_index".equals(paramString)) {
			this.index.setImageResource(R.drawable.tab_icon_home_sel);
		}

		if ("tag_finance".equals(paramString)) {
			this.finance.setImageResource(R.drawable.tab_icon_finance_sel);

		}
		if ("tag_person".equals(paramString)) {
			this.person.setImageResource(R.drawable.tab_icon_account_sel);

		}
		if ("tag_more".equals(paramString)) {
			this.more.setImageResource(R.drawable.tab_icon_more_sel);
		}
	}

	private class ViewOnClickListener implements View.OnClickListener {
		private ViewOnClickListener() {
		}

		public void onClick(View paramView) {
			switch (paramView.getId()) {
			case R.id.index_layout:
				MainActivity.this.turnToTab("tag_index");
				return;
			case R.id.finance_layout:
				MainActivity.this.turnToTab("tag_finance");
				return;
			case R.id.person_layout:
				MainActivity.this.turnToTab("tag_person");
				return;
			case R.id.index:
			case R.id.finance:
			case R.id.person:
			default:
				MainActivity.this.turnToTab("tag_more");
				return;
			}

		}
	}
}
