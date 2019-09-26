package io.shardingjdbc.example.spring.boot.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;

import io.shardingjdbc.example.spring.boot.mybatis.entity.Setting;
@Mapper
public interface SettingRepository {
    int deleteByPrimaryKey(String settingKey);

    int insert(Setting record);

    int insertSelective(Setting record);

    Setting selectByPrimaryKey(String settingKey);

    int updateByPrimaryKeySelective(Setting record);

    int updateByPrimaryKey(Setting record);
}