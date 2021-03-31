import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "../views/Index";
import CourseManage from "../views/CourseManage";
import AddCourse from "../views/AddCourse";
import CourseUpdate from "../views/CourseUpdate"

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    show: true,
    name: '课程管理',
    component: Index,
    redirect:"/CourseManage",
    children:[
      {
        path: "/CourseManage",
        name: "查询课程",
        component: CourseManage
      },
      {
        path: "/AddCourse",
        name: "添加课程",
        component: AddCourse
      }
    ]},
  {
    path: "/update",
    show: false,
    component: CourseUpdate



}]
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
