package com.example.springbott41.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author : 顾兆远
 * @program: springbott-4-1
 * @description: 购物车实体类
 * @date : 2020-04-03 20:24
 **/

@Entity
@Data
public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String date;
    private Float price;
    private Integer num;
    private String description;
}
