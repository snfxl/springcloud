package com.sn.springcloud.mapper;

import com.sn.springcloud.doman.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 19:40
 * @Description: TODO
 */
@Mapper
public interface OrderMapper {

    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
