package com.zzz.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
//import com.zfl.webapp.net.http;
//import com.zfl.webapp.net.https;
//import com.zfl.webapp.util.MD5;
//import com.zfl.webapp.util.ManageApplication;
//import com.zfl.webapp.util.SharedPClass;
//import com.zfl.webapp.view.more.HelpActivity;
import java.io.PrintStream;
import java.util.HashMap;
import org.json.JSONObject;

public class PersonActivity extends Activity {
	private Button head_btn_left;
	private Button head_btn_right;
	private TextView head_textview_public;
	private View.OnClickListener myOnClickListener;
	private RelativeLayout relative_temp1;
	private RelativeLayout relative_temp2;
	private RelativeLayout relative_temp3;
	private RelativeLayout relative_temp4;
	private RelativeLayout relative_temp5;
	private TextView tx_temp1;
	private TextView tx_temp2;
	private TextView tx_temp22;
	private TextView tx_temp4;
	private TextView tx_temp6;
	private TextView tx_temp8;

	private void initData() {
		this.head_textview_public = ((TextView) findViewById(2131296371));
		this.head_btn_right = ((Button) findViewById(2131296375));
		this.head_btn_left = ((Button) findViewById(2131296374));
		this.relative_temp1 = ((RelativeLayout) findViewById(2131296322));
		this.relative_temp2 = ((RelativeLayout) findViewById(2131296323));
		this.relative_temp3 = ((RelativeLayout) findViewById(2131296324));
		this.relative_temp4 = ((RelativeLayout) findViewById(2131296325));
		this.relative_temp5 = ((RelativeLayout) findViewById(2131296326));
		this.tx_temp1 = ((TextView) findViewById(2131296258));
		this.tx_temp2 = ((TextView) findViewById(2131296259));
		this.tx_temp4 = ((TextView) findViewById(2131296261));
		this.tx_temp6 = ((TextView) findViewById(2131296263));
		this.tx_temp8 = ((TextView) findViewById(2131296265));
		this.tx_temp22 = ((TextView) findViewById(2131296268));
		this.head_textview_public.setText("我的账号");
		this.head_btn_left.setText("帮助");
		this.head_btn_right.setText("消息");
	}

	private void initMainUIListener() {
		this.myOnClickListener = new View.OnClickListener() {
			public void onClick(View paramAnonymousView) {
				// switch (paramAnonymousView.getId()) {
				// default:
				// case 2131296374:
				// case 2131296375:
				// case 2131296322:
				// case 2131296323:
				// case 2131296324:
				// do {
				// return;
				// Intent localIntent12 = new Intent(PersonActivity.this,
				// HelpActivity.class);
				// PersonActivity.this.startActivity(localIntent12);
				// PersonActivity.this.overridePendingTransition(
				// 2130968579, 2130968576);
				// return;
				// if (SharedPClass
				// .getParam("lognin", PersonActivity.this)
				// .equals("1")) {
				// Intent localIntent10 = new Intent(
				// PersonActivity.this,
				// MessageListActivity.class);
				// PersonActivity.this.startActivity(localIntent10);
				// PersonActivity.this.overridePendingTransition(
				// 2130968579, 2130968576);
				// return;
				// }
				// Intent localIntent11 = new Intent(PersonActivity.this,
				// LognActivity.class);
				// PersonActivity.this.startActivity(localIntent11);
				// PersonActivity.this.overridePendingTransition(
				// 2130968579, 2130968579);
				// return;
				// if (SharedPClass
				// .getParam("lognin", PersonActivity.this)
				// .equals("1")) {
				// Intent localIntent8 = new Intent(
				// PersonActivity.this, MyAccount.class);
				// PersonActivity.this.startActivity(localIntent8);
				// PersonActivity.this.overridePendingTransition(
				// 2130968577, 2130968580);
				// return;
				// }
				// Intent localIntent9 = new Intent(PersonActivity.this,
				// LognActivity.class);
				// PersonActivity.this.startActivity(localIntent9);
				// PersonActivity.this.getParent()
				// .overridePendingTransition(2130968579,
				// 2130968576);
				// return;
				// if (SharedPClass
				// .getParam("lognin", PersonActivity.this)
				// .equals("1")) {
				// PersonActivity.this.lognIn();
				// return;
				// }
				// Intent localIntent7 = new Intent(PersonActivity.this,
				// LognActivity.class);
				// PersonActivity.this.startActivity(localIntent7);
				// PersonActivity.this.getParent()
				// .overridePendingTransition(2130968579,
				// 2130968576);
				// return;
				// } while (SharedPClass.getParam("lognin",
				// PersonActivity.this).equals("1"));
				// Intent localIntent6 = new Intent(PersonActivity.this,
				// LognActivity.class);
				// PersonActivity.this.startActivity(localIntent6);
				// PersonActivity.this.getParent().overridePendingTransition(
				// 2130968579, 2130968576);
				// return;
				// case 2131296325:
				// if (SharedPClass.getParam("lognin", PersonActivity.this)
				// .equals("1")) {
				// Intent localIntent4 = new Intent(PersonActivity.this,
				// AcountNavActivity.class);
				// PersonActivity.this.startActivity(localIntent4);
				// PersonActivity.this.overridePendingTransition(
				// 2130968579, 2130968576);
				// return;
				// }
				// Intent localIntent5 = new Intent(PersonActivity.this,
				// LognActivity.class);
				// PersonActivity.this.startActivity(localIntent5);
				// PersonActivity.this.getParent().overridePendingTransition(
				// 2130968579, 2130968576);
				// return;
				// }
				// if (SharedPClass.getParam("lognin", PersonActivity.this)
				// .equals("1")) {
				// if (SharedPClass.getParam("idcard", PersonActivity.this)
				// .equals("1")) {
				// Intent localIntent2 = new Intent(PersonActivity.this,
				// GiveMoneyActivity.class);
				// PersonActivity.this.startActivity(localIntent2);
				// PersonActivity.this.overridePendingTransition(
				// 2130968581, 2130968578);
				// return;
				// }
				// Toast.makeText(PersonActivity.this, "请先实名认证", 1).show();
				// Intent localIntent3 = new Intent(PersonActivity.this,
				// IdCardActivity.class);
				// PersonActivity.this.startActivity(localIntent3);
				// PersonActivity.this.overridePendingTransition(2130968579,
				// 2130968576);
				// return;
				// }
				// Intent localIntent1 = new Intent(PersonActivity.this,
				// LognActivity.class);
				// PersonActivity.this.startActivity(localIntent1);
				// PersonActivity.this.getParent().overridePendingTransition(
				// 2130968579, 2130968576);
			}
		};
		if (this.head_btn_left != null) {
			this.head_btn_left.setOnClickListener(this.myOnClickListener);
		}
		if (this.head_btn_right != null) {
			this.head_btn_right.setOnClickListener(this.myOnClickListener);
		}
		if (this.relative_temp1 != null) {
			this.relative_temp1.setOnClickListener(this.myOnClickListener);
		}
		if (this.relative_temp2 != null) {
			this.relative_temp2.setOnClickListener(this.myOnClickListener);
		}
		if (this.relative_temp3 != null) {
			this.relative_temp3.setOnClickListener(this.myOnClickListener);
		}
		if (this.relative_temp4 != null) {
			this.relative_temp4.setOnClickListener(this.myOnClickListener);
		}
		if (this.relative_temp5 != null) {
			this.relative_temp5.setOnClickListener(this.myOnClickListener);
		}
	}

	private void initView() {
		initMainUIListener();

		if (SharedPClass.getParam("lognin", this).equals("1")) {
			if (SharedPClass.getParam("idcard", this).equals("0")) {
				this.tx_temp1.setText("未认证");
				this.tx_temp2.setText(SharedPClass.getParam("phone", this));
				this.tx_temp4.setText(SharedPClass.getParam("capital", this));
				this.tx_temp6.setText(SharedPClass.getParam("account_money",
						this));
				this.tx_temp8.setText(SharedPClass.getParam("totalearn", this));
				this.tx_temp22.setText(SharedPClass.getParam("scores", this));
			} else {
				this.tx_temp1.setText(SharedPClass.getParam("real_name", this));
			}
		} else {
			this.tx_temp1.setText("未登录");
			this.tx_temp2.setText("");
			this.tx_temp4.setText("");
			this.tx_temp6.setText("");
			this.tx_temp8.setText("");
			this.tx_temp22.setText("");
		}

	}

	@SuppressLint({ "HandlerLeak" })
	private void lognIn() {

		System.out.println("登陆环节");

		// final Handler local2 = new Handler() {
		// public void handleMessage(Message paramAnonymousMessage) {
		// if (paramAnonymousMessage.what == 1) {
		// PersonActivity.this.initView();
		// return;
		// }
		// Toast.makeText(PersonActivity.this, "刷新数据失败", 0).show();
		// }
		// };
		// final ProgressDialog localProgressDialog = ProgressDialog.show(this,
		// "", "Loading...", false);
		// localProgressDialog.setCancelable(false);
		// new Thread() {
		// public void run() {
		// Message localMessage = new Message();
		// localMessage.what = 0;
		// try {
		// Looper.prepare();
		// String str1 = https.url4;
		// HashMap localHashMap = new HashMap();
		// localHashMap.put("txtUser", SharedPClass.getParam(
		// "userNameTxt", PersonActivity.this));
		// localHashMap.put("txtPwd", MD5.getMD5(SharedPClass
		// .getParam("passWordTxt", PersonActivity.this)));
		// http.getHttpClient();
		// String str2 = http.doGet(str1, localHashMap);
		// System.out.println(str1 + "  " + localHashMap.toString());
		// localMessage.obj = str2;
		// if (!str2.equals("0")) {
		// JSONObject localJSONObject = new JSONObject(str2);
		// if (localJSONObject.getInt("uid") > 0) {
		// new SharedPClass("freshlogn", "0",
		// PersonActivity.this);
		// new SharedPClass("lognin", "1", PersonActivity.this);
		// SharedPClass.saveLognInfo(localJSONObject,
		// PersonActivity.this);
		// localMessage.what = 1;
		// }
		// }
		// } catch (Exception localException) {
		// for (;;) {
		// localException.printStackTrace();
		// localProgressDialog.dismiss();
		// }
		// } finally {
		// localProgressDialog.dismiss();
		// }
		// local2.sendMessage(localMessage);
		// Looper.loop();
		// }
		// }.start();
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		ManageApplication.getInstance().addActivity(this);
		setContentView(R.layout.activity_account_list);
//		initData();
	}

	protected void onResume() {
		super.onResume();
//		if (SharedPClass.getParam("freshlogn", this).equals("1")) {
//			lognIn();
//			return;
//		}
//		initView();
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name: com.zfl.webapp.view.account.PersonActivity JD-Core Version:
 * 0.7.1
 */