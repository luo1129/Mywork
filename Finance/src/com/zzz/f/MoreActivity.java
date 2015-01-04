package com.zzz.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
//import cn.jpush.android.api.JPushInterface;
//import cn.sharesdk.onekeyshare.OnekeyShare;
//import com.zfl.webapp.net.http;
//import com.zfl.webapp.net.https;
//import com.zfl.webapp.util.ManageApplication;
//import com.zfl.webapp.util.SharedPClass;
import java.io.File;

public class MoreActivity extends Activity {
	private Button bt_temp1;
	private CheckBox checkbox_temp1;
	private int firstTimeCheck = 0;
	private Button head_btn_left;
	private Button head_btn_right;
	private TextView head_textview_public;
	private ImageView im_temp0;
	private View.OnClickListener myOnClickListener;
	private RelativeLayout relative_temp1;
	private RelativeLayout relative_temp2;
	private RelativeLayout relative_temp3;
	private RelativeLayout relative_temp4;
	private RelativeLayout relative_temp5;
	private RelativeLayout relative_temp6;
	private RelativeLayout relative_temp7;
	private RelativeLayout relative_temp8;


	@SuppressLint({ "HandlerLeak" })
	private void downLoadApk() {
		final Handler local11 = new Handler() {
			public void handleMessage(Message paramAnonymousMessage) {
				if (paramAnonymousMessage.what != 1) {
					Toast.makeText(MoreActivity.this, "下载失败", 0).show();
				}
			}
		};
		if (Environment.getExternalStorageState().equals("mounted")) {
			final ProgressDialog localProgressDialog = new ProgressDialog(this);
			localProgressDialog.setProgressStyle(1);
			localProgressDialog.setMessage("正在下载更新");
			localProgressDialog.show();

			System.out.println("正在下载更新");

			// new Thread() {
			// public void run() {
			// try {
			// String str1 = Environment.getExternalStorageDirectory()
			// .getAbsolutePath();
			// String str2 = MoreActivity.this.getString(2131361855);
			// File localFile1 = new File(str1 + File.separator + str2);
			// if (!localFile1.exists()) {
			// localFile1.mkdirs();
			// }
			// File localFile2 = http.getFileFromServer(https.url0,
			// str1 + File.separator + str2 + File.separator
			// + "lxjr.apk", localProgressDialog);
			// sleep(1000L);
			// MoreActivity.this.installApk(localFile2);
			// localProgressDialog.dismiss();
			// return;
			// } catch (Exception localException) {
			// Message localMessage = new Message();
			// localMessage.what = 0;
			// local11.sendMessage(localMessage);
			// localException.printStackTrace();
			// }
			// }
			// }.start();
		}
	}

	private String getVersionInfo() {
		String str = "0";
		try {
			str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
			return str;
		} catch (Exception localException) {

		}
		return str;
	}

	private void initData() {
		this.head_textview_public = ((TextView) findViewById(2131296371));
		this.head_btn_right = ((Button) findViewById(2131296375));
		this.head_btn_left = ((Button) findViewById(2131296374));
		this.bt_temp1 = ((Button) findViewById(2131296296));
		this.im_temp0 = ((ImageView) findViewById(2131296276));
		this.relative_temp1 = ((RelativeLayout) findViewById(2131296322));
		this.relative_temp2 = ((RelativeLayout) findViewById(2131296323));
		this.relative_temp3 = ((RelativeLayout) findViewById(2131296324));
		this.relative_temp4 = ((RelativeLayout) findViewById(2131296325));
		this.relative_temp5 = ((RelativeLayout) findViewById(2131296326));
		this.relative_temp6 = ((RelativeLayout) findViewById(2131296327));
		this.relative_temp7 = ((RelativeLayout) findViewById(2131296328));
		this.relative_temp8 = ((RelativeLayout) findViewById(2131296329));
		this.checkbox_temp1 = ((CheckBox) findViewById(2131296360));
		this.head_textview_public.setText("更多");
		initView();
	}

	private void initMainUIListener() {
		this.myOnClickListener = new View.OnClickListener() {
			public void onClick(View paramAnonymousView) {

				System.out.println("moreActivity 点击相应");

				// switch (paramAnonymousView.getId()) {
				// case 2131296374:
				// case 2131296375:
				// default:
				// return;
				// case 2131296296:
				// MoreActivity.this.lognOutId();
				// return;
				// case 2131296322:
				// Intent localIntent5 = new Intent(MoreActivity.this,
				// NewsListActivity.class);
				// MoreActivity.this.startActivity(localIntent5);
				// MoreActivity.this.overridePendingTransition(2130968579,
				// 2130968576);
				// return;
				// case 2131296323:
				// Intent localIntent4 = new Intent(MoreActivity.this,
				// HelpActivity.class);
				// MoreActivity.this.startActivity(localIntent4);
				// MoreActivity.this.overridePendingTransition(2130968579,
				// 2130968576);
				// return;
				// case 2131296324:
				// Intent localIntent3 = new Intent(MoreActivity.this,
				// AboutUsActivity.class);
				// MoreActivity.this.startActivity(localIntent3);
				// MoreActivity.this.overridePendingTransition(2130968579,
				// 2130968576);
				// return;
				// case 2131296325:
				// Intent localIntent2 = new Intent(MoreActivity.this,
				// HelpShowActivity.class);
				// localIntent2.putExtra("titile", "合作招募");
				// MoreActivity.this.startActivity(localIntent2);
				// MoreActivity.this.overridePendingTransition(2130968579,
				// 2130968576);
				// return;
				// case 2131296326:
				// Intent localIntent1 = new Intent(MoreActivity.this,
				// FeedBackActivity.class);
				// MoreActivity.this.startActivity(localIntent1);
				// MoreActivity.this.overridePendingTransition(2130968579,
				// 2130968576);
				// return;
				// case 2131296327:
				// Vibrator localVibrator = (Vibrator) MoreActivity.this
				// .getSystemService("vibrator");
				// long[] arrayOfLong = new long[4];
				// arrayOfLong[1] = 100L;
				// arrayOfLong[3] = 50L;
				// localVibrator.vibrate(arrayOfLong, -1);
				// MoreActivity.this
				// .startShareSDKApp(
				// "前海理想金融－中国领先的互联网金融投融资平台。官网：www.id68.cn  热线：4000105168",
				// "http://www.id68.cn/UF/Uploads/Ad/20140723171456169.jpg");
				// return;
				// case 2131296328:
				// MoreActivity.this.checkVer();
				// return;
				// }
				MoreActivity.this.toAtionUs();
			}
		};
		if (this.head_btn_left != null) {
			this.head_btn_left.setOnClickListener(this.myOnClickListener);
		}
		if (this.head_btn_right != null) {
			this.head_btn_right.setOnClickListener(this.myOnClickListener);
		}
		if (this.bt_temp1 != null) {
			this.bt_temp1.setOnClickListener(this.myOnClickListener);
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
		if (this.relative_temp6 != null) {
			this.relative_temp6.setOnClickListener(this.myOnClickListener);
		}
		if (this.relative_temp7 != null) {
			this.relative_temp7.setOnClickListener(this.myOnClickListener);
		}
		if (this.relative_temp8 != null) {
			this.relative_temp8.setOnClickListener(this.myOnClickListener);
		}
	}

	private void initView() {
		this.head_btn_left.setVisibility(8);
		this.head_btn_right.setVisibility(8);
		// this.checkbox_temp1
		// .setOnCheckedChangeListener(new
		// CompoundButton.OnCheckedChangeListener() {
		// public void onCheckedChanged(
		// CompoundButton paramAnonymousCompoundButton,
		// boolean paramAnonymousBoolean) {
		// if (paramAnonymousBoolean) {
		// new SharedPClass("pushmessage", "1",
		// MoreActivity.this);
		// JPushInterface.resumePush(MoreActivity.this);
		// return;
		// }
		// new SharedPClass("pushmessage", "0", MoreActivity.this);
		// JPushInterface.stopPush(MoreActivity.this);
		// }
		// });
		initMainUIListener();
	}

	@SuppressLint({ "HandlerLeak" })
	private void lognOutId() {
		final Handler local3 = new Handler() {
			public void handleMessage(Message paramAnonymousMessage) {
				Toast.makeText(MoreActivity.this, "注销成功", 0).show();
				MoreActivity.this.bt_temp1.setVisibility(8);
			}
		};
		final ProgressDialog localProgressDialog = ProgressDialog.show(this,
				"", "Loading...", false);
		localProgressDialog.setCancelable(false);
		new Thread() {
			public void run() {
				Message localMessage = new Message();
				localMessage.what = 0;
				try {
					Looper.prepare();
					MoreActivity.this.getSharedPreferences("GUE_PWD", 0).edit()
							.clear().commit();
					new SharedPClass("lognin", "0", MoreActivity.this);
					SharedPClass.lognOut(MoreActivity.this);
					sleep(500L);
				} catch (Exception localException) {
					for (;;) {
						localException.printStackTrace();
						localProgressDialog.dismiss();
					}
				} finally {
					localProgressDialog.dismiss();
				}
				local3.sendMessage(localMessage);
				Looper.loop();
			}
		}.start();
	}

	private void startShareSDKApp(String paramString1, String paramString2) {
		// OnekeyShare localOnekeyShare = new OnekeyShare();
		// localOnekeyShare.setNotification(2130837546, getString(2131361855));
		// localOnekeyShare.setTitle(paramString1);
		// localOnekeyShare.setTitleUrl("http://www.id68.cn");
		// localOnekeyShare.setText(paramString1);
		// localOnekeyShare.setComment(paramString1);
		// localOnekeyShare.setSite(getString(2131361855));
		// localOnekeyShare.setSiteUrl("http://www.id68.cn");
		// localOnekeyShare.setSilent(true);
		// localOnekeyShare.show(this);
	}

	private void toAtionUs() {
		AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
		localBuilder.setMessage("您可在微信-通讯录-添加好友-查找公众号中搜索:前海理想金融,点击关注,获取我们最新资讯");
		localBuilder.setTitle("关注");
		localBuilder.setPositiveButton("去关注",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface paramAnonymousDialogInterface,
							int paramAnonymousInt) {
						try {
							Intent localIntent = new Intent();
							localIntent.setPackage("com.tencent.mm");
							MoreActivity.this.startActivity(localIntent);
							return;
						} catch (Exception localException) {
							Toast.makeText(MoreActivity.this, "您的系统不能关注", 0)
									.show();
						}
					}
				});
		localBuilder.setNeutralButton("取消",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface paramAnonymousDialogInterface,
							int paramAnonymousInt) {
						paramAnonymousDialogInterface.dismiss();
					}
				});
		localBuilder.create().show();
	}

	protected void dialog(String paramString) {
		AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
		localBuilder.setMessage(paramString);
		localBuilder.setTitle("检查到有可升级版本");
		localBuilder.setPositiveButton("升级",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface paramAnonymousDialogInterface,
							int paramAnonymousInt) {
						MoreActivity.this.downLoadApk();
					}
				});
		localBuilder.setNeutralButton("取消",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface paramAnonymousDialogInterface,
							int paramAnonymousInt) {
						paramAnonymousDialogInterface.dismiss();
					}
				});
		localBuilder.create().show();
	}

	protected void installApk(File paramFile) {
		Intent localIntent = new Intent();
		localIntent.setAction("android.intent.action.VIEW");
		localIntent.setDataAndType(Uri.fromFile(paramFile),
				"application/vnd.android.package-archive");
		startActivity(localIntent);
	} 

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		ManageApplication.getInstance().addActivity(this);
		setContentView(R.layout.activity_more);
//		initData();
	}

	protected void onResume() {
		super.onResume();
//		if (SharedPClass.getParam("lognin", this).equals("1")) {
//			this.bt_temp1.setVisibility(0);
//		}
//		if (SharedPClass.getParam("pushmessage", this).equals("1")) {
//			this.checkbox_temp1.setChecked(true);
//			// JPushInterface.resumePush(this);
//			this.bt_temp1.setVisibility(8);
//		} else {
//			this.checkbox_temp1.setChecked(false);
//		}

		// JPushInterface.stopPush(this);
	}

	public void startShareApp(String paramString1, String paramString2,
			String paramString3) {
		Intent localIntent = new Intent("android.intent.action.SEND");
		localIntent.setType("text/plain");
		localIntent.putExtra("android.intent.extra.SUBJECT", paramString2);
		localIntent.putExtra("android.intent.extra.TEXT", paramString3);
		startActivity(Intent.createChooser(localIntent, paramString1));
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name: com.zfl.webapp.view.more.MoreActivity JD-Core Version: 0.7.1
 */