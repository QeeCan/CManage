<template>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <!--menu和router的绑定
        el-menu标签添加router属性
        el-menu标签添加router-view标签,动态渲染所选router
        el-menu-item标签的值就是要跳转的router-->
      <el-menu router :default-openeds="['0','1']">
        <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" v-if="item.show">
          <template slot="title"><i class="el-icon-setting"></i>{{ item.name }}</template>
          <el-menu-item v-for="(item2) in item.children" :index="item2.path"
                        :class="$route.path===item2.path?'is-active':''">{{ item2.name }}
          </el-menu-item>
        </el-submenu>
      </el-menu>
    </el-aside>
    <!--一些坑和注意事项：
        route和router的拼写请注意,route带数据，router为跳转；
        openeds的拼写请注意；
        index="index+''"情况下导航栏默认展开，只有index的情况会自动收起；
        其class帮助实现浏览器访问地址与当前导航栏选中（is-active）的标签动态绑定-->
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>


<script>
export default {
  name: "Index"
}
</script>

<style scoped>

</style>