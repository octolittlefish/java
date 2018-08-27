package com.example.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

import com.example.adapter.ItemAdapter;
import com.example.bean.QuestionBean;
import com.example.bean.QuestionOptionBean;
import com.example.listmultichoise.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnClickListener {

	public static int[] results = new int[66];
	List<View> list = new ArrayList<View>();
	public static List<QuestionBean> questionlist = new ArrayList<QuestionBean>();
	public static QuestionBean question;
	public List<QuestionOptionBean> options1 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options2 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options3 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options4 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options5 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options6 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options7 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options8 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options9 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options10 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options11 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options12 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options13 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options14= new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options15 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options16 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options17 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options18 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options19 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options20 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options21 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options22 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options23 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options24 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options25 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options26 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options27 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options28 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options29 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options30 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options31 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options32 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options33 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options34 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options35 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options36 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options37 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options38 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options39 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options40 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options41 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options42 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options43 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options44 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options45 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options46 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options47 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options48 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options49 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options50 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options51 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options52 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options53 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options54 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options55 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options56 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options57 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options58 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options59 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options60 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options61 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options62 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options63 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options64 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options65 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options66 = new ArrayList<QuestionOptionBean>();
	public static QuestionOptionBean option;
	private ViewPager vp;
	private ItemAdapter pagerAdapter;
	View pager_item;
	public static int currentIndex = 0;
	private TextView tv_time;
	private TextView tv_share;
	private TextView tv_answercard;
	private TextView tv_back;
 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		loadData();
		

		Log.e("测试数据", questionlist.get(0).toString());
		Log.e("测试数据", questionlist.get(1).toString());
		
		tv_back = (TextView) findViewById(R.id.tv_back);
		tv_answercard = (TextView) findViewById(R.id.tv_answercard);
		tv_share = (TextView) findViewById(R.id.tv_share);
		tv_back.setOnClickListener(this); 
		tv_answercard.setOnClickListener(this);
		tv_share.setOnClickListener(this); 
		
		vp = (ViewPager) findViewById(R.id.vp);

		vp.setCurrentItem(0);
		pagerAdapter = new ItemAdapter(getSupportFragmentManager());
		vp.setAdapter(pagerAdapter);
		vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int position) {
				currentIndex = position;
			}
		});
		
		LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
		 IntentFilter filter = new IntentFilter();
		 filter.addAction("com.leyikao.jumptonext");
		 filter.addAction("com.leyikao.jumptopage");
		lbm.registerReceiver(mMessageReceiver, filter);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_back://点击头部返回
			
			break;
		case R.id.tv_answercard://点击头部答题卡
			
			jumpToPage(questionlist.size());
			
			break;
		case R.id.tv_share://点击头部分享
			
			break;			
		default:
			break;
		}
	}

	private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			 if (intent.getAction().equals("com.leyikao.jumptonext")) {
				 jumpToNext() ;
             } else if (intent.getAction().equals("com.leyikao.jumptopage")) {
            	 int index = intent.getIntExtra("index", 0);
            	 jumpToPage(index);
             }  
		}
	};
 
	public void jumpToNext() {
		int position = vp.getCurrentItem();
		vp.setCurrentItem(position + 1);
		 
	}
	public void jumpToPage(int index) {
		vp.setCurrentItem(index);
	}

	private void loadData() {
		// 初始化数据
		option = new QuestionOptionBean("1", "没有(根本不)");
		options1.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options1.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options1.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options1.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options1.add(option);
		question = new QuestionBean("0001", "您精力充沛吗？", 1, "体质检测", "001", options1);
		questionlist.add(question);

		// 初始化数据
		option = new QuestionOptionBean("5", "没有(根本不)");
		options2.add(option);
		option = new QuestionOptionBean("4", "很少(有一点)");
		options2.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options2.add(option);
		option = new QuestionOptionBean("2", "经常(相当)");
		options2.add(option);
		option = new QuestionOptionBean("1", "总是(非常)");
		options2.add(option);
		question = new QuestionBean("0002", "您容易疲劳吗？", 1, "体质检测", "001",
				options2);
		questionlist.add(question);

		// 初始化数据
		option = new QuestionOptionBean("5", "没有(根本不)");
		options3.add(option);
		option = new QuestionOptionBean("4", "很少(有一点)");
		options3.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options3.add(option);
		option = new QuestionOptionBean("2", "经常(相当)");
		options3.add(option);
		option = new QuestionOptionBean("1", "总是(非常)");
		options3.add(option);
		question = new QuestionBean("0003", "你说话声音低弱无力？ ", 1, "体质检测",
				"001", options3);
		questionlist.add(question);

		// 初始化数据
		option = new QuestionOptionBean("5", "没有(根本不)");
		options4.add(option);
		option = new QuestionOptionBean("4", "很少(有一点)");
		options4.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options4.add(option);
		option = new QuestionOptionBean("2", "经常(相当)");
		options4.add(option);
		option = new QuestionOptionBean("1", "总是(非常)");
		options4.add(option);
		question = new QuestionBean("0004", "您感到闷闷不乐，情绪低沉吗？", 1, "体质检测",
				"001", options4);
		questionlist.add(question);

		option = new QuestionOptionBean("5", "没有(根本不)");
		options5.add(option);
		option = new QuestionOptionBean("4", "很少(有一点)");
		options5.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options5.add(option);
		option = new QuestionOptionBean("2", "经常(相当)");
		options5.add(option);
		option = new QuestionOptionBean("1", "总是(非常)");
		options5.add(option);
		question = new QuestionBean("0005", "您不耐寒吗？", 1, "体质检测",
				"001", options5);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options6.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options6.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options6.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options6.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options6.add(option);
		question = new QuestionBean("0006", "您能适应外界自然和社会环境吗？", 1, "体质检测",
				"001", options6);
		questionlist.add(question);

		option = new QuestionOptionBean("5", "没有(根本不)");
		options7.add(option);
		option = new QuestionOptionBean("4", "很少(有一点)");
		options7.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options7.add(option);
		option = new QuestionOptionBean("2", "经常(相当)");
		options7.add(option);
		option = new QuestionOptionBean("1", "总是(非常)");
		options7.add(option);
		question = new QuestionBean("0007", "您容易失眠吗？", 1, "体质检测",
				"001", options7);
		questionlist.add(question);

		option = new QuestionOptionBean("5", "没有(根本不)");
		options8.add(option);
		option = new QuestionOptionBean("4", "很少(有一点)");
		options8.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options8.add(option);
		option = new QuestionOptionBean("2", "经常(相当)");
		options8.add(option);
		option = new QuestionOptionBean("1", "总是(非常)");
		options8.add(option);
		question = new QuestionBean("0008", "您能适应外界自然和社会环境吗？", 1, "体质检测",
				"001", options8);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options9.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options9.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options9.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options9.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options9.add(option);
		question = new QuestionBean("0009", "您容易疲劳吗？", 1, "体质检测",
				"001", options9);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options10.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options10.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options10.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options10.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options10.add(option);
		question = new QuestionBean("0010", "您容易气短吗？", 1, "体质检测",
				"001", options10);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options11.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options11.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options11.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options11.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options11.add(option);
		question = new QuestionBean("0011", "您容易心慌吗？", 1, "体质检测",
				"001", options11);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options12.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options12.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options12.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options12.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options12.add(option);
		question = new QuestionBean("0012", "您容易头晕或站立时眩晕吗？", 1, "体质检测",
				"001", options12);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options13.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options13.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options13.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options13.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options13.add(option);
		question = new QuestionBean("0013", "您比别人更容易感冒吗？", 1, "体质检测",
				"001", options13);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options14.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options14.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options14.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options14.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options14.add(option);
		question = new QuestionBean("0014", "您喜欢安静，懒得说话吗？", 1, "体质检测",
				"001", options14);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options15.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options15.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options15.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options15.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options15.add(option);
		question = new QuestionBean("0015", "您说话低弱无力吗？", 1, "体质检测",
				"001", options15);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options16.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options16.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options16.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options16.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options16.add(option);
		question = new QuestionBean("0016", "您活动量稍大就容易出虚汗吗？", 1, "体质检测",
				"001", options16);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options17.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options17.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options17.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options17.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options17.add(option);
		question = new QuestionBean("0017", "您手脚发凉吗？", 1, "体质检测",
				"001", options17);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options18.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options18.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options18.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options18.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options18.add(option);
		question = new QuestionBean("0018", "您胃脘部、背部或腰膝部怕冷吗？", 1, "体质检测",
				"001", options18);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options19.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options19.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options19.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options19.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options19.add(option);
		question = new QuestionBean("0019", "您感到怕冷、衣服比别人穿得多吗?", 1, "体质检测",
				"001", options19);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options20.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options20.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options20.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options20.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options20.add(option);
		question = new QuestionBean("0020", "您比一般人耐受不了寒冷(冬天的寒冷，夏天的冷空调、电扇等)吗？", 1, "体质检测",
				"001", options20);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options21.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options21.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options21.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options21.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options21.add(option);
		question = new QuestionBean("0021", "您比别人容易患感冒吗?", 1, "体质检测",
				"001", options21);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options22.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options22.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options22.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options22.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options22.add(option);
		question = new QuestionBean("0022", "您吃(喝)凉的东西会感到不舒服或者怕吃(喝)凉的东西吗？", 1, "体质检测",
				"001", options22);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options23.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options23.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options23.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options23.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options23.add(option);
		question = new QuestionBean("0023", "您受凉或吃(喝)凉的东西后，容易腹泻(拉肚子)吗?", 1, "体质检测",
				"001", options23);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options24.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options24.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options24.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options24.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options24.add(option);
		question = new QuestionBean("0024", "您感到手脚心发热吗?", 1, "体质检测",
				"001", options24);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options25.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options25.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options25.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options25.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options25.add(option);
		question = new QuestionBean("0025", "您感觉身体、脸上发热吗？", 1, "体质检测",
				"001", options25);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options26.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options26.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options26.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options26.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options26.add(option);
		question = new QuestionBean("0026", "您皮肤或口唇干吗?", 1, "体质检测",
				"001", options26);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options27.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options27.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options27.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options27.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options27.add(option);
		question = new QuestionBean("0027", "您口唇的颜色比一般人红吗?", 1, "体质检测",
				"001", options27);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options28.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options28.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options28.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options28.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options28.add(option);
		question = new QuestionBean("0028", "您容易便秘或大便干燥吗?", 1, "体质检测",
				"001", options28);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options29.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options29.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options29.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options29.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options29.add(option);
		question = new QuestionBean("0029", "您面部两颧潮红或偏红吗?", 1, "体质检测",
				"001", options29);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options30.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options30.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options30.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options30.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options30.add(option);
		question = new QuestionBean("0030", "您感到眼睛干涩吗？", 1, "体质检测",
				"001", options30);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options31.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options31.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options31.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options31.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options31.add(option);
		question = new QuestionBean("0031", "您感到口干咽燥、总想喝水吗？", 1, "体质检测",
				"001", options31);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options32.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options32.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options32.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options32.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options32.add(option);
		question = new QuestionBean("0032", "您感到胸闷或腹部胀满吗？", 1, "体质检测",
				"001", options32);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options33.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options33.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options33.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options33.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options33.add(option);
		question = new QuestionBean("0033", "您感到身体沉重不轻松或不爽快吗?", 1, "体质检测",
				"001", options33);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options34.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options34.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options34.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options34.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options34.add(option);
		question = new QuestionBean("0034", "您腹部肥满松软吗?", 1, "体质检测",
				"001", options34);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options35.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options35.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options35.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options35.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options35.add(option);
		question = new QuestionBean("0023", "您有额部油脂分泌多的现象吗?", 1, "体质检测",
				"001", options23);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options36.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options36.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options36.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options36.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options36.add(option);
		question = new QuestionBean("0036", "您上眼睑比别人肿（上眼睑有轻微隆起的现象）吗?", 1, "体质检测",
				"001", options36);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options37.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options37.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options37.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options37.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options37.add(option);
		question = new QuestionBean("0037", "您嘴里有黏黏的感觉吗?", 1, "体质检测",
				"001", options37);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options38.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options38.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options38.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options38.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options38.add(option);
		question = new QuestionBean("0038", "您平时痰多，特别是咽喉部总感到有痰堵着吗?", 1, "体质检测",
				"001", options38);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options39.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options39.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options39.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options39.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options39.add(option);
		question = new QuestionBean("0039", "您舌苔厚腻或有舌苔厚厚的感觉吗?", 1, "体质检测",
				"001", options39);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options40.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options40.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options40.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options40.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options40.add(option);
		question = new QuestionBean("0040", "您面部或鼻部有油腻感或者油亮发光吗?", 1, "体质检测",
				"001", options40);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options41.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options41.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options41.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options41.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options41.add(option);
		question = new QuestionBean("0041", "您易生痤疮或疮疖吗?", 1, "体质检测",
				"001", options41);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options42.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options42.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options42.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options42.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options42.add(option);
		question = new QuestionBean("0042", "您感到口苦或嘴里有异味吗?", 1, "体质检测",
				"001", options42);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options43.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options43.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options43.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options43.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options43.add(option);
		question = new QuestionBean("0043", "您大便黏滞不爽、有解不尽的感觉吗?", 1, "体质检测",
				"001", options43);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options44.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options44.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options44.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options44.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options44.add(option);
		question = new QuestionBean("0044", "您小便时尿道有发热感、尿色浓(深)吗？", 1, "体质检测",
				"001", options44);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options45.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options45.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options45.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options45.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options45.add(option);
		question = new QuestionBean("0045", "（女性）您带下色黄(白带颜色发黄)吗?/(男性）您的阴囊部位潮湿吗?", 1, "体质检测",
				"001", options45);
		questionlist.add(question);


		option = new QuestionOptionBean("1", "没有(根本不)");
		options46.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options46.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options46.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options46.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options46.add(option);
		question = new QuestionBean("0046", "您的皮肤在不知不觉中会出现青紫瘀斑(皮下出血)吗?", 1, "体质检测",
				"001", options46);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options47.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options47.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options47.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options47.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options47.add(option);
		question = new QuestionBean("0047", "您两颧部有细微红丝吗?", 1, "体质检测",
				"001", options47);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options48.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options48.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options48.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options48.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options48.add(option);
		question = new QuestionBean("0048", "您身体上有哪里疼痛吗？", 1, "体质检测",
				"001", options48);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options49.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options49.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options49.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options49.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options49.add(option);
		question = new QuestionBean("0049", "您面色晦黯、或容易出现褐斑吗?", 1, "体质检测",
				"001", options49);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options50.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options50.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options50.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options50.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options50.add(option);
		question = new QuestionBean("0050", "您容易有黑眼圈吗?", 1, "体质检测",
				"001", options50);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options51.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options51.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options51.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options51.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options51.add(option);
		question = new QuestionBean("0051", "您容易忘事（健忘）吗？", 1, "体质检测",
				"001", options51);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options52.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options52.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options52.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options52.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options52.add(option);
		question = new QuestionBean("0052", "您口唇颜色偏黯吗?", 1, "体质检测",
				"001", options52);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options53.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options53.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options53.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options53.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options53.add(option);
		question = new QuestionBean("0053", "您感到闷闷不乐、情绪低沉吗?", 1, "体质检测",
				"001", options53);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options54.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options54.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options54.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options54.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options54.add(option);
		question = new QuestionBean("0054", "您容易精神紧张、焦虑不安吗?", 1, "体质检测",
				"001", options54);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options55.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options55.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options55.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options55.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options55.add(option);
		question = new QuestionBean("0055", "您多愁善感、感情脆弱吗？", 1, "体质检测",
				"001", options55);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options56.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options56.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options56.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options56.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options56.add(option);
		question = new QuestionBean("0056", "您容易感到害怕或受到惊吓吗?", 1, "体质检测",
				"001", options56);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options57.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options57.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options57.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options57.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options57.add(option);
		question = new QuestionBean("0057", "您胁肋部或乳房胀痛吗?", 1, "体质检测",
				"001", options57);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options58.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options58.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options58.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options58.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options58.add(option);
		question = new QuestionBean("0058", "您无缘无故叹气吗?", 1, "体质检测",
				"001", options58);
		questionlist.add(question);

		option = new QuestionOptionBean("1", "没有(根本不)");
		options59.add(option);
		option = new QuestionOptionBean("2", "很少(有一点)");
		options59.add(option);
		option = new QuestionOptionBean("3", "有时(有些)");
		options59.add(option);
		option = new QuestionOptionBean("4", "经常(相当)");
		options59.add(option);
		option = new QuestionOptionBean("5", "总是(非常)");
		options59.add(option);
		question = new QuestionBean("0059", "您咽喉部有异物感，且吐之不出、咽之不下吗？", 1, "体质检测",
				"001", options59);
		questionlist.add(question);

        option = new QuestionOptionBean("1", "没有(根本不)");
        options60.add(option);
        option = new QuestionOptionBean("2", "很少(有一点)");
        options60.add(option);
        option = new QuestionOptionBean("3", "有时(有些)");
        options60.add(option);
        option = new QuestionOptionBean("4", "经常(相当)");
        options60.add(option);
        option = new QuestionOptionBean("5", "总是(非常)");
        options60.add(option);
        question = new QuestionBean("0060", "您没有感冒时也会打喷嚏吗？", 1, "体质检测",
                "001", options60);
        questionlist.add(question);

        option = new QuestionOptionBean("1", "没有(根本不)");
        options61.add(option);
        option = new QuestionOptionBean("2", "很少(有一点)");
        options61.add(option);
        option = new QuestionOptionBean("3", "有时(有些)");
        options61.add(option);
        option = new QuestionOptionBean("4", "经常(相当)");
        options61.add(option);
        option = new QuestionOptionBean("5", "总是(非常)");
        options61.add(option);
        question = new QuestionBean("0061", "您没有感冒时也会鼻塞、流鼻涕吗?", 1, "体质检测",
                "001", options61);
        questionlist.add(question);

        option = new QuestionOptionBean("1", "没有(根本不)");
        options62.add(option);
        option = new QuestionOptionBean("2", "很少(有一点)");
        options62.add(option);
        option = new QuestionOptionBean("3", "有时(有些)");
        options62.add(option);
        option = new QuestionOptionBean("4", "经常(相当)");
        options62.add(option);
        option = new QuestionOptionBean("5", "总是(非常)");
        options62.add(option);
        question = new QuestionBean("0062", "您有因季节变化、温度变化或异味等原因而咳喘的现象吗？", 1, "体质检测",
                "001", options62);
        questionlist.add(question);

        option = new QuestionOptionBean("1", "没有(根本不)");
        options63.add(option);
        option = new QuestionOptionBean("2", "很少(有一点)");
        options63.add(option);
        option = new QuestionOptionBean("3", "有时(有些)");
        options63.add(option);
        option = new QuestionOptionBean("4", "经常(相当)");
        options63.add(option);
        option = new QuestionOptionBean("5", "总是(非常)");
        options63.add(option);
        question = new QuestionBean("0063", "您容易过敏(对药物、食物、气味、花粉或在季节交替、气候变化时)吗?", 1, "体质检测",
                "001", options63);
        questionlist.add(question);

        option = new QuestionOptionBean("1", "没有(根本不)");
        options64.add(option);
        option = new QuestionOptionBean("2", "很少(有一点)");
        options64.add(option);
        option = new QuestionOptionBean("3", "有时(有些)");
        options64.add(option);
        option = new QuestionOptionBean("4", "经常(相当)");
        options64.add(option);
        option = new QuestionOptionBean("5", "总是(非常)");
        options64.add(option);
        question = new QuestionBean("0064", "您的皮肤容易起荨麻疹(风团、风疹块、风疙瘩)吗?", 1, "体质检测",
                "001", options64);
        questionlist.add(question);

        option = new QuestionOptionBean("1", "没有(根本不)");
        options65.add(option);
        option = new QuestionOptionBean("2", "很少(有一点)");
        options65.add(option);
        option = new QuestionOptionBean("3", "有时(有些)");
        options65.add(option);
        option = new QuestionOptionBean("4", "经常(相当)");
        options65.add(option);
        option = new QuestionOptionBean("5", "总是(非常)");
        options65.add(option);
        question = new QuestionBean("0065", "您的皮肤因过敏出现过紫癜(紫红色瘀点、瘀斑)吗?", 1, "体质检测",
                "001", options65);
        questionlist.add(question);

        option = new QuestionOptionBean("1", "没有(根本不)");
        options66.add(option);
        option = new QuestionOptionBean("2", "很少(有一点)");
        options66.add(option);
        option = new QuestionOptionBean("3", "有时(有些)");
        options66.add(option);
        option = new QuestionOptionBean("4", "经常(相当)");
        options66.add(option);
        option = new QuestionOptionBean("5", "总是(非常)");
        options66.add(option);
        question = new QuestionBean("0066", "您的皮肤一抓就红，并出现抓痕吗?", 1, "体质检测",
                "001", options66);
        questionlist.add(question);

	}
	
	protected void onDestroy() {
		LocalBroadcastManager.getInstance(this).unregisterReceiver(
				mMessageReceiver);
		super.onDestroy();
	}

 
}
