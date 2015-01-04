package com.a.a.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

@SuppressLint({ "HandlerLeak" })
public class f {
	protected FragmentActivity a;
	private Handler b;

	public f() {
		e();
	}

	public f(FragmentActivity paramh) {
		this.a = paramh;
		e();
	}

	private void e() {
		if (Looper.myLooper() != null) {
			this.b = new Handler() {
				public void handleMessage(Message paramMessage) {
					a(paramMessage);
				}
			};
		}
	}

	protected Message a(int paramInt, Object paramObject) {
		if (this.b != null) {
			return this.b.obtainMessage(paramInt, paramObject);
		}
		Message localMessage = Message.obtain();
		localMessage.what = paramInt;
		localMessage.obj = paramObject;
		return localMessage;
	}

	public void a() {
	}

	public void a(int paramInt, String paramString) {
		a(paramString);
	}

	public void a(int paramInt, Header[] paramArrayOfHeader, String paramString) {
		a(paramInt, paramString);
	}

	protected void a(Message paramMessage) {
		switch (paramMessage.what) {
		default:
			b();
			return;
		case 0:
			Object[] arrayOfObject2 = (Object[]) paramMessage.obj;
			c(((Integer) arrayOfObject2[0]).intValue(),
					(Header[]) arrayOfObject2[1], (String) arrayOfObject2[2]);
			return;
		case 1:
			Object[] arrayOfObject1 = (Object[]) paramMessage.obj;
			c((Throwable) arrayOfObject1[0], (String) arrayOfObject1[1]);
			return;
		case 2:
			a();
			return;
		}

	}

	public void a(String paramString) {
	}

	@Deprecated
	public void a(Throwable paramThrowable) {
	}

	public void a(Throwable paramThrowable, String paramString) {
		a(paramThrowable);
	}

	protected void a(Throwable paramThrowable, byte[] paramArrayOfByte) {
		b(a(1, new Object[] { paramThrowable, paramArrayOfByte }));
	}

	void a(HttpResponse paramHttpResponse) {
		StatusLine localStatusLine = paramHttpResponse.getStatusLine();
		String localObject = null;
		try {
			HttpEntity localHttpEntity = paramHttpResponse.getEntity();

			if (localHttpEntity != null) {
				String str = EntityUtils.toString(new BufferedHttpEntity(
						localHttpEntity), "UTF-8");
				localObject = str;
			}
		} catch (IOException localIOException) {

			b(localIOException, (String) null);
			localObject = null;

			b(localStatusLine.getStatusCode(),
					paramHttpResponse.getAllHeaders(), localObject);
		}
		if (localStatusLine.getStatusCode() >= 300) {
			b(new HttpResponseException(localStatusLine.getStatusCode(),
					localStatusLine.getReasonPhrase()), localObject);
			return;
		}
	}

	public void b() {
	}

	protected void b(int paramInt, Header[] paramArrayOfHeader,
			String paramString) {
		Object[] arrayOfObject = new Object[3];
		arrayOfObject[0] = Integer.valueOf(paramInt);
		arrayOfObject[1] = paramArrayOfHeader;
		arrayOfObject[2] = paramString;
		b(a(0, arrayOfObject));
	}

	protected void b(Message paramMessage) {
		if (this.b != null) {
			this.b.sendMessage(paramMessage);
			return;
		}
		a(paramMessage);
	}

	protected void b(Throwable paramThrowable, String paramString) {
		b(a(1, new Object[] { paramThrowable, paramString }));
	}

	protected void c() {
		b(a(2, (Object) null));
	}

	protected void c(int paramInt, Header[] paramArrayOfHeader,
			String paramString) {
		a(paramInt, paramArrayOfHeader, paramString);
	}

	protected void c(Throwable paramThrowable, String paramString) {
		a(paramThrowable, paramString);
	}

	protected void d() {
		b(a(3, (Object) null));
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.a.a.a.f
 * 
 * JD-Core Version: 0.7.0.1
 */