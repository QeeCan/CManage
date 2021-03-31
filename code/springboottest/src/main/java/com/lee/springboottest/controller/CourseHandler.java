package com.lee.springboottest.controller;

import com.lee.springboottest.entity.Course;
import com.lee.springboottest.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
此处注解的CrossOrigin，还可以写成CrossOrigin(origins = "*",maxAge = 3600)
其帮助实现跨域访问，加在类上或者需要跨域的方法上都可以
其它可实现跨域访问的方法还有：新建同级目录实现WebMvcConfigurer接口，重写addCorsMappings方法解决跨域问题（此版本下无效果）
自定义跨域过滤器：实现Filter接口，重写doFilter方法，添加报头实现跨域
*/
@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseHandler {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Course> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page-1,size);
        return courseRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Course course){
        Course result = courseRepository.save(course);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }
   @GetMapping("/findById/{num}")
    public Course findById(@PathVariable("num") Integer num){
        return courseRepository.findById(num).get();

   }
    @PostMapping("/update")
    public String update(@RequestBody Course course){
        Course result = courseRepository.save(course);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{num}")
    public void deleteById(@PathVariable("num") Integer num){
        courseRepository.deleteById(num);

    }

}
