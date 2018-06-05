package com.ying.background.mapper;

import com.ying.background.model.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yingsy on 2018/5/8.
 */
@Component
@Mapper
public interface TestMapper {

    @Select("select * from test")
    List<Test> selectAll();
}
