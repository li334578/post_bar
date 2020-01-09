package com.zzgs.post_bar.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
    /**
     * 获取当前系统时间
     * @return
     */
    public String getNowDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return formatter.format(localDateTime);
    }
}
