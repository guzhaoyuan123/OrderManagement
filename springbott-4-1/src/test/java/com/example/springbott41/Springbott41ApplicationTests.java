package com.example.springbott41;

import com.example.springbott41.repository.ShoppingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springbott41ApplicationTests {

    @Autowired
    private ShoppingRepository shoppingRepository;

    @Test
    void findAll() {
        System.out.println(shoppingRepository.findAll());
    }

    @Test
    void contextLoads() {
    }

}
