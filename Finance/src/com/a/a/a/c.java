package com.a.a.a;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

class c implements HttpResponseInterceptor {
	c(a parama) {
	}

	public void process(HttpResponse paramHttpResponse,
			HttpContext paramHttpContext) {
		HttpEntity localHttpEntity = paramHttpResponse.getEntity();
		if (localHttpEntity == null) {
			return;
		}
		for (;;) {

			Header localHeader = localHttpEntity.getContentEncoding();
			if (localHeader != null) {
				HeaderElement[] arrayOfHeaderElement = localHeader
						.getElements();
				int i = arrayOfHeaderElement.length;
				for (int j = 0; j < i; j++) {
					if (arrayOfHeaderElement[j].getName().equalsIgnoreCase(
							"gzip")) {
						paramHttpResponse.setEntity(new d(paramHttpResponse
								.getEntity()));
						return;
					}
				}
			}
		}
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.a.a.a.c
 * 
 * JD-Core Version: 0.7.0.1
 */