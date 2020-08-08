package com.zzgs.post_bar.Utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Title QiNiuFileUtil
 * @Author liWenBo
 * @Date 2020/8/8 9:14
 * @Description
 */
public class QiNiuFileUtil {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    private static final String ACCESS_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx-"; //这两个登录七牛 账号里面可以找到
    private static final String SECRET_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    //要上传的空间
    private static final String bucketname = "xxxxxxxxxx"; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）

    public static Boolean uploadFile(MultipartFile file, String fileName) {
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //创建上传对象
        Configuration cfg = new Configuration(Zone.autoZone());  //zong1() 代表华北地区
        UploadManager uploadManager = new UploadManager(cfg);
        //简单上传，使用默认策略，只需要设置上传的空间名就可以了
        try {
            //调用put方法上传
            Response res = uploadManager.put(file.getBytes(), fileName, auth.uploadToken(bucketname));
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
                return false;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
