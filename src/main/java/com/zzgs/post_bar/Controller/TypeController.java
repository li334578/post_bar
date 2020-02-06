package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Dto.TypeDto;
import com.zzgs.post_bar.Service.ArticleService;
import com.zzgs.post_bar.Service.TypeService;
import com.zzgs.post_bar.Service.UserService;
import com.zzgs.post_bar.Utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * Author:   Tang
 * Date:     2019/12/30 14:48
 * Description: 话题控制类
 */
@Controller
@RequestMapping("/type")
public class TypeController {

    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @Autowired
    private TypeService typeService;

    /**
     * 新增话题
     * @param type_name 话题名
     * @return
     */
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

    /**
     * 分页查询所有分类及文章
     * @param model 页面模型
     * @param pageNum 当前页
     * @param pageSize 每页显示条数
     * @return
     */
    @RequestMapping("/types")
    public String types(Model model,
                        @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                        @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        //查询帖子
        List<ArticleDto> articleDtoList = articleService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        //查询所有的分类
        List<TypeDto> typeDtoList = typeService.findAll();
        model.addAttribute("typeTotalNum",typeDtoList.size());
        model.addAttribute("typeDtoList",typeDtoList);
        return "types";
    }

    /**
     * 根据分类id查询文章
     * @param model 页面模型
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @param type_id 分类id
     * @return
     */
    @RequestMapping("/findArticleByTypeId/{id}")
    public String findTypeByTypeId(Model model,
                                   @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                                   @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize,
                                   @PathVariable("id")Integer type_id){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            User user = userService.findByAccountName(subject.getPrincipal().toString());
            user.setUser_avatar("../"+user.getUser_avatar());
            model.addAttribute("user",user);
        }
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
        //根据分类进行查询 在model中放入标志
        model.addAttribute("type_id",type_id);
        return "types";
    }
}
