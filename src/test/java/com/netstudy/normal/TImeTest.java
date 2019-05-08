package com.netstudy.normal;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TImeTest {

    @Test
    public void testNowDate() {

        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //获取String类型的时间
        String createdate = sdf.format(date);
        System.out.println(createdate);
    }
}
