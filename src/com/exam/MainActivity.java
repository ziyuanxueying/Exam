package com.exam;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {

	private ViewPager topic_pager;
	private int ViewTag = 0;
	private TextView tv_page;
	
	private List<View> lists = new ArrayList<View>(); 
	private ViewPagerAdapter adapter; 
	private Animation animation; 
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        topic_pager = (ViewPager) findViewById(R.id.topic_pager);
        tv_page = (TextView) findViewById(R.id.textView2);
        
//        topic_pager.setCurrentItem(0);// 将当前页设定为第1页
//		topic_pager.setAdapter(getPagerAdapter());
//        topic_pager.setOnPageChangeListener(new MyOnPageChangeListener());
        
        // 热门商圈和热门分类 页面添加到viewPager集合  
        lists.add(getLayoutInflater().inflate(R.layout.view1, null));  
        lists.add(getLayoutInflater().inflate(R.layout.view2, null));  
        lists.add(getLayoutInflater().inflate(R.layout.view3, null)); 
        
        // 初始化滑动图片位置  
//        initeCursor();  
        adapter = new ViewPagerAdapter(lists);  
        topic_pager.setAdapter(adapter);  
        // ViewPager滑动监听器  
        topic_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {  
              
            @Override  
            public void onPageSelected(int arg0) {  
                // TODO Auto-generated method stub
            	ViewTag = topic_pager.getCurrentItem()+1;
            	tv_page.setText(ViewTag+"");
                // 当滑动时，顶部的imageView是通过animation缓慢的滑动  
//                switch (arg0) {  
//                case 0:  
//                    if (ViewTag == 1) {  
//                    	tv_page.setText(ViewTag+"");
//                    }
//                    break;  
//                case 1:  
//                    if (ViewTag == 2) {  
//                    	tv_page.setText(ViewTag+"");
//                    }  
//                    break;  
//                case 2:  
//                	if (ViewTag == 3) {  
//                		tv_page.setText(ViewTag+"");
//                	} 
//                	break;  
//                }  
//                ViewTag = arg0; 
  
            }  
              
            @Override  
            public void onPageScrolled(int arg0, float arg1, int arg2) {  
                // TODO Auto-generated method stub  
            }  
              
            @Override  
            public void onPageScrollStateChanged(int arg0) {  
                // TODO Auto-generated method stub  
            }  
        });  
          
    }  
   
}
