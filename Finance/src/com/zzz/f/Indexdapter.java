package com.zzz.f;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

//import com.zfl.webapp.net.https;
//import com.zfl.webapp.net.tsz.afinal.FinalBitmap;
//import com.zfl.webapp.view.more.HtmlActivity;
import java.util.List;

import net.tsz.afinal.FinalBitmap;

public class Indexdapter extends PagerAdapter {
	private Context _context;
	private List<IndexObject> _dataSource;
	private FinalBitmap _finalMab;
	private List<View> _views;

	public Indexdapter(Context paramContext, List<IndexObject> paramList,
			List<View> paramList1) {
		this._context = paramContext;
		this._dataSource = paramList;
		this._views = paramList1;
	}

	public void destroyItem(ViewGroup paramViewGroup, int paramInt,
			Object paramObject) {
		paramViewGroup.removeView((View) this._views.get(paramInt));
	}

	public int getCount() {
		try {
			int i = this._views.size();
			return i;
		} catch (Exception localException) {
		}
		return 0;
	}

	public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
		View localView = (View) this._views.get(paramInt);
		final IndexObject localIndexObject = (IndexObject) this._dataSource
				.get(paramInt);
		if (!localIndexObject.img.equals("0")) {
			ImageButton localImageButton = (ImageButton) localView
					.findViewById(2131296287);
			localImageButton.setTag(Integer.valueOf(paramInt));
			localImageButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View paramAnonymousView) {
					// Intent localIntent = new
					// Intent(Indexdapter.this._context, HtmlActivity.class);
					// localIntent.putExtra("webUrl", https.url +
					// localIndexObject.url);
					// localIntent.putExtra("title", "活动中心");
					// localIntent.putExtra("info", localIndexObject.info);
					// Indexdapter.this._context.startActivity(localIntent);
					// ((Activity)Indexdapter.this._context).overridePendingTransition(2130968581,
					// 2130968578);
				}
			});
			 this._finalMab = FinalBitmap.create(this._context);
			 this._finalMab.configLoadingImage(localIndexObject.resId);
			 this._finalMab.display(localImageButton, localIndexObject.img);
		}
		paramViewGroup.addView(localView);
		return localView;
	}

	public boolean isViewFromObject(View paramView, Object paramObject) {
		return paramView == paramObject;
	}
}
