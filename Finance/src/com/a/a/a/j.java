package com.a.a.a;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class j {
	private static String d = "UTF-8";
	private static Charset e = Charset.forName(d);
	protected ConcurrentHashMap a;
	protected ConcurrentHashMap b;
	protected ConcurrentHashMap c;

	public j() {
		d();
	}

	private void d() {
		this.a = new ConcurrentHashMap();
		this.b = new ConcurrentHashMap();
		this.c = new ConcurrentHashMap();
	}

	public HttpEntity a() {
		// abcdefg
		// Object localObject;
		// if (!this.b.isEmpty()) {
		// localObject = new m();
		// Iterator localIterator1 = this.a.entrySet().iterator();
		// while (localIterator1.hasNext()) {
		// Map.Entry localEntry2 = (Map.Entry) localIterator1.next();
		// ((m) localObject).a((String) localEntry2.getKey(),
		// (String) localEntry2.getValue());
		// }
		// int i = -1 + this.b.entrySet().size();
		// Iterator localIterator2 = this.b.entrySet().iterator();
		// int j = 0;
		// if (!localIterator2.hasNext()) {
		// return localObject;
		// }
		// Map.Entry localEntry1 = (Map.Entry) localIterator2.next();
		// k localk = (k) localEntry1.getValue();
		// boolean bool;
		// if (localk.a != null) {
		// if (j != i) {
		// break label206;
		// }
		// bool = true;
		// label161: if (localk.c == null) {
		// break label212;
		// }
		// ((m) localObject).a((String) localEntry1.getKey(), localk.a(),
		// localk.a, localk.c, bool);
		// }
		// for (;;) {
		// j++;
		// break;
		// label206: bool = false;
		// break label161;
		// label212: ((m) localObject).a((String) localEntry1.getKey(),
		// localk.a(), localk.a, bool);
		// }
		// }
		// try {
		// localObject = new UrlEncodedFormEntity(b(), d);
		// label256:
		// } catch (UnsupportedEncodingException
		// localUnsupportedEncodingException) {
		// localUnsupportedEncodingException.printStackTrace();
		// }
		return null;
	}

	public void a(String paramString, k paramk) {
		if ((paramString != null) && (paramk != null)) {
			this.b.put(paramString, paramk);
		}
	}

	public void a(String paramString1, String paramString2) {
		if ((paramString1 != null) && (paramString2 != null)) {
			this.a.put(paramString1, paramString2);
		}
	}

	protected List b() {
		LinkedList localLinkedList = new LinkedList();
		Iterator localIterator1 = this.a.entrySet().iterator();
		while (localIterator1.hasNext()) {
			Map.Entry localEntry2 = (Map.Entry) localIterator1.next();
			localLinkedList.add(new BasicNameValuePair((String) localEntry2
					.getKey(), (String) localEntry2.getValue()));
		}
		Iterator localIterator2 = this.c.entrySet().iterator();
		while (localIterator2.hasNext()) {
			Map.Entry localEntry1 = (Map.Entry) localIterator2.next();
			Iterator localIterator3 = ((ArrayList) localEntry1.getValue())
					.iterator();
			while (localIterator3.hasNext()) {
				String str = (String) localIterator3.next();
				localLinkedList.add(new BasicNameValuePair((String) localEntry1
						.getKey(), str));
			}
		}
		return localLinkedList;
	}

	protected String c() {
		return URLEncodedUtils.format(b(), d);
	}

	public String toString() {
		StringBuilder localStringBuilder = new StringBuilder();
		Iterator localIterator1 = this.a.entrySet().iterator();
		while (localIterator1.hasNext()) {
			Map.Entry localEntry3 = (Map.Entry) localIterator1.next();
			if (localStringBuilder.length() > 0) {
				localStringBuilder.append("&");
			}
			localStringBuilder.append((String) localEntry3.getKey());
			localStringBuilder.append("=");
			localStringBuilder.append((String) localEntry3.getValue());
		}
		Iterator localIterator2 = this.b.entrySet().iterator();
		while (localIterator2.hasNext()) {
			Map.Entry localEntry2 = (Map.Entry) localIterator2.next();
			if (localStringBuilder.length() > 0) {
				localStringBuilder.append("&");
			}
			localStringBuilder.append((String) localEntry2.getKey());
			localStringBuilder.append("=");
			localStringBuilder.append("FILE");
		}
		Iterator localIterator3 = this.c.entrySet().iterator();
		while (localIterator3.hasNext()) {
			Map.Entry localEntry1 = (Map.Entry) localIterator3.next();
			if (localStringBuilder.length() > 0) {
				localStringBuilder.append("&");
			}
			ArrayList localArrayList = (ArrayList) localEntry1.getValue();
			for (int i = 0; i < localArrayList.size(); i++) {
				if (i != 0) {
					localStringBuilder.append("&");
				}
				localStringBuilder.append((String) localEntry1.getKey());
				localStringBuilder.append("=");
				localStringBuilder.append((String) localArrayList.get(i));
			}
		}
		return localStringBuilder.toString();
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.a.a.a.j
 * 
 * JD-Core Version: 0.7.0.1
 */