package com.chanyun.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreateNoUtil {

    //没有redis时临时用
    public static String createNo() {

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String number = df.format(new Date())+ new Random().nextInt(18);// new Date()为获取当前系统时间，也可使用当前时间戳
        return number;
    }
}
