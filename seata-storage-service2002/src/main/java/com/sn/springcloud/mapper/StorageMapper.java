package com.sn.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/26 9:51
 * @Description: TODO
 */
@Mapper
public interface StorageMapper {

    void decrease(@Param("productId")Long productId,@Param("count")Integer count);

}