package com.a.a.a;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class l implements HttpRequestRetryHandler {
	private static HashSet a = new HashSet();
	private static HashSet b = new HashSet();
	private final int c;

	static {
		a.add(NoHttpResponseException.class);
		a.add(UnknownHostException.class);
		a.add(SocketException.class);
		b.add(InterruptedIOException.class);
		b.add(SSLException.class);
	}

	public l(int paramInt) {
		this.c = paramInt;
	}

	protected boolean a(HashSet paramHashSet, Throwable paramThrowable) {
		Iterator localIterator = paramHashSet.iterator();
		while (localIterator.hasNext()) {
			if (((Class) localIterator.next()).isInstance(paramThrowable)) {
				return true;
			}
		}
		return false;
	}

	public boolean retryRequest(IOException paramIOException, int paramInt,
			HttpContext paramHttpContext) {
		return false;// abcdefg
		// boolean bool1 = true;
		// Boolean localBoolean = (Boolean) paramHttpContext
		// .getAttribute("http.request_sent");
		// boolean bool2;
		// boolean bool3;
		// if ((localBoolean != null) && (localBoolean.booleanValue())) {
		// bool2 = bool1;
		// if (paramInt <= this.c) {
		// break label93;
		// }
		// bool3 = false;
		// }
		// for (;;) {
		// label44: if (bool3) {
		// if (((HttpUriRequest) paramHttpContext
		// .getAttribute("http.request")).getMethod().equals(
		// "POST")) {
		// }
		// }
		// for (;;) {
		// if (bool1) {
		// SystemClock.sleep(1500L);
		// return bool1;
		// bool2 = false;
		// break;
		// label93: if (a(b, paramIOException)) {
		// bool3 = false;
		// break label44;
		// }
		// if (a(a, paramIOException)) {
		// bool3 = bool1;
		// break label44;
		// }
		// if (bool2) {
		// break label160;
		// }
		// bool3 = bool1;
		// break label44;
		// bool1 = false;
		// continue;
		// }
		// paramIOException.printStackTrace();
		// return bool1;
		// bool1 = bool3;
		// }
		// label160: bool3 = bool1;
		// }
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.a.a.a.l
 * 
 * JD-Core Version: 0.7.0.1
 */