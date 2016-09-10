package com.example.oliverjiang.a01httpurlconnect;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        private TextView text;
        private Button button;
    private  ArrayList<Weather.small> detail;
        private final String url = "http://api.1-blog.com/biz/bizserver/weather/list.do";
        private Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                switch (msg.what){
                    case  4:


                }
            }
        };
    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                    getDatafromIntent();


                    }
                }).start();
            }
        });
    }


    public   void getDatafromIntent() {
        StringBuffer stringBuffer;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            InputStream inputStream =httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            stringBuffer = new StringBuffer();
            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line);
                System.out.println("数据"+stringBuffer);
                String data = stringBuffer.toString();
                parseData(data);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            httpURLConnection.disconnect();
        }
    }

    private  void parseData(String data) {
        Gson gson = new Gson();
        weather = gson.fromJson(data,Weather.class);
        System.out.println("解析结果"+ weather);
        Message message = new Message();
        message.what = 4;
        message.obj = data.toString();
        handler.sendMessage(message);
    }
}
