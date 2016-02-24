package com.exam;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {

	private ViewPager topic_pager;
	private int ViewTag = 0;
	private int length = 5;
	private TextView tv_page;
	
	private List<View> lists = new ArrayList<View>(); 
	private ViewPagerAdapter adapter; 
	
    @SuppressLint("InflateParams") 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        topic_pager = (ViewPager) findViewById(R.id.topic_pager);
        tv_page = (TextView) findViewById(R.id.textView2);
        
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
