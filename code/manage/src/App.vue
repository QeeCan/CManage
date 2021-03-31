<template>
  <!--el-container:构建整个页面框架-->
  <!--el-aside:构建左侧菜单-->
  <!--el-menu:左侧菜单内容
      default-openeds:默认展开的菜单，通过菜单的index值来关联(which one)
      default-active:默认选中，通过菜单的index值来关联(which one)-->
  <!--el-submenu:可展开的菜单，常用属性
  index:菜单的下标，文本类型，不能是数值类型
  template:对应el-submenu的菜单名;i:设置菜单的图标，通过class属性实现(el-icon-message/menu/setting)-->
  <!--el-menu-item:菜单的下标，文本类型，不能是数值类型
  菜单层级和通过标签格式决定-->
  <div id="app">
<!--    <el-container style="height: 500px; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu router :default-openeds="['0','1']">
          <el-submenu v-for="(item,index) in $router.options.routes" :index="index+'' ":v-if="item.show">
            <template slot="title"><i class="el-icon-setting"></i>{{ item.name }}</template>
            <el-menu-item v-for="(item2) in item.children" :index="item2.path"
                          :class="$route.path===item2.path?'is-active':''">{{ item2.name }}
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>-->
      <el-main>
        <router-view></router-view>
      </el-main>
<!--    </el-container>-->
  </div>
</template>

<style>

</style>

<script>

</script>
