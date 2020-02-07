package com.zzgs.post_bar;

import com.zzgs.post_bar.Utils.CommentUtil;

import java.util.regex.Pattern;

/**
 * Author:   Tang
 * Date:     2020/1/25 14:56
 * Description:
 */
public class CommentTest {
    public static void main(String[] args) {
//        System.out.println(CommentUtil.structureSonCommentId("1",1));
//        System.out.println(CommentUtil.structureSonCommentId("1,2,3",1));
//        System.out.println(CommentUtil.structureSonCommentId("2,3,1",1));
//        System.out.println(CommentUtil.structureSonCommentId("2,1,3",1));
//        String str1 = "1";
//        String[] strings = str1.split(",");
//        System.out.println(strings.length);
//        for (String string : strings) {
//            System.out.println("string = " + string);
//        }
        boolean admin = Pattern.matches("^[a-zA-Z][a-zA-Z0-9_]{4,15}$", "adm-in");
        System.out.println("admin = " + admin);
    }
}
