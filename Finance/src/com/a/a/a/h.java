package com.a.a.a;

import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class h extends f {
	private static String[] b = { "image/jpeg", "image/png" };

	public void a(int paramInt, byte[] paramArrayOfByte) {
		a(paramArrayOfByte);
	}

	protected void a(Message paramMessage) {
		super.a(paramMessage);
		switch (paramMessage.what) {
		case 0:
			Object[] arrayOfObject2 = (Object[]) paramMessage.obj;
			c(((Integer) arrayOfObject2[0]).intValue(),
					(byte[]) arrayOfObject2[1]);
			return;
		}
		Object[] arrayOfObject1 = (Object[]) paramMessage.obj;
		c((Throwable) arrayOfObject1[0], (String) arrayOfObject1[1]);
	}

	protected void a(Throwable paramThrowable, byte[] paramArrayOfByte) {
		b(a(1, new Object[] { paramThrowable, paramArrayOfByte }));
	}

	void a(HttpResponse paramHttpResponse) {
		int i = 0;
		StatusLine localStatusLine = paramHttpResponse.getStatusLine();
		Header[] arrayOfHeader = paramHttpResponse.getHeaders("Content-Type");
		if (arrayOfHeader.length != 1) {
			a(new HttpResponseException(localStatusLine.getStatusCode(),
					"None, or more than one, Content-Type Header found!"), "");
			return;
		}
		Header localHeader = arrayOfHeader[0];
		String[] arrayOfString = b;
		int j = arrayOfString.length;
		for (int k = 0; k < j; k++) {
			if (arrayOfString[k].equals(localHeader.getValue().toLowerCase())) {
				i = 1;
			}
		}
		if (i == 0) {
			a(new HttpResponseException(localStatusLine.getStatusCode(),
					"Content-Type not allowed!"), "");
			return;
		}

		byte[] arrayOfByte2 = null;
		try {
			HttpEntity localHttpEntity = paramHttpResponse.getEntity();
			BufferedHttpEntity localBufferedHttpEntity = null;
			if (localHttpEntity != null) {
				localBufferedHttpEntity = new BufferedHttpEntity(
						localHttpEntity);
				arrayOfByte2 = EntityUtils.toByteArray(localBufferedHttpEntity);
			}

		} catch (IOException localIOException) {
			a(localIOException, (byte[]) null);
			byte[] arrayOfByte1 = null;
			b(localStatusLine.getStatusCode(), arrayOfByte1);
			return;
		}
		if (localStatusLine.getStatusCode() >= 300) {
			a(new HttpResponseException(localStatusLine.getStatusCode(),
					localStatusLine.getReasonPhrase()), arrayOfByte2);
			return;
		}

	}

	public void a(byte[] paramArrayOfByte) {
	}

	protected void b(int paramInt, byte[] paramArrayOfByte) {
		Object[] arrayOfObject = new Object[2];
		arrayOfObject[0] = Integer.valueOf(paramInt);
		arrayOfObject[1] = paramArrayOfByte;
		b(a(0, arrayOfObject));
	}

	protected void c(int paramInt, byte[] paramArrayOfByte) {
		a(paramInt, paramArrayOfByte);
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.a.a.a.h
 * 
 * JD-Core Version: 0.7.0.1
 */