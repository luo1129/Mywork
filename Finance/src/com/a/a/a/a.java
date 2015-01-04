package com.a.a.a;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class a
{
  private static int a = 10;
  private static int b = 12000;
  private final DefaultHttpClient c;
  private final HttpContext d;
  private ThreadPoolExecutor e;
  private final Map f;
  private final Map g;
  
  public a()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, b);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(a));
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 10);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, b);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, b);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, "Atourong(Android 1.0)");
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    ThreadSafeClientConnManager localThreadSafeClientConnManager = new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry);
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
    this.d = new SyncBasicHttpContext(new BasicHttpContext());
    this.c = new DefaultHttpClient(localThreadSafeClientConnManager, localBasicHttpParams);
    this.c.addRequestInterceptor(new b(this));
    this.c.addResponseInterceptor(new c(this));
    this.c.setHttpRequestRetryHandler(new l(5));
    this.e = ((ThreadPoolExecutor)Executors.newCachedThreadPool());
    this.f = new WeakHashMap();
    this.g = new HashMap();
  }
  
  public static String a(String paramString, j paramj)
  {
    String str;
    if (paramj != null)
    {
      str = paramj.c();
      if (paramString.indexOf("?") == -1) {
        paramString = paramString + "?" + str;
      }
    }
    else
    {
      return paramString;
    }
    return paramString + "&" + str;
  }
  
  private HttpEntity a(j paramj)
  {
    HttpEntity localHttpEntity = null;
    if (paramj != null) {
      localHttpEntity = paramj.a();
    }
    return localHttpEntity;
  }
  
  private HttpEntityEnclosingRequestBase a(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, HttpEntity paramHttpEntity)
  {
    if (paramHttpEntity != null) {
      paramHttpEntityEnclosingRequestBase.setEntity(paramHttpEntity);
    }
    return paramHttpEntityEnclosingRequestBase;
  }
  
  public List a()
  {
    return this.c.getCookieStore().getCookies();
  }
  
  public void a(Context paramContext, String paramString, j paramj, f paramf)
  {
    a(this.c, this.d, new HttpGet(a(paramString, paramj)), null, paramf, paramContext);
  }
  
  public void a(Context paramContext, String paramString1, HttpEntity paramHttpEntity, String paramString2, f paramf)
  {
    a(this.c, this.d, a(new HttpPost(paramString1), paramHttpEntity), paramString2, paramf, paramContext);
  }
  
  public void a(String paramString, f paramf)
  {
    a(null, paramString, null, paramf);
  }
  
  public void a(String paramString, j paramj, f paramf)
  {
    b(null, paramString, paramj, paramf);
  }
  
  protected void a(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, f paramf, Context paramContext)
  {
    if (paramString != null) {
      paramHttpUriRequest.addHeader("Content-Type", paramString);
    }
    Future localFuture = this.e.submit(new e(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramf));
    if (paramContext != null)
    {
      Object localObject = (List)this.f.get(paramContext);
      if (localObject == null)
      {
        localObject = new LinkedList();
        this.f.put(paramContext, localObject);
      }
      ((List)localObject).add(new WeakReference(localFuture));
    }
  }
  
  public void b()
  {
    this.c.getCookieStore().clear();
  }
  
  public void b(Context paramContext, String paramString, j paramj, f paramf)
  {
    a(paramContext, paramString, a(paramj), null, paramf);
  }
}


/* Location:           C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name:     com.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */