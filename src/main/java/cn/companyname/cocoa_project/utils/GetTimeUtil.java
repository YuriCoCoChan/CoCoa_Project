package cn.companyname.cocoa_project.utils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 获取时间
 *
 * @author CoCo
 * 中国科学院国家授时中心("http://www.ntsc.ac.cn")
 */
public class GetTimeUtil {
    public static void main(String[] args) {
        String ntsc = "http://www.ntsc.ac.cn";
        String[] arra = getByUrl(true);
        for (int i = 0; i < arra.length; i++) {
            System.out.println(arra[i]);

        }
    }

    /**
     * 获取网络时间 默认为 NTSC(中国科学院国家授时中心)
     *
     * @return 通过访问网络时间返回一个时间格式字符串;
     */
    public static Date getByUrl() {
        try {
            // 取得资源对象
            URL url = new URL("http://www.ntsc.ac.cn");
            // 生成连接对象
            URLConnection uc = url.openConnection();
            // 发出连接
            uc.connect();
            // 读取网站日期时间
            long ld = uc.getDate();
            // 转换为标准时间对象
            Date date = new Date(ld);
            return date;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String[] getByUrl(boolean a) {
        try {
            // 取得资源对象
            URL url = new URL("http://www.ntsc.ac.cn");
            // 生成连接对象
            URLConnection uc = url.openConnection();
            // 发出连接
            uc.connect();
            // 读取网站日期时间
            long ld = uc.getDate();
            // 转换为标准时间对象
            Date date = new Date(ld);
            String[] times = date.toString().split(" ");
            return times;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过网址获取网络时间
     *
     * @param urlStr 网址
     * @return 通过访问网络时间返回一个时间格式字符串
     */
    public static Date getByUrl(String urlStr) {
        try {
            // 取得资源对象
            URL url = new URL(urlStr);
            // 生成连接对象
            URLConnection uc = url.openConnection();
            // 发出连接
            uc.connect();
            // 读取网站日期时间
            long ld = uc.getDate();
            // 转换为标准时间对象
            Date date = new Date(ld);
            return date;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取系统时间
     *
     * @param format = "yyyy-MM-dd HH:mm:ss" / format = "yyyy-MM-dd"
     * @return 一个时间格式的字符串;
     */
    public static String getBySystem(String format) {
        // 输出北京时间
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        return sdf.format(new Date());
    }

    /**
     * 获取系统时间
     * @return
     */
    public static Map getByCalendar() {
        Map map = new HashMap();
        Calendar now = Calendar.getInstance();
        map.put("year", now.get(Calendar.YEAR));
        map.put("mon", (now.get(Calendar.MONTH) + 1));
        map.put("day", now.get(Calendar.DAY_OF_MONTH));
        return map;
    }

    public static void test() {
        try {
            //中国科学院国家授时中心
            // 取得资源对象
            URL url = new URL("http://www.ntsc.ac.cn");
            // 生成连接对象
            URLConnection uc = url.openConnection();
            // 发出连接
            uc.connect();
            // 读取网站日期时间
            long ld = uc.getDate();
            // 转换为标准时间对象
            Date date = new Date(ld);
            // 输出北京时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            System.out.println(sdf.format(new Date()));
            System.out.println("-----------------");
            System.out.println(date);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
