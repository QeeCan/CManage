package com.lee.springboottest;

import com.lee.springboottest.entity.Course;
import com.lee.springboottest.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class SpringboottestApplicationTests {
    @Autowired
    private CourseRepository repository;

    @Test
    void contextLoads() {
        /*PageRequest pageRequest = PageRequest.of(0, 6);
        Page<Course> page = repository.findAll(pageRequest);*/
    }

    @Test
    void save() {
        Course course = new Course();
        course.setName("test");
        course.setProperty("testforsth");
        course.setTextbook("keeptest");
        course.setPublish("testisgood");
        Course course1 = repository.save(course);
        System.out.println(course1);
    }

    @Test
    void findById() {
        Course course=repository.findById(1).get();
        System.out.println(course);
    }
    @Test
    void update(){
        Course course=new Course();
        course.setName("啊呀");
        course.setTextbook("dfssdfs");
        course.setProperty("dfs");
        course.setPublish("fdsjfs");
        Course course1=repository.save(course);
        System.out.println(course1);
    }

    @Test
    void deleteById(){
        repository.deleteById(62);
    }
}
