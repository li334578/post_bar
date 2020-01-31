package com.zzgs.post_bar;

import com.zzgs.post_bar.Utils.CommentUtil;

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
        String str1 = "1";
        String[] strings = str1.split(",");
        System.out.println(strings.length);
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }
}
