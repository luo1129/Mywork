package com.zzz.f;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.webkit.WebView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
//import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXTextObject;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.Util;

public class MyMethod {
	private static final String division = "&";
	private static final String equalSign = "=";

	private static String buildTransaction(String paramString) {
		if (paramString == null) {
			return String.valueOf(System.currentTimeMillis());
		}
		return paramString + System.currentTimeMillis();
	}

	public static String getValue(String paramString1, String paramString2,
			String paramString3) {
		if ((paramString1 == null) || (paramString2 == null)
				|| ("".equals(paramString1.trim()))
				|| ("".equals(paramString2.trim()))) {
			return paramString3;
		}
		if (paramString1.contains(paramString2 + "=")) {
			paramString3 = paramString1.substring(
					paramString1.indexOf(paramString2) + paramString2.length()
							+ "=".length(), paramString1.length());
			if (paramString3.contains("&")) {
				paramString3 = paramString3.substring(0,
						paramString3.indexOf("&"));
			}
		}
		return paramString3;
	}

	public static void initImageLoader(Context paramContext) {
		ImageLoaderConfiguration localImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(
				paramContext).threadPriority(3)
				.denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.discCacheFileCount(150)
				.tasksProcessingOrder(QueueProcessingType.LIFO).build();
		ImageLoader.getInstance().init(localImageLoaderConfiguration);
	}

	public static DisplayImageOptions initImgOption(Context paramContext,
			int paramInt1, int paramInt2) {
		DisplayImageOptions.Builder localBuilder1 = new DisplayImageOptions.Builder();
		DisplayImageOptions.Builder localBuilder2;
		if (paramInt1 != 0) {
			localBuilder2 = localBuilder1.showStubImage(paramInt1);
			if (paramInt2 == 0) {
				// break label51;
			}
			for (;;) {
				paramInt1 = 2130837546;
				label51: paramInt2 = 2130837546;
				return localBuilder2.showImageForEmptyUri(paramInt2)
						.cacheInMemory().cacheOnDisc()
						.imageScaleType(ImageScaleType.NONE).build();

			}
		}
		
		return null;

	}

	public static void lockInit(Context paramContext, WebView paramWebView) {
//		ShareUtil localShareUtil = new ShareUtil(paramContext);
//		String str1 = localShareUtil.getString("CurrentUser", "");
//		boolean bool1 = localShareUtil.getBoolean("islaunchoff:" + str1, false);
//		String str2 = localShareUtil.getString("pwd:" + str1, null);
//		boolean bool2 = false;
//		if (str2 != null) {
//			bool2 = true;
//		}
//		paramWebView.loadUrl("javascript:lockInit('" + bool1 + "','" + bool2
//				+ "');");
	}

	public static void removeSession(Context paramContext) {
//		CookieSyncManager.createInstance(paramContext);
//		CookieManager localCookieManager = CookieManager.getInstance();
//		localCookieManager.setAcceptCookie(true);
//		localCookieManager.removeSessionCookie();
//		ShareUtil localShareUtil = new ShareUtil(paramContext);
//		localShareUtil.delString("islaunchoff:"
//				+ localShareUtil.getString("CurrentUser", ""));
//		localShareUtil.delString("pwd:"
//				+ localShareUtil.getString("CurrentUser", ""));
//		localShareUtil.delString("CurrentUser");
	}

	public static void sendTxt(IWXAPI paramIWXAPI, String paramString,
			int paramInt) {
		WXTextObject localWXTextObject = new WXTextObject();
		localWXTextObject.text = paramString;
		WXMediaMessage localWXMediaMessage = new WXMediaMessage();
		localWXMediaMessage.mediaObject = localWXTextObject;
		localWXMediaMessage.description = paramString;
		SendMessageToWX.Req localReq = new SendMessageToWX.Req();
		localReq.transaction = buildTransaction("text");
		localReq.message = localWXMediaMessage;
		localReq.scene = paramInt;
		paramIWXAPI.sendReq(localReq);
	}

	public static void sendWebPage(Context paramContext, IWXAPI paramIWXAPI,
			int paramInt, String paramString1, String paramString2,
			String paramString3) {
		WXWebpageObject localWXWebpageObject = new WXWebpageObject();
		localWXWebpageObject.webpageUrl = paramString1;
		WXMediaMessage localWXMediaMessage = new WXMediaMessage(
				localWXWebpageObject);
		localWXMediaMessage.title = paramString2;
		localWXMediaMessage.description = paramString3;
		localWXMediaMessage.thumbData = Util.bmpToByteArray(BitmapFactory
				.decodeResource(paramContext.getResources(), 2130837672), true);
		SendMessageToWX.Req localReq = new SendMessageToWX.Req();
		localReq.transaction = buildTransaction("webpage");
		localReq.message = localWXMediaMessage;
		localReq.scene = paramInt;
		paramIWXAPI.sendReq(localReq);
	}

	public static void shareMsg(Context paramContext, String paramString) {
		Intent localIntent = new Intent("android.intent.action.VIEW");
		localIntent.putExtra("sms_body", paramString);
		localIntent.setType("vnd.android-dir/mms-sms");
		paramContext.startActivity(localIntent);
	}

	public static void toHref(WebView paramWebView, String paramString) {
		paramWebView.loadUrl("javascript:window.location.href='" + paramString
				+ "'");
	}
}
