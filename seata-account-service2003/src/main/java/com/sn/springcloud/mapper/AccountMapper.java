package com.sn.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/26 10:23
 * @Description: TODO
 */
@Mapper
public interface AccountMapper {

    void decrease(@Param("userId")Long userId, @Param("money")BigDecimal money);
}