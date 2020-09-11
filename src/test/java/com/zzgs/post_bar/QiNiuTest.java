package com.zzgs.post_bar;

import java.io.File;
import java.io.IOException;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;


/**
 * @Title QiNiuTest
 * @Author liWenBo
 * @Date 2020/8/7 17:16
 * @Description
 */
public class QiNiuTest {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "drm1TBYLsRYUJS5WTMUPEHdhxZrpt4zOL6adqXB-"; //这两个登录七牛 账号里面可以找到
    String SECRET_KEY = "3SPFntVuphHn0Oux6P9nUj4D11W7mpGg6JIKMeHX";
    //要上传的空间
    String bucketname = "qiniu-lwb"; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）
    //上传到七牛后保存的文件名
    String key = "testniu.txt";
    //上传文件的路径
    String FilePath = "d:\\test.txt";  //本地要上传文件路径
    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    Configuration cfg = new Configuration(Zone.autoZone());   //zong1() 代表华北地区
    UploadManager uploadManager = new UploadManager(cfg);
    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(bucketname);
    }
    //普通上传
    public void upload() throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, getUpToken());
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
            }
        }
    }
    public static void main(String[] args) throws IOException {
        new QiNiuTest().upload();
    }
}
