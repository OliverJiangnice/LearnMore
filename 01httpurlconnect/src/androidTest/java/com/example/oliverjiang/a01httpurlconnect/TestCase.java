package com.example.oliverjiang.a01httpurlconnect;

import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;

import com.example.oliverjiang.a01httpurlconnect.utils.Utils;

/**
 * Created by ${oliver} on 2016/8/29.
 */
public class TestCase extends InstrumentationTestCase {
    public void test(){//用来测试结果
        int resutl = Utils.add(3,5);
        assertEquals(8,resutl);

        System.out.println("helloworld");

        new MainActivity().getDatafromIntent();

    }
    public void test2(){//用来测试方法，过程。
        Utils.copy(2,4);
    }

}
