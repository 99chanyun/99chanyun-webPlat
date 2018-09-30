package com.chanyun.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreateNoUtil {

    //没有redis时临时用
    public static String createNo() {

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String number = df.format(new Date())+ getRandomString(4);// new Date()为获取当前系统时间，也可使用当前时间戳
        return number;
    }
    
    
    
    /**
	 * length用户要求产生字符串的长度
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length){
//	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		 String str="0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(str.length());
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
    
}
