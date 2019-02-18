package com.fec.yunmall.core.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import com.fec.yunmall.core.base.BaseData;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

/**
 * @author liubp
 * @function 检测工具类
 */
public class DetectTool {
	static TelephonyManager tm ;

	/**获取时间戳
	 * @return
	 */
	public static String getTS(){
		return System.currentTimeMillis()+"";

	}

	/**获取手机唯一串号IMEI
	 * @param context
	 * @return imei
	 */
	public static String getIMEI(Context context){
		return getUniquePsuedoID();
	}

	//获得独一无二的Psuedo ID
	public static String getUniquePsuedoID() {
		String serial;

		String m_szDevIDShort = "35" +
				Build.BOARD.length() % 10 + Build.BRAND.length() % 10 +

				Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 +

				Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +

				Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 +

				Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 +

				Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +

				Build.USER.length() % 10; //13 位

		try {
			serial = android.os.Build.class.getField("SERIAL").get(null).toString();
			//API>=9 使用serial号
			return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
		} catch (Exception exception) {
			//serial需要一个初始化
			serial = "serial"; // 随便一个初始化
		}
		//使用硬件信息拼凑出来的15位号码
		return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();

	}

	public static String getSign(Map<String,String> params){

		Log.e("11111111111111111", params.toString());
		 // 先将参数以其参数名的字典序升序进行排序
	    Map<String, String> sortedParams = new TreeMap<String, String>(params);
	    Set<Entry<String, String>> entrys = sortedParams.entrySet();


	    // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
	    StringBuilder basestring = new StringBuilder();
	    for (Entry<String, String> param : entrys) {
	        basestring.append(param.getKey()).append("=").append(param.getValue());
	    }
	    Log.e("11111111111111111", basestring.toString());
	    /*****************对排序后的参数进行MD5散列函数运算***********************/
	    byte[] hash;

	    try {
	        hash = MessageDigest.getInstance("MD5").digest(basestring.toString().getBytes("UTF-8"));
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException("Huh, MD5 should be supported?", e);
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("Huh, UTF-8 should be supported?", e);
	    }

	    StringBuilder hex = new StringBuilder(hash.length * 2);
	    for (byte b : hash) {
	        if ((b & 0xFF) < 0x10) hex.append("0");
	        hex.append(Integer.toHexString(b & 0xFF));
	    }
	    /*****************对排序后的参数进行MD5散列函数运算***********************/
	    //返回md5加密后的字符串注意统一转化为大写
		return hex.toString().toUpperCase();

	}

	/**
	 * 获取屏幕横向(宽度)分辨率
	 * @param context
	 * @return
	 */
	public static int getResolutionX(Context context){
		DisplayMetrics mDisplayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);

		int width = mDisplayMetrics.widthPixels;


		return width;
	}


	/**
	 * 获取凭证(Token)
	 * @return
	 */
	public static String getToken(){
		return BaseData.UID;
	}

	/**
	 * 写死的版本号，对应versionName
	 * @return
	 */
	public static String getVersionName(){
		return "1.0.0";
	}


	/**
	 * 获取设备类型，1-Android，2-IOS
	 * @return
	 */
	public static String getType(){
		return "1";
	}
}
