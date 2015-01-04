package com.zzz.f;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Map;

public class TenderFragment extends Fragment implements
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
						System.out
								.println("TenderFragment: FinanceDeailActivity");
						// Intent localIntent = new
						// Intent(TenderFragment.this.getActivity(),
						// FinanceDeailActivity.class);
						// FinanceActivity.listMap = new HashMap();
						// FinanceActivity.listMap =
						// (Map)FinanceActivity.listData.get(paramAnonymousInt -
						// 1);
						// TenderFragment.this.getActivity().startActivity(localIntent);
						// TenderFragment.this.getActivity().overridePendingTransition(2130968579,
						// 2130968576);
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
		this.listView.setRefreshTime("刚刚");
	}

	@SuppressLint({ "HandlerLeak" })
	private void toGetListData() {
		final Handler local2 = new Handler() {
			public void handleMessage(Message paramAnonymousMessage) {
				if (paramAnonymousMessage.what == 1) {
					TenderFragment.this.pageOld = TenderFragment.this.pageNum;
					new SharedPClass("freshlist", "2",
							TenderFragment.this.getActivity());
					TenderFragment.this.initView();
				}
				TenderFragment.this.onLoad();
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
		// String str1 = https.url1;
		// HashMap localHashMap1 = new HashMap();
		// localHashMap1.put("page",
		// String.valueOf(TenderFragment.this.pageNum));
		// http.getHttpClient();
		// str2 = http.doGet(str1, localHashMap1);
		// System.out.println(str1 + "  " + localHashMap1.toString());
		// if (!str2.equals("0"))
		// {
		// if (TenderFragment.this.finaceData.equals("0"))
		// {
		// TenderFragment.this.finaceData = str2;
		// new SharedPClass("finaceData", TenderFragment.this.finaceData,
		// TenderFragment.this.getActivity());
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
		// if (TenderFragment.this.pageNum != 1) {
		// break label597;
		// }
		// FinanceActivity.listData.clear();
		// FinanceActivity.listData = localArrayList;
		// localMessage.what = 1;
		// localProgressDialog.dismiss();
		// local2.sendMessage(localMessage);
		// Looper.loop();
		// return;
		// }
		// localJSONObject = localJSONArray.getJSONObject(i);
		// localHashMap2 = new HashMap();
		// localHashMap2.put("id", localJSONObject.getString("id"));
		// localHashMap2.put("pro_provide_id",
		// localJSONObject.getString("pro_provide_id"));
		// localHashMap2.put("borrow_name",
		// localJSONObject.getString("borrow_name"));
		// localHashMap2.put("repayment_type",
		// localJSONObject.getString("repayment_type"));
		// localHashMap2.put("has_borrow",
		// localJSONObject.getString("has_borrow"));
		// localHashMap2.put("bi_count", localJSONObject.getString("bi_count"));
		// localHashMap2.put("borrow_info",
		// localJSONObject.getString("borrow_info"));
		// localHashMap2.put("pro_provide",
		// localJSONObject.getString("pro_provide"));
		// localHashMap2.put("borrow_min",
		// localJSONObject.getString("borrow_min"));
		// localHashMap2.put("borrow_money",
		// localJSONObject.getString("borrow_money"));
		// localHashMap2.put("borrow_duration",
		// localJSONObject.getString("borrow_duration"));
		// localHashMap2.put("borrow_interest_rate",
		// localJSONObject.getString("borrow_interest_rate"));
		// localHashMap2.put("progress", localJSONObject.getString("progress"));
		// localHashMap2.put("first_verify_time",
		// localJSONObject.getString("first_verify_time"));
		// localArrayList.add(localHashMap2);
		// FinanceActivity.listData.add(localHashMap2);
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
		// FinanceActivity.listData.add((Map)localArrayList.get(j));
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
		this.pageNum = (1 + FinanceActivity.listData.size() / 6);
		if (this.pageNum == this.pageOld) {
			Toast.makeText(getActivity(), "已经加载完所有数据", 0).show();
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
			return FinanceActivity.listData.size();
		}

		public Object getItem(int paramInt) {
			if (FinanceActivity.listData == null) {
				return null;
			}
			return (Map) FinanceActivity.listData.get(paramInt);
		}

		public long getItemId(int paramInt) {
			return 0L;
		}

		public View getView(int paramInt, View paramView,
				ViewGroup paramViewGroup) {
			ClientTalkViewHolder localClientTalkViewHolder;
			String str1;
			if (paramView == null) {
				paramView = TenderFragment.this.inflater.inflate(2130903071,
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
				str1 = ((Map) FinanceActivity.listData.get(paramInt)).get(
						"borrow_name").toString();
				if (!str1.contains("月盈利")) {
					if (str1.contains("年存宝")) {
						String str2 = str1.substring(3, str1.length());
						String str3 = "<font color='#50f01e'>年存宝</font>" + str2;
						localClientTalkViewHolder.tx_temp1.setText(Html
								.fromHtml(str3));
						if (Integer.valueOf(
								((Map) FinanceActivity.listData.get(paramInt))
										.get("repayment_type").toString())
								.intValue() != 1) {
							localClientTalkViewHolder.tx_temp11.setText("个月");
						}
						localClientTalkViewHolder.tx_temp11.setText("天");
					}
					localClientTalkViewHolder.tx_temp1.setText(str1);
					if (Integer.valueOf(
							((Map) FinanceActivity.listData.get(paramInt)).get(
									"repayment_type").toString()).intValue() != 1) {
						localClientTalkViewHolder.tx_temp11.setText("个月");
					}
					localClientTalkViewHolder.tx_temp11.setText("天");
				}
				String str4 = str1.substring(3, str1.length());
				String str5 = "<font color='#E5A81B'>月盈利</font>" + str4;
				localClientTalkViewHolder.tx_temp1.setText(Html.fromHtml(str5));

			}

			localClientTalkViewHolder = (ClientTalkViewHolder) paramView
					.getTag();

			localClientTalkViewHolder.tx_temp2
					.setText(((Map) FinanceActivity.listData.get(paramInt))
							.get("borrow_interest_rate").toString());
			localClientTalkViewHolder.tx_temp3
					.setText(((Map) FinanceActivity.listData.get(paramInt))
							.get("borrow_duration").toString());
			localClientTalkViewHolder.tx_temp4
					.setText(((Map) FinanceActivity.listData.get(paramInt))
							.get("borrow_min").toString());
			localClientTalkViewHolder.tx_temp5
					.setText(((Map) FinanceActivity.listData.get(paramInt))
							.get("progress").toString());
			if (System.currentTimeMillis() >= 1000L * Long.valueOf(
					((Map) FinanceActivity.listData.get(paramInt)).get(
							"first_verify_time").toString()).longValue()) {
				if (Float.valueOf(
						((Map) FinanceActivity.listData.get(paramInt)).get(
								"progress").toString()).floatValue() < 100.0F) {
					localClientTalkViewHolder.im_temp1
							.setImageDrawable(TenderFragment.this
									.getResources().getDrawable(2130837648));
					return paramView;
				}
				localClientTalkViewHolder.im_temp1
						.setImageDrawable(TenderFragment.this.getResources()
								.getDrawable(2130837649));
				return paramView;
			}
			localClientTalkViewHolder.im_temp1
					.setImageDrawable(TenderFragment.this.getResources()
							.getDrawable(2130837647));
			return paramView;
		}

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

/*
 * Location: C:\Users\Administrator\Desktop\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name: com.zfl.webapp.view.finance.TenderFragment JD-Core Version:
 * 0.7.1
 */