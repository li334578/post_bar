package com.zzgs.post_bar.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/**
 * Author:   Tang
 * Date:     2020/1/25 14:38
 * Description: 日期工具类
 */

public class DateUtil {
    /**
     * 获取当前系统时间
     * @return 系统时间
     */
    public String getNowDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return formatter.format(localDateTime);
    }
}
