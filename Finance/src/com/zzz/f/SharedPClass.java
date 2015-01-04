package com.zzz.f;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public class SharedPClass {
	public SharedPClass(String paramString1, String paramString2,
			Context paramContext) {
		paramContext.getSharedPreferences("userInfo", 0).edit()
				.putString(paramString1, paramString2).commit();
	}

	public static String getParam(String paramString, Context paramContext) {
		return paramContext.getSharedPreferences("userInfo", 0).getString(
				paramString, "0");
	}

	public static void lognOut(Context paramContext) {
		new SharedPClass("account_money", "0", paramContext);
		new SharedPClass("bank_address", "0", paramContext);
		new SharedPClass("bank_city", "0", paramContext);
		new SharedPClass("bank_name", "0", paramContext);
		new SharedPClass("bank_province", "0", paramContext);
		new SharedPClass("bankcard", "0", paramContext);
		new SharedPClass("banknum", "0", paramContext);
		new SharedPClass("capital", "0", paramContext);
		new SharedPClass("email", "0", paramContext);
		new SharedPClass("errmsg", "0", paramContext);
		new SharedPClass("idcard", "0", paramContext);
		new SharedPClass("phone", "0", paramContext);
		new SharedPClass("real_name", "0", paramContext);
		new SharedPClass("reg_time", "0", paramContext);
		new SharedPClass("scores", "0", paramContext);
		new SharedPClass("totalearn", "0", paramContext);
		new SharedPClass("uid", "0", paramContext);
		new SharedPClass("id_card", "0", paramContext);
		new SharedPClass("id_name", "0", paramContext);
	}

	public static void saveLognInfo(JSONObject paramJSONObject,
			Context paramContext) {
		try {
			new SharedPClass("account_money",
					paramJSONObject.getString("account_money"), paramContext);
			new SharedPClass("bank_address",
					paramJSONObject.getString("bank_address"), paramContext);
			new SharedPClass("bank_city",
					paramJSONObject.getString("bank_city"), paramContext);
			new SharedPClass("bank_name",
					paramJSONObject.getString("bank_name"), paramContext);
			new SharedPClass("bank_province",
					paramJSONObject.getString("bank_province"), paramContext);
			new SharedPClass("bankcard", paramJSONObject.getString("bankcard"),
					paramContext);
			new SharedPClass("banknum", paramJSONObject.getString("banknum"),
					paramContext);
			new SharedPClass("capital", paramJSONObject.getString("capital"),
					paramContext);
			new SharedPClass("email", paramJSONObject.getString("email"),
					paramContext);
			new SharedPClass("idcard", paramJSONObject.getString("idcard"),
					paramContext);
			new SharedPClass("phone", paramJSONObject.getString("phone"),
					paramContext);
			new SharedPClass("real_name",
					paramJSONObject.getString("real_name"), paramContext);
			new SharedPClass("reg_time", paramJSONObject.getString("reg_time"),
					paramContext);
			new SharedPClass("scores", paramJSONObject.getString("scores"),
					paramContext);
			new SharedPClass("totalearn",
					paramJSONObject.getString("totalearn"), paramContext);
			new SharedPClass("uid", paramJSONObject.getString("uid"),
					paramContext);
			new SharedPClass("id_card", paramJSONObject.getString("id_card"),
					paramContext);
			new SharedPClass("id_name", paramJSONObject.getString("id_name"),
					paramContext);
			new SharedPClass("errmsg", paramJSONObject.getString("errmsg"),
					paramContext);
			return;
		} catch (JSONException localJSONException) {
			localJSONException.printStackTrace();
		}
	}
}
