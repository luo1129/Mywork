package com.zzz.f.d;

import android.content.Context;
import android.content.pm.*;
import android.graphics.Bitmap;
import android.os.Process;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class b {
	private static Map a = new HashMap();
	private d b;

	private b(File paramFile, long paramLong, int paramInt) {
		if ((!paramFile.exists()) && (!paramFile.mkdirs())) {
			throw new RuntimeException("can't make dirs in "
					+ paramFile.getAbsolutePath());
		}
		// this.b = new d(this, paramFile, paramLong, paramInt, null);
	}

	public static b a(Context paramContext, long paramLong, int paramInt) {
		return a(new File(paramContext.getCacheDir(), "cache_dir"), paramLong,
				paramInt);
	}

	public static b a(File paramFile, long paramLong, int paramInt) {
		b localb = (b) a.get(paramFile.getAbsoluteFile() + a());
		if ((localb == null) || (!paramFile.exists())) {
			localb = new b(paramFile, paramLong, paramInt);
			a.put(paramFile.getAbsolutePath() + a(), localb);
		}
		return localb;
	}

	private static String a() {
		return "_" + Process.myPid();
	}

	public static void a(Context paramContext, f paramf) {
		// abcdefg
		// PackageManager localPackageManager =
		// paramContext.getPackageManager();
		// Method localMethod = localPackageManager.getClass().getMethod(
		// "getPackageSizeInfo",
		// new Class[] { String.class, IPackageStatsObserver.class });
		// Object[] arrayOfObject = new Object[2];
		// arrayOfObject[0] = paramContext.getPackageName();
		// arrayOfObject[1] = new g(paramContext, paramf, null);
		// localMethod.invoke(localPackageManager, arrayOfObject);
	}

	private static void b(File paramFile) {
		for (File localFile : paramFile.listFiles()) {
			if (localFile.isDirectory()) {
				b(localFile);
			}
			localFile.delete();
		}
	}

	public void a(String paramString, Bitmap paramBitmap) {// abcdefg
		// a(paramString, h.a(paramBitmap));
	}

	/* Error */
	public void a(String paramString, byte[] paramArrayOfByte) {
		// abcdefg
	}

	/* Error */
	public byte[] a(String paramString) {
		// abcdefg
		return null;
	}

	public Bitmap b(String paramString) {// abcdefg
		if (a(paramString) == null) {
			return null;
		}
		return null;
		// return h.c(a(paramString));
	}

	public boolean c(String paramString) {// abcdefg

		// return d.c(paramString);
		return false;
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.yrz.atourong.d.b
 * 
 * JD-Core Version: 0.7.0.1
 */