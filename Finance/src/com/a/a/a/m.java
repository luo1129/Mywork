package com.a.a.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class m implements HttpEntity {
	private static final char[] d = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
			.toCharArray();
	ByteArrayOutputStream a = new ByteArrayOutputStream();
	boolean b = false;
	boolean c = false;
	private String e = null;

	public m() {
		StringBuffer localStringBuffer = new StringBuffer();
		Random localRandom = new Random();
		int i = 0;
		while (i < 30) {
			localStringBuffer.append(d[localRandom.nextInt(d.length)]);
			i++;
		}
		this.e = localStringBuffer.toString();
	}

	public void a() {
		try {
			this.a.write(("--" + this.e + "\r\n").getBytes());
			return;
		} catch (IOException localIOException) {
			localIOException.printStackTrace();
		}
	}

	public void a(String paramString1, String paramString2) {
		a(paramString1, paramString2, "text/plain; charset=UTF-8");
	}

	public void a(String paramString1, String paramString2,
			InputStream paramInputStream, String paramString3,
			boolean paramBoolean) {
		a();
		try {
			String str = "Content-Type: " + paramString3 + "\r\n";
			this.a.write(("Content-Disposition: form-data; name=\""
					+ paramString1 + "\"; filename=\"" + paramString2 + "\"\r\n")
					.getBytes());
			this.a.write(str.getBytes());
			this.a.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());
			byte[] arrayOfByte = new byte[4096];
			for (;;) {
				int i = paramInputStream.read(arrayOfByte);
				if (i == -1) {
					break;
				}
				this.a.write(arrayOfByte, 0, i);
			}
			try {
				paramInputStream.close();

			} catch (IOException localIOException1) {
				for (;;) {
					localIOException1.printStackTrace();
				}
			}
		} catch (IOException localIOException2) {
			localIOException2 = localIOException2;
			localIOException2.printStackTrace();
			try {
				paramInputStream.close();
				return;
			} catch (IOException localIOException3) {
				localIOException3.printStackTrace();

			}

			try {
				this.a.write("\r\n".getBytes());
				paramInputStream.close();
				return;
			} catch (IOException localIOException4) {
				localIOException4.printStackTrace();
				return;
			}
		} finally {
		}
	}

	public void a(String paramString1, String paramString2,
			InputStream paramInputStream, boolean paramBoolean) {
		a(paramString1, paramString2, paramInputStream,
				"application/octet-stream", paramBoolean);
	}

	public void a(String paramString1, String paramString2, String paramString3) {
		a();
		try {
			this.a.write(("Content-Disposition: form-data; name=\""
					+ paramString1 + "\"\r\n").getBytes());
			this.a.write(("Content-Type: " + paramString3 + "\r\n\r\n")
					.getBytes());
			this.a.write(paramString2.getBytes());
			this.a.write("\r\n".getBytes());
			return;
		} catch (IOException localIOException) {
			localIOException.printStackTrace();
		}
	}

	public void b() {
		if (this.b) {
			return;
		}
		try {
			this.a.write(("--" + this.e + "--\r\n").getBytes());
			this.a.flush();
			this.b = true;
			return;
		} catch (IOException localIOException) {
			for (;;) {
				localIOException.printStackTrace();
			}
		}
	}

	public void consumeContent() {
		if (isStreaming()) {
			throw new UnsupportedOperationException(
					"Streaming entity does not implement #consumeContent()");
		}
	}

	public InputStream getContent() {
		b();
		return new ByteArrayInputStream(this.a.toByteArray());
	}

	public Header getContentEncoding() {
		return null;
	}

	public long getContentLength() {
		b();
		return this.a.toByteArray().length;
	}

	public Header getContentType() {
		return new BasicHeader("Content-Type", "multipart/form-data; boundary="
				+ this.e);
	}

	public boolean isChunked() {
		return false;
	}

	public boolean isRepeatable() {
		return false;
	}

	public boolean isStreaming() {
		return false;
	}

	public void writeTo(OutputStream paramOutputStream) throws IOException {
		b();
		paramOutputStream.write(this.a.toByteArray());
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.a.a.a.m
 * 
 * JD-Core Version: 0.7.0.1
 */