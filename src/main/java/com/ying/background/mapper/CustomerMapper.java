package com.ying.background.mapper;

import com.ying.background.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by yingsy on 2018/6/3.
 */
@Component
@Mapper
public interface CustomerMapper {

    @Select("select * from customer where LOGIN_ACCOUNT = #{account} and  PASSWORD = #{password}")
    Customer toLogin(@Param("account") String accont, @Param("password") String password);
}
