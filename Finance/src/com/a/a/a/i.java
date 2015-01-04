package com.a.a.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
//import com.yrz.atourong.d.r;
//import com.yrz.atourong.d.w;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class i extends f {
	public i() {
		this.a = null;
	}

	public static void a(final Activity paramActivity, final String paramString) {
		if (paramActivity != null) {
			paramActivity.runOnUiThread(new Runnable() {
				public void run() {
					Toast.makeText(paramActivity, paramString, 0).show();
				}
			});
		}
	}

	public i(FragmentActivity paramh) {
		super(paramh);
	}

	public void a(int paramInt, JSONArray paramJSONArray) {
		a(paramJSONArray);
	}

	public void a(int paramInt, JSONObject paramJSONObject) {
		// abcdefg
		// com.yrz.atourong.d.i.a.a();
		// if (this.a == null) {
		// a(paramJSONObject);
		// return;
		// }
		// String str3;
		// com.yrz.atourong.ui.a.h localh;
		// if (paramJSONObject != null) {
		// try {
		// if ((!paramJSONObject.has("boolen"))
		// || (!paramJSONObject.has("logined"))) {
		// break label159;
		// }
		// if (paramJSONObject.getString("boolen").equals("1")) {
		// a(paramJSONObject);
		// return;
		// }
		// } catch (JSONException localJSONException) {
		// localJSONException.printStackTrace();
		// return;
		// }
		// if (paramJSONObject.getString("logined").trim().equals("0")) {
		// w.L.d = false;
		// str3 = this.a.getIntent().getStringExtra("goClass");
		// localh = (com.yrz.atourong.ui.a.h) this.a;
		// if (str3 == null) {
		// break label238;
		// }
		// }
		// }
		// for (;;) {
		// r.a(localh, 104, str3);
		// return;
		// String str2 = paramJSONObject.getString("message");
		// if ("暂无数据,请登入".indexOf(str2) != -1) {
		// break;
		// }
		// al.a(this.a, str2);
		// return;
		// label159: if ((!paramJSONObject.has("message"))
		// || (!paramJSONObject.has("boolen"))) {
		// break;
		// }
		// String str1 = paramJSONObject.getString("message");
		// if ((paramJSONObject.getString("boolen").equals("1"))
		// || (str1 == null) || (str1.trim().equals(""))
		// || ("暂无数据,请登入".indexOf(str1) != -1)) {
		// break;
		// }
		// al.a(this.a, str1);
		// return;
		// label238: str3 = "";
		// }
	}

	protected void a(int paramInt, Header[] paramArrayOfHeader,
			Object paramObject) {
		if ((paramObject instanceof JSONObject)) {
			a(paramInt, paramArrayOfHeader, (JSONObject) paramObject);
			return;
		}
		if ((paramObject instanceof JSONArray)) {
			a(paramInt, paramArrayOfHeader, (JSONArray) paramObject);
			return;
		}
		a(new JSONException("Unexpected type "
				+ paramObject.getClass().getName()), (JSONObject) null);
	}

	public void a(int paramInt, Header[] paramArrayOfHeader,
			JSONArray paramJSONArray) {
		a(paramInt, paramJSONArray);
	}

	public void a(int paramInt, Header[] paramArrayOfHeader,
			JSONObject paramJSONObject) {
		a(paramInt, paramJSONObject);
	}

	protected void a(Message paramMessage) {
		Object[] arrayOfObject = (Object[]) paramMessage.obj;
		a(((Integer) arrayOfObject[0]).intValue(), (Header[]) arrayOfObject[1],
				arrayOfObject[2]);
		switch (paramMessage.what) {
		default:
			super.a(paramMessage);
			return;
		}

	}

	public void a(Throwable paramThrowable, JSONArray paramJSONArray) {
	}

	public void a(Throwable paramThrowable, JSONObject paramJSONObject) {
	}

	public void a(JSONArray paramJSONArray) {
	}

	public void a(JSONObject paramJSONObject) {
	}

	protected Object b(String paramString) throws JSONException {
		String str = paramString.trim();
		Object localObject;
		if (!str.startsWith("{")) {
			boolean bool = str.startsWith("[");
			localObject = null;
			if (!bool) {
			}
		} else {
			localObject = new JSONTokener(str).nextValue();
		}
		if (localObject == null) {
			return str;
		}
		return localObject;
	}

	protected void b(int paramInt, Header[] paramArrayOfHeader,
			String paramString) {
		if (paramInt != 204) {
			try {
				Object localObject = b(paramString);
				Object[] arrayOfObject2 = new Object[3];
				arrayOfObject2[0] = Integer.valueOf(paramInt);
				arrayOfObject2[1] = paramArrayOfHeader;
				arrayOfObject2[2] = localObject;
				b(a(100, arrayOfObject2));
				return;
			} catch (JSONException localJSONException) {
				b(localJSONException, paramString);
				return;
			}
		}
		Object[] arrayOfObject1 = new Object[2];
		arrayOfObject1[0] = Integer.valueOf(paramInt);
		arrayOfObject1[1] = new JSONObject();
		b(a(100, arrayOfObject1));
	}

	protected void c(Throwable paramThrowable, String paramString) {
		if (paramString != null) {
			try {
				Object localObject = b(paramString);
				if ((localObject instanceof JSONObject)) {
					a(paramThrowable, (JSONObject) localObject);
					return;
				}
				if ((localObject instanceof JSONArray)) {
					a(paramThrowable, (JSONArray) localObject);
					return;
				}
			} catch (JSONException localJSONException) {
				a(paramThrowable, new JSONObject());
				return;
			}
			a(paramThrowable, new JSONObject());
			return;
		}
		a(paramThrowable, new JSONObject());
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * 
 * Qualified Name: com.a.a.a.i
 * 
 * JD-Core Version: 0.7.0.1
 */