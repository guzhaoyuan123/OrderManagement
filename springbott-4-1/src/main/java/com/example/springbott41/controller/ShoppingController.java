package com.example.springbott41.controller;

import com.example.springbott41.entity.Shopping;
import com.example.springbott41.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

/**
 * @author : 顾兆远
 * @program: springbott-4-1
 * @description: 购物车接口类
 * @date : 2020-04-03 20:24
 **/
@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingRepository shoppingRepository;

    //查询所有的订单
    @GetMapping("/findAll/{page}/{size}")
    public Page<Shopping> findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return shoppingRepository.findAll(request);
    }

    //加入订单的接口
    @PostMapping("/save")
    public String save(@RequestBody Shopping shopping){
        Shopping result = shoppingRepository.save(shopping);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Shopping shopping){
        Shopping result = shoppingRepository.save(shopping);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }
    //删除
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        shoppingRepository.deleteById(id);
    }
}
