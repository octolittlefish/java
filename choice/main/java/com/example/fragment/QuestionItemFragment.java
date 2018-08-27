package com.example.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.example.activity.MainActivity;
import com.example.adapter.OptionsListAdapter;
import com.example.bean.QuestionBean;
import com.example.listmultichoise.R;
import com.example.view.NoScrollListview;


public class QuestionItemFragment extends Fragment {
	QuestionBean questionBean;
	int index ;
	String string;
	private OptionsListAdapter adapter;
	private StringBuffer sb;
	private NoScrollListview lv;
	LocalBroadcastManager mLocalBroadcastManager;
	public QuestionItemFragment(int index){
		this.index = index;
		questionBean = MainActivity.questionlist.get(index);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 mLocalBroadcastManager = LocalBroadcastManager.getInstance(getActivity());
		View rootView = inflater.inflate(R.layout.pager_item,
				container, false);
		lv = (NoScrollListview) rootView.findViewById(R.id.lv_options);
		TextView tv_paper_name = (TextView) rootView.findViewById(R.id.tv_paper_name);
		TextView tv_sequence = (TextView) rootView.findViewById(R.id.tv_sequence);
		TextView tv_total_count = (TextView) rootView.findViewById(R.id.tv_total_count);
		TextView tv_description = (TextView) rootView.findViewById(R.id.tv_description);
//		Button btn_submit = (Button) rootView.findViewById(R.id.btn_submit);
		adapter = new OptionsListAdapter(getActivity(), questionBean.getQuestionOptions(),lv,index);
		lv.setAdapter(adapter);
		//TODO 展开listvie所有子条目使用了自定义Listview，下面的方法有问题
		//setListViewHeightBasedOnChildren(lv);
		
	 
		tv_paper_name.setText("体质检测");
		tv_sequence.setText((index+1)+"");
		tv_total_count.setText("/"+MainActivity.questionlist.size());
		
		tv_description.setText(questionBean.getDescription());
		
		//题干描述前面加上(单选题)或(多选题)
		//判断是单选还是多选
		int questionType = questionBean.getQuestionType();
		sb = new StringBuffer();
		if(questionType == 1){//单选
			SpannableStringBuilder ssb = new SpannableStringBuilder("(单选题)");  
			ssb.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			ssb.append(questionBean.getDescription());
			tv_description.setText(ssb);
			lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
			lv.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position,
						long id) {
					adapter.notifyDataSetChanged();
					//TODO 单选题选中后自动跳转到下一页
					long check[] =lv.getCheckedItemIds();
					string = questionBean.getQuestionOptions().get((int)check[0]).getName();
					sb.append(string);
//					Toast.makeText(getActivity(), "选中的选项为"+sb.toString(), Toast.LENGTH_SHORT).show();
					MainActivity.results[index]=Integer.parseInt(string);
					sb.setLength(0);
					 Intent intent = new Intent("com.leyikao.jumptonext");
	                    mLocalBroadcastManager.sendBroadcast(intent);

				} 
			});
//			btn_submit.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View v) {
//					long[] ids = lv.getCheckedItemIds();
//					for (int i = 0; i < ids.length; i++) {
//						long id = ids[i];
//						sb.append(questionBean.getQuestionOptions().get((int)id).getName()).append(" ");
//					}
//					Toast.makeText(getActivity(), "选中的选项为"+sb.toString(), Toast.LENGTH_SHORT).show();
//					sb.setLength(0);
//				}
//			});
		}

		return rootView;
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

}