package com.zzz.f;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//import com.zfl.webapp.net.http;
//import com.zfl.webapp.net.https;
//import com.XListView;
//import com.XListView.IXListViewListener;
//import com.zfl.webapp.util.SharedPClass;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IssuingFragment extends Fragment implements
		XListView.IXListViewListener {
	private ClientTalkAdapter clientTalkAdapter;
	private String finaceData = "0";
	LayoutInflater inflater;
	private XListView listView;
	private int pageNum = 1;
	private int pageOld = 0;
	View view;

	private void freshData() {
		this.pageOld = 0;
		this.pageNum = 1;
		this.finaceData = "0";
		toGetListData();
	}

	private void initData() {
		freshData();
	}

	private void initView() {
		this.listView.setPullLoadEnable(true);
		this.listView.setXListViewListener(this);
		this.clientTalkAdapter = new ClientTalkAdapter(getActivity());
		this.listView.setAdapter(this.clientTalkAdapter);
		this.listView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					public void onItemClick(
							AdapterView<?> paramAnonymousAdapterView,
							View paramAnonymousView, int paramAnonymousInt,
							long paramAnonymousLong) {
						System.out.println("IssuingFragment: IssuingDeailActivity");
//						Intent localIntent = new Intent(IssuingFragment.this
//								.getActivity(), IssuingDeailActivity.class);
//						FinanceActivity.listMapA = new HashMap();
//						FinanceActivity.listMapA = (Map) FinanceActivity.listDataA
//								.get(paramAnonymousInt - 1);
//						IssuingFragment.this.getActivity().startActivity(
//								localIntent);
//						IssuingFragment.this.getActivity()
//								.overridePendingTransition(2130968579,
//										2130968576);
					}
				});
		if (this.pageNum > 1) {
			this.listView.setStackFromBottom(true);
			return;
		}
		this.listView.setStackFromBottom(false);
	}

	private void onLoad() {
		this.listView.stopRefresh();
		this.listView.stopLoadMore();
		this.listView.setRefreshTime("鍒氬垰");
	}

	@SuppressLint({ "HandlerLeak" })
	private void toGetListData() {
		final Handler local2 = new Handler() {
			public void handleMessage(Message paramAnonymousMessage) {
				if (paramAnonymousMessage.what == 1) {
					IssuingFragment.this.pageOld = IssuingFragment.this.pageNum;
					new SharedPClass("freshlist", "2",
							IssuingFragment.this.getActivity());
					IssuingFragment.this.initView();
				}
				IssuingFragment.this.onLoad();
			}
		};
		final ProgressDialog localProgressDialog = ProgressDialog.show(
				getActivity(), "", "Loading...", false);
		localProgressDialog.setCancelable(false);
		// new Thread()
		// {
		// public void run()
		// {
		// Message localMessage = new Message();
		// localMessage.what = 0;
		// for (;;)
		// {
		// try
		// {
		// Looper.prepare();
		// String str1 = https.url37;
		// HashMap localHashMap1 = new HashMap();
		// localHashMap1.put("page",
		// String.valueOf(IssuingFragment.this.pageNum));
		// http.getHttpClient();
		// str2 = http.doGet(str1, localHashMap1);
		// System.out.println(str1 + "  " + localHashMap1.toString());
		// if (!str2.equals("0"))
		// {
		// if (IssuingFragment.this.finaceData.equals("0"))
		// {
		// IssuingFragment.this.finaceData = str2;
		// new SharedPClass("finaceDataA", IssuingFragment.this.finaceData,
		// IssuingFragment.this.getActivity());
		// }
		// localArrayList = new ArrayList();
		// }
		// }
		// catch (Exception localException)
		// {
		// String str2;
		// ArrayList localArrayList;
		// JSONArray localJSONArray;
		// int i;
		// JSONObject localJSONObject;
		// HashMap localHashMap2;
		// localException.printStackTrace();
		// localProgressDialog.dismiss();
		// continue;
		// }
		// finally
		// {
		// localProgressDialog.dismiss();
		// }
		// try
		// {
		// localJSONArray = new JSONArray(str2);
		// i = 0;
		// }
		// catch (JSONException localJSONException1)
		// {
		// localJSONException1.printStackTrace();
		// continue;
		// }
		// try
		// {
		// if (i >= localJSONArray.length())
		// {
		// if (IssuingFragment.this.pageNum != 1) {
		// break label597;
		// }
		// FinanceActivity.listDataA.clear();
		// FinanceActivity.listDataA = localArrayList;
		// localMessage.what = 1;
		// localProgressDialog.dismiss();
		// local2.sendMessage(localMessage);
		// Looper.loop();
		// return;
		// }
		// localJSONObject = localJSONArray.getJSONObject(i);
		// localHashMap2 = new HashMap();
		// localHashMap2.put("id", localJSONObject.getString("id"));
		// localHashMap2.put("borrow_id",
		// localJSONObject.getString("borrow_id"));
		// localHashMap2.put("pro_provide_id",
		// localJSONObject.getString("pro_provide_id"));
		// localHashMap2.put("borrow_name",
		// localJSONObject.getString("trans_name"));
		// localHashMap2.put("has_borrow",
		// localJSONObject.getString("has_borrow"));
		// localHashMap2.put("bi_count", localJSONObject.getString("count"));
		// localHashMap2.put("borrow_info",
		// localJSONObject.getString("borrow_info"));
		// localHashMap2.put("pro_provide",
		// localJSONObject.getString("pro_provide"));
		// localHashMap2.put("borrow_min",
		// localJSONObject.getString("borrow_min"));
		// localHashMap2.put("borrow_money",
		// localJSONObject.getString("trans_money"));
		// localHashMap2.put("borrow_duration",
		// localJSONObject.getString("trans_duration"));
		// localHashMap2.put("borrow_interest_rate",
		// localJSONObject.getString("trans_interest_rate"));
		// localHashMap2.put("progress", localJSONObject.getString("progress"));
		// localHashMap2.put("first_verify_time",
		// localJSONObject.getString("first_verify_time"));
		// localArrayList.add(localHashMap2);
		// FinanceActivity.listDataA.add(localHashMap2);
		// i++;
		// continue;
		// }
		// catch (JSONException localJSONException2)
		// {
		// continue;
		// j = 0;
		// continue;
		// }
		// if (j < localArrayList.size())
		// {
		// FinanceActivity.listDataA.add((Map)localArrayList.get(j));
		// j++;
		// }
		// }
		// }
		// }.start();
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
	}

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		this.inflater = paramLayoutInflater;
		this.view = paramLayoutInflater.inflate(2130903094, paramViewGroup,
				false);
		this.listView = ((XListView) this.view.findViewById(16908298));
		initData();
		return this.view;
	}

	@SuppressLint({ "HandlerLeak" })
	public void onLoadMore() {
		this.pageNum = (1 + FinanceActivity.listDataA.size() / 6);
		if (this.pageNum == this.pageOld) {
			Toast.makeText(getActivity(), "宸茬粡鍔犺浇瀹屾墍鏈夋暟鎹�", 0).show();
			return;
		}
		toGetListData();
	}

	@SuppressLint({ "HandlerLeak" })
	public void onRefresh() {
		freshData();
	}

	private class ClientTalkAdapter extends BaseAdapter {
		public ClientTalkAdapter(Context paramContext) {
		}

		public int getCount() {
			return FinanceActivity.listDataA.size();
		}

		public Object getItem(int paramInt) {
			if (FinanceActivity.listDataA == null) {
				return null;
			}
			return (Map) FinanceActivity.listDataA.get(paramInt);
		}

		public long getItemId(int paramInt) {
			return 0L;
		}

		public View getView(int paramInt, View paramView,
				ViewGroup paramViewGroup) {
			ClientTalkViewHolder localClientTalkViewHolder;
			String str1;
			if (paramView == null) {
				paramView = IssuingFragment.this.inflater.inflate(2130903071,
						paramViewGroup, false);
				localClientTalkViewHolder = new ClientTalkViewHolder();
				localClientTalkViewHolder.tx_temp11 = ((TextView) paramView
						.findViewById(2131296267));
				localClientTalkViewHolder.tx_temp1 = ((TextView) paramView
						.findViewById(2131296258));
				localClientTalkViewHolder.tx_temp2 = ((TextView) paramView
						.findViewById(2131296259));
				localClientTalkViewHolder.tx_temp3 = ((TextView) paramView
						.findViewById(2131296260));
				localClientTalkViewHolder.tx_temp4 = ((TextView) paramView
						.findViewById(2131296261));
				localClientTalkViewHolder.tx_temp5 = ((TextView) paramView
						.findViewById(2131296262));
				localClientTalkViewHolder.im_temp1 = ((ImageView) paramView
						.findViewById(2131296277));
				paramView.setTag(localClientTalkViewHolder);
				str1 = ((Map) FinanceActivity.listDataA.get(paramInt)).get(
						"borrow_name").toString();
				if (!str1.contains("鏈堢泩鍒�")) {
					if (str1.contains("骞村瓨瀹�")) {
						String str2 = str1.substring(3, str1.length());
						String str3 = "<font color='#50f01e'>骞村瓨瀹�</font>"
								+ str2;
						localClientTalkViewHolder.tx_temp1.setText(Html
								.fromHtml(str3));
					} else {
						localClientTalkViewHolder.tx_temp1.setText(str1);
					}
					String str4 = str1.substring(3, str1.length());
					String str5 = "<font color='#E5A81B'>鏈堢泩鍒�</font>" + str4;
					localClientTalkViewHolder.tx_temp1.setText(Html
							.fromHtml(str5));
				}

				localClientTalkViewHolder.tx_temp11.setText("涓湀");
				localClientTalkViewHolder.tx_temp2
						.setText(((Map) FinanceActivity.listDataA.get(paramInt))
								.get("borrow_interest_rate").toString());
				localClientTalkViewHolder.tx_temp3
						.setText(((Map) FinanceActivity.listDataA.get(paramInt))
								.get("borrow_duration").toString());
				localClientTalkViewHolder.tx_temp4
						.setText(((Map) FinanceActivity.listDataA.get(paramInt))
								.get("borrow_min").toString());
				localClientTalkViewHolder.tx_temp5
						.setText(((Map) FinanceActivity.listDataA.get(paramInt))
								.get("progress").toString());
				if (System.currentTimeMillis() >= 1000L * Long.valueOf(
						((Map) FinanceActivity.listDataA.get(paramInt)).get(
								"first_verify_time").toString()).longValue()) {
					if (Float.valueOf(
							((Map) FinanceActivity.listDataA.get(paramInt))
									.get("progress").toString()).floatValue() < 100.0F) {
						localClientTalkViewHolder.im_temp1
								.setImageDrawable(IssuingFragment.this
										.getResources().getDrawable(2130837648));
						return paramView;
					}
					localClientTalkViewHolder.im_temp1
							.setImageDrawable(IssuingFragment.this
									.getResources().getDrawable(2130837649));
					return paramView;
				}
				localClientTalkViewHolder.im_temp1
						.setImageDrawable(IssuingFragment.this.getResources()
								.getDrawable(2130837647));

				localClientTalkViewHolder = (ClientTalkViewHolder) paramView
						.getTag();

			}
			return paramView;
		}

		private class ClientTalkViewHolder {
			ImageView im_temp1;
			TextView tx_temp1;
			TextView tx_temp11;
			TextView tx_temp2;
			TextView tx_temp3;
			TextView tx_temp4;
			TextView tx_temp5;

			private ClientTalkViewHolder() {
			}
		}
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name: com.zfl.webapp.view.finance.IssuingFragment JD-Core Version:
 * 0.7.1
 */