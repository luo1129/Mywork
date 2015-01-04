package com.a.a.a;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

class e implements Runnable {
	private final AbstractHttpClient a;
	private final HttpContext b;
	private final HttpUriRequest c;
	private final f d;
	private boolean e;
	private int f;

	public e(AbstractHttpClient paramAbstractHttpClient,
			HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest,
			f paramf) {
		this.a = paramAbstractHttpClient;
		this.b = paramHttpContext;
		this.c = paramHttpUriRequest;
		this.d = paramf;
		if ((paramf instanceof h)) {
			this.e = true;
		}
	}

	private void a() throws IOException {
		if (!Thread.currentThread().isInterrupted()) {
		}
		try {
			HttpResponse localHttpResponse = this.a.execute(this.c, this.b);
			if ((!Thread.currentThread().isInterrupted()) && (this.d != null)) {
				this.d.a(localHttpResponse);
			}
			return;
		} catch (IOException localIOException) {
			while (Thread.currentThread().isInterrupted()) {
			}
			throw localIOException;
		}
	}

	private void b() throws ConnectException {
		boolean bool = true;
		Object localObject = null;
		HttpRequestRetryHandler localHttpRequestRetryHandler = this.a
				.getHttpRequestRetryHandler();
		IOException localIOException2 = null;
		while (bool) {
			try {
				a();
				return;
			} catch (UnknownHostException localUnknownHostException) {
				while (this.d == null) {
				}
				this.d.b(localUnknownHostException, "can't resolve host");
				return;
			} catch (SocketException localSocketException) {
				while (this.d == null) {
				}
				this.d.b(localSocketException, "can't resolve host");
				return;
			} catch (SocketTimeoutException localSocketTimeoutException) {
				while (this.d == null) {
				}
				this.d.b(localSocketTimeoutException, "socket time out");
				return;
			} catch (IOException localIOException1) {
				int j = 1 + this.f;
				this.f = j;
				bool = localHttpRequestRetryHandler.retryRequest(
						localIOException1, j, this.b);
			} catch (NullPointerException localNullPointerException) {
				localIOException2 = new IOException("NPE in HttpClient"
						+ localNullPointerException.getMessage());
				int i = 1 + this.f;
				this.f = i;
				bool = localHttpRequestRetryHandler.retryRequest(
						localIOException2, i, this.b);
			}
		}
		ConnectException localConnectException = new ConnectException();
		localConnectException.initCause(localIOException2);
		throw localConnectException;
	}

	public void run() {
		try {
			if (this.d != null) {
				this.d.c();
			}
			b();
			if (this.d != null) {
				this.d.d();
			}
			return;
		} catch (IOException localIOException) {
			while (this.d == null) {
			}
			this.d.d();
			if (this.e) {
				this.d.a(localIOException, (byte[]) null);
				return;
			}
			this.d.b(localIOException, (String) null);
		}
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.a.a.a.e
 * 
 * JD-Core Version: 0.7.0.1
 */