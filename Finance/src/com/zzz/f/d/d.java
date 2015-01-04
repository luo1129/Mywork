package com.zzz.f.d;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class d {
	protected File a;
	private final AtomicLong c;
	private final AtomicInteger d;
	private final long e;
	private final int f;
	private final Map g = Collections.synchronizedMap(new HashMap());

	private d(b paramb, File paramFile, long paramLong, int paramInt) {
		this.a = paramFile;
		this.e = paramLong;
		this.f = paramInt;
		this.c = new AtomicLong();
		this.d = new AtomicInteger();
		a();
	}

	private File a(String paramString) {
		File localFile = b(paramString);
		Long localLong = Long.valueOf(System.currentTimeMillis());
		localFile.setLastModified(localLong.longValue());
		this.g.put(localFile, localLong);
		return localFile;
	}

	private void a() {
		new Thread(new Runnable() {

			public void run() {
				//abcdefg
				// int i = 0;
				// File[] arrayOfFile = this.a.a.listFiles();
				// if (arrayOfFile != null)
				// {
				// int j = arrayOfFile.length;
				// int k = 0;
				// int m = 0;
				// while (i < j)
				// {
				// File localFile = arrayOfFile[i];
				// m = (int)(m + d.b(this.a, localFile));
				// k++;
				// d.a(this.a).put(localFile,
				// Long.valueOf(localFile.lastModified()));
				// i++;
				// }
				// d.b(this.a).set(m);
				// d.c(this.a).set(k);
				// }
			}
		}).start();
	}

	private void a(File paramFile) {
		for (int i = this.d.get(); i + 1 > this.f; i = this.d.addAndGet(-1)) {
			long l4 = b();
			this.c.addAndGet(-l4);
		}
		this.d.addAndGet(1);
		long l1 = b(paramFile);
		long l3;
		for (long l2 = this.c.get(); l2 + l1 > this.e; l2 = this.c
				.addAndGet(-l3)) {
			l3 = b();
		}
		this.c.addAndGet(l1);
		Long localLong = Long.valueOf(System.currentTimeMillis());
		paramFile.setLastModified(localLong.longValue());
		this.g.put(paramFile, localLong);
	}

	private long b() {
		return 0L;
		// abcdefg
		// Object localObject1 = null;
		// long l;
		// if (this.g.isEmpty()) {
		// l = 0L;
		// return l;
		// }
		// Set localSet = this.g.entrySet();
		// for (;;) {
		// synchronized (this.g) {
		// Iterator localIterator = localSet.iterator();
		// localObject3 = null;
		// if (localIterator.hasNext()) {
		// Map.Entry localEntry = (Map.Entry) localIterator.next();
		// if (localObject1 == null) {
		// localObject4 = (File) localEntry.getKey();
		// localObject5 = (Long) localEntry.getValue();
		// break label194;
		// }
		// Long localLong = (Long) localEntry.getValue();
		// if (localLong.longValue() < localObject3.longValue()) {
		// File localFile = (File) localEntry.getKey();
		// localObject5 = localLong;
		// localObject4 = localFile;
		// break label194;
		// }
		// } else {
		// l = b((File) localObject1);
		// if (!((File) localObject1).delete()) {
		// break;
		// }
		// this.g.remove(localObject1);
		// return l;
		// }
		// }
		// Object localObject4 = localObject1;
		// Object localObject5 = localObject3;
		// label194: localObject1 = localObject4;
		// Object localObject3 = localObject5;
		// }
	}

	private long b(File paramFile) {
		return paramFile.length();
	}

	private File b(String paramString) {
		return new File(this.a, paramString.hashCode() + "");
	}

	boolean c(String paramString) {
		return a(paramString).delete();
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.yrz.atourong.d.d
 * 
 * JD-Core Version: 0.7.0.1
 */