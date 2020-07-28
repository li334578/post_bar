package com.zzgs.post_bar;

import com.zzgs.post_bar.Utils.MarkdownUtil;

public class markdownToHtmlTest {
    public static void main(String[] args) {
        String markdown = "**你好**";
        MarkdownUtil.markdownToHtml(markdown);
        System.out.println("markdown = " + markdown);
    }
}
