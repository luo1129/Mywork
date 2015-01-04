package com.yrz.atourong.widget;

import com.a.a.a.f;
import com.a.a.a.j;
import com.zzz.f.b.Tools;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class MyFragment extends Fragment {

	protected void a(String paramString, j paramj, f paramf) {
		if (!a(this.getActivity())) {
		}
		try {
			a(this.getActivity(), "网络连接异常,请检查网络");
			return;
		} catch (Exception localException) {
			Tools.a(this.getActivity(), paramString, paramj, paramf);
		}
	}

	public void a(final Activity paramActivity, final String paramString) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Looper.prepare();
					Toast.makeText(paramActivity, paramString, 0).show();
					Looper.loop();
					return;
				} catch (Exception localException) {
				}
			}
		}).start();
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
}
