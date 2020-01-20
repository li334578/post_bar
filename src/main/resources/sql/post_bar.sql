/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : post_bar

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-01-20 16:30:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '帖子标题',
  `content` longtext COMMENT '帖子内容',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `first_picture` varchar(255) DEFAULT NULL COMMENT '封面图地址',
  `published` int(4) DEFAULT NULL COMMENT '是否发布',
  `description` varchar(255) DEFAULT NULL COMMENT '描述/摘要 信息',
  `type_id` int(20) DEFAULT NULL COMMENT '文章所属话题',
  `user_id` int(20) DEFAULT NULL COMMENT '文章所属用户 id',
  `approval_num` int(20) DEFAULT NULL COMMENT '文章赞同数',
  `trample_num` int(20) DEFAULT NULL COMMENT '文章点踩数',
  `browse_volume` int(20) DEFAULT NULL COMMENT '文章浏览数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'Markdown使用示例', '//将下面的文字复制粘贴到你的有道云笔记Markdown编辑器/简书Markdown编辑器即可在预览中重现上文。\n> 作者：在路上\\\n贡献者：诺布\n\n# 0x00 写在前面\n\n#### 到底什么是个Markdown?\n- **Markdown** 是一种文本编辑时候使用的**语法**，通过在文字中加入助记符，将排版/编号/列表/文字高亮/加粗等问题交给机器处理，对文字进行自动排版，从而大大提高编辑记录效率。\n\n- 有道云Markdown编辑器 or 简书Markdown编辑器都是依照这种Markdown**语法的实现**，所以难免上渲染出来的效果有些小偏差，但是排版方式是通用的。\n\n#### 为什么要用Markdown?\n\n- 文章的排版很麻烦，如果有一种对于文章排版的解决方案就好了。\n\n- 学习实践Markdown语法后你可以自定义你的文章排版。\n\n- 这是一套定义文章排版格式的语法。\n\n- 这是一个边际成本递减的升维实践过程。\n\n#### Markdown的应用场景?\n\n可以说，所有的文本场景下都可以使用Markdown语法，只要你有一个支持Markdown语法的编辑器就可以，笔者使用的是有道云笔记的Markdown编辑器，因为其支持语法全面(包括文本高亮标记)。当前探索出的支持Markdown的环境有:有道云笔记、简书、微信公众号推送(粘贴渲染排版后的文本即可)。\n\n#### 本文逻辑安排目录：\n\n1. **Markdown可以实现的排版效果**\n\n2. **Markdown文章示例**\n\n3. **本文的Markdown语法的原文**\n\n# 0x01 标题相关示例\n---\n# 主标题\n## 副标题\n### 一级标题\n#### 二级标题\n##### 三级标题\n###### 六级小标题\n### [标题网址](http://yq.upwith.me/)\n> 引用文字块\n---\n\n\n# 0x02 无序列表相关示例\n---\n- # 一级列表\n- ## 二级列表\n- ### 三级列表\n- #### 四级列表\n- ##### 五级列表\n- ###### 六级列表\n---\n\n# 0x03 有序列表相关示例\n---\n1. **加粗标题1**\n    1. 自编号标题1.1\n        1. ++下划线自编号标题1.1.1++\n            1. *斜体自编号标题1.1.1.1*\n\n---\n\n# 0x04 综合使用示例\n\n> 使用MD时候的要点，合理使用无序列表语法与自定义序号，尽量少使用有序列表语法，因为存在兼容性问题(有道云笔记兼容性比简书好很多)会导致标题无层次分类，示例开始。\n\n![image](http://upload-images.jianshu.io/upload_images/6189910-13d61acf16fccc84.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\n## 一、如何更好地理解第四章？\n### (一) 前置两个问题：升维与复杂系统\n#### 1. 升维\n##### (1) 维度是什么？\n时空坐标体系下的坐标轴数量，可以理解为**增加的视野角度**。\n        \n##### (2) 高维和低维的关系\n- 信息密度*高*，信息量*大*\n- 低维是高维的切片\n- 高维的低维展开会导致低维量级的无限扩张\n- 推演：高维比低维的视角更多\n        \n### 2. 复杂系统\n#### (1) 定义\n什么叫系统？一组组内相互作用、相互依赖的复杂整体\n#### (2) 要素\n#### (3) 系统的三要素\n- 系统关系\n- **元素间关系**\n- 系统功能\n#### (4) 两大类系统\n##### ① 他组织系统\n- 系统元素\n- 系统结构关系\n- 系统功能\n- 特点：功能稳定，输入一定，输出一定。\n##### ② 自组织系统\n\n---\n\n# 0x05 Markdown原文\n\nMarkdown与Markdown编辑器与排版文字的关系梳理与实践：\n\n- Markdown格式原文->有道云Markdown编辑器 or 简书Markdown编辑器->预览效果就是发布后的效果\n\n- 简书中Markdown编辑器开启方式\n    - ```个人设置-基础设置-常用编辑器-Markdown```\n\n- 有道云笔记Markdown编辑器开启方式\n    - ```新文档-新建Markdown```', '2020年01月06日 13:50:28', '2020年01月06日 13:50:28', '../static/images/cover/157906924839620191.jpg', '0', '一个Markdown的使用实例', '1', '1', '3', '0', '21');
INSERT INTO `article` VALUES ('2', 'Linux知识总结', '## linux常用的命令\n| 序号 |命令  |对应英文|作用|\n|--|--|--|--|\n|01|ls|list|查看当前文件夹下的内容|\n|02|pwd|print work directory|查看当前所在文件夹|\n|03|cd(目录名)|change directory|切换文件夹|\n|04|touch(文件名)|touch|如果文件不存在，创建新文件|\n|05|mkdir(目录名)|make directory|创建目录|\n|06|rm(文件名)|remove|删除指定文件名|\n|07|clear|clear|清屏|\ntip:\nctrl+shift+= :放大终端窗口的字体显示\nctrl+- :缩小终端窗口的字体显示\nrm -r 目录名 删除指定目录\n## linux终端命令格式 [表示可选]\n- 1.command [-options][parameter]\n command 命令名，相应功能的英文单词或单词的缩写。\n [-options] 选项，可用来对命令进行控制，也可省略。\n [parameter] 传给命令的参数可以是0个、1个或者多个。\n- 2.查询命令的帮助信息\n - 2.1--help\n command --help\n 显示command命令的帮助信息\n - 2.2man\n man command\n 查询 command命令的帮助信息\n man 是manual的缩写，是linux提供的一个手册，包含了绝大部分的命令、函数的详细使用说明。\n 使用man时的操作键：\n \n|操作键| 功能 |\n|--|--|\n| 空格键 | 显示手册的下一屏 |\n| enter键 | 一次滚动手册页的一行 |\n| b | 回滚一屏 |\n| f | 前滚一屏 |\n| q | 退出 |\n| /word | 搜索word字符串 |\n### 文件和目录的常用命令\n查看目录内容 ls\n切换目录 cd\n创建和删除文件操作 touch rm mkdir\n拷贝和移动文件 cp mv\n查看文件内容 cat more  grep\n其他 echo 重定向>和>>管道1\n- 1.查看目录内容\n - 1.1linux终端实用技巧\n  - 自动补全\n  在敲出文件/目录/命令 的前几个字母后，按下tab键\n  如果输入的没有歧义系统会进行自动补全\n  如果还存在其他 文件/目录/命令，再按一下tab键，系统会提示当前可能存在的命令。\n  - 曾经使用过的命令\n  按 ↑/↓光标键可以在曾经使用过的命令中来回切换\n  如果想要退出选择，并且不想执行当前选中的命令。可以按ctrl+c。\n - 1.2 ls命令说明\n ls是英文单词list的缩写，其功能是列出目录的所有内容，是用户最常用的命令之一类似于Dos下的dir命令。\n linux下的文件和目录的特点\n linux下文件和目录名称最多可以有256个字符。\n 以.开头的文件为隐藏文件，需要加上-a参数才能显示。\n .表示当前目录 ..表示上一级目录', '2020年01月06日 14:05:04', '2020年01月10日 10:04:55', '../static/images/cover/1579055203921_20191213093838.jpg', '1', '一个介绍linux的帖子-update', '1', '1', '4', '0', '186');
INSERT INTO `article` VALUES ('3', 'linux入门', '## 1.操作系统 OS\n没有安装操作系统的计算机叫做裸机。\n在裸机上运行程序必须使用机器语言来编写程序。\n### 1.1操作系统直接操作硬件\n作用：封装后调用\n### 1.2\n- 1 桌面级操作系统 windows （安全性稳定性不好）、macos（基于Linux适合于开发人员）、Linux（应用软件较少）。\n- 2 服务器操作系统 \n linux 安全、稳定、免费 占有率高\n windows server 付费占有率低\n- 3 嵌入式操作系统\n 智能家居 linux\n- 4 移动设备操作系统\n ios、android（基于linux）\n### 1.3 虚拟机（virtual Machine）\n指通过软件模拟的具有完整硬件系统功能的、运行在一个完全隔离的环境中的完整的操作系统。\n- 1 虚拟系统是指通过生成完整的虚拟镜像具有真实操作系统完全一样的功能\n- 2 进入虚拟系统后，所有的操作都是在这个全新的，独立的虚拟系统中进行，可以独立安装运行软件、保存数据、拥有独立桌面、不会对真正的系统产生任何的影响\n- 3 而且能够在现有的操作系统和虚拟镜像之间灵活切换的一类操作系统。\n## 1.操作系统的发展史\n- 1.1 unix 多个用户能够在同一时间登录到同一个计算机上使用的系统。\n- 1.2 minix 教学使用\n- 1.3 linux \n      内核版本：是系统的心脏，是运行程序和管理像磁盘和打印机等硬件设备的核心程序，它提供了一个在设备与应用程序之间抽象层，包括稳定版本和开发版本。\n      发行版本：通常包含了桌面环境、办公套件、媒体播放器、数据库。\n      常见版本：ubuntu，Redhat，Fedora。opensuse，linux Mint，Debian，Manjaro，mageia，centos，Arch。\n## 2.文件系统 \n- 2.1windows下文件系统(基于单用户或家目录)\n 每个驱动器都有自己的根目录结构\n- 2.2linux 文件系统(基于多用户操作系统) /home\n Ubuntu没有盘符概念，只有一个根目录/\n- 2.3 用户目录\n /home/user 称为用户目录或者家目录\n- 2.4 linux 主要目录速查表\n/：根目录 根目录下只存放目录\n/bin ./usr/bin:可执行的二进制文件的目录\n/boot 放置li', '2020年01月06日 14:12:55', '2020年01月06日 14:12:55', '../static/images/cover/1579054612005Lighthouse.jpg', '1', 'linux的一些相关知识', '1', '2', '2', '0', '44');
INSERT INTO `article` VALUES ('4', 'Spring Boot 快速搭建web项目', '# Spring Boot 快速搭建web项目\n- 操作系统：win10\n- 开发工具：IDEA2017.3.4\n- 数据库: MySQL+Mybatis\n- 使用数据源: Druid\n## 1.Create new project(Spring Initializr)\n推荐使用 jdk1.8，我这里使用的是jdk9.0\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903100041315.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 2. next 确认输入的信息\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903101433510.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 3.next 勾选组件IDEA会自动生成pom文件中的依赖\n- Lombok是IDEA 的一个插件 使用其中的@Data注解可以自动生成实体类的 Get Set 以及ToString等方法（没有可以不勾选，自己手动生成方法）\n- Spring web Starter web的启动器\n- MySQLDriver MySQL mysql驱动组件\n- MyBatis mybatis的组件\n![在这里插入图片描述](https://img-blog.csdnimg.cn/2019090310041098.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 4.next 确认文件存放位置\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903101136691.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 5.finish IDEA会创建一个新工程\n### 新文件的层级目录\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903101635796.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 6.导入Druid数据源和log4j的依赖坐标\n右下角选自动导入就可以\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903101801183.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n\n```xml\n//坐标在这里可以直接复制\n<dependency>\n            <groupId>com.alibaba</groupId>\n            <artifactId>druid</artifactId>\n            <version>1.0.9</version>\n        </dependency>\n        <dependency>\n            <groupId>log4j</groupId>\n            <artifactId>log4j</artifactId>\n            <version>1.2.12</version>\n        </dependency>\n```\n## 7.创建并配置application.yml文件\n- 注:根据个人喜好也可以使用application.properties\n- username和password请配置自己数据库的用户名和密码\n- driver-class-name 是上面配置的mysql驱动\n- url配置好数据库所在的ip地址 jdbc:mysql://localhost:3306/eesy_mybatis 以及数据库名称\n- ?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC这是数据库配置的参数，设置数据库的编码格式和时区。\n- type 数据源\n```yml\nspring:\n  datasource:\n    username: root\n    password: root\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/eesy_mybatis?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC\n    type: com.alibaba.druid.pool.DruidDataSource\n```\n\n## 8.配置数据源 在工程下创建Config->DruidConfig文件\n- 配置Druid数据源\n```java\n@Configuration\npublic class DruidConfig {\n    @ConfigurationProperties(prefix = \"spring.datasource\")\n    @Bean\n    public DataSource druid(){\n        return new DruidDataSource();\n    }\n}\n```\n## 9.编写实体类 bean->User\n- @Data注解是Lombok提供的自动生成Get和Set以及ToSting方法的注解\n- 可以通过file->setting->Plugins->Browse repositories..搜索Lombok安装并重启IDEA。再在pom.xml文件中配置`<dependency>\n   <groupId>org.projectlombok</groupId>\n   <artifactId>lombok</artifactId>\n   <optional>true</optional>\n  </dependency>`即可使用\n- 也可以自己手动使用Alt+Insert 生成Get和Set方法\n```java\n@Data\npublic class User {\n    private Integer id;\n    private String username;\n    private Date birthday;\n    private String sex;\n    private String address;\n}\n```\n## 10.编写Mapper->UserMapper接口\n\n```java\n@Mapper\npublic interface UserMapper {\n //查询所有方法\n    @Select(\"select * from user\")\n    public List<User> findAll();\n\n}\n```\n## 11.编写Controller->UserController方法\n\n```java\n@RestController\npublic class UserController {\n //注入UserMapper 这里DEA可能会提示报错不用理会就行\n    @Autowired\n    UserMapper userMapper;\n \n    @GetMapping(\"/user\")\n    public List<User> findAll(){\n        return userMapper.findAll();\n    }\n}\n```\n## 12.resources->static->index.html编写index.html向后台发送ajax请求\n- 需要创建resources->static->js并引入jquery-1.12.4.min.js文件\n```html\n<head>\n<script src=\"js/jquery-1.12.4.min.js\"></script>\n<script>\n$(function () {\n            //查询所有\n            var select_all = $(\"#select_btn\");\n            select_all.click(function () {\n                $.ajax({\n                        url: \"/user\",\n                        type: \"get\",\n                        success: function (result) {\n                            var div = $(\"#div01\");\n                            for (var i = 0; i < result.length; i++) {\n                                div.append(\"<p> 姓名:\" + result[i].username + \"</p >\");\n                                div.append(\"<p>生日：\" + result[i].birthday + \"</p >\");\n                                div.append(\"<p>性别：\" + result[i].sex + \"</p >\");\n                                div.append(\"<p>地址：\" + result[i].address + \"</p >\");\n                            }\n                        }\n                    }\n                )\n            });\n         })\n</script>\n</head>\n<h1>这是首页！</h1>\n<button id=\"select_btn\">点击查询所有</button>\n<div id=\"div01\"></div>\n```\n## 13.启动项目进行测试\n- 运行此main方法\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903104429446.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n- 下图表示启动成功\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903104525256.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n- 打开浏览器访问 http://localhost:8080/index.html 下图为页面效果\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903104640203.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n- 点击查询所有按钮 会向后台发送ajax请求 效果如下图\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20190903104733843.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjA2ODI1NA==,size_16,color_FFFFFF,t_70)\n## 14.end 至此完成了SpringBoot的查询所有user操作', '2020年01月06日 14:19:30', '2020年01月10日 09:56:24', '../static/images/cover/1579054612005Lighthouse.jpg', '1', 'Spring Boot 快速搭建web项目-更新了', '3', '1', '3', '1', '19');
INSERT INTO `article` VALUES ('5', 'MarkDown编辑文章示例', '# 欢迎使用 Markdown在线编辑器 MdEditor\n\n**Markdown是一种轻量级的「标记语言」**\n\n\n![markdown](https://www.mdeditor.com/images/logos/markdown.png \"markdown\")\n\n\nMarkdown是一种可以使用普通文本编辑器编写的标记语言，通过简单的标记语法，它可以使普通文本内容具有一定的格式。它允许人们使用易读易写的纯文本格式编写文档，然后转换成格式丰富的HTML页面，Markdown文件的后缀名便是“.md”\n\n\n## MdEditor是一个在线编辑Markdown文档的编辑器\n\n*MdEditor扩展了Markdown的功能（如表格、脚注、内嵌HTML等等），以使让Markdown转换成更多的格式，和更丰富的展示效果，这些功能原初的Markdown尚不具备。*\n\n> Markdown增强版中比较有名的有Markdown Extra、MultiMarkdown、 Maruku等。这些衍生版本要么基于工具，如~~Pandoc~~，Pandao；要么基于网站，如GitHub和Wikipedia，在语法上基本兼容，但在一些语法和渲染效果上有改动。\n\nMdEditor源于Pandao的JavaScript开源项目，开源地址[Editor.md](https://github.com/pandao/editor.md \"Editor.md\")，并在MIT开源协议的许可范围内进行了优化，以适应广大用户群体的需求。向优秀的markdown开源编辑器原作者Pandao致敬。\n\n\n![Pandao editor.md](https://pandao.github.io/editor.md/images/logos/editormd-logo-180x180.png \"Pandao editor.md\")\n\n\n\n## MdEditor的功能列表演示\n\n# 标题H1\n\n## 标题H2\n\n### 标题H3\n\n#### 标题H4\n\n##### 标题H5\n\n###### 标题H5\n\n### 字符效果和横线等\n----\n\n~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\n\n*斜体字*      _斜体字_\n\n**粗体**  __粗体__\n\n***粗斜体*** ___粗斜体___\n\n上标：X<sub>2</sub>，下标：O<sup>2</sup>\n\n**缩写(同HTML的abbr标签)**\n> 即更长的单词或短语的缩写形式，前提是开启识别HTML标签时，已默认开启\n\nThe <abbr title=\"Hyper Text Markup Language\">HTML</abbr> specification is maintained by the <abbr title=\"World Wide Web Consortium\">W3C</abbr>.\n### 引用 Blockquotes\n\n> 引用文本 Blockquotes\n\n引用的行内混合 Blockquotes\n\n> 引用：如果想要插入空白换行`即<br />标签`，在插入处先键入两个以上的空格然后回车即可，[普通链接](https://www.mdeditor.com/)。\n\n### 锚点与链接 Links\n[普通链接](https://www.mdeditor.com/)\n[普通链接带标题](https://www.mdeditor.com/ \"普通链接带标题\")\n直接链接：<https://www.mdeditor.com>\n[锚点链接][anchor-id]\n[anchor-id]: https://www.mdeditor.com/\n[mailto:test.test@gmail.com](mailto:test.test@gmail.com)\nGFM a-tail link @pandao\n邮箱地址自动链接 test.test@gmail.com  www@vip.qq.com\n> @pandao\n\n### 多语言代码高亮 Codes\n\n#### 行内代码 Inline code\n\n\n执行命令：`npm install marked`\n\n#### 缩进风格\n\n即缩进四个空格，也做为实现类似 `<pre>` 预格式化文本 ( Preformatted Text ) 的功能。\n\n    <?php\n        echo \"Hello world!\";\n    ?>\n预格式化文本：\n\n    | First Header  | Second Header |\n    | ------------- | ------------- |\n    | Content Cell  | Content Cell  |\n    | Content Cell  | Content Cell  |\n\n#### JS代码\n```javascript\nfunction test() {\n	console.log(\"Hello world!\");\n}\n```\n\n#### HTML 代码 HTML codes\n```html\n<!DOCTYPE html>\n<html>\n    <head>\n        <mate charest=\"utf-8\" />\n        <meta name=\"keywords\" content=\"Editor.md, Markdown, Editor\" />\n        <title>Hello world!</title>\n        <style type=\"text/css\">\n            body{font-size:14px;color:#444;font-family: \"Microsoft Yahei\", Tahoma, \"Hiragino Sans GB\", Arial;background:#fff;}\n            ul{list-style: none;}\n            img{border:none;vertical-align: middle;}\n        </style>\n    </head>\n    <body>\n        <h1 class=\"text-xxl\">Hello world!</h1>\n        <p class=\"text-green\">Plain text</p>\n    </body>\n</html>\n```\n### 图片 Images\n\n图片加链接 (Image + Link)：\n\n\n[![](https://www.mdeditor.com/images/logos/markdown.png)](https://www.mdeditor.com/images/logos/markdown.png \"markdown\")\n\n> Follow your heart.\n\n----\n### 列表 Lists\n\n#### 无序列表（减号）Unordered Lists (-)\n\n- 列表一\n- 列表二\n- 列表三\n\n#### 无序列表（星号）Unordered Lists (*)\n\n* 列表一\n* 列表二\n* 列表三\n\n#### 无序列表（加号和嵌套）Unordered Lists (+)\n+ 列表一\n+ 列表二\n    + 列表二-1\n    + 列表二-2\n    + 列表二-3\n+ 列表三\n    * 列表一\n    * 列表二\n    * 列表三\n\n#### 有序列表 Ordered Lists (-)\n\n1. 第一行\n2. 第二行\n3. 第三行\n\n#### GFM task list\n\n- [x] GFM task list 1\n- [x] GFM task list 2\n- [ ] GFM task list 3\n    - [ ] GFM task list 3-1\n    - [ ] GFM task list 3-2\n    - [ ] GFM task list 3-3\n- [ ] GFM task list 4\n    - [ ] GFM task list 4-1\n    - [ ] GFM task list 4-2\n\n----\n\n### 绘制表格 Tables\n\n| 项目        | 价格   |  数量  |\n| --------   | -----:  | :----:  |\n| 计算机      | $1600   |   5     |\n| 手机        |   $12   |   12   |\n| 管线        |    $1    |  234  |\n\nFirst Header  | Second Header\n------------- | -------------\nContent Cell  | Content Cell\nContent Cell  | Content Cell\n\n| First Header  | Second Header |\n| ------------- | ------------- |\n| Content Cell  | Content Cell  |\n| Content Cell  | Content Cell  |\n\n| Function name | Description                    |\n| ------------- | ------------------------------ |\n| `help()`      | Display the help window.       |\n| `destroy()`   | **Destroy your computer!**     |\n\n| Left-Aligned  | Center Aligned  | Right Aligned |\n| :------------ |:---------------:| -----:|\n| col 3 is      | some wordy text | $1600 |\n| col 2 is      | centered        |   $12 |\n| zebra stripes | are neat        |    $1 |\n\n| Item      | Value |\n| --------- | -----:|\n| Computer  | $1600 |\n| Phone     |   $12 |\n| Pipe      |    $1 |\n\n----\n\n#### 特殊符号 HTML Entities Codes\n\n&copy; &  &uml; &trade; &iexcl; &pound;\n&amp; &lt; &gt; &yen; &euro; &reg; &plusmn; &para; &sect; &brvbar; &macr; &laquo; &middot;\n\nX&sup2; Y&sup3; &frac34; &frac14;  &times;  &divide;   &raquo;\n\n18&ordm;C  &quot;  &apos;\n\n[========]\n\n### Emoji表情 :smiley:\n\n> Blockquotes :star:\n\n#### GFM task lists & Emoji & fontAwesome icon emoji & editormd logo emoji :editormd-logo-5x:\n\n- [x] :smiley: @mentions, :smiley: #refs, [links](), **formatting**, and <del>tags</del> supported :editormd-logo:;\n- [x] list syntax required (any unordered or ordered list supported) :editormd-logo-3x:;\n- [x] [ ] :smiley: this is a complete item :smiley:;\n- [ ] []this is an incomplete item [test link](#) :fa-star: @pandao;\n- [ ] [ ]this is an incomplete item :fa-star: :fa-gear:;\n    - [ ] :smiley: this is an incomplete item [test link](#) :fa-star: :fa-gear:;\n    - [ ] :smiley: this is  :fa-star: :fa-gear: an incomplete item [test link](#);\n\n#### 反斜杠 Escape\n\n\\*literal asterisks\\*\n\n[========]\n### 科学公式 TeX(KaTeX)\n\n$$E=mc^2$$\n\n行内的公式$$E=mc^2$$行内的公式，行内的$$E=mc^2$$公式。\n\n$$x > y$$\n\n$$\\(\\sqrt{3x-1}+(1+x)^2\\)$$\n\n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\n\n多行公式：\n\n```math\n\\displaystyle\n\\left( \\sum\\_{k=1}^n a\\_k b\\_k \\right)^2\n\\leq\n\\left( \\sum\\_{k=1}^n a\\_k^2 \\right)\n\\left( \\sum\\_{k=1}^n b\\_k^2 \\right)\n```\n```katex\n\\displaystyle\n    \\frac{1}{\n        \\Bigl(\\sqrt{\\phi \\sqrt{5}}-\\phi\\Bigr) e^{\n        \\frac25 \\pi}} = 1+\\frac{e^{-2\\pi}} {1+\\frac{e^{-4\\pi}} {\n        1+\\frac{e^{-6\\pi}}\n        {1+\\frac{e^{-8\\pi}}\n         {1+\\cdots} }\n        }\n    }\n```\n```latex\nf(x) = \\int_{-\\infty}^\\infty\n    \\hat f(\\xi)\\,e^{2 \\pi i \\xi x}\n    \\,d\\xi\n```\n### 分页符 Page break\n\n> Print Test: Ctrl + P\n\n[========]\n\n### 绘制流程图 Flowchart\n\n```flow\nst=>start: 用户登陆\nop=>operation: 登陆操作\ncond=>condition: 登陆成功 Yes or No?\ne=>end: 进入后台\n\nst->op->cond\ncond(yes)->e\ncond(no)->op\n```\n[========]\n\n### 绘制序列图 Sequence Diagram\n\n```seq\nAndrew->China: Says Hello\nNote right of China: China thinks\\nabout it\nChina-->Andrew: How are you?\nAndrew->>China: I am good thanks!\n```\n### End', '2020年01月20日 14:51:04', '2020年01月20日 14:51:04', '../static/images/cover/1579503035215bgImg.jpg', '1', 'markdown的文章展示希望大家多多点赞。', '1', '1', '0', '0', '0');
INSERT INTO `article` VALUES ('8', 'SpringBoot 系列教程 Solr 之查询使用姿势小结', '# SpringBoot 系列教程 Solr 之查询使用姿势小结\n接下来进入 solr CURD 查询的使用姿势介绍，本文将主要包括以下知识点\n- 基本的查询操作\n- fq 查询\n- fl 指定字段查询\n- 比较/范围\n- 排序\n- 分页\n- 分组\n### 配置\n在介绍 demo 之前，需要先安装 solr 环境，搭建 SpringBoot 项目工程，具体的环境搭建过程不细说\n在 ```application.yml``` 配置文件中红，指定 solr 的域名\n\n```yml\nspring:\n  data:\n    solr:\n      host: http://127.0.0.1:8983/solr\n```\n然后在 solr 中，写入一些数据，供我们查询使用，可以通过控制台的方式写入\n初始化 solr 文档内容如下\n```json\n{\n  \"id\":\"1\",\n  \"content_id\":1,\n  \"title\":\"一灰灰blog\",\n  \"content\":\"这是一灰灰blog的内容\",\n  \"type\":1,\n  \"create_at\":1578912072,\n  \"publish_at\":1578912072,\n  \"_version_\":1655609540674060288},\n{\n  \"id\":\"2\",\n  \"content_id\":2,\n  \"title\":\"一灰灰\",\n  \"content\":\"这是一灰灰的内容\",\n  \"type\":1,\n  \"create_at\":1578912072,\n  \"publish_at\":1578912072,\n  \"_version_\":1655609550229733376},\n{\n  \"id\":\"3\",\n  \"content_id\":3,\n  \"title\":\"solrTemplate 修改之后!!!\",\n  \"create_at\":1578993153,\n  \"publish_at\":1578993153,\n  \"type\":0,\n  \"_version_\":1655694325261008896},\n{\n  \"id\":\"4\",\n  \"content_id\":4,\n  \"type\":1,\n  \"create_at\":0,\n  \"publish_at\":0,\n  \"_version_\":1655694325422489600},\n{\n  \"id\":\"5\",\n  \"content_id\":5,\n  \"title\":\"addBatchByBean - 1\",\n  \"content\":\"新增一个测试文档\",\n  \"type\":1,\n  \"create_at\":1578993153,\n  \"publish_at\":1578993153,\n  \"_version_\":1655694325129936896},\n{\n  \"id\":\"6\",\n  \"content_id\":6,\n  \"title\":\"addBatchByBean - 2\",\n  \"content\":\"新增又一个测试文档\",\n  \"type\":1,\n  \"create_at\":1578993153,\n  \"publish_at\":1578993153,\n  \"_version_\":1655694325136228352\n}\n```\n### 查询\nsolr 文档对应的 POJO 如下，（注意 solr 中的主键 id 为 string 类型，下面定义中用的是 Integer，推荐与 solr 的数据类型保持一致）\n```java\n@Data\npublic class DocDO implements Serializable {\n    private static final long serialVersionUID = 7245059137561820707L;\n    @Id\n    @Field(\"id\")\n    private Integer id;\n    @Field(\"content_id\")\n    private Integer contentId;\n    @Field(\"title\")\n    private String title;\n    @Field(\"content\")\n    private String content;\n    @Field(\"type\")\n    private Integer type;\n    @Field(\"create_at\")\n    private Long createAt;\n    @Field(\"publish_at\")\n    private Long publishAt;\n}\n```\n#### 主键查询\n支持单个查询和批量查询，三个参数，第一个为需要查询的 Collection, 第二个为 id/id 集合，第三个为返回的数据类型\n```java\nprivate void queryById() {\n    DocDO ans = solrTemplate.getById(\"yhh\", 1, DocDO.class).get();\n    System.out.println(\"queryById: \" + ans);\n\n    Collection<DocDO> list = solrTemplate.getByIds(\"yhh\", Arrays.asList(1, 2), DocDO.class);\n    System.out.println(\"queryByIds: \" + list);\n}\n```\n输出结果如下\n```\nqueryById: DocDO(id=1, contentId=1, title=一灰灰blog, content=这是一灰灰blog的内容, type=1, createAt=1578912072, publishAt=1578912072)\nqueryByIds: [DocDO(id=1, contentId=1, title=一灰灰blog, content=这是一灰灰blog的内容, type=1, createAt=1578912072, publishAt=1578912072), DocDO(id=2, contentId=2, title=一灰灰, content=这是一灰灰的内容, type=1, createAt=1578912072, publishAt=1578912072)]\n```\n#### 简单查询\n比如最简单的根据某个字段进行查询\n```java\nQuery query = new SimpleQuery(\"title:一灰灰\");\nPage<DocDO> ans = solrTemplate.query(\"yhh\", query, DocDO.class);\nSystem.out.println(\"simpleQuery : \" + ans.getContent());\n```\n直接在 SimpleQuery 中指定查询条件，上面的 case 表示查询 title 为```一灰灰```的文档\n\n输出结果如下：\n```\nsimpleQuery : [DocDO(id=2, contentId=2, title=一灰灰, content=这是一灰灰的内容, type=1, createAt=1578912072, publishAt=1578912072)]\n```\n简单的查询使用上面的姿势 ok，当然就是阅读起来不太优雅；推荐另外一种基于Criteria的查询条件构建方式\n如果看过之前的 mongodb 系列教程，可以看到 monodb 的查询条件也用到了 Criteria 来拼装，但是请注意这两个并不是一个东西\n```\nquery = new SimpleQuery();\n// 查询内容中包含一灰灰的文档\nquery.addCriteria(new Criteria(\"content\").contains(\"一灰灰\"));\n\nans = solrTemplate.query(\"yhh\", query, DocDO.class);\nSystem.out.println(\"simpleQuery : \" + ans.getContent());\n```\n\nCriteria可以构建复杂的且阅读友好的查询条件，后面会有具体的演示，这里给出一个多条件查询的 case\n输出结果如下，在上面的基础上，捞出了 contentId 小于 2 的记录\n```\nmultiQuery: [DocDO(id=1, contentId=1, title=一灰灰blog, content=这是一灰灰blog的内容, type=1, createAt=1578912072, publishAt=1578912072)]\n```\n####  fq 查询\nfq 主要用来快速过滤，配合 query 进行操作，主要是借助```org.springframework.data.solr.core.query.Query#addFilterQuery```来添加 fq 条件\n```java\n// fq查询\nquery = new SimpleQuery(\"content: *一灰灰*\");\nquery.addFilterQuery(FilterQuery.filter(Criteria.where(\"title\").contains(\"blog\")));\nans = solrTemplate.query(\"yhh\", query, DocDO.class);\nSystem.out.println(\"simpleQueryAndFilter: \" + ans.getContent());\n```\n输出结果如:\n```\nsimpleQueryAndFilter: [DocDO(id=1, contentId=1, title=一灰灰blog, content=这是一灰灰blog的内容, type=1, createAt=1578912072, publishAt=1578912072)]\n```\n#### fl 指定查询字段\n当我们只关注 solr 文档中的部分字段时，可以考虑指定 fl，只获取所需的字段；通过```org.springframework.data.solr.core.query.SimpleQuery#addProjectionOnFields(java.lang.String...)```来指定需要返回的字段名\n```java\n/**\n * 查询指定的字段\n */\nprivate void querySpecialFiled() {\n    SimpleQuery query = new SimpleQuery();\n    query.addCriteria(Criteria.where(\"content_id\").lessThanEqual(2));\n    // fl 查询\n    query.addProjectionOnFields(\"id\", \"title\", \"content\");\n\n    List<DocDO> ans = solrTemplate.query(\"yhh\", query, DocDO.class).getContent();\n    System.out.println(\"querySpecialField: \" + ans);\n}\n```\n输出结果如下\n```\nquerySpecialField: [DocDO(id=1, contentId=null, title=一灰灰blog, content=这是一灰灰blog的内容, type=null, createAt=null, publishAt=null), DocDO(id=2, contentId=null, title=一灰灰, content=这是一灰灰的内容, type=null, createAt=null, publishAt=null)]\n```\n请注意，我们指定了只需要返回id, title, content，所以返回的 DO 中其他的成员为 null\n#### 范围查询\n针对数字类型，支持范围查询，比如上面给出```Criteria.where(\"content_id\").lessThanEqual(2)```，表示查询content_id小于 2 的记录，下面给出一个 between 的查询\n```java\n/**\n * 范围查询\n */\nprivate void queryRange() {\n    Query query = new SimpleQuery();\n    query.addCriteria(Criteria.where(\"content_id\").between(1, 3));\n    query.addSort(Sort.by(\"content_id\").ascending());\n    List<DocDO> ans = solrTemplate.query(\"yhh\", query, DocDO.class).getContent();\n    System.out.println(\"queryRange: \" + ans);\n}\n```\n输出结果如下，请注意 between 查询，左右都是闭区间\n```\nqueryRange: [DocDO(id=1, contentId=1, title=一灰灰blog, content=这是一灰灰blog的内容, type=1, createAt=1578912072, publishAt=1578912072), DocDO(id=2, contentId=2, title=一灰灰, content=这是一灰灰的内容, type=1, createAt=1578912072, publishAt=1578912072), DocDO(id=3, contentId=3, title=solrTemplate 修改之后!!!, content=null, type=0, createAt=1578997659, publishAt=1578997659)]\n```\n如果不想要闭区间，可以用between的重载方法\n```java\nquery = new SimpleQuery();\n// 两个false，分表表示不包含下界 上界\nquery.addCriteria(Criteria.where(\"content_id\").between(1, 3, false, false));\nquery.addSort(Sort.by(\"content_id\").ascending());\nans = solrTemplate.query(\"yhh\", query, DocDO.class).getContent();\nSystem.out.println(\"queryRange: \" + ans);\n```\n输出结果如下\n```\nqueryRange: [DocDO(id=2, contentId=2, title=一灰灰, content=这是一灰灰的内容, type=1, createAt=1578912072, publishAt=1578912072)]\n```\n#### 排序\n上面的 case 中，已经用到了排序，主要是Sort来指定排序字段以及排序的方式；因为 id 在 solr 中实际上是字符串格式，所以如果用 id 进行排序时，实际上是根据字符串的排序规则来的（虽然我们的 POJO 中 id 为 int 类型）\n```java\n/**\n * 查询并排序\n */\nprivate void queryAndSort() {\n    // 排序\n    Query query = new SimpleQuery();\n    query.addCriteria(new Criteria(\"content\").contains(\"一灰灰\"));\n    // 倒排\n    query.addSort(Sort.by(\"content_id\").descending());\n    Page<DocDO> ans = solrTemplate.query(\"yhh\", query, DocDO.class);\n    System.out.println(\"queryAndSort: \" + ans.getContent());\n}\n```\n输出结果如下\n```\nqueryAndSort: [DocDO(id=2, contentId=2, title=一灰灰, content=这是一灰灰的内容, type=1, createAt=1578912072, publishAt=1578912072), DocDO(id=1, contentId=1, title=一灰灰blog, content=这是一灰灰blog的内容, type=1, createAt=1578912072, publishAt=1578912072)]\n```\n#### 分页查询\n分页查询比较常见，特别是当数据量比较大时，请一定记得，添加分页条件\n\n一个查询 case 如下，查询所有的数据，并制定了分页条件，查询第二条和第三条数据（计数从 0 开始）\n```java\n/**\n * 分页\n */\nprivate void queryPageSize() {\n    Query query = new SimpleQuery(\"*:*\");\n    query.addSort(Sort.by(\"content_id\").ascending());\n    // 指定偏移量，从0开始\n    query.setOffset(2L);\n    // 查询的size数量\n    query.setRows(2);\n    Page<DocDO> ans = solrTemplate.queryForPage(\"yhh\", query, DocDO.class);\n\n    // 文档数量\n    long totalDocNum = ans.getTotalElements();\n    List<DocDO> docList = ans.getContent();\n    System.out.println(\"queryPageSize:  totalDocNum=\" + totalDocNum + \" docList=\" + docList);\n}\n```\n在返回结果中，查了返回查询的文档之外，还会给出满足条件的文档数量，可以通过Page#getTotalElements获取，\n上面 case 输出结果如下\n```\nqueryPageSize:  totalDocNum=6 docList=[DocDO(id=3, contentId=3, title=solrTemplate 修改之后!!!, content=null, type=0, createAt=1578997946, publishAt=1578997946), DocDO(id=4, contentId=4, title=null, content=null, type=1, createAt=0, publishAt=0)]\n```\n#### 分组查询\n分组和前面的查询有一点区别，主要在于结果的处理，以及分组参数必须指定分页信息\n```java\n/**\n * 分组查询\n */\nprivate void queryGroup() {\n    Query query = new SimpleQuery(\"*:*\");\n    // 请注意，分组查询，必须指定 offset/limit, 否则会抛异常，Pageable must not be null!\n    GroupOptions groupOptions = new GroupOptions().addGroupByField(\"type\").setOffset(0).setLimit(10);\n    query.setGroupOptions(groupOptions);\n\n    GroupPage<DocDO> ans = solrTemplate.queryForGroupPage(\"yhh\", query, DocDO.class);\n    GroupResult<DocDO> groupResult = ans.getGroupResult(\"type\");\n\n    Page<GroupEntry<DocDO>> entries = groupResult.getGroupEntries();\n    System.out.println(\"============ query for group ============ \");\n    for (GroupEntry<DocDO> sub : entries) {\n        // type 的具体值\n        String groupValue = sub.getGroupValue();\n        Page<DocDO> contentList = sub.getResult();\n        System.out.println(\"queryGroup v=\" + groupValue + \" content=\" + contentList.getContent());\n    }\n    System.out.println(\"============ query for group ============ \");\n}\n```\n上面的 case 虽然比较简单，但是有几点需要注意, 特别是返回结果的获取，包装层级有点深\n- GroupOptions\n	- 必须指定 offset/limit，当两个条件都没有时会抛异常\n	- 只指定 offset 时，limit 默认为 1\n	- 只指定 limit 时，offset 默认为 0\n- 结果处理\n	- GroupPage#getGroupResult(field) 获取分组内容，其中 field 为指定分组的成员\n	- 遍历GroupResult#getGroupEntries，获取每个分组对应的文档列表\n输出结果如下\n```\n============ query for group ============\nqueryGroup v=1 content=[DocDO(id=1, contentId=1, title=一灰灰blog, content=这是一灰灰blog的内容, type=1, createAt=1578912072, publishAt=1578912072), DocDO(id=2, contentId=2, title=一灰灰, content=这是一灰灰的内容, type=1, createAt=1578912072, publishAt=1578912072), DocDO(id=5, contentId=5, title=addBatchByBean - 1, content=新增一个测试文档, type=1, createAt=1578997946, publishAt=1578997946), DocDO(id=6, contentId=6, title=addBatchByBean - 2, content=新增又一个测试文档, type=1, createAt=1578997946, publishAt=1578997946), DocDO(id=4, contentId=4, title=null, content=null, type=1, createAt=0, publishAt=0)]\nqueryGroup v=0 content=[DocDO(id=3, contentId=3, title=solrTemplate 修改之后!!!, content=null, type=0, createAt=1578997946, publishAt=1578997946)]\n============ query for group ============\n```\n### end', '2020年01月20日 16:12:15', '2020年01月20日 16:12:15', '../static/images/cover/157950790197520191204165422.png', '1', 'SpringBoot 系列教程 Solr 之查询使用姿势小结', '2', '1', '0', '0', '0');

-- ----------------------------
-- Table structure for article_attitude
-- ----------------------------
DROP TABLE IF EXISTS `article_attitude`;
CREATE TABLE `article_attitude` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(20) DEFAULT NULL COMMENT '用户id',
  `article_id` int(20) DEFAULT NULL COMMENT '文章id',
  `attitude` int(20) DEFAULT NULL COMMENT '态度 0为不赞同 1为赞同',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_attitude
-- ----------------------------
INSERT INTO `article_attitude` VALUES ('1', '1', '2', '1');
INSERT INTO `article_attitude` VALUES ('2', '1', '1', '1');
INSERT INTO `article_attitude` VALUES ('3', '2', '2', '1');
INSERT INTO `article_attitude` VALUES ('4', '2', '4', '0');
INSERT INTO `article_attitude` VALUES ('5', '2', '1', '1');
INSERT INTO `article_attitude` VALUES ('6', '1', '4', '1');
INSERT INTO `article_attitude` VALUES ('7', '2', '3', '1');
INSERT INTO `article_attitude` VALUES ('8', '3', '2', '1');
INSERT INTO `article_attitude` VALUES ('9', '3', '3', '1');
INSERT INTO `article_attitude` VALUES ('10', '3', '4', '1');
INSERT INTO `article_attitude` VALUES ('11', '4', '4', '1');
INSERT INTO `article_attitude` VALUES ('12', '3', '1', '1');
INSERT INTO `article_attitude` VALUES ('13', '9', '2', '1');

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_id` int(20) DEFAULT NULL COMMENT '帖子id',
  `tag_id` int(20) DEFAULT NULL COMMENT '标签id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES ('1', '3', '8');
INSERT INTO `article_tag` VALUES ('2', '4', '1');
INSERT INTO `article_tag` VALUES ('3', '4', '6');
INSERT INTO `article_tag` VALUES ('4', '1', '7');
INSERT INTO `article_tag` VALUES ('8', '8', '1');
INSERT INTO `article_tag` VALUES ('9', '8', '6');
INSERT INTO `article_tag` VALUES ('10', '8', '9');
INSERT INTO `article_tag` VALUES ('11', '5', '5');
INSERT INTO `article_tag` VALUES ('12', '2', '2');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(20) DEFAULT NULL COMMENT '用户id',
  `article_id` int(20) DEFAULT NULL COMMENT '帖子id',
  `create_time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `parent_comment_id` int(20) DEFAULT NULL COMMENT '父级评论id',
  `son_comment_id` varchar(20) DEFAULT NULL COMMENT '子级评论id的list集合',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '2', '2020年01月10日 13:04:12', 'test comment 1', '0', '9,10,12,13');
INSERT INTO `comment` VALUES ('2', '5', '2', '2020年01月14日 13:50:39', '评论测试....', '0', null);
INSERT INTO `comment` VALUES ('9', '6', '2', '2020年01月19日 15:59:49', '@张三: 回复评论测试1', '1', '12');
INSERT INTO `comment` VALUES ('10', '10', '2', '2020年01月19日 16:42:23', '@张三: 回复评论测试2', '1', '13');
INSERT INTO `comment` VALUES ('12', '8', '2', '2020年01月19日 17:03:51', '@赵八: 回复评论的评论的测试1', '9', null);
INSERT INTO `comment` VALUES ('13', '8', '2', '2020年01月19日 17:05:24', '@熊二: 回复评论的评论测试2', '10', null);

-- ----------------------------
-- Table structure for jurisdiction
-- ----------------------------
DROP TABLE IF EXISTS `jurisdiction`;
CREATE TABLE `jurisdiction` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `resource` varchar(255) DEFAULT NULL COMMENT '允许访问的资源',
  `value` varchar(32) DEFAULT NULL,
  `sortnum` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jurisdiction
-- ----------------------------
INSERT INTO `jurisdiction` VALUES ('1', '/login', 'anon', '10');
INSERT INTO `jurisdiction` VALUES ('2', '/static/**', 'anon', '20');
INSERT INTO `jurisdiction` VALUES ('3', '/**', 'authc', '999');
INSERT INTO `jurisdiction` VALUES ('4', '/index', 'anon', '10');
INSERT INTO `jurisdiction` VALUES ('5', '/logout', 'anon', '10');
INSERT INTO `jurisdiction` VALUES ('6', '/logout', 'logout', '10');
INSERT INTO `jurisdiction` VALUES ('7', '/register', 'anon', '10');
INSERT INTO `jurisdiction` VALUES ('8', '/article/**', 'anon', '25');
INSERT INTO `jurisdiction` VALUES ('9', '/article/article_input/**', 'authc', '20');
INSERT INTO `jurisdiction` VALUES ('10', '/article/myArticle/**', 'authc', '20');
INSERT INTO `jurisdiction` VALUES ('11', '/type/**', 'anon', '10');
INSERT INTO `jurisdiction` VALUES ('12', '/tag/**', 'anon', '10');
INSERT INTO `jurisdiction` VALUES ('13', '/user/author', 'anon', '10');
INSERT INTO `jurisdiction` VALUES ('14', '/about', 'anon', '10');
INSERT INTO `jurisdiction` VALUES ('15', '/user/author_details/**', 'anon', '10');
INSERT INTO `jurisdiction` VALUES ('16', '/findAccountName', 'anon', '10');
INSERT INTO `jurisdiction` VALUES ('17', '/findNickname', 'anon', '10');
INSERT INTO `jurisdiction` VALUES ('18', '/addComment', 'anon', '10');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(16) DEFAULT NULL COMMENT '角色名',
  `role_mark` varchar(16) DEFAULT NULL COMMENT '角色说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'user', '用户角色');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tag_name` varchar(255) DEFAULT NULL COMMENT '标签名',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', 'Java', '2020年01月04日 14:45:30');
INSERT INTO `tag` VALUES ('2', 'MySql', '2020年01月04日 14:51:58');
INSERT INTO `tag` VALUES ('3', 'Html', '2020年01月04日 14:53:08');
INSERT INTO `tag` VALUES ('4', 'CSS', '2020年01月04日 15:39:23');
INSERT INTO `tag` VALUES ('5', 'JavaScript', '2020年01月04日 15:48:29');
INSERT INTO `tag` VALUES ('6', 'SpringBoot', '2020年01月04日 15:53:05');
INSERT INTO `tag` VALUES ('7', 'markdown', '2020年01月06日 13:47:27');
INSERT INTO `tag` VALUES ('8', 'linux', '2020年01月06日 14:02:54');
INSERT INTO `tag` VALUES ('9', 'solr', '2020年01月20日 15:30:31');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type_name` varchar(255) DEFAULT NULL COMMENT '话题名',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '学习感悟', '2020年01月04日 15:10:42');
INSERT INTO `type` VALUES ('2', '问题与总结', '2020年01月04日 15:13:16');
INSERT INTO `type` VALUES ('3', '重在实践', '2020年01月04日 15:16:23');
INSERT INTO `type` VALUES ('4', '创新突破', '2020年01月04日 15:23:31');
INSERT INTO `type` VALUES ('5', '挑战不可能', '2020年01月04日 15:25:28');
INSERT INTO `type` VALUES ('6', '错误日志', '2020年01月04日 15:53:33');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `account_name` varchar(50) DEFAULT NULL COMMENT '账户名',
  `account_password` varchar(50) DEFAULT NULL COMMENT '账户密码',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `user_intro` varchar(200) DEFAULT NULL COMMENT '用户简介',
  `user_mailbox` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  `user_phone` varchar(50) DEFAULT NULL COMMENT '用户手机号',
  `user_avatar` varchar(100) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '0224ec7377460a7ecbebe189981ec8b9', '张三', '这是测试账户', 'admin@qq.com', '18737843824', '../static/images/avatar/1578645165891Koala.jpg');
INSERT INTO `user` VALUES ('2', 'admin1', '83e096e439c66b94cc7bbb616f414034', '李四', null, null, null, '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES ('3', 'admin2', '5751ed26ca55faaf65db9ba91516e580', '王五', null, null, null, '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES ('4', 'admin3', 'f5e54952015ddb3221c10fa04e02ce69', '赵六', null, null, null, '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES ('5', 'admin4', '58c43a61991e94d874de136ea9fd0b73', '钱七', null, null, null, '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES ('6', 'admin5', '0689c2dba08e6e2573f2d842ee022e52', '赵八', null, null, null, '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES ('7', 'admin6', 'd0d0314119939b4763c4b93841cafc28', '刘九', null, null, null, '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES ('8', 'admin7', '12819060e4d7dba530f129e05875034f', '孙十', null, null, null, '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES ('9', 'admin8', 'c8a7dc7dc08e44ff419c1648726797e3', '熊大', '测试账户', 'admin8@qq.com', '18638623273', '../static/images/avatar/1578977994806Tulips.jpg');
INSERT INTO `user` VALUES ('10', 'admin9', 'fdc8cb1fbfb7ce4ac1910f7b7c489d03', '熊二', '测试账户', 'admin9@qq.com', '13638632323', '../static/images/avatar/1578978439036Penguins.jpg');
INSERT INTO `user` VALUES ('11', 'admin10', '1f31c2fd147ed3a1f7408e288847c41a', '光头强', null, null, null, '../static/images/avatar/Lighthouse.jpg');
INSERT INTO `user` VALUES ('12', 'admin11', 'a4d5553f6ec0bd8c6c427c2bf66a0be4', '海绵宝宝', '测试账户', 'admin10@qq.com', '13538734636', '../static/images/avatar/Lighthouse.jpg');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(16) DEFAULT NULL COMMENT '用户id',
  `role_id` int(16) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '1');
INSERT INTO `user_role` VALUES ('3', '3', '1');
SET FOREIGN_KEY_CHECKS=1;
