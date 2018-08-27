package com.example.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.activity.MainActivity;
import com.example.activity.ResultReportActivity;
import com.example.listmultichoise.R;
import com.example.view.NoScrollGridView;


public class ScantronItemFragment extends Fragment {
	LocalBroadcastManager mLocalBroadcastManager;
	public ScantronItemFragment() {

	}

	int count = MainActivity.questionlist.size();
	int[] mIds = new int[count];

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		initData();
		mLocalBroadcastManager = LocalBroadcastManager.getInstance(getActivity());
		View rootView = inflater.inflate(R.layout.pager_item_scantron,
				container, false);
		NoScrollGridView gv = (NoScrollGridView) rootView.findViewById(R.id.gridview);
		TextView tv_submit_result = (TextView) rootView.findViewById(R.id.tv_submit_result);
		tv_submit_result.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),ResultReportActivity.class);
				startActivity(intent);

			}
		});
		MyAdapter adapter = new MyAdapter(getActivity());
		gv.setAdapter(adapter);
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				// TODO跳转到相应的viewpager 页面
				Intent intent = new Intent("com.leyikao.jumptopage");
				intent.putExtra("index", position);
				mLocalBroadcastManager.sendBroadcast(intent);
			}
		});
		return rootView;

	}

	private void initData() {
		for (int i = 0; i < count; i++) {
			mIds[i] = i + 1;
		}
	}

	private class MyAdapter extends BaseAdapter {
		private Context mContext;

		public MyAdapter(Context context) {
			this.mContext = context;
		}

		@Override
		public int getCount() {
			return mIds.length;
		}

		@Override
		public Object getItem(int position) {
			return mIds[position];
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = new TextView(mContext);
			tv.setGravity(Gravity.CENTER);
			tv.setLayoutParams(new GridView.LayoutParams(100, 100));
			tv.setPadding(8, 8, 8, 8);

			tv.setText(mIds[position] + "");
			tv.setBackgroundResource(R.drawable.option_btn_single_normal);
			return tv;
		}

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

}