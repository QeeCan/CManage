package com.lee.springboottest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Course {
    @Id
    //因为id在数据库中设置为一个自增的字段，所以要添加一个自增的属性
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;
    private String name;
    private String property;
    private String textbook;
    private String publish;

}
