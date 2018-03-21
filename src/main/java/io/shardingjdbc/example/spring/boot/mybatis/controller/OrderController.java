package io.shardingjdbc.example.spring.boot.mybatis.controller;

import io.shardingjdbc.example.spring.boot.mybatis.entity.Order;
import io.shardingjdbc.example.spring.boot.mybatis.repository.OrderRepository;
import io.shardingjdbc.example.spring.boot.mybatis.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DemoService demoService;

    @RequestMapping
    public List<Order> list() {
        return orderRepository.queryList();
    }

    @RequestMapping("save")
    public void save() {
        demoService.save();
    }
}
