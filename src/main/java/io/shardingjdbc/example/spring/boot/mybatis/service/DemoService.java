/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingjdbc.example.spring.boot.mybatis.service;

import io.shardingjdbc.example.spring.boot.mybatis.entity.Order;
import io.shardingjdbc.example.spring.boot.mybatis.entity.OrderItem;
import io.shardingjdbc.example.spring.boot.mybatis.entity.Setting;
import io.shardingjdbc.example.spring.boot.mybatis.repository.OrderItemRepository;
import io.shardingjdbc.example.spring.boot.mybatis.repository.OrderRepository;
import io.shardingjdbc.example.spring.boot.mybatis.repository.SettingRepository;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {

    @Resource
    private SettingRepository settingRepository;
    
    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderItemRepository orderItemRepository;

    public void demo() {
        orderRepository.createIfNotExistsTable();
        orderItemRepository.createIfNotExistsTable();
        orderRepository.truncateTable();
        orderItemRepository.truncateTable();
        System.out.println("1.Insert--------------");
        save();
        System.out.println(orderItemRepository.selectAll());
        /*System.out.println("2.Delete--------------");
        for (Long each : orderIds) {
            orderRepository.delete(each);
            orderItemRepository.delete(each);
        }
        System.out.println(orderItemRepository.selectAll());
        orderItemRepository.dropTable();
        orderRepository.dropTable();*/
    }

    public void save() {
        List<Long> orderIds = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
        	Setting setting=new Setting();
        	setting.setSettingKey(System.currentTimeMillis()+"");
        	setting.setSettingValue("settingValue");
        	settingRepository.insertSelective(setting);
            Order order = new Order();
            order.setUserId(52);
            order.setStatus("INSERT_TEST");
            orderRepository.insert(order);
            long orderId = order.getOrderId();
            orderIds.add(orderId);

            OrderItem item = new OrderItem();
            item.setOrderId(orderId);
            item.setUserId(52);
            item.setStatus("INSERT_TEST");
            orderItemRepository.insert(item);
        }
    }
}
