package com.a.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

class d
  extends HttpEntityWrapper
{
  public d(HttpEntity paramHttpEntity)
  {
    super(paramHttpEntity);
  }
  
  public InputStream getContent() throws IOException
  {
    return new GZIPInputStream(this.wrappedEntity.getContent());
  }
  
  public long getContentLength()
  {
    return -1L;
  }
}


/* Location:           C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name:     com.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */