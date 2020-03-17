package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Dto.TagDto;
import com.zzgs.post_bar.Dto.TypeDto;
import com.zzgs.post_bar.Service.ArticleService;
import com.zzgs.post_bar.Service.TagService;
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
 * Description: 标签控制类
 */
@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;
    @Autowired
    ArticleService articleService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private UserService userService;

    /**
     * 新增标签
     * @param tag_name 标签名
     * @return 新增标签的结果数据
     */
    @RequestMapping("/addTag")
    @ResponseBody
    public String addTag(@Param("tag_name")String tag_name){
        JSONObject jsonObject = new JSONObject();
        DateUtil dateUtil = new DateUtil();
        String date = dateUtil.getNowDate();
        //查询标签是否已存在
        Tag dbtag = tagService.findByTagName(tag_name);
        if (dbtag == null) {
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
        }else {
            //标签已存在
            jsonObject.put("statusCode",501);
        }
        return jsonObject.toString();
    }

    /**
     * 分页查询所有标签
     * @param model 页面模型
     * @param pageNum 当前页
     * @param pageSize 每页显示条数
     * @return 标签列表页
     */
    @RequestMapping("/tags")
    public String tags(Model model,
                       @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                       @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
//        List<ArticleDto> articleDtoList = articleService.findAll(pageNum, pageSize);
        List<ArticleDto> articleDtoList = articleService.findAllOrderByApprovalNumPaging(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        //查询所有的标签
        List<TagDto> tagDtoList = tagService.findAll();
        model.addAttribute("tagTotalNum",tagDtoList.size());
        model.addAttribute("tagDtoList",tagDtoList);
        return "tags";
    }

    /**
     * 根据标签id查询标签下的文章
     * @param model 页面模型
     * @param pageNum 当前页
     * @param pageSize 每页显示条数
     * @param tag_id 分类id
     * @return 标签下的文章列表页
     */
    @RequestMapping("/findArticleByTagId/{id}")
    public String findTypeByTypeId(Model model,
                                   @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                                   @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize,
                                   @PathVariable("id")Integer tag_id){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            User user = userService.findByAccountName(subject.getPrincipal().toString());
            user.setUser_avatar("../"+user.getUser_avatar());
            model.addAttribute("user",user);
        }
        //根据tag_id查询文章 根据点赞数排序
//        List<ArticleDto> articleDtoList = articleService.findArticleByTagId(tag_id,pageNum,pageSize);
        List<ArticleDto> articleDtoList = articleService.findArticleByTagIdOrderByApprovalNum(tag_id,pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        //查询所有的分类
        List<TagDto> tagDtoList = tagService.findAll();
        for (TagDto tagDto : tagDtoList) {
            tagDto.setTotal_num(articleService.findTotalByTagId(tagDto.getId()));
        }
        model.addAttribute("tagTotalNum",tagDtoList.size());
        model.addAttribute("tagDtoList",tagDtoList);
        model.addAttribute("currentTagId",tag_id);
        //根据标签进行查询 在model中放入标志
        model.addAttribute("tag_id",tag_id);
        return "tags";
    }

}
