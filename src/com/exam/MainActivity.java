package com.exam;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {

	private ViewPager topic_pager;
	private int ViewTag = 1;
	private int length = 10;
	private TextView tv_page,tv_time;
	private Button btn_up,btn_down,btn_time,btn_stop;
	
	private List<View> lists = new ArrayList<View>(); 
	private ViewPagerAdapter adapter; 
	
    @SuppressLint("InflateParams") 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        topic_pager = (ViewPager) findViewById(R.id.topic_pager);
        tv_page = (TextView) findViewById(R.id.textView2);
        tv_time = (TextView) findViewById(R.id.tv_time);
        btn_up = (Button) findViewById(R.id.button1);
        btn_down = (Button) findViewById(R.id.button3);
        btn_time = (Button) findViewById(R.id.btn_time);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        
        btn_up.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ViewTag = topic_pager.getCurrentItem()-1;
				topic_pager.setCurrentItem(ViewTag);
	        	tv_page.setText(ViewTag+"");
			}
		});
		
        btn_down.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		ViewTag = topic_pager.getCurrentItem()+1;
        		topic_pager.setCurrentItem(ViewTag);
        		tv_page.setText(ViewTag+"");
        	}
        });
        
        btn_time.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RestTimeUtil.startTime(tv_time);
			}
		});
        
        btn_stop.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		RestTimeUtil.pauseTime(tv_time);
        	}
        });
        
        // 页面添加到viewPager集合  
        for (int i = 0; i < length; i++) {
            lists.add(getLayoutInflater().inflate(R.layout.view1, null));  
		}
        
        // 初始化滑动图片位置  
//        initeCursor();  
        adapter = new ViewPagerAdapter(lists);  
        topic_pager.setAdapter(adapter);  
        // ViewPager滑动监听器  
        topic_pager.setOnPageChangeListener(new MyOnPageChangeListener());  
          
    }  
   
	/**
	 * 为选项卡绑定监听器，不同页面显示不同数据
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		public void onPageScrollStateChanged(int index) {
			ViewTag = topic_pager.getCurrentItem()+1;
        	tv_page.setText(ViewTag+"");
//        	switch (ViewTag) {
//			case 1:
//				Toast.makeText(MainActivity.this, "这是第一题", Toast.LENGTH_SHORT).show();
//				break;
//			case 5:
//				Toast.makeText(MainActivity.this, "这是最后一题", Toast.LENGTH_SHORT).show();
//				break;
//
//			default:
//				break;
//			}
		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		public void onPageSelected(int index) {
		}
	}

}
