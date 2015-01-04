package com.zzz.f.b;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.a.a.a.f;
import com.a.a.a.h;
import com.a.a.a.j;
import java.util.List;

public class Tools {
	private static com.a.a.a.a a = new com.a.a.a.a();

	public static String a(String paramString) {
		if ((("https://www.xinhehui.com/" + paramString).indexOf("#") != -1)
				|| (("https://www.xinhehui.com/" + paramString).indexOf("?") != -1)) {
			return "https://www.xinhehui.com/" + paramString
					+ "&app_version=4.0.5";
		}
		return "https://www.xinhehui.com/" + paramString + "?app_version=4.0.5";
	}

	public static String a(String paramString, Activity paramActivity) {
		PackageManager localPackageManager = paramActivity.getPackageManager();
		PackageInfo localPackageInfo2;
		PackageInfo localPackageInfo1;
		ApplicationInfo localApplicationInfo2;
		String str1;
		String str2;
		String str3;
		String str4;
		try {
			localApplicationInfo2 = localPackageManager.getApplicationInfo(
					paramActivity.getPackageName(), 128);

			localPackageInfo2 = localPackageManager.getPackageInfo(
					paramActivity.getPackageName(), 0);
			localPackageInfo1 = localPackageInfo2;
			str1 = Build.BRAND;
			str2 = localPackageInfo1.versionName;
			str3 = localApplicationInfo2.metaData.getString("UMENG_CHANNEL");
			str4 = ((TelephonyManager) paramActivity.getSystemService("phone"))
					.getDeviceId();
			return "https://www.xinhehui.com/" + paramString + "?app_version="
					+ str2 + "&hmsr=" + str3 + "&brand=" + str1 + "&deviceId="
					+ str4;

		} catch (Exception localException1) {
			localException1.printStackTrace();
		}
		return null;
	}

	public static void a() {
		a.b();
	}

	public static void a(Activity paramActivity, String paramString, j paramj,
			f paramf) {
		String str = a(paramString, paramActivity);
		Log.d("UPGHttpClient",
				String.format("%s&%s", new Object[] { str, paramj }));
		a.a(str, paramj, paramf);
	}

	public static void a(String paramString, int paramInt, h paramh) {
		a.a(paramString, paramh);
	}

	public static void a(String paramString, h paramh) {
		String str = a(paramString);
		a.a(str, paramh);
	}

	public static void a(String paramString, j paramj, f paramf) {
		String str = a(paramString);
		a.a(str, paramj, paramf);
	}

	public static List b() {
		return a.a();
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.yrz.atourong.b.a
 * 
 * JD-Core Version: 0.7.0.1
 */