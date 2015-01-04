package com.zzz.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
//import com.zfl.webapp.net.tsz.afinal.FinalBitmap;
//import com.zfl.webapp.util.SharedPClass;

import java.util.List;

public class GuildAdapter extends PagerAdapter {
	private Context _context;
	private List<IndexObject> _dataSource;
	// private FinalBitmap _finalMab;
	private List<View> _views;

	public GuildAdapter(Context paramContext, List<IndexObject> paramList,
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
		IndexObject localIndexObject = (IndexObject) this._dataSource
				.get(paramInt);
		ImageButton localImageButton = (ImageButton) localView
				.findViewById(R.id.imbt_temp1);
		localImageButton.setTag(Integer.valueOf(paramInt));
		localImageButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramAnonymousView) {
				if (paramAnonymousView.getTag().toString().equals("2")) {
					// if (SharedPClass.getParam("welcome",
					// (Activity)GuildAdapter.this._context).equals("1"))
					// {
					// new SharedPClass("times", "1",
					// (Activity)GuildAdapter.this._context);
					// Intent localIntent = new
					// Intent((Activity)GuildAdapter.this._context,
					// MainActivity.class);
					// ((Activity)GuildAdapter.this._context).startActivity(localIntent);
					// ((Activity)GuildAdapter.this._context).finish();
					// ((Activity)GuildAdapter.this._context).overridePendingTransition(2130968581,
					// 2130968578);
					// }
				} else {
					return;
				}
				// new SharedPClass("welcome", "1",
				// (Activity)GuildAdapter.this._context);
				((Activity) GuildAdapter.this._context).finish();
				((Activity) GuildAdapter.this._context)
						.overridePendingTransition(R.anim.top_down_activity, R.anim.no_change);
			}
		});
		// this._finalMab = FinalBitmap.create(this._context);
		// this._finalMab.configLoadingImage(localIndexObject.resId);
		// this._finalMab.display(localImageButton, localIndexObject.img);
		paramViewGroup.addView(localView);
		return localView;
	}

	public boolean isViewFromObject(View paramView, Object paramObject) {
		return paramView == paramObject;
	}
}
