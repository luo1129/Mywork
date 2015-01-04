package com.zzz.f;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
//import cn.jpush.android.api.JPushInterface;
//import com.zfl.webapp.db.DBManager;
//import com.zfl.webapp.setui.GuildAdapter;
//import com.zfl.webapp.setui.IndexObject;
//import com.zfl.webapp.util.ManageApplication;
//import com.zfl.webapp.util.MyMethod;
//import com.zfl.webapp.util.SharedPClass;
import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends Activity {
	private List<IndexObject> dataSource;
	private List<View> itemViews;
	private ViewPager viewPager;

	private void initItems() {
		this.dataSource = new ArrayList();
		int j;
		for (int i = 0;; i++) {
			if (i >= 3) {
				this.itemViews = new ArrayList();
				j = 0;
				if (j < this.dataSource.size()) {
					break;
				}
				return;
			}
			IndexObject localIndexObject = new IndexObject();
			localIndexObject.img = "0";
			localIndexObject.info = "0";
			localIndexObject.url = "0";
			this.dataSource.add(localIndexObject);
		}

		for (int i = 0; i < 3; i++) {
			View localView = getLayoutInflater().inflate(R.layout.guild_item,
					null);
			if (i == 0) {
				localView.setBackgroundResource(R.drawable.start_a);
			} else if (i == 1) {
				localView.setBackgroundResource(R.drawable.start_b);
			} else {
				localView.setBackgroundResource(R.drawable.start_c);
			}
			localView.setTag(Integer.valueOf(i));
			this.itemViews.add(localView);
		}
	}

	private void initView() {
		System.out.println("initView");
		this.viewPager = ((ViewPager) findViewById(R.id.mainViewPager));
		GuildAdapter localGuildAdapter = new GuildAdapter(this,
				this.dataSource, this.itemViews);
		this.viewPager.setAdapter(localGuildAdapter);
	}

	public void createShut() {
		Intent localIntent1 = new Intent(
				"com.android.launcher.action.INSTALL_SHORTCUT");
		String str = getResources().getString(2131361855);
		Intent.ShortcutIconResource localShortcutIconResource = Intent.ShortcutIconResource
				.fromContext(this, 2130837546);
		Intent localIntent2 = new Intent(this, WelcomeActivity.class);
		localIntent1.putExtra("android.intent.extra.shortcut.NAME", str);
		localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE",
				localShortcutIconResource);
		localIntent1.putExtra("android.intent.extra.shortcut.INTENT",
				localIntent2);
		sendBroadcast(localIntent1);
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		ManageApplication.getInstance().addActivity(this);
		// JPushInterface.setDebugMode(true);
		// JPushInterface.init(this);
		if (SharedPClass.getParam("pushmessage", this).equals("1")) {
			// JPushInterface.resumePush(this);
		}

		setContentView(R.layout.welcomeview);
		if (SharedPClass.getParam("lognin", this).equals("1")) {
			new SharedPClass("gesturepwd", "1", this);
		}

		System.out
				.println("welcome: " + SharedPClass.getParam("welcome", this));

		if (SharedPClass.getParam("welcome", this).equals("1")) {

			System.out.println("/////////////////////////////");

			initItems();
			initView();
		}
		MyMethod.initImageLoader(this);
		new Handler().postDelayed(new Runnable() {
			public void run() {
				// DBManager localDBManager = new
				// DBManager(WelcomeActivity.this);
				// localDBManager.openDatabase();
				// localDBManager.closeDatabase();
				// if (SharedPClass.getParam("times", WelcomeActivity.this)
				// .equals("0")) {
				// WelcomeActivity.this.initItems();
				// WelcomeActivity.this.initView();
				// new SharedPClass("welcome", "1", WelcomeActivity.this);
				// WelcomeActivity.this.createShut();
				// }
				// while (!SharedPClass.getParam("welcome",
				// WelcomeActivity.this)
				// .equals("1")) {
				// return;
				// }
				Intent localIntent = new Intent(WelcomeActivity.this,
						MainActivity.class);
				WelcomeActivity.this.startActivity(localIntent);
				WelcomeActivity.this.finish();
			}
		}, 3000L);
		return;
		// JPushInterface.stopPush(this);

	}

	protected void onPause() {
		super.onPause();
		// JPushInterface.onPause(this);
	}

	protected void onResume() {
		super.onResume();
		// JPushInterface.onResume(this);
	}
}
