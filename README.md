# CManage 一个课程管理的Demo
-
**项目详情**
此demo使用为前后端分离开发，具体分工为：
manage文件内为前端相关搭建，使用vue和ElementUI搭建简单的课程后台管理系统；
springboottest内为后端相关，采用spring boot技术，连接的数据库使用的MySQL。

**功能**
能够完成简单的增删改功能，并统一到数据库内数据的操作。

------------截止至2021.03.31更新-------------------
系统内容：
基于vue和Spring Boot的前后端分离的课程管理系统，前端利用vue和ElementUI完成课程信息的相关显示和管理选择，后端由Spring Boot完成对MySQL数据库中数据的读取和操作。
技术核心：
前后端分离 vue+Spring Boot
实现流程：
·使用vue脚手架（vue-cli3.0以上）vue ui 命令进入管理器页面创建新项目，Idea中安装vue.js的插件打开项目
·另起一个新窗口建立springboot项目，选择LomBok(Developer Tools)、Spring Web(web)、Spring Data JPA\MySQL Driver(SQL)工具
·进入application.yml进行配置，包括spring下的datasourse和jpa相关信息配置，以及服务器端口
·前端假数据可用于测试（vue可以动态更改有关于view的改动）
·后端项目创建（包）实体类，属性名应与数据库中表名对应绑定
              创建（包）repository，定义一个泛型接口继承JpaRepository
·接口右键goto--Test可生成一个JUnit5测试类
·需要从前端（post:8080）跨域访问后端（post:8181），使用注解@CrossOrigin，还可以写成CrossOrigin(origins = "*",maxAge = 3600)其帮助实现跨域访问，加在类上或者需要跨域的方法上即可
·获取后端数据
·打开vue脚手架并在其中安装ElementUI相应组件，根据ElementUI 的开发文档选择需要的样式进行开发，通过导航栏和动态路由访问对应页面（menu和router绑定）el-menu-item标签的值就是要跳转的router
·检测用户点击到哪一页（前端），使用Pageable的执行PageRequest进行分页
@GetMapping("/findAll/{page}/{size}")
public Page<Course> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
    Pageable pageable = PageRequest.of(page-1,size);
    return courseRepository.findAll(pageable);
}
·引入axios组件拿到后台数据然后赋值

增删改查
·增加：
使用ElementUI 完成相应的组件添加添加相关信息的视图
在其rules对象中定义表单各个选项的校验规则（一些绑定）：module用来绑定对象；rules用来绑定规则 注意自增（后端的实体类及前端显示）
@Id
//因为id在数据库中设置为一个自增的字段，所以要添加一个自增的属性
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer num;

在前端完成新建的表单提交修改 前端获取修改对象的id 后端 获得id 进行更改

