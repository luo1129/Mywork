package com.zzz.f.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class aj {
	public static HashMap a = new HashMap();
	public static ReferenceQueue b = new ReferenceQueue();
	public static String c = "folder";
	public static String d = "empty";
	public static String e = "text";
	public static String f = "audio";
	public static String g = "video";
	public static String h = "image";
	private static aj i = null;
	private static Object j = new Object();
	private static Context k;

	// private x l = null;

	private aj(Context paramContext) {
		k = paramContext;
		// abcdefg
		// try {
		// this.l = x.a(paramContext);
		// return;
		// } catch (Exception localException) {
		// }
	}

	public static aj a(Context paramContext) {
		synchronized (j) {
			if (i == null) {
				i = new aj(paramContext);
			}
			aj localaj = i;
			return localaj;
		}
	}

	public Bitmap a(Context paramContext, int paramInt) {
		BitmapFactory.Options localOptions = new BitmapFactory.Options();
		localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
		localOptions.inPurgeable = true;
		localOptions.inInputShareable = true;
		return BitmapFactory.decodeStream(paramContext.getResources()
				.openRawResource(paramInt), null, localOptions);
	}

	public Bitmap a(String paramString) {
		SoftReference localSoftReference = (SoftReference) a.get(paramString);
		if ((localSoftReference == null) || (localSoftReference.get() == null)) {
			localSoftReference = new SoftReference(b(paramString), b);
			a.put(paramString, localSoftReference);
		}
		return (Bitmap) localSoftReference.get();
	}

	public Bitmap b(String paramString) {
		return c(paramString);
	}

	public Bitmap c(String paramString) {
		String str = paramString.toLowerCase();
		if (TextUtils.isEmpty(str)) {
		}
		Resources localResources = k.getResources();
		return BitmapFactory.decodeResource(
				localResources,
				localResources.getIdentifier(str, "drawable",
						k.getPackageName()));
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.yrz.atourong.d.aj
 * 
 * JD-Core Version: 0.7.0.1
 */