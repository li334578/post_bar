package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Dto.TypeDto;
import com.zzgs.post_bar.Service.ArticleService;
import com.zzgs.post_bar.Service.TypeService;
import com.zzgs.post_bar.Service.UserService;
import com.zzgs.post_bar.Utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {

    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
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

    @RequestMapping("/types")
    public String types(Model model,
                        @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                        @RequestParam(defaultValue = "2",value = "pageSize")Integer pageSize){
        //查询帖子
        List<ArticleDto> articleDtoList = articleService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        //查询所有的分类
        List<TypeDto> typeDtoList = typeService.findAll();
        System.out.println(typeDtoList.size());
        model.addAttribute("typeTotalNum",typeDtoList.size());
        model.addAttribute("typeDtoList",typeDtoList);
        return "types";
    }

    @RequestMapping("/findArticleByTypeId/{id}")
    public String findTypeByTypeId(Model model,
                                   @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                                   @RequestParam(defaultValue = "2",value = "pageSize")Integer pageSize,
                                   @PathVariable("id")Integer type_id){
        //根据type_id查询文章
        List<ArticleDto> articleDtoList = articleService.findArticleByTypeId(type_id,pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        //查询所有的分类
        List<TypeDto> typeDtoList = typeService.findAll();
        model.addAttribute("typeTotalNum",typeDtoList.size());
        model.addAttribute("typeDtoList",typeDtoList);
        model.addAttribute("currentTypeId",type_id);
        return "types";
    }
}
