package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Service.TypeService;
import com.zzgs.post_bar.Utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/addType")
    @ResponseBody
    public String addType(@Param("type_name")String type_name){
        JSONObject jsonObject = new JSONObject();
        DateUtil dateUtil = new DateUtil();
        String date = dateUtil.getNowDate();
        Integer flag = typeService.addTag(type_name, date);
        if (flag==1){
            //成功添加话题
            Type type = typeService.findByTypeName(type_name);
            jsonObject.put("type_name",type.getType_name());
            jsonObject.put("type_id",type.getId());
            jsonObject.put("statusCode",200);
        }else {
            jsonObject.put("statusCode",500);
        }
        return jsonObject.toString();
    }
}
