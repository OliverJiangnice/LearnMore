package com.oliver.autorunpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private static final int[] mImageIds = new int[]{
            R.mipmap.girla, R.mipmap.girl, R.mipmap.girlb, R.mipmap.girlc, R.mipmap.girld, R.mipmap.girle,
            R.mipmap.girlm, R.mipmap.girlj, R.mipmap.girli, R.mipmap.girlh, R.mipmap.girlg, R.mipmap.girlf,

    };
    private ArrayList<ImageView> mImageViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);这个方法没有用了，用下面的代替
        View view = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
        view.setSystemUiVisibility(option);//隐藏状态栏
        final ActionBar actionBar = getSupportActionBar();
        actionBar.hide();//隐藏ActionBar

       // int width  = getWindowManager().getDefaultDisplay().getWidth();//得到屏幕宽度


        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new GuildAdapter());

      viewPager.setCurrentItem(1000*mImageIds.length);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        autoRunPager.stop();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        autoRunPager.start();//手指抬起和取消都执行.start();
                        break;
                }

                return false;//viewPager 触摸事件 返回值一定要是false
            }
        });
        autoRunPager = new AutoRunPager();
        autoRunPager.start();

        initViews();

    }
    private AutoRunPager autoRunPager;
    private void initViews() {
        mImageViewList = new ArrayList<ImageView>();
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView image = new ImageView(this);
            image.setBackgroundResource(mImageIds[i]);
            mImageViewList.add(image);

        }

    }
    boolean flag;
    public class AutoRunPager implements Runnable{
        @Override
        public void run() {
            if (flag) {
               UiUtils.cancel(this);
                int currentItem = viewPager.getCurrentItem();
                currentItem++;
                viewPager.setCurrentItem(currentItem);
                UiUtils.postDelayed(this,2000);
            }
        }
        public void start(){
            if(!flag){
                UiUtils.cancel(this);  // 取消之前
                flag=true;
                UiUtils.postDelayed(this, 2000);// 递归调用
            }
        }
        public  void stop(){
            if(flag){
                flag=false;
                UiUtils.cancel(this);
            }
        }
    }

    class GuildAdapter extends PagerAdapter {
        LinkedList<ImageView> imageViewLinkedList = new LinkedList<ImageView>();
        @Override
        public int getCount() {
            return	Integer.MAX_VALUE;
        }
       /* @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mImageIds.length;
        }*/

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
           /* int index = position%mImageIds.length;
           ImageView view;

            if (imageViewLinkedList.size()>0){
                view = imageViewLinkedList.remove(0);//从集合中取出来一个view
            }else {
                view = new ImageView(UiUtils.getContext());
            }
            view = mImageViewList.get(index);
            container.addView(view);


            return view;*/
            int index = position%mImageIds.length;
            container.addView(mImageViewList.get(index));
            return mImageViewList.get(index);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            ImageView view = (ImageView) object;
            imageViewLinkedList.add(view);
            container.removeView(view);
        }
    }



}
