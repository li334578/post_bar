/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : post_bar

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 16/03/2020 22:53:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '帖子标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '帖子内容',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `first_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图地址',
  `published` int(4) NULL DEFAULT NULL COMMENT '是否发布',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述/摘要 信息',
  `type_id` int(20) NULL DEFAULT NULL COMMENT '文章所属话题',
  `user_id` int(20) NULL DEFAULT NULL COMMENT '文章所属用户 id',
  `approval_num` int(20) NULL DEFAULT NULL COMMENT '文章赞同数',
  `trample_num` int(20) NULL DEFAULT NULL COMMENT '文章点踩数',
  `browse_volume` int(20) NULL DEFAULT NULL COMMENT '文章浏览数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, 'Markdown使用示例', '//将下面的文字复制粘贴到你的有道云笔记Markdown编辑器/简书Markdown编辑器即可在预览中重现上文。\n> 作者：在路上\\\n贡献者：诺布\n\n# 0x00 写在前面\n\n#### 到底什么是个Markdown?\n- **Markdown** 是一种文本编辑时候使用的**语法**，通过在文字中加入助记符，将排版/编号/列表/文字高亮/加粗等问题交给机器处理，对文字进行自动排版，从而大大提高编辑记录效率。\n\n- 有道云Markdown编辑器 or 简书Markdown编辑器都是依照这种Markdown**语法的实现**，所以难免上渲染出来的效果有些小偏差，但是排版方式是通用的。\n\n#### 为什么要用Markdown?\n\n- 文章的排版很麻烦，如果有一种对于文章排版的解决方案就好了。\n\n- 学习实践Markdown语法后你可以自定义你的文章排版。\n\n- 这是一套定义文章排版格式的语法。\n\n- 这是一个边际成本递减的升维实践过程。\n\n#### Markdown的应用场景?\n\n可以说，所有的文本场景下都可以使用Markdown语法，只要你有一个支持Markdown语法的编辑器就可以，笔者使用的是有道云笔记的Markdown编辑器，因为其支持语法全面(包括文本高亮标记)。当前探索出的支持Markdown的环境有:有道云笔记、简书、微信公众号推送(粘贴渲染排版后的文本即可)。\n\n#### 本文逻辑安排目录：\n\n1. **Markdown可以实现的排版效果**\n\n2. **Markdown文章示例**\n\n3. **本文的Markdown语法的原文**\n\n# 0x01 标题相关示例\n---\n# 主标题\n## 副标题\n### 一级标题\n#### 二级标题\n##### 三级标题\n###### 六级小标题\n### [标题网址](http://yq.upwith.me/)\n> 引用文字块\n---\n\n\n# 0x02 无序列表相关示例\n---\n- # 一级列表\n- ## 二级列表\n- ### 三级列表\n- #### 四级列表\n- ##### 五级列表\n- ###### 六级列表\n---\n\n# 0x03 有序列表相关示例\n---\n1. **加粗标题1**\n    1. 自编号标题1.1\n        1. ++下划线自编号标题1.1.1++\n            1. *斜体自编号标题1.1.1.1*\n\n---\n\n# 0x04 综合使用示例\n\n> 使用MD时候的要点，合理使用无序列表语法与自定义序号，尽量少使用有序列表语法，因为存在兼容性问题(有道云笔记兼容性比简书好很多)会导致标题无层次分类，示例开始。\n\n![image](http://upload-images.jianshu.io/upload_images/6189910-13d61acf16fccc84.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\n## 一、如何更好地理解第四章？\n### (一) 前置两个问题：升维与复杂系统\n#### 1. 升维\n##### (1) 维度是什么？\n时空坐标体系下的坐标轴数量，可以理解为**增加的视野角度**。\n        \n##### (2) 高维和低维的关系\n- 信息密度*高*，信息量*大*\n- 低维是高维的切片\n- 高维的低维展开会导致低维量级的无限扩张\n- 推演：高维比低维的视角更多\n        \n### 2. 复杂系统\n#### (1) 定义\n什么叫系统？一组组内相互作用、相互依赖的复杂整体\n#### (2) 要素\n#### (3) 系统的三要素\n- 系统关系\n- **元素间关系**\n- 系统功能\n#### (4) 两大类系统\n##### ① 他组织系统\n- 系统元素\n- 系统结构关系\n- 系统功能\n- 特点：功能稳定，输入一定，输出一定。\n##### ② 自组织系统\n\n---\n\n# 0x05 Markdown原文\n\nMarkdown与Markdown编辑器与排版文字的关系梳理与实践：\n\n- Markdown格式原文->有道云Markdown编辑器 or 简书Markdown编辑器->预览效果就是发布后的效果\n\n- 简书中Markdown编辑器开启方式\n    - ```个人设置-基础设置-常用编辑器-Markdown```\n\n- 有道云笔记Markdown编辑器开启方式\n    - ```新文档-新建Markdown```', '2020年01月06日 13:50:28', '2020年01月06日 13:50:28', '../static/images/cover/157906924839620191.jpg', 0, '一个Markdown的使用实例', 1, 1, 3, 0, 21);
INSERT INTO `article` VALUES (2, 'Linux知识总结', '## linux常用的命令\n| 序号 |命令  |对应英文|作用|\n|--|--|--|--|\n|01|ls|list|查看当前文件夹下的内容|\n|02|pwd|print work directory|查看当前所在文件夹|\n|03|cd(目录名)|change directory|切换文件夹|\n|04|touch(文件名)|touch|如果文件不存在，创建新文件|\n|05|mkdir(目录名)|make directory|创建目录|\n|06|rm(文件名)|remove|删除指定文件名|\n|07|clear|clear|清屏|\ntip:\nctrl+shift+= :放大终端窗口的字体显示\nctrl+- :缩小终端窗口的字体显示\nrm -r 目录名 删除指定目录\n## linux终端命令格式 [表示可选]\n- 1.command [-options][parameter]\n command 命令名，相应功能的英文单词或单词的缩写。\n [-options] 选项，可用来对命令进行控制，也可省略。\n [parameter] 传给命令的参数可以是0个、1个或者多个。\n- 2.查询命令的帮助信息\n - 2.1--help\n command --help\n 显示command命令的帮助信息\n - 2.2man\n man command\n 查询 command命令的帮助信息\n man 是manual的缩写，是linux提供的一个手册，包含了绝大部分的命令、函数的详细使用说明。\n 使用man时的操作键：\n \n|操作键| 功能 |\n|--|--|\n| 空格键 | 显示手册的下一屏 |\n| enter键 | 一次滚动手册页的一行 |\n| b | 回滚一屏 |\n| f | 前滚一屏 |\n| q | 退出 |\n| /word | 搜索word字符串 |\n### 文件和目录的常用命令\n查看目录内容 ls\n切换目录 cd\n创建和删除文件操作 touch rm mkdir\n拷贝和移动文件 cp mv\n查看文件内容 cat more  grep\n其他 echo 重定向>和>>管道1\n- 1.查看目录内容\n - 1.1linux终端实用技巧\n  - 自动补全\n  在敲出文件/目录/命令 的前几个字母后，按下tab键\n  如果输入的没有歧义系统会进行自动补全\n  如果还存在其他 文件/目录/命令，再按一下tab键，系统会提示当前可能存在的命令。\n  - 曾经使用过的命令\n  按 ↑/↓光标键可以在曾经使用过的命令中来回切换\n  如果想要退出选择，并且不想执行当前选中的命令。可以按ctrl+c。\n - 1.2 ls命令说明\n ls是英文单词list的缩写，其功能是列出目录的所有内容，是用户最常用的命令之一类似于Dos下的dir命令。\n linux下的文件和目录的特点\n linux下文件和目录名称最多可以有256个字符。\n 以.开头的文件为隐藏文件，需要加上-a参数才能显示。\n .表示当前目录 ..表示上一级目录', '2020年01月06日 14:05:04', '2020年02月01日 14:02:46', '../../../static/images/cover/1579055203921_20191213093838.jpg', 1, '一个介绍linux的帖子-update', 1, 1, 4, 0, 304);
INSERT INTO `article` VALUES (3, 'linux入门', '## 1.操作系统 OS\n没有安装操作系统的计算机叫做裸机。\n在裸机上运行程序必须使用机器语言来编写程序。\n### 1.1操作系统直接操作硬件\n作用：封装后调用\n### 1.2\n- 1 桌面级操作系统 windows （安全性稳定性不好）、macos（基于Linux适合于开发人员）、Linux（应用软件较少）。\n- 2 服务器操作系统 \n linux 安全、稳定、免费 占有率高\n windows server 付费占有率低\n- 3 嵌入式操作系统\n 智能家居 linux\n- 4 移动设备操作系统\n ios、android（基于linux）\n### 1.3 虚拟机（virtual Machine）\n指通过软件模拟的具有完整硬件系统功能的、运行在一个完全隔离的环境中的完整的操作系统。\n- 1 虚拟系统是指通过生成完整的虚拟镜像具有真实操作系统完全一样的功能\n- 2 进入虚拟系统后，所有的操作都是在这个全新的，独立的虚拟系统中进行，可以独立安装运行软件、保存数据、拥有独立桌面、不会对真正的系统产生任何的影响\n- 3 而且能够在现有的操作系统和虚拟镜像之间灵活切换的一类操作系统。\n## 1.操作系统的发展史\n- 1.1 unix 多个用户能够在同一时间登录到同一个计算机上使用的系统。\n- 1.2 minix 教学使用\n- 1.3 linux \n      内核版本：是系统的心脏，是运行程序和管理像磁盘和打印机等硬件设备的核心程序，它提供了一个在设备与应用程序之间抽象层，包括稳定版本和开发版本。\n      发行版本：通常包含了桌面环境、办公套件、媒体播放器、数据库。\n      常见版本：ubuntu，Redhat，Fedora。opensuse，linux Mint，Debian，Manjaro，mageia，centos，Arch。\n## 2.文件系统 \n- 2.1windows下文件系统(基于单用户或家目录)\n 每个驱动器都有自己的根目录结构\n- 2.2linux 文件系统(基于多用户操作系统) /home\n Ubuntu没有盘符概念，只有一个根目录/\n- 2.3 用户目录\n /home/user 称为用户目录或者家目录\n- 2.4 linux 主要目录速查表\n/：根目录 根目录下只存放目录\n/bin ./usr/bin:可执行的二进制文件的目录\n/boot 放置li', '2020年01月06日 14:12:55', '2020年01月06日 14:12:55', '../static/images/cover/1579054612005Lighthouse.jpg', 1, 'linux的一些相关知识', 1, 2, 3, 0, 48);
INSERT INTO `article` VALUES (4, 'Spring Boot 快速搭建web项目', '# Spring Boot 快速搭建web项目\n- 操作系统：win10\n- 开发工具：IDEA2017.3.4\n- 数据库: MySQL+Mybatis\n- 使用数据源: Druid\n## 1.Create new project(Spring Initializr)\n推荐使用 jdk1.8，我这里使用的是jdk9.0\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903100041315.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 2. next 确认输入的信息\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903101433510.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 3.next 勾选组件IDEA会自动生成pom文件中的依赖\n- Lombok是IDEA 的一个插件 使用其中的@Data注解可以自动生成实体类的 Get Set 以及ToString等方法（没有可以不勾选，自己手动生成方法）\n- Spring web Starter web的启动器\n- MySQLDriver MySQL mysql驱动组件\n- MyBatis mybatis的组件\n![在这里插入图片描述](https://img-blog.csdnimg.cn/2019090310041098.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 4.next 确认文件存放位置\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903101136691.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 5.finish IDEA会创建一个新工程\n### 新文件的层级目录\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903101635796.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 6.导入Druid数据源和log4j的依赖坐标\n右下角选自动导入就可以\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903101801183.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n\n```xml\n//坐标在这里可以直接复制\n<dependency>\n            <groupId>com.alibaba</groupId>\n            <artifactId>druid</artifactId>\n            <version>1.0.9</version>\n        </dependency>\n        <dependency>\n            <groupId>log4j</groupId>\n            <artifactId>log4j</artifactId>\n            <version>1.2.12</version>\n        </dependency>\n```\n## 7.创建并配置application.yml文件\n- 注:根据个人喜好也可以使用application.properties\n- username和password请配置自己数据库的用户名和密码\n- driver-class-name 是上面配置的mysql驱动\n- url配置好数据库所在的ip地址 jdbc:mysql://localhost:3306/eesy_mybatis 以及数据库名称\n- ?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC这是数据库配置的参数，设置数据库的编码格式和时区。\n- type 数据源\n```yml\nspring:\n  datasource:\n    username: root\n    password: root\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/eesy_mybatis?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC\n    type: com.alibaba.druid.pool.DruidDataSource\n```\n\n## 8.配置数据源 在工程下创建Config->DruidConfig文件\n- 配置Druid数据源\n```java\n@Configuration\npublic class DruidConfig {\n    @ConfigurationProperties(prefix = \"spring.datasource\")\n    @Bean\n    public DataSource druid(){\n        return new DruidDataSource();\n    }\n}\n```\n## 9.编写实体类 bean->User\n- @Data注解是Lombok提供的自动生成Get和Set以及ToSting方法的注解\n- 可以通过file->setting->Plugins->Browse repositories..搜索Lombok安装并重启IDEA。再在pom.xml文件中配置`<dependency>\n   <groupId>org.projectlombok</groupId>\n   <artifactId>lombok</artifactId>\n   <optional>true</optional>\n  </dependency>`即可使用\n- 也可以自己手动使用Alt+Insert 生成Get和Set方法\n```java\n@Data\npublic class User {\n    private Integer id;\n    private String username;\n    private Date birthday;\n    private String sex;\n    private String address;\n}\n```\n## 10.编写Mapper->UserMapper接口\n\n```java\n@Mapper\npublic interface UserMapper {\n //查询所有方法\n    @Select(\"select * from user\")\n    public List<User> findAll();\n\n}\n```\n## 11.编写Controller->UserController方法\n\n```java\n@RestController\npublic class UserController {\n //注入UserMapper 这里DEA可能会提示报错不用理会就行\n    @Autowired\n    UserMapper userMapper;\n \n    @GetMapping(\"/user\")\n    public List<User> findAll(){\n        return userMapper.findAll();\n    }\n}\n```\n## 12.resources->static->index.html编写index.html向后台发送ajax请求\n- 需要创建resources->static->js并引入jquery-1.12.4.min.js文件\n```html\n<head>\n<script src=\"js/jquery-1.12.4.min.js\"></script>\n<script>\n$(function () {\n            //查询所有\n            var select_all = $(\"#select_btn\");\n            select_all.click(function () {\n                $.ajax({\n                        url: \"/user\",\n                        type: \"get\",\n                        success: function (result) {\n                            var div = $(\"#div01\");\n                            for (var i = 0; i < result.length; i++) {\n                                div.append(\"<p> 姓名:\" + result[i].username + \"</p >\");\n                                div.append(\"<p>生日：\" + result[i].birthday + \"</p >\");\n                                div.append(\"<p>性别：\" + result[i].sex + \"</p >\");\n                                div.append(\"<p>地址：\" + result[i].address + \"</p >\");\n                            }\n                        }\n                    }\n                )\n            });\n         })\n</script>\n</head>\n<h1>这是首页！</h1>\n<button id=\"select_btn\">点击查询所有</button>\n<div id=\"div01\"></div>\n```\n## 13.启动项目进行测试\n- 运行此main方法\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903104429446.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n- 下图表示启动成功\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903104525256.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n- 打开浏览器访问 http://localhost:8080/index.html 下图为页面效果\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903104640203.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n- 点击查询所有按钮 会向后台发送ajax请求 效果如下图\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903104733843.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 14.end 至此完成了SpringBoot的查询所有user操作', '2020年01月06日 14:19:30', '2020年01月10日 09:56:24', '../static/images/cover/1579054612005Lighthouse.jpg', 1, 'Spring Boot 快速搭建web项目-更新了', 3, 1, 3, 1, 32);
INSERT INTO `article` VALUES (5, 'MarkDown编辑文章示例', '# 欢迎使用 Markdown在线编辑器 MdEditor\n\n**Markdown是一种轻量级的「标记语言」**\n\n\n![markdown](https://www.mdeditor.com/images/logos/markdown.png \"markdown\")\n\n\nMarkdown是一种可以使用普通文本编辑器编写的标记语言，通过简单的标记语法，它可以使普通文本内容具有一定的格式。它允许人们使用易读易写的纯文本格式编写文档，然后转换成格式丰富的HTML页面，Markdown文件的后缀名便是“.md”\n\n\n## MdEditor是一个在线编辑Markdown文档的编辑器\n\n*MdEditor扩展了Markdown的功能（如表格、脚注、内嵌HTML等等），以使让Markdown转换成更多的格式，和更丰富的展示效果，这些功能原初的Markdown尚不具备。*\n\n> Markdown增强版中比较有名的有Markdown Extra、MultiMarkdown、 Maruku等。这些衍生版本要么基于工具，如~~Pandoc~~，Pandao；要么基于网站，如GitHub和Wikipedia，在语法上基本兼容，但在一些语法和渲染效果上有改动。\n\nMdEditor源于Pandao的JavaScript开源项目，开源地址[Editor.md](https://github.com/pandao/editor.md \"Editor.md\")，并在MIT开源协议的许可范围内进行了优化，以适应广大用户群体的需求。向优秀的markdown开源编辑器原作者Pandao致敬。\n\n\n![Pandao editor.md](https://pandao.github.io/editor.md/images/logos/editormd-logo-180x180.png \"Pandao editor.md\")\n\n\n\n## MdEditor的功能列表演示\n\n# 标题H1\n\n## 标题H2\n\n### 标题H3\n\n#### 标题H4\n\n##### 标题H5\n\n###### 标题H5\n\n### 字符效果和横线等\n----\n\n~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\n\n*斜体字*      _斜体字_\n\n**粗体**  __粗体__\n\n***粗斜体*** ___粗斜体___\n\n上标：X<sub>2</sub>，下标：O<sup>2</sup>\n\n**缩写(同HTML的abbr标签)**\n> 即更长的单词或短语的缩写形式，前提是开启识别HTML标签时，已默认开启\n\nThe <abbr title=\"Hyper Text Markup Language\">HTML</abbr> specification is maintained by the <abbr title=\"World Wide Web Consortium\">W3C</abbr>.\n### 引用 Blockquotes\n\n> 引用文本 Blockquotes\n\n引用的行内混合 Blockquotes\n\n> 引用：如果想要插入空白换行`即<br />标签`，在插入处先键入两个以上的空格然后回车即可，[普通链接](https://www.mdeditor.com/)。\n\n### 锚点与链接 Links\n[普通链接](https://www.mdeditor.com/)\n[普通链接带标题](https://www.mdeditor.com/ \"普通链接带标题\")\n直接链接：<https://www.mdeditor.com>\n[锚点链接][anchor-id]\n[anchor-id]: https://www.mdeditor.com/\n[mailto:test.test@gmail.com](mailto:test.test@gmail.com)\nGFM a-tail link @pandao\n邮箱地址自动链接 test.test@gmail.com  www@vip.qq.com\n> @pandao\n\n### 多语言代码高亮 Codes\n\n#### 行内代码 Inline code\n\n\n执行命令：`npm install marked`\n\n#### 缩进风格\n\n即缩进四个空格，也做为实现类似 `<pre>` 预格式化文本 ( Preformatted Text ) 的功能。\n\n    <?php\n        echo \"Hello world!\";\n    ?>\n预格式化文本：\n\n    | First Header  | Second Header |\n    | ------------- | ------------- |\n    | Content Cell  | Content Cell  |\n    | Content Cell  | Content Cell  |\n\n#### JS代码\n```javascript\nfunction test() {\n	console.log(\"Hello world!\");\n}\n```\n\n#### HTML 代码 HTML codes\n```html\n<!DOCTYPE html>\n<html>\n    <head>\n        <mate charest=\"utf-8\" />\n        <meta name=\"keywords\" content=\"Editor.md, Markdown, Editor\" />\n        <title>Hello world!</title>\n        <style type=\"text/css\">\n            body{font-size:14px;color:#444;font-family: \"Microsoft Yahei\", Tahoma, \"Hiragino Sans GB\", Arial;background:#fff;}\n            ul{list-style: none;}\n            img{border:none;vertical-align: middle;}\n        </style>\n    </head>\n    <body>\n        <h1 class=\"text-xxl\">Hello world!</h1>\n        <p class=\"text-green\">Plain text</p>\n    </body>\n</html>\n```\n### 图片 Images\n\n图片加链接 (Image + Link)：\n\n\n[![](https://www.mdeditor.com/images/logos/markdown.png)](https://www.mdeditor.com/images/logos/markdown.png \"markdown\")\n\n> Follow your heart.\n\n----\n### 列表 Lists\n\n#### 无序列表（减号）Unordered Lists (-)\n\n- 列表一\n- 列表二\n- 列表三\n\n#### 无序列表（星号）Unordered Lists (*)\n\n* 列表一\n* 列表二\n* 列表三\n\n#### 无序列表（加号和嵌套）Unordered Lists (+)\n+ 列表一\n+ 列表二\n    + 列表二-1\n    + 列表二-2\n    + 列表二-3\n+ 列表三\n    * 列表一\n    * 列表二\n    * 列表三\n\n#### 有序列表 Ordered Lists (-)\n\n1. 第一行\n2. 第二行\n3. 第三行\n\n#### GFM task list\n\n- [x] GFM task list 1\n- [x] GFM task list 2\n- [ ] GFM task list 3\n    - [ ] GFM task list 3-1\n    - [ ] GFM task list 3-2\n    - [ ] GFM task list 3-3\n- [ ] GFM task list 4\n    - [ ] GFM task list 4-1\n    - [ ] GFM task list 4-2\n\n----\n\n### 绘制表格 Tables\n\n| 项目        | 价格   |  数量  |\n| --------   | -----:  | :----:  |\n| 计算机      | $1600   |   5     |\n| 手机        |   $12   |   12   |\n| 管线        |    $1    |  234  |\n\nFirst Header  | Second Header\n------------- | -------------\nContent Cell  | Content Cell\nContent Cell  | Content Cell\n\n| First Header  | Second Header |\n| ------------- | ------------- |\n| Content Cell  | Content Cell  |\n| Content Cell  | Content Cell  |\n\n| Function name | Description                    |\n| ------------- | ------------------------------ |\n| `help()`      | Display the help window.       |\n| `destroy()`   | **Destroy your computer!**     |\n\n| Left-Aligned  | Center Aligned  | Right Aligned |\n| :------------ |:---------------:| -----:|\n| col 3 is      | some wordy text | $1600 |\n| col 2 is      | centered        |   $12 |\n| zebra stripes | are neat        |    $1 |\n\n| Item      | Value |\n| --------- | -----:|\n| Computer  | $1600 |\n| Phone     |   $12 |\n| Pipe      |    $1 |\n\n----\n\n#### 特殊符号 HTML Entities Codes\n\n&copy; &  &uml; &trade; &iexcl; &pound;\n&amp; &lt; &gt; &yen; &euro; &reg; &plusmn; &para; &sect; &brvbar; &macr; &laquo; &middot;\n\nX&sup2; Y&sup3; &frac34; &frac14;  &times;  &divide;   &raquo;\n\n18&ordm;C  &quot;  &apos;\n\n[========]\n\n### Emoji表情 :smiley:\n\n> Blockquotes :star:\n\n#### GFM task lists & Emoji & fontAwesome icon emoji & editormd logo emoji :editormd-logo-5x:\n\n- [x] :smiley: @mentions, :smiley: #refs, [links](), **formatting**, and <del>tags</del> supported :editormd-logo:;\n- [x] list syntax required (any unordered or ordered list supported) :editormd-logo-3x:;\n- [x] [ ] :smiley: this is a complete item :smiley:;\n- [ ] []this is an incomplete item [test link](#) :fa-star: @pandao;\n- [ ] [ ]this is an incomplete item :fa-star: :fa-gear:;\n    - [ ] :smiley: this is an incomplete item [test link](#) :fa-star: :fa-gear:;\n    - [ ] :smiley: this is  :fa-star: :fa-gear: an incomplete item [test link](#);\n\n#### 反斜杠 Escape\n\n\\*literal asterisks\\*\n\n[========]\n### 科学公式 TeX(KaTeX)\n\n$$E=mc^2$$\n\n行内的公式$$E=mc^2$$行内的公式，行内的$$E=mc^2$$公式。\n\n$$x > y$$\n\n$$\\(\\sqrt{3x-1}+(1+x)^2\\)$$\n\n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\n\n多行公式：\n\n```math\n\\displaystyle\n\\left( \\sum\\_{k=1}^n a\\_k b\\_k \\right)^2\n\\leq\n\\left( \\sum\\_{k=1}^n a\\_k^2 \\right)\n\\left( \\sum\\_{k=1}^n b\\_k^2 \\right)\n```\n```katex\n\\displaystyle\n    \\frac{1}{\n        \\Bigl(\\sqrt{\\phi \\sqrt{5}}-\\phi\\Bigr) e^{\n        \\frac25 \\pi}} = 1+\\frac{e^{-2\\pi}} {1+\\frac{e^{-4\\pi}} {\n        1+\\frac{e^{-6\\pi}}\n        {1+\\frac{e^{-8\\pi}}\n         {1+\\cdots} }\n        }\n    }\n```\n```latex\nf(x) = \\int_{-\\infty}^\\infty\n    \\hat f(\\xi)\\,e^{2 \\pi i \\xi x}\n    \\,d\\xi\n```\n### 分页符 Page break\n\n> Print Test: Ctrl + P\n\n[========]\n\n### 绘制流程图 Flowchart\n\n```flow\nst=>start: 用户登陆\nop=>operation: 登陆操作\ncond=>condition: 登陆成功 Yes or No?\ne=>end: 进入后台\n\nst->op->cond\ncond(yes)->e\ncond(no)->op\n```\n[========]\n\n### 绘制序列图 Sequence Diagram\n\n```seq\nAndrew->China: Says Hello\nNote right of China: China thinks\\nabout it\nChina-->Andrew: How are you?\nAndrew->>China: I am good thanks!\n```\n### End', '2020年01月20日 14:51:04', '2020年01月20日 14:51:04', '../static/images/cover/1579503035215bgImg.jpg', 1, 'markdown的文章展示希望大家多多点赞。', 1, 1, 0, 0, 5);
INSERT INTO `article` VALUES (9, '创建ssm整合项目', '# 创建ssm整合项目\n\n### 1.使用maven骨架创建一个webapp的基本工程\n\n### 2.main下新建一个java，用来放java文件，src下新建一个test，用来放测试文件，main下新建一个resources文件夹，鼠标右键，找到make directory as，选择Resources root \n\n### 3.src->main->java下新建com.zzgs.springmvc.(Controller,Dao,Service,Domain)\n\ncontroller包用来放前台url映射文件，dao用来放与数据库的接口文件，domain用来放实体类文件，service用来放自己定义的接口\n\n### 4.修改pom文件，锁定版本导入相应依赖\n\n### 5.resources.applicationContext.xml是spring配置文件：开启注解扫描\n~~~xml\n<context:component-scan base-packsge=\"com.zzgs\">\n    <!--配置那些注解不扫描-->\n	<context:exclude-filter type=\"annotation\" expression=\"org.springframework.sterootype.Controller\"/>\n</context:component-scan>\n~~~\n### 6.配置springMVC\n#### 修改web.xml\n~~~xml\n<!-- 配置springmvc的前端控制器 指向springmvc.xml 程序在启动的时候就加载springmvc 可以接受所有请求 load-on-startup：表示启动容器时初始化该Servlet； -->\n  <servlet>\n    <servlet-name>dispatcherServlet</servlet-name>\n    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>\n    <init-param>\n      <param-name>contextConfigLocation</param-name>\n      <param-value> classpath:springmvc.xml</param-value>\n    </init-param>\n    <load-on-startup>1</load-on-startup>\n  </servlet>\n  <!-- 将前端URL请求和后台处理方法controller建立对应关系-->\n  <servlet-mapping>\n    <servlet-name>dispatcherServlet</servlet-name>\n    <url-pattern>/</url-pattern>\n  </servlet-mapping>\n  \n  \n  <!-- 配置编码方式-->\n  <filter>\n    <filter-name>encodingFilter</filter-name>\n    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>\n    <init-param>\n      <param-name>encoding</param-name>\n      <param-value>UTF-8</param-value>\n    </init-param>\n    <init-param>\n      <param-name>forceEncoding</param-name>\n      <param-value>true</param-value>\n    </init-param>\n  </filter>\n  <filter-mapping>\n    <filter-name>encodingFilter</filter-name>\n    <url-pattern>/*</url-pattern>\n  </filter-mapping>\n~~~\n#### springmvc.xml\n~~~xml\n	<!--开启注解扫描只扫描controller-->\n	<context:component-scan base-packsge=\"com.zzgs\">\n    <!--配置只扫描controller扫描-->\n	<context:include-filter type=\"annotation\" expression=\"org.springframework.sterootype.Controller\"/>\n</context:component-scan>\n	<!--配置视图解析器对象-->\n	<bean id=\"internalResourceViewResolver\" class=\"org.springframework.web.servlet.view.InternalResourceViewResolver\">\n		<property name=\"prefix\" value=\"/WEB-INF/pages/\" />\n		<property name=\"suffix\" value=\".jsp\" />	\n	</bean>\n	<!--过滤静态文件-->\n	<mvc:resources location=\"/images/\" mapping=\"/images/**\"/>\n    <mvc:resources location=\"/css/\" mapping=\"/css/**\"/>\n    <mvc:resources location=\"/js/\" mapping=\"/js/**\"/>\n	<!--开启springmvc注解的支持-->\n	<mvc:annotation-driven />\n~~~\nspring整合springmvc\n启动tomcat服务器的时候，需要加载spring的配置文件(applicationContext)\n#### 在web.xml中配置\n~~~xml\n		<!--配置spring的监听器 默认只加载WEB-INF下的applicationContext.xml文件-->\n      <listener>\n        <listener-class>\n          org.springframework.web.context.ContextLoaderListener\n        </listener-class>\n      </listener>\n      <!--设置加载配置文件的路径-->\n      <context-param>\n    <param-name>contextConfigLocation</param-name>\n    <param-value> classpath:applicationContext.xml</param-value>\n    </context-param>\n~~~\nspring整合mybatis\napplicationContext.xml\n~~~xml\n	<!--配置连接池-->\n	<bean id=\"dataSource\" class=\"com.mchange.v2.c3p0.ComboPooledDataSource\">\n	<property name=\"druid\" value=\"com.mysql.jdbc.Driver\"/>\n	<property name=\"jdbcurl\" value=\"jdbc:mysql://localhost:3306/mytest/\">\n	<property name=\"user\" value=\"root\"/>\n	<property name=\"password\" value=\"root\"/>\n	</bean>\n	<!--配置SqlSessionFactory-->\n	<bean id=\"sqlSessionFactory\" class=\"org.mybatis.spring.SqlSessionFactoryBean\">\n		<property name=\"dataSource\" ref=\"dataSource\"/>\n	</bean>\n	<!--配置Dao接口所在的包-->\n	<bean id=\"mapperScanner\" class=\"org.mybatis.spring.mapper.MapperScannerConfigurer\">\n	<property name=\"basePackage\" value=\"com.zzgs.dao\"/>\n	</bean>\n~~~\n\nspring整合springmvc，mybatis完成\n下面配置声明式事务管理\n#### 在applicationContext.xml\n\n~~~xml\n\n<!--配置声明式事务管理器-->\n<bean id=\"transactionManager\" class=\"org.springframework.jdbc.datasource.DataSourceTransactionManager\">\n	<property name=\"dataSource\" ref=\"dataSource\"/>\n</bean>\n<!--配置事务通知-->\n<tx:advice id=\"txAdvice\" transaction-manager=\"transactionManager\">\n	<tx:attributes>\n		<tx:method name=\"find*\" read-only=\"true\"/>\n		<tx:method name=\"*\" isolation=\"DEFAULT\"/>\n	</tx:attributes>\n</tx:advice>\n<!--配置AOP增强-->\n<aop:config>\n	<aop:advisor advice-ref=\"txAdvice\" pointcut=\"execution(* com.zzgs.services.impl.*ServiceImpl.*(..))*/\">\n</aop:config>\n~~~\n', '2020年01月30日 20:58:04', '2020年01月30日 20:58:04', '../static/images/cover/city.jpg', 1, '创建ssm整合项目.', 1, 4, 0, 0, 2);
INSERT INTO `article` VALUES (10, '程序员你为什么这么累', '大家一提到程序员，首先想到的是以下标签：苦逼，加班，熬夜通宵。但是，但凡工作了的同学都知道，其实大部分程序员做的事情都很简单，代码CRUD可以说毫无技术含量，就算什么不懂依葫芦画瓢很多功能也能勉强做出来，做个多线程并发就算高科技了，程序员这行的门槛其实还是比较低的。（这里说的是大部分，有些牛逼的，写算法、jvm等的请自动跳过）\n\n**是不是觉得很矛盾，一方面工作不复杂，一方面却累成狗。**有没有想过问题出在哪里？有没有想过时间都花在哪里呢？\n\n对于我个人来说，编码还是一个相对轻松的活（我是负责公司it系统的，没有太多技术含量，数据量大，但并发量不大）。从工作到现在，我加班编码的时间还是比较少的，我到现在为止每天还会编码，很少因为编码工作加班。\n\n大家写的东西都是一些crud的业务逻辑代码，为什么大家这么累，加班加点天天都是奋斗者？我从自己带的项目中观察中发现，**大部分人的大部分时间都是在 定位问题 + 改代码，真正开发的时间并不多。**定位问题包括开发转测试的时候发现问题和上线后发现问题，改代码的包括改bug和因为需求变动修改代码（后面专门开一贴说如何应对需求改动）。\n\n所以说，simple is not easy。很多人就是因为觉得简单，所以功能完成自己测试ok了就算了，没有思考有没有更加好的方式。归根到底是因为编码习惯太糟糕，写的代码太烂，导致无法定位频繁修改频繁出问题。（后面我会详细讲一些我看到的大部分的编码问题。）\n\n其实，**对于个人来说，技术很重要，但是对于工作来说，编码的习惯比技术更加主要。**工作中你面试的大部分技术都不需要用到的。工作中，因为你的编码习惯不好，写的代码质量差，代码冗余重复多，很多无关的代码和业务代码搅在一起，导致了你疲于奔命应付各种问题。\n\n所以我作为**SE**，不管接手任何项目组，第一步就是制定代码框架，制定项目组的开发规范，把代码量减下去。事实上证明，这一步之后，大家的代码量能下去最少1/3，后台的问题数下降比较明显，大家的加班会比之前少。\n\n给大家一个直观的例子。下面是**controller**的一个删除数据的接口，我来之前大家写的这个样子的（其实一开始比这个还差很多），功能很简单，输入一个对象id执行删除返回是否删除成功。大家有没有觉得有什么问题？\n\n```java\n＠PostMapping(\"/delete\")\npublic Map<String, Object> delete(long id, String lang) {\n  Map<String, Object> data = new HashMap<String, Object>();\n\n  boolean result = false;\n  try {\n    // 语言（中英文提示不同）\n    Locale local = \"zh\".equalsIgnoreCase(lang) ? Locale.CHINESE : Locale.ENGLISH;\n\n    result = configService.delete(id, local);\n\n    data.put(\"code\", 0);\n\n  } catch (CheckException e) {\n    // 参数等校验出错，这类异常属于已知异常，不需要打印堆栈，返回码为-1\n    data.put(\"code\", -1);\n    data.put(\"msg\", e.getMessage());\n  } catch (Exception e) {\n    // 其他未知异常，需要打印堆栈分析用，返回码为99\n    log.error(e);\n\n    data.put(\"code\", 99);\n    data.put(\"msg\", e.toString());\n  }\n\n  data.put(\"result\", result);\n\n  return data;\n}\n```\n\n其实上面的代码也没有大问题。而我接手之后，我会开发自己的代码框架，最后制定代码框架交付的代码如下（这是controller的部分）:\n\n```java\n＠PostMapping(\"/delete\")\npublic ResultBean<Boolean> delete(long id) {\n  return new ResultBean<Boolean>(configService.delete(id));\n}\n```\n\n用到的技术就是**AOP**，也不是什么高深技术。怎么样？代码量就一行，特性一个都没有丢。这就是我们项目组现在的**controller**的样子！（如果恰好有我带过的项目组的人，看到**ResultBean<>**应该很熟悉应该知道我是谁了）\n\n所以说技术无所谓高低，看你怎么样用。上面的代码简单说一下问题，第一，lang和业务没有什么关系，我后面的代码框架去掉了（不是说我后面的代码没有这个功能，是把他隐藏起来对开发人员透明了，使用的技术就是ThreadLocal）。第二，前面那个代码，实际上干活的就只有一行，其他都和业务代码没有一毛钱关系，我的代码框架里面完全看不到了。\n\n使用的技术真的很简单，但是编码效果非常好，因为大家不要因为使用的技术初级就觉得不重要！！使用这套框架后，大家再也不需要大部分时间都写一些无聊的代码，可以有更加多时间学习其他技术。说实话，在我项目组的开发人员都是比较幸运的，觉得能学到东西，不是像其他项目组，写了几年都是一样的CRUD代码，虽然我比较严厉，但是还是愿意待在我项目组，毕竟加班比其他项目组少啊。\n\n这就是我说的工作中，编码习惯（或者说编码风格）比技术更加重要。我工作了也有很长时间了，我觉得我个人价值最大的地方就是这些，技术上其实我懂的也和大家差不多，但编码上我还是觉得可以超过大部分人的。后面我会把我们这些业务系统中大家编码的问题一个一个写出来，并把我的解决办法分享出来。\n\n请大家持续关注后续更新，谢谢！', '2020年03月13日 21:29:21', '2020年03月13日 21:29:21', '../static/images/cover/15841058912031584105779210.png', 1, '大家一提到程序员，首先想到的是以下标签：苦逼，加班，熬夜通宵。但是，但凡工作了的同学都知道，其实大部分程序员做的事情都很简单，代码CRUD可以说毫无技术含量，就算什么不懂依葫芦画瓢很多功能也能勉强做出来，做个多线程并发就算高科技了，程序员这行的门槛其实还是比较低的。（这里说的是大部分，有些牛逼的，写算法、jvm等的请自动跳过）', 7, 2, 6, 0, 18);
INSERT INTO `article` VALUES (11, '我的编码习惯 - 接口定义', '工作中，少不了要定义各种接口，系统集成要定义接口，前后台掉调用也要定义接口。接口定义一定程度上能反应程序员的编程功底。列举一下工作中我发现大家容易出现的问题：\n\n## 1. 返回格式不统一\n\n同一个接口，有时候返回数组，有时候返回单个；成功的时候返回对象，失败的时候返回错误信息字符串。工作中有个系统集成就是这样定义的接口，真是辣眼睛。这个对应代码上，返回的类型是map，json，object，都是不应该的。实际工作中，我们会定义一个统一的格式，就是ResultBean，分页的有另外一个PageResultBean\n\n### 错误范例：\n\n```java\n//返回map可读性不好，尽量不要\n　＠PostMapping(\"/delete\")\n  public Map<String, Object> delete(long id, String lang) {\n\n  }\n\n  // 成功返回boolean，失败返回string，大忌\n  ＠PostMapping(\"/delete\")\n  public Object delete(long id, String lang) {\n    try {\n      boolean result = configService.delete(id, local);\n      return result;\n    } catch (Exception e) {\n      log.error(e);\n      return e.toString();\n    }\n  }\n```\n\n## 2. 没有考虑失败情况\n一开始只考虑成功场景，等后面测试发现有错误情况，怎么办，改接口呗，前后台都改，劳民伤财无用功。\n\n### 错误范例：\n\n```java\n //不返回任何数据，没有考虑失败场景，容易返工\n　＠PostMapping(\"/update\")\n  public void update(long id, xxx) {\n\n  }\n```\n\n## 3. 出现和业务无关的输入参数\n\n如lang语言，当前用户信息 都不应该出现参数里面，应该从当前会话里面获取。后面讲ThreadLocal会说到怎么样去掉。除了代码可读性不好问题外，尤其是参数出现当前用户信息的，这是个严重问题。\n\n### 错误范例：\n```java\n // （当前用户删除数据）参数出现lang和userid，尤其是userid，大忌\n　＠PostMapping(\"/delete\")\n  public Map<String, Object> delete(long id, String lang, String userId) {\n\n  }\n```\n\n## 4. 出现复杂的输入参数\n一般情况下，不允许出现例如json字符串这样的参数，这种参数可读性极差。应该定义对应的bean。\n### 错误范例：\n```java\n // 参数出现json格式，可读性不好，代码也难看\n　＠PostMapping(\"/update\")\n  public Map<String, Object> update(long id, String jsonStr) {\n\n  }\n```\n\n## 5. 没有返回应该返回的数据\n\n例如，新增接口一般情况下应该返回新对象的id标识，这需要编程经验。新手定义的时候因为前台没有用就不返回数据或者只返回true，这都是不恰当的。别人要不要是别人的事情，你该返回的还是应该返回。\n### 错误范例：\n\n```java\n // 约定俗成，新建应该返回新对象的信息，只返回boolean容易导致返工\n　＠PostMapping(\"/add\")\n  public boolean add(xxx) {\n    //xxx\n    return configService.add();\n  }\n```\n很多人看了我的这篇文章 [程序员你为什么这么累](http://localhost:8080/article/article_details/10 \"程序员你为什么这么累\")？，都觉得里面的技术也很简单，没有什么特别的地方，但是，实现这个代码框架之前，就是要你的接口的统一的格式ResultBean，aop才好做。有些人误解了，我那篇文章说的都不是技术，重点说的是编码习惯工作方式，如果你重点还是放在什么技术上，那我也帮不了你了。同样，如果我后面的关于习惯和规范的帖子，你重点还是放在技术上的话，那是丢了西瓜捡芝麻，有很多贴还是没有任何技术点呢。\n\n附上ResultBean，没有任何技术含量：\n```java\n＠Data\npublic class ResultBean<T> implements Serializable {\n\n  private static final long serialVersionUID = 1L;\n\n  public static final int SUCCESS = 0;\n\n  public static final int FAIL = 1;\n\n  public static final int NO_PERMISSION = 2;\n\n  private String msg = \"success\";\n\n  private int code = SUCCESS;\n\n  private T data;\n\n  public ResultBean() {\n    super();\n  }\n\n  public ResultBean(T data) {\n    super();\n    this.data = data;\n  }\n\n  public ResultBean(Throwable e) {\n    super();\n    this.msg = e.toString();\n    this.code = FAIL ;\n  }\n}\n```\n\n**统一的接口规范，能帮忙规避很多无用的返工修改和可能出现的问题。能使代码可读性更加好，利于进行aop和自动化测试这些额外工作。大家一定要重视。**\n\n下一篇讲controller的规范，还有用到ResultBean，敬请留意。', '2020年03月13日 21:36:26', '2020年03月13日 21:36:26', '../static/images/cover/15841062731441584106188724.png', 1, '工作中，少不了要定义各种接口，系统集成要定义接口，前后台掉调用也要定义接口。接口定义一定程度上能反应程序员的编程功底。列举一下工作中我发现大家容易出现的问题：', 7, 2, 6, 0, 11);
INSERT INTO `article` VALUES (12, '我的编码习惯 - controller规范', '先说说Controller规范，主要的内容是就是接口定义里面的内容，你只要遵循里面的规范，controller就问题不大，除了这些，还有另外的几点：\n\n## 1 所有函数返回统一的ResultBean/PageResultBean格式\n原因见[我的接口定义](http://localhost:8080/article/article_details/11 \"我的接口定义\")这个贴。没有统一格式，AOP无法玩。\n## 2 ResultBean/PageResultBean是controller专用的，不允许往后传！\n## 3 Controller做参数格式的转换，不允许把json，map这类对象传到services去，也不允许services返回json、map。\n一般情况下！写过代码都知道，map，json这种格式灵活，但是可读性差，如果放业务数据，每次阅读起来都比较困难。定义一个bean看着工作量多了，但代码清晰多了。\n## 4 参数中一般情况不允许出现Request，Response这些对象\n主要是可读性问题。一般情况下。\n## 5 不需要打印日志\n日志在AOP里面会打印，而且我的建议是大部分日志在Services这层打印。\n**规范里面大部分是 不要做的项多，要做的比较少，落地比较容易。**\n**ResultBean**定义带泛型，使用了lombok。\n```java\n@Data\npublic class ResultBean<T> implements Serializable {\n\n  private static final long serialVersionUID = 1L;\n\n  public static final int NO_LOGIN = -1;\n\n  public static final int SUCCESS = 0;\n\n  public static final int FAIL = 1;\n\n  public static final int NO_PERMISSION = 2;\n\n  private String msg = \"success\";\n\n  private int code = SUCCESS;\n\n  private T data;\n\n  public ResultBean() {\n    super();\n  }\n\n  public ResultBean(T data) {\n    super();\n    this.data = data;\n  }\n\n  public ResultBean(Throwable e) {\n    super();\n    this.msg = e.toString();\n    this.code = FAIL;\n  }\n}\n```\n`AOP代码`，主要就是打印日志和捕获异常，异常要区分已知异常和未知异常，其中未知的异常是我们重点关注的，可以做一些邮件通知啥的，已知异常可以再细分一下，可以不同的异常返回不同的返回码：\n```java\n/**\n * 处理和包装异常\n */\npublic class ControllerAOP {\n  private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);\n\n  public Object handlerControllerMethod(ProceedingJoinPoint pjp) {\n    long startTime = System.currentTimeMillis();\n\n    ResultBean<?> result;\n\n    try {\n      result = (ResultBean<?>) pjp.proceed();\n      logger.info(pjp.getSignature() + \"use time:\" + (System.currentTimeMillis() - startTime));\n    } catch (Throwable e) {\n      result = handlerException(pjp, e);\n    }\n\n    return result;\n  }\n\n  private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {\n    ResultBean<?> result = new ResultBean();\n\n    // 已知异常\n    if (e instanceof CheckException) {\n      result.setMsg(e.getLocalizedMessage());\n      result.setCode(ResultBean.FAIL);\n    } else if (e instanceof UnloginException) {\n      result.setMsg(\"Unlogin\");\n      result.setCode(ResultBean.NO_LOGIN);\n    } else {\n      logger.error(pjp.getSignature() + \" error \", e);\n      //TODO 未知的异常，应该格外注意，可以发送邮件通知等\n      result.setMsg(e.toString());\n      result.setCode(ResultBean.FAIL);\n    }\n\n    return result;\n  }\n}\n```\n`AOP配置：`(关于用java代码还是xml配置，这里我倾向于xml配置，因为这个会不定期改动)\n```java\n<!-- aop -->\n  <aop:aspectj-autoproxy />\n  <beans:bean id=\"controllerAop\" class=\"xxx.common.aop.ControllerAOP\" />\n  <aop:config>\n    <aop:aspect id=\"myAop\" ref=\"controllerAop\">\n      <aop:pointcut id=\"target\"\n        expression=\"execution(public xxx.common.beans.ResultBean *(..))\" />\n      <aop:around method=\"handlerControllerMethod\" pointcut-ref=\"target\" />\n    </aop:aspect>\n  </aop:config>\n```\n现在知道为什么要返回**统一**的一个`ResultBean`了：\n- 为了统一格式\n- 为了应用AOP\n- 为了包装异常信息\n\n分页的PageResultBean大同小异，大家自己依葫芦画瓢自己完成就好了。\n贴一个简单的controller。请对比 [程序员你为什么这么累](http://localhost:8080/article/article_details/10 \"程序员你为什么这么累\")？里面原来的代码查看，没有对比就没有伤害。\n\n```java\n\n@RequestMapping(\"/config\")\n@RestController\npublic class ConfigController {\n    @Autowired\n    ConfigService configService;\n\n    @GetMapping(\"/all\")\n    public ResultBean<Collection<Config>> getAll() {\n        return new ResultBean<Long>(configService.getAll());\n    }\n\n    @GetMapping(\"/add\")\n    public ResultBean<Long> add(Config config) {\n        return new ResultBean<Long>(configService.add(config));\n    }\n\n    @GetMapping(\"/delete\")\n    public ResultBean<Boolean> delete(Long id) {\n        return new ResultBean<Long>(configService.delete(id));\n    }\n}\n```\n最后说一句，**先有统一的接口定义规范，然后有AOP实现。先有思想再有技术。**技术不是关键，AOP技术也很简单，这个帖子的关键点不是技术，而是习惯和思想，不要捡了芝麻丢了西瓜。网络上讲技术的贴多，讲习惯、风格的少，这些都是我工作多年的行之有效的经验之谈，望有缘人珍惜。', '2020年03月13日 21:51:43', '2020年03月14日 09:50:34', '../../static/images/cover/15841068077871584106756711.png', 1, '第一篇文章中，我贴了2段代码，第一个是原生态的，第2段是我指定了接口定义规范，使用AOP技术之后最终交付的代码，从15行到1行，自己感受一下。今天来说说大家关注的AOP如何实现。', 7, 2, 5, 0, 10);
INSERT INTO `article` VALUES (13, '我的编程习惯 - 日志建议', '开发中日志这个问题，每个公司都强调，也制定了一大堆规范，但根据实际情况看，效果不是很明显，主要是这个东西不好测试和考核，没有日志功能一样跑啊。\n\n但编程活久见，开发久了，总会遇到“这个问题生产环境上能重现，但是没有日志，业务很复杂，不知道哪一步出错了？” 这个时候，怎么办？ 还能怎么办，发个版本，就是把所有地方加上日志，没有任何新功能，然后在让用户重现一遍，拿下日志来看，哦，原来是这个问题。\n\n**有没有很熟悉的感觉？**\n\n还有一种情况，我们系统有3*5=15个节点，出了问题找日志真是痛苦，一个一个机器翻，N分钟后终于找到了，找到了后发现好多相似日志，一个一个排查；日志有了，发现逻辑很复杂，不知道走到那个分支，只能根据逻辑分析，半天过去了，终于找到了原因。。。一个问题定位就过去了2个小时，变更时间过去了一半。。。\n\n所以我对日志的最少有以下2点要求：\n\n**1 能找到那个机器**\n\n**2 能找到用户做了什么**\n\n针对第一点，需要修改一下nginx的配置文件，让返回头里面返回是那个机器处理的。\n\nnginx的基本配置，大家查阅一下资料就知道。\n\n第二点，要知道用户做了什么。**用户信息**是很重要的一个信息，能帮助海量日志里面能快速找到目标日志。一开始要求开发人员打印的时候带上用户，但是发现这个落地不容易，开发人员打印日志都经常忘记，更加不用说日志上加上用户信息，我也不可能天天看代码。所以找了一下`log4j`的配置，果然`log4j`有个叫`MDC(Mapped Diagnostic Context)`的类（技术上使用了ThreadLocal实现，重点技术）。具体使用方法请自行查询。\n\n`filter`中得到用户信息，并放入MDC，记住`filter`后要清理掉（因为`tomcat`线程池线程重用的原因）。\n用户信息放入MDC：\n\nlog4j配置，增加用户信息变量：\n```\nlog4j.rootLogger=debug, stdout\nlog4j.appender.stdout=org.apache.log4j.ConsoleAppender\nlog4j.appender.stdout.layout=org.apache.log4j.PatternLayout\nlog4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n -%X{user}\n```\n我做好上面2步后，对开发人员的日志只有3点要求：\n\n### 1. 修改（包括新增）操作必须打印日志\n大部分问题都是修改导致的。数据修改必须有据可查。\n### 2. 条件分支必须打印条件值，重要参数必须打印\n尤其是分支条件的参数，打印后就不用分析和猜测走那个分支了，很重要！\n### 3. 数据量大的时候需要打印数据量\n前后打印日志和最后的数据量，主要用于分析性能，能从日志中知道查询了多少数据用了多久。这点是建议。自己视情况而决定是否打印，我一般建议打印。\n其实日志的级别我到不是很关注，还没有到关注这步到时候。**开发组长需要做好后勤工作（前面2步），然后制定简单规则，规则太多太能落实了。**\n日志这个东西，更多是靠自觉，项目组这么多人，我也不可能一个一个给大家看代码，然后叫你加日志。我分析了一下，为什么有些人没有打印日志的习惯，说了多次都改不过来。**我建议大家养成下面的习惯，这样你的日志就会改善多了！**\n### 1.不要依赖debug，多依赖日志。\n别人面对对象编程，你面对debug编程。有些人无论什么语言，最后都变成了面对debug编程。哈哈。这个习惯非常非常不好！debug会让你写代码的时候偷懒不打日志，而且很浪费时间。改掉这个恶习。\n### 2. 代码开发测试完成之后不要急着提交，先跑一遍看看日志是否看得懂。\n日志是给人看的，只要热爱编程的人才能成为合格程序员，不要匆匆忙忙写完功能测试ok就提交代码，日志也是功能的一部分。要有精益求精的工匠精神！\n日志规范想不到写了这么多，不容易啊。觉得有帮助请点赞加关注，其他规范敬请期待！', '2020年03月13日 22:01:35', '2020年03月13日 22:01:35', '../static/images/cover/city.jpg', 1, '开发中日志这个问题，每个公司都强调，也制定了一大堆规范，但根据实际情况看，效果不是很明显，主要是这个东西不好测试和考核，没有日志功能一样跑啊。\n但编程活久见，开发久了，总会遇到“这个问题生产环境上能重现，但是没有日志，业务很复杂，不知道哪一步出错了？” 这个时候，怎么办？ 还能怎么办，发个版本，就是把所有地方加上日志，没有任何新功能，然后在让用户重现一遍，拿下日志来看，哦，原来是这个问题。\n', 7, 2, 6, 0, 12);
INSERT INTO `article` VALUES (14, '我的编码习惯 - 异常处理', '对于大型IT系统，最怕的事情第一是系统出现了异常我不知道，等问题闹大了用户投诉了才知道出问题了。第二就是出了问题之后无法找到出错原因。针对这2个问题，说说我们项目组是怎么样规定异常处理的。\n\n再次声明我的观点，我这系列贴里面，没有什么技术点，都是一些编程的经验之谈，而且是建立在项目背景是大部分代码都是简单的CRUD、开发人员流动大水平一般的情况下。希望读者的重点不要再关注技术点。大部分工作中不需要什么技术，你只要把代码写好，足够你轻松面对！\n\n言归正传，说回第一个问题，系统出异常了我不知道，等问题闹大了用户投诉了才知道。这个问题出现非常多，而且非常严重。我不知道其他公司有没有这种场景，对我们公司而言，经常会出现用户反馈、投诉过来说某个功能不可用，开发人员定位分析之后，才发现之前的某一步出错了。公司业务流程非常复杂，和周边系统一堆集成，一堆的后台队列任务，任何一部都可能出问题。\n\n举几个今年真实的案例：\n- 某系统销户无法成功，最后定位发现前段时间ldap密码修改没有更新\n- 某个流程失败，最后发现集成的系统新增加了NAS盘，防火墙不通无法访问导致报错。\n- 某个功能无法使用，查看日志发现后台定时任务已经停了好几天。\n\n针对这些功能，在流程上当然可以采取相对的策略来保证，但从开发的角度来说，任何规定都无法保证一定不会发生错误，老虎也有打盹的时候，我只相信代码。\n贴一段非常常见的代码，大家觉得这段代码有没有问题？\n![常见代码片段](../../static/images/illustration/1584151005514Snipaste_2020-03-14_09-56-32.png)\n在我看来，这段代码很多时候问题特别大！\n#### 1.丢掉了异常。异常就算打印了堆栈，也不会有人去看的！除非用户告诉你出问题了，你才会去找日志！所以，看着好像很严谨的代码，其实作用并不大\n#### 2.异常处理再加上框框2处的空判断，天衣无缝的避开了所有正确答案。本来需要更新文档，结果什么错误没有报，什么也没有做。你后台就算打了日志堆栈又怎么样？\n\n所以，我对开发人员的要求就是，绝大部分场景，不允许捕获异常，不要乱加空判断。只有明显不需要关心的异常，如关闭资源的时候的io异常，可以捕获然后什么都不干，其他时候，不允许捕获异常，都抛出去，到controller处理。空判断大部分时候不需要，你如果写了空判断，你就必须测试为空和不为空二种场景，要么就不要写空判断。\n\n强调，有些空判断是要的，如：参数是用户输入的情况下。但是，大部分场景是不需要的（我们的IT系统里面，一半以上不需要），如参数是其它系统传过来，或者其他地方获取的传过来的，99.99%都不会为空，你判断来干嘛？就抛一个空指针到前台怎么啦？何况基本上不会出现。\n\n新手最容易犯的错误，到处捕获异常，到处加空判断，自以为写出了“健壮”的代码，实际上完全相反。导致的问题，第一代码可读性很差，你如果工作了看到一半代码是try-catch和空判断你会同意我的观点的，第二更加重要的掩盖了很多错误，如上面图片的例子！日志是不会有人看的，我们的目的是尽早让错误抛出来，还有，你加了空判断，那你测试过为空的场景吗？\n\nweb请求上的异常，不允许开发人员捕获，直接抛到前台，会有controller处理！见[我的编码习惯 - Controller规范](http://localhost:8080/article/article_details/12 \"我的编码习惯 - Controller规范\")\n所以上面的代码，我来写的话是这样的，清晰明了。\n![我的代码片段](../../static/images/illustration/1584151174579Snipaste_2020-03-14_09-59-18.png)\n另外一种后台定时任务队列的异常，其实思路是一样的，有个统一的地方处理异常，里面的代码同样不准捕获异常！然后异常的时候邮件通知到我和开发人员，开发组长必须知道后台的任何异常，不要等用户投诉了才知道系统出问题了。\n\n另外，开发组长需要自己定义好系统里面的异常，其实能定义的没有几种，太细了很难落地，来，异常不要继承Exception，而是继承RuntimeException，否则到时候从头改到尾就为了加个异常声明你就觉得很无聊。\n![重构后的代码](../../static/images/illustration/1584151277667Snipaste_2020-03-14_10-01-02.png)\n总结：\n- 开发组长定义好异常，异常继承RuntimeException。\n- 不允许开发人员捕获异常。（异常上对开发人员就这点要求！异常都抛出到controller上用AOP处理）\n- 后台（如队列等）异常一定要有通知机制，要第一时间知道异常。\n- 少加空判断，加了空判断就要测试为空的场景！\n\n这篇文章，我估计一定有很多争议，这些规则都和常见的认识相反，我在公司里面推广和写贴分享的时候也有人反对。但是，你要知道你遇到的是什么问题，要解决的是什么问题？我遇到是很多异常本来很简单，但由于一堆健壮的try-catch和空判断，导致问题发现很晚，可能很小一个问题最后变成了一个大事件，在一些IT系统里面，尤其常见。大家不要理解为不能加空判断，大家见仁见智吧。反正我是这样写代码的，我发现效果很好，我很少花时间在调试代码和改bug上，更加不会出现前台返回成功，后台有异常什么也没有做的场景。\n\n最后对新手说一句，不要养成到处try-catch和加空判断的恶习，你这样会掩盖掉很多错误，给人埋很多坑的！\n', '2020年03月14日 10:02:54', '2020年03月14日 10:39:06', '../../../static/images/cover/city.jpg', 1, '对于大型IT系统，最怕的事情第一是系统出现了异常我不知道，等问题闹大了用户投诉了才知道出问题了。第二就是出了问题之后无法找到出错原因。针对这2个问题，说说我们项目组是怎么样规定异常处理的。', 7, 2, 6, 0, 11);
INSERT INTO `article` VALUES (15, '我的编码习惯 - 参数校验和国际化规范', '今天我们说说参数校验和国际化，这些代码没有什么技术含量，却大量充斥在业务代码上，很可能业务代码只有几行，参数校验代码却有十几行，非常影响代码阅读，所以很有必要把这块的代码量减下去。\n\n今天的目的主要是把之前例子里面的和业务无关的国际化参数隐藏掉，以及如何封装好校验函数。\n\n今天累，少说话多贴代码，先看对比图，修改前：\n![修改前代码](../../static/images/illustration/1584151469962Snipaste_2020-03-14_10-04-17.png)\nservice\n![service代码](../../static/images/illustration/1584151518172Snipaste_2020-03-14_10-05-04.png)\n修改后：\n![修改后代码](../../static/images/illustration/1584151584056Snipaste_2020-03-14_10-06-13.png)\nservices\n![service修改后代码](../../static/images/illustration/1584151679361Snipaste_2020-03-14_10-07-49.png)\nControll的非业务代码如何去掉参考[我的编码习惯 - Controller规范](http://localhost:8080/article/article_details/12 \"我的编码习惯 - Controller规范\")，下面说说去掉Local参数。\n\n**强调一下：业务代码里面不要出现和业务无关的东西，如local，MessageSource 。**\n\n**去掉国际化参数还是使用的技术还是ThreadLocal。**国际化信息可以放好几个地方，但建议不要放在每一个url上，除了比较low还容易出很多其他问题。这里演示的是放在cookie上面的例子：\n![](../static/images/illustration/1584151784621Snipaste_2020-03-14_10-09-32.png)\n\nUserUtil\n\n```java\npublic class UserUtil {\n\n  private final static ThreadLocal<String> tlUser = new ThreadLocal<String>();\n\n  private final static ThreadLocal<Locale> tlLocale = new ThreadLocal<Locale>() {\n    protected Locale initialValue() {\n      // 语言的默认值\n      return Locale.CHINESE;\n    };\n  };\n\n  public static final String KEY_LANG = \"lang\";\n\n  public static final String KEY_USER = \"user\";\n\n  public static void setUser(String userid) {\n    tlUser.set(userid);\n\n    // 把用户信息放到log4j\n    MDC.put(KEY_USER, userid);\n  }\n\n  public static String getUser() {\n    return tlUser.get();\n  }\n\n  public static void setLocale(String locale) {\n    setLocale(new Locale(locale));\n  }\n\n  public static void setLocale(Locale locale) {\n    tlLocale.set(locale);\n  }\n\n  public static Locale getLocale() {\n    return tlLocale.get();\n  }\n\n  public static void clearAllUserInfo() {\n    tlUser.remove();\n    tlLocale.remove();\n\n    MDC.remove(KEY_USER);\n  }\n}\n```\n\nCheckUtil，这里需要得到用户的语言\n\n```java\npackage plm.common.utils;\n\nimport org.springframework.context.MessageSource;\n\nimport plm.common.exceptions.CheckException;\n\npublic class CheckUtil {\n  private static MessageSource resources;\n\n  public static void setResources(MessageSource resources) {\n    CheckUtil.resources = resources;\n  }\n\n  public static void check(boolean condition, String msgKey, Object... args) {\n    if (!condition) {\n      fail(msgKey, args);\n    }\n  }\n\n  public static void notEmpty(String str, String msgKey, Object... args) {\n    if (str == null || str.isEmpty()) {\n      fail(msgKey, args);\n    }\n  }\n\n  public static void notNull(Object obj, String msgKey, Object... args) {\n    if (obj == null) {\n      fail(msgKey, args);\n    }\n  }\n\n  private static void fail(String msgKey, Object... args) {\n    throw new CheckException(resources.getMessage(msgKey, args, UserUtil.getLocale()));\n  }\n}\n```\n\n这里有几个小技术点：\n\n工具类里面使用spring的bean，使用了MethodInvokingFactoryBean的静态方法注入：\n\n```xml\n<!-- 国际化 -->\n<bean id=\"messageSource\"\n  class=\"org.springframework.context.support.ResourceBundleMessageSource\">\n  <property name=\"basenames\">\n    <list>\n      <value>format</value>\n      <value>exceptions</value>\n      <value>windows</value>\n    </list>\n  </property>\n</bean>\n\n<bean\n  class=\"org.springframework.beans.factory.config.MethodInvokingFactoryBean\">\n  <property name=\"staticMethod\" value=\"plm.common.utils.CheckUtil.setResources\" />\n  <!-- 这里配置参数 -->\n  <property name=\"arguments\" ref=\"messageSource\">\n  </property>\n</bean>\n```\n\nserver里面调用的使用没有出现类名\n\n![](../static/images/illustration/1584151925635Snipaste_2020-03-14_10-11-52.png)\n\n这里使用的jdk的import static 特性，可以在ide上配置，请自行google。\n\n`import static plm.common.utils.CheckUtil.*;`\n还有一小点注意，我建议参数非法的时候，把值打印出来，否则你又要浪费时间看是没有传呢还是传错了，时间就是这样一点点浪费的。\n`check(id > 0L, \"id.error\", id); // 当前非法的id也传入提示出去`\n\n另外有些项目用valid来校验，从我实际接触来看，用的不多，可能是有短木板吧。如果你的项目valid就能满足，那就更加好了，不需要看了。但是大部分场景，校验比例子复杂N多，提示也千变万化，所以我们还是自己调用函数校验。\n\n做了这几步之后，代码会漂亮很多，记住，**代码最主要的不是性能，而是可读性**，有了可读性才有才维护性。而去掉无关的代码后的代码，和之前的代码对比一下，自己看吧。\n\n还有人说代码要注释率到多少（我们公司有段时间工具扫描要求注释率到30%以上），依我看来，大部分业务代码这么简单，你把代码写成我例子那样，还需要什么注释？注释是画蛇添足。\n\n敬请期待,后续更新。', '2020年03月14日 10:14:59', '2020年03月14日 10:36:58', '../../../static/images/cover/city.jpg', 1, '今天我们说说参数校验和国际化，这些代码没有什么技术含量，却大量充斥在业务代码上，很可能业务代码只有几行，参数校验代码却有十几行，非常影响代码阅读，所以很有必要把这块的代码量减下去。', 7, 2, 5, 0, 7);

-- ----------------------------
-- Table structure for article_attitude
-- ----------------------------
DROP TABLE IF EXISTS `article_attitude`;
CREATE TABLE `article_attitude`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(20) NULL DEFAULT NULL COMMENT '用户id',
  `article_id` int(20) NULL DEFAULT NULL COMMENT '文章id',
  `attitude` int(20) NULL DEFAULT NULL COMMENT '态度 0为不赞同 1为赞同',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article_attitude
-- ----------------------------
INSERT INTO `article_attitude` VALUES (1, 1, 2, 1);
INSERT INTO `article_attitude` VALUES (2, 1, 1, 1);
INSERT INTO `article_attitude` VALUES (3, 2, 2, 1);
INSERT INTO `article_attitude` VALUES (4, 2, 4, 0);
INSERT INTO `article_attitude` VALUES (5, 2, 1, 1);
INSERT INTO `article_attitude` VALUES (6, 1, 4, 1);
INSERT INTO `article_attitude` VALUES (7, 2, 3, 1);
INSERT INTO `article_attitude` VALUES (8, 3, 2, 1);
INSERT INTO `article_attitude` VALUES (9, 3, 3, 1);
INSERT INTO `article_attitude` VALUES (10, 3, 4, 1);
INSERT INTO `article_attitude` VALUES (11, 4, 4, 1);
INSERT INTO `article_attitude` VALUES (12, 3, 1, 1);
INSERT INTO `article_attitude` VALUES (13, 9, 2, 1);
INSERT INTO `article_attitude` VALUES (14, 14, 3, 1);
INSERT INTO `article_attitude` VALUES (15, 2, 10, 1);
INSERT INTO `article_attitude` VALUES (16, 2, 11, 1);
INSERT INTO `article_attitude` VALUES (17, 2, 13, 1);
INSERT INTO `article_attitude` VALUES (18, 2, 12, 1);
INSERT INTO `article_attitude` VALUES (19, 1, 10, 1);
INSERT INTO `article_attitude` VALUES (20, 1, 11, 1);
INSERT INTO `article_attitude` VALUES (21, 1, 12, 1);
INSERT INTO `article_attitude` VALUES (22, 1, 13, 1);
INSERT INTO `article_attitude` VALUES (23, 1, 14, 1);
INSERT INTO `article_attitude` VALUES (24, 1, 15, 1);
INSERT INTO `article_attitude` VALUES (25, 2, 14, 1);
INSERT INTO `article_attitude` VALUES (26, 2, 15, 1);
INSERT INTO `article_attitude` VALUES (27, 3, 10, 1);
INSERT INTO `article_attitude` VALUES (28, 3, 11, 1);
INSERT INTO `article_attitude` VALUES (29, 3, 12, 1);
INSERT INTO `article_attitude` VALUES (30, 3, 13, 1);
INSERT INTO `article_attitude` VALUES (31, 3, 14, 1);
INSERT INTO `article_attitude` VALUES (32, 3, 15, 1);
INSERT INTO `article_attitude` VALUES (33, 4, 10, 1);
INSERT INTO `article_attitude` VALUES (34, 4, 12, 1);
INSERT INTO `article_attitude` VALUES (35, 4, 11, 1);
INSERT INTO `article_attitude` VALUES (36, 4, 13, 1);
INSERT INTO `article_attitude` VALUES (37, 4, 14, 1);
INSERT INTO `article_attitude` VALUES (38, 6, 10, 1);
INSERT INTO `article_attitude` VALUES (39, 6, 11, 1);
INSERT INTO `article_attitude` VALUES (40, 6, 12, 1);
INSERT INTO `article_attitude` VALUES (41, 6, 13, 1);
INSERT INTO `article_attitude` VALUES (42, 6, 14, 1);
INSERT INTO `article_attitude` VALUES (43, 6, 15, 1);
INSERT INTO `article_attitude` VALUES (44, 8, 15, 1);
INSERT INTO `article_attitude` VALUES (45, 8, 10, 1);
INSERT INTO `article_attitude` VALUES (46, 8, 11, 1);
INSERT INTO `article_attitude` VALUES (47, 8, 13, 1);
INSERT INTO `article_attitude` VALUES (48, 8, 14, 1);

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_id` int(20) NULL DEFAULT NULL COMMENT '帖子id',
  `tag_id` int(20) NULL DEFAULT NULL COMMENT '标签id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES (1, 3, 8);
INSERT INTO `article_tag` VALUES (2, 4, 1);
INSERT INTO `article_tag` VALUES (3, 4, 6);
INSERT INTO `article_tag` VALUES (4, 1, 7);
INSERT INTO `article_tag` VALUES (11, 5, 5);
INSERT INTO `article_tag` VALUES (12, 2, 2);
INSERT INTO `article_tag` VALUES (13, 9, 1);
INSERT INTO `article_tag` VALUES (14, 9, 10);
INSERT INTO `article_tag` VALUES (15, 10, 1);
INSERT INTO `article_tag` VALUES (16, 10, 10);
INSERT INTO `article_tag` VALUES (17, 11, 1);
INSERT INTO `article_tag` VALUES (18, 11, 10);
INSERT INTO `article_tag` VALUES (19, 12, 1);
INSERT INTO `article_tag` VALUES (20, 12, 10);
INSERT INTO `article_tag` VALUES (21, 13, 1);
INSERT INTO `article_tag` VALUES (22, 13, 10);
INSERT INTO `article_tag` VALUES (23, 14, 1);
INSERT INTO `article_tag` VALUES (24, 14, 10);
INSERT INTO `article_tag` VALUES (25, 15, 1);
INSERT INTO `article_tag` VALUES (26, 15, 10);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(20) NULL DEFAULT NULL COMMENT '用户id',
  `article_id` int(20) NULL DEFAULT NULL COMMENT '帖子id',
  `create_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `parent_comment_id` int(20) NULL DEFAULT NULL COMMENT '父级评论id',
  `son_comment_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子级评论id的list集合',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 2, '2020年01月10日 13:04:12', 'test comment 1', 0, '9,10,12,13');
INSERT INTO `comment` VALUES (2, 5, 2, '2020年01月14日 13:50:39', '评论测试....', 0, '23');
INSERT INTO `comment` VALUES (9, 6, 2, '2020年01月19日 15:59:49', '@张三: 回复评论测试1', 1, '12');
INSERT INTO `comment` VALUES (10, 10, 2, '2020年01月19日 16:42:23', '@张三: 回复评论测试2', 1, '13');
INSERT INTO `comment` VALUES (12, 8, 2, '2020年01月19日 17:03:51', '@赵八: 回复评论的评论的测试1', 9, NULL);
INSERT INTO `comment` VALUES (13, 8, 2, '2020年01月19日 17:05:24', '@熊二: 回复评论的评论测试2', 10, '');
INSERT INTO `comment` VALUES (16, 1, 2, '2020年01月25日 17:17:23', '@钱七: 删除评论测试', 2, '');
INSERT INTO `comment` VALUES (23, 7, 2, '2020年01月25日 17:53:05', '@钱七: dasdasdasd', 2, NULL);

-- ----------------------------
-- Table structure for comment_attitude
-- ----------------------------
DROP TABLE IF EXISTS `comment_attitude`;
CREATE TABLE `comment_attitude`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(20) NULL DEFAULT NULL COMMENT '用户id',
  `comment_id` int(20) NULL DEFAULT NULL COMMENT '评论id',
  `attitude` int(20) NULL DEFAULT NULL COMMENT '态度 0为不赞同 1为赞同',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment_attitude
-- ----------------------------

-- ----------------------------
-- Table structure for jurisdiction
-- ----------------------------
DROP TABLE IF EXISTS `jurisdiction`;
CREATE TABLE `jurisdiction`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `resource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '允许访问的资源',
  `value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sortnum` int(8) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of jurisdiction
-- ----------------------------
INSERT INTO `jurisdiction` VALUES (1, '/login', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (2, '/static/**', 'anon', 20);
INSERT INTO `jurisdiction` VALUES (3, '/**', 'authc', 999);
INSERT INTO `jurisdiction` VALUES (4, '/index', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (5, '/logout', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (6, '/logout', 'logout', 10);
INSERT INTO `jurisdiction` VALUES (7, '/register', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (8, '/article/**', 'anon', 25);
INSERT INTO `jurisdiction` VALUES (9, '/article/article_input/**', 'authc', 20);
INSERT INTO `jurisdiction` VALUES (10, '/article/myArticle/**', 'authc', 20);
INSERT INTO `jurisdiction` VALUES (11, '/type/**', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (12, '/tag/**', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (13, '/user/author', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (14, '/about', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (15, '/user/author_details/**', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (16, '/findAccountName', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (17, '/findNickname', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (18, '/addComment', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (19, '/delComment', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (20, '/admin/login', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (21, '/admin/**', 'authc', 20);
INSERT INTO `jurisdiction` VALUES (22, '/admin/loginPage', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (23, '/user/sendEmail', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (24, '/user/changePwdPage', 'anon', 10);
INSERT INTO `jurisdiction` VALUES (25, '/user/changePassword', 'anon', 10);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `role_mark` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'user', '用户角色');
INSERT INTO `role` VALUES (2, 'admin', '管理员角色');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tag_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, 'Java', '2020年01月04日 14:45:30');
INSERT INTO `tag` VALUES (2, 'MySql', '2020年01月04日 14:51:58');
INSERT INTO `tag` VALUES (3, 'Html', '2020年01月04日 14:53:08');
INSERT INTO `tag` VALUES (4, 'CSS', '2020年01月04日 15:39:23');
INSERT INTO `tag` VALUES (5, 'JavaScript', '2020年01月04日 15:48:29');
INSERT INTO `tag` VALUES (6, 'SpringBoot', '2020年01月04日 15:53:05');
INSERT INTO `tag` VALUES (7, 'markdown', '2020年01月06日 13:47:27');
INSERT INTO `tag` VALUES (8, 'linux', '2020年01月06日 14:02:54');
INSERT INTO `tag` VALUES (9, 'solr', '2020年01月20日 15:30:31');
INSERT INTO `tag` VALUES (10, 'Spring', '2020年01月30日 20:56:25');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '话题名',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '学习感悟', '2020年01月04日 15:10:42');
INSERT INTO `type` VALUES (2, '问题与总结', '2020年01月04日 15:13:16');
INSERT INTO `type` VALUES (3, '重在实践', '2020年01月04日 15:16:23');
INSERT INTO `type` VALUES (4, '创新突破', '2020年01月04日 15:23:31');
INSERT INTO `type` VALUES (5, '挑战不可能', '2020年01月04日 15:25:28');
INSERT INTO `type` VALUES (6, '错误日志', '2020年01月04日 15:53:33');
INSERT INTO `type` VALUES (7, '技术栈', '2020年03月13日 21:21:11');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `account_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户名',
  `account_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户密码',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `user_intro` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户简介',
  `user_mailbox` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `user_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `user_avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'cf2f84b6b83710fd7442ede509c95012', '张三', '这是测试账户', '2424417354@qq.com', '18737843824', '../static/images/avatar/1578645165891Koala.jpg');
INSERT INTO `user` VALUES (2, 'admin1', '83e096e439c66b94cc7bbb616f414034', '李四', '这是测试账户', 'admin@163.com', '15306829271', '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES (3, 'admin2', '5751ed26ca55faaf65db9ba91516e580', '王五', '这是测试账户', 'admin@163.com', '15016065465', '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES (4, 'admin3', 'f5e54952015ddb3221c10fa04e02ce69', '赵六', '赵六的个人介绍', 'admin@163.com', '18737843825', '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES (5, 'admin4', '58c43a61991e94d874de136ea9fd0b73', '钱七', '这是测试账户', 'admin@163.com', '17350211389', '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES (6, 'admin5', '0689c2dba08e6e2573f2d842ee022e52', '赵八', '这是测试账户', 'admin@163.com', '13500368199', '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES (7, 'admin6', 'd0d0314119939b4763c4b93841cafc28', '刘九', '这是测试账户', 'admin@163.com', '13801023888', '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES (8, 'admin7', '12819060e4d7dba530f129e05875034f', '孙十', '这是测试账户', 'admin@163.com', '13851733655', '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES (9, 'admin8', 'c8a7dc7dc08e44ff419c1648726797e3', '熊大', '测试账户', 'admin8@qq.com', '18638623273', '../static/images/avatar/1578977994806Tulips.jpg');
INSERT INTO `user` VALUES (10, 'admin9', 'fdc8cb1fbfb7ce4ac1910f7b7c489d03', '熊二', '测试账户', 'admin9@qq.com', '13638632323', '../static/images/avatar/1578978439036Penguins.jpg');
INSERT INTO `user` VALUES (11, 'admin10', '1f31c2fd147ed3a1f7408e288847c41a', '光头强', '这是测试账户', 'admin@163.com', '17723309169', '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES (12, 'admin11', 'a4d5553f6ec0bd8c6c427c2bf66a0be4', '海绵宝宝', '测试账户', 'admin10@qq.com', '13538734636', '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES (14, 'liwenbo', '23a5c1390196e2ea8d8acfe85c4c4a0a', '李文博', '这是测试账户', 'admin@163.com', '15739121359', '../static/images/avatar/Lighthouse.jpg');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(16) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` int(16) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 1);
INSERT INTO `user_role` VALUES (3, 3, 1);
INSERT INTO `user_role` VALUES (4, 4, 1);
INSERT INTO `user_role` VALUES (5, 5, 1);
INSERT INTO `user_role` VALUES (6, 6, 1);
INSERT INTO `user_role` VALUES (7, 7, 1);
INSERT INTO `user_role` VALUES (8, 8, 1);
INSERT INTO `user_role` VALUES (9, 9, 1);
INSERT INTO `user_role` VALUES (10, 10, 1);
INSERT INTO `user_role` VALUES (11, 11, 1);
INSERT INTO `user_role` VALUES (12, 12, 1);
INSERT INTO `user_role` VALUES (13, 14, 2);

SET FOREIGN_KEY_CHECKS = 1;
