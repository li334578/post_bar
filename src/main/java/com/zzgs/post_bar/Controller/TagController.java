package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Service.TagService;
import com.zzgs.post_bar.Utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/addTag")
    @ResponseBody
    public String addTag(@Param("tag_name")String tag_name){
        JSONObject jsonObject = new JSONObject();
        DateUtil dateUtil = new DateUtil();
        String date = dateUtil.getNowDate();
        Integer flag = tagService.addTag(tag_name, date);
        if (flag==1){
            //成功添加标签
            Tag tag = tagService.findByTagName(tag_name);
            jsonObject.put("tag_name",tag.getTag_name());
            jsonObject.put("tag_id",tag.getId());
            jsonObject.put("statusCode",200);
        }else {
            jsonObject.put("statusCode",500);
        }
        return jsonObject.toString();
    }
}
