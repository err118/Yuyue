package com.yuyue.utils;

import java.util.Random;


 /**
  * 根据时间戳生成一个唯一的TOKEN标示
  * description：TODO <br/>
  * Creator: andy <br/> 
  * Create Date：2015年4月8日 下午3:24:18 <br/> 
  */
public class GenerateTokenUtil {
	private static final Random random = new Random(System.currentTimeMillis());
	/** 生成一个token */
	public static synchronized String generateToken() {
	    String s = String.valueOf(random.nextLong());
	    int index = s.indexOf('-');
	    if(-1!=index){
	    	s = s.replace("-","0");
	    }
	    return s;
	}
}
