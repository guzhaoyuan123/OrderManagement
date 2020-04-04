package com.example.springbott41.repository;

import com.example.springbott41.entity.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author : 顾兆远
 * @program: springbott-4-1
 * @description: 购物车接口
 * @date : 2020-04-03 20:25
 **/
public interface ShoppingRepository extends JpaRepository<Shopping,Integer> {
}
