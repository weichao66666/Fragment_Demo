package io.weichao.fragment_demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by pi on 2017/6/22.
 */
public class DateUtil {
    private DateUtil() {
    }

    public static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒", Locale.CHINA);
        Date data = new Date(System.currentTimeMillis());//获取当前时间
        return formatter.format(data);
    }
}
