/*
package com.oliver.autorunpager;

*/
/**
 * Created by ${oliver} on 2016/8/27.
 *//*

public class MainCopy {
    package com.oliverjiang.viewpage;

    import java.util.ArrayList;

    import android.app.Activity;
    import android.os.Bundle;
    import android.support.v4.view.PagerAdapter;
    import android.support.v4.view.ViewPager;
    import android.view.View;
    import android.view.ViewGroup;
    import android.view.Window;
    import android.widget.ImageView;

    public class MainActivity extends Activity {
        private ViewPager viewPager;
        private static final int[] mImageIds = new int[]{
                R.drawable.girla,R.drawable.girl,R.drawable.girlb,R.drawable.girlc,R.drawable.girld,R.drawable.girle,
                R.drawable.girlm,R.drawable.girlj,R.drawable.girli,R.drawable.girlh,R.drawable.girlg,R.drawable.girlf,

        };
        private ArrayList<ImageView> mImageViewList;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //requestWindowFeature(Window.FEATURE_NO_TITLE);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_main);
            viewPager = (ViewPager)findViewById(R.id.viewPager);
            viewPager.setAdapter(new GuildAdapter());
            initViews();
        }
        private void initViews(){
            mImageViewList = new ArrayList<ImageView>();
            for(int i =0;i<mImageIds.length;i++){
                ImageView image = new ImageView(this);
                image.setBackgroundResource(mImageIds[i]);
                mImageViewList.add(image);

            }
        }
        class GuildAdapter extends PagerAdapter{

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return mImageIds.length;
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0==arg1;
            }
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mImageViewList.get(position));
                return mImageViewList.get(position);
            }
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                // TODO Auto-generated method stub
                container.removeView((View)object);
            }
        }



    }

}
*/
/*
package com.itheima.googleplay.holder;

import java.util.LinkedList;
import java.util.List;

import com.itheima.googleplay.R;
import com.itheima.googleplay.http.HttpHelper;
import com.itheima.googleplay.tools.UiUtils;

import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.AbsListView.LayoutParams;

public class HomePictureHolder extends BaseHolder<List<String>> {
    */
/* 当new HomePictureHolder()就会调用该方法 *//*

    private ViewPager viewPager;
    private List<String> datas;

    @Override
    public View initView() {
        viewPager = new ViewPager(UiUtils.getContext());
        viewPager.setLayoutParams(new AbsListView.LayoutParams(
                LayoutParams.MATCH_PARENT, UiUtils
                .getDimens(R.dimen.home_picture_height)));
        return viewPager;
    }

    */
/* 当 holder.setData 才会调用 *//*

    @Override
    public void refreshView(List<String> datas) {
        this.datas = datas;
        viewPager.setAdapter(new HomeAdapter());
        viewPager.setCurrentItem(2000*datas.size());// 设置起始的位置   Integer.Max_Vlue/2
        viewPager.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        runTask.stop();
                        break;
                    case MotionEvent.ACTION_CANCEL:  // 事件的取消
                    case MotionEvent.ACTION_UP:
                        runTask.start();
                        break;
                }

                return false; // viewPager 触摸事件 返回值要是false
            }
        });
        runTask = new AuToRunTask();
        runTask.start();
    }
    boolean flag;
    private AuToRunTask runTask;
    public class AuToRunTask implements Runnable{

        @Override
        public void run() {
            if(flag){
                UiUtils.cancel(this);  // 取消之前
                int currentItem = viewPager.getCurrentItem();
                currentItem++;
                viewPager.setCurrentItem(currentItem);
                //  延迟执行当前的任务
                UiUtils.postDelayed(this, 2000);// 递归调用
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

    class HomeAdapter extends PagerAdapter {
        // 当前viewPager里面有多少个条目
        LinkedList<ImageView> convertView=new LinkedList<ImageView>();
        // ArrayList
        @Override
        public int getCount() {
            return	Integer.MAX_VALUE;
        }

        */
/* 判断返回的对象和 加载view对象的关系 *//*

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ImageView view=(ImageView) object;
            convertView.add(view);// 把移除的对象 添加到缓存集合中
            container.removeView(view);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int index=position%datas.size();
            ImageView view;
            if(convertView.size()>0){
                view=convertView.remove(0);//从集合中取出来一个view
            }else{
                view= new ImageView(UiUtils.getContext());
            }
            bitmapUtils.display(view, HttpHelper.URL + "image?name="
                    + datas.get(index));
            container.addView(view); // 加载的view对象
            return view; // 返回的对象
        }

    }

}

*/
